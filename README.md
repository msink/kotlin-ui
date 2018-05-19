Kotiln-UI
=========

(this repository remains here for historical reasons, subsequent work will be in https://github.com/msink/kotlin-libui)

## Motivation

Just for fun, wanted to try new flavor of [Kotlin](https://kotlinlang.org)
language - [Kotlin/Native](https://github.com/JetBrains/kotlin-native)

_Kotlin/Native_ is under development, but as is - in technical preview stage -
can produce reasonably-sized self-contained programs for 64-bit versions
of 3 major OSes - Windows/Linux/MacOS.
(It also can produce binaries for embedded/mobile devices, but in this area not
so ready because of performance issues. For modern desktops performance is not
critical in most cases, and it is already usable.)

Lets explore how _Kotlin/Native_ can be used for producing small self-contained
GUI applications.

## UI library

We need a native GUI library with C interface - _Kotlin/Native_ currently can
interop only with libraries that have plain C API.
GTK and QT are too big and complex, I wanted someting relatively small,
cross-platform and with native-looking widgets.

Here it is - [libui](https://github.com/andlabs/libui)

## Preparations

Assume we have Windows 7 64-bit, working environment is `c:\src`.

Download and build _Kotlin/Native_ :

    cd \src
    git clone https://github.com/JetBrains/kotlin-native.git
    chdir kotlin-native
    gradlew dependencies:update
    gradlew dist
    chdir ..

Working directory:

    mkdir kotlin-ui
    chdir kotlin-ui

Now we have two sibling directories: `\src\kotlin-native` and `\src\kotlin-ui`.

## Low-Level bindings

Create and enter working directory:

    mkdir libui
    chdir libui

Download and unpack libui tarball:

    wget https://github.com/andlabs/libui/releases/download/alpha3.1/alpha3.1.tgz --no-check-certificate  -O libui.tgz`
    7z x libui.tgz -so | 7z x -si -ttar

(or use your favorite programs to download and unpack)

Create `libui\libui.def`:

    headers = ui.h
    headerFilter = ui.h
    compilerOpts = -I./alpha3.1/src

Create and run `libui\build.bat`:

    @echo off
    setlocal
    set KOTLIN_HOME=..\..\kotlin-native\dist
    set "PATH=%KOTLIN_HOME%\bin;%PATH%"
    call cinterop -def libui.def -o libui || exit /b
    rename libui-build build-native

It should produce `libui.klib` - native bindings for _Kotlin/Native_ :)

## High-Level bindings

Now we have direct binding for libui, but it is too low-level for user code.

Lets create one more level to isolate this low-level API -
[uiWidgets.kt](https://github.com/msink/kotlin-ui/blob/master/libui/kotlin/uiWidgets.kt)

(TODO: complete bindings, something like TornadoFX)

## Test program

Create simple [test](https://github.com/msink/kotlin-ui/blob/master/src/test.kt):

```kotlin
fun main(args: Array<String>) = ui.application {
    val window = ui.Window("Button example", width=320, height=60)
    window.margined = true

    val button = ui.Button()
    button.text = "Konan ãîâîðèò: click me!"
    button.onClick { println ("Hi Kotlin") }
    window.child = button

    window.show()
}
```

Create and run `build.bat`:

    @echo off
    setlocal
    set "PATH=..\kotlin-native\dist\bin;%PATH%"
    set LFLAGS=libui\alpha3.1\windows_amd64\mingw_static\libui.a^
            -luser32 -lkernel32 -lusp10 -lgdi32 -lcomctl32 -luxtheme^
            -lmsimg32 -lcomdlg32 -ld2d1 -ldwrite -lole32 -loleaut32^
            -loleacc -luuid -mwindows
    call konanc src libui/kotlin -library libui/libui -linkerOpts "%LFLAGS%" -o test

Result - `test.exe` - when runned should draw small window with one button inside.

## Debugging

OK, but how to debug?

Currently _Kotlin/Native_ have very limited debugging capabilites.
Sure it will improve someday, but what to do now?

There is a way. _Kotlin/Native_ itself is JVM program, written in _Kotlin/JVM_ .
But it also heavily use LLVM toolchain, and LLVM is native.
How these two parts interact? And how compiler developers debug it?

Looking in _Kotlin/Native_ sources, one can find *JVM version of Interop* .
It is almost similar to native cinterop, but designed to work with "big" Kotlin,
using under the hood `sun.misc.Unsafe` and `ffi`.

But this way anyone can develop and debug in familiar and powerful IDEA,
and then just compile to native!

Lets try.

First, quick and dirty, just copy jvm-citerop to our working directory:

    xcopy /E /I \src\kotlin-native\Interop\Runtime\src\jvm cinterop\jvm\
    xcopy /E /I \src\kotlin-native\Interop\Runtime\src\main cinterop\main\
    xcopy /E /I \src\kotlin-native\dist\konan\nativelib\callbacks.dll cinterop

Now, we need to generate jvm bindings for libui.

Modify `libui\libui.def` like this:

```
headers = ui.h
headerFilter = ui.h

compilerOpts = -I./alpha3.1/src -std=c99 -fPIC \
    -Wall -W -Wno-unused-parameter -Wwrite-strings -Wmissing-field-initializers \
    -pedantic -Wno-long-long -Wcovered-switch-default -Wdelete-non-virtual-dtor \
    -DNDEBUG -D__STDC_CONSTANT_MACROS -D__STDC_FORMAT_MACROS -D__STDC_LIMIT_MACROS

linker = clang++

linkerOpts = -fPIC -fvisibility-inlines-hidden \
    -Wall -W -Wno-unused-parameter -Wwrite-strings -Wcast-qual -Wmissing-field-initializers \
    -pedantic -Wno-long-long -Wcovered-switch-default -Wnon-virtual-dtor -Wdelete-non-virtual-dtor \
    -std=c++11 \
    -DNDEBUG -D__STDC_CONSTANT_MACROS -D__STDC_FORMAT_MACROS -D__STDC_LIMIT_MACROS
```

And `libui\build.bat`:

```
@echo off
setlocal

set KOTLIN_HOME=..\..\kotlin-native\dist
set "PATH=%KOTLIN_HOME%\bin;%PATH%"

set LFLAGS=alpha3.1\windows_amd64\mingw_static\libui.a^
        -luser32 -lkernel32 -lusp10 -lgdi32 -lcomctl32 -luxtheme^
        -lmsimg32 -lcomdlg32 -ld2d1 -ldwrite -lole32 -loleaut32^
        -loleacc -luuid^
        -mwindows^
        -static-libgcc -static-libstdc++^
        -Wl,-Bstatic,--whole-archive -lwinpthread -Wl,--no-whole-archive,-Bdynamic

call cinterop -def libui.def -flavor jvm -linkerOpts "%LFLAGS%" -o libui
rename libui-build build-jvm

call cinterop -def libui.def -o libui || exit /b
rename libui-build build-native
```

This "magic" was mostly copied from `kotlin-native\backend.native\llvm.def`

But `citerop` don't like undocumented `-flavor` option, so I just patched kotlin
sources, and rebuild. Yes, quick and dirty :)

```patch
@@ -329,11 +329,11 @@ private fun processLib(konanHome: String,
                        args: Map<String, List<String>>) {

     val userDir = System.getProperty("user.dir")
     val ktGenRoot = args["-generated"]?.single() ?: userDir
     val nativeLibsDir = args["-natives"]?.single() ?: userDir
-    val flavorName = args["-flavor"]?.single() ?: "jvm"
+    val flavorName = args["-flavor"]?.lastOrNull() ?: "jvm"
     val flavor = KotlinPlatform.values().single { it.name.equals(flavorName, ignoreCase = true) }
     val target = args["-target"]?.single()?.targetSuffix() ?: defaultTarget
     val defFile = args["-def"]?.single()?.let { File(it) }
     val manifestAddend = args["-manifest"]?.single()?.let { File(it) }
```

Now, running libui\build.bat should produce both native and jvm bindings.

And finally, create IDEA kotlin project in our working directory,
add source paths (Ctrl+Alt+Shift+S) - `libui/kotlin`, `build-jvm/kotlin`, `cinterop`
add native paths `libui/build-jvm/natives` and `cinterop`

Trying to run - we get error, something like "ffi not loaded".
OK, patch our copy of cinterop, quick and dirty again:

```patch
--- "F:\src\kotlin-native\Interop\Runtime\src\jvm\kotlin\kotlinx\cinterop\JvmCallbacks.kt"
+++ "F:\src\kotlin-ui\cinterop\jvm\JvmCallbacks.kt"
@@ -201,7 +201,6 @@
     val kFunction = function as? KFunction<*> ?: function.reflect() ?:
             throw IllegalArgumentException(errorMessage)

+    loadCallbacksLibrary()
     val returnType = getArgOrRetValCType(kFunction.returnType)
     val paramTypes = kFunction.parameters.map { getArgOrRetValCType(it.type) }
```

Finally it should work, you can develop and debug in IDEA.
