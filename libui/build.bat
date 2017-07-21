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
