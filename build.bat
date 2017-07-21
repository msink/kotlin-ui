@echo off
setlocal

set "PATH=..\kotlin-native\dist\bin;%PATH%"

set LFLAGS=libui\alpha3.1\windows_amd64\mingw_static\libui.a^
        -luser32 -lkernel32 -lusp10 -lgdi32 -lcomctl32 -luxtheme^
        -lmsimg32 -lcomdlg32 -ld2d1 -ldwrite -lole32 -loleaut32^
        -loleacc -luuid -mwindows

call konanc src libui/kotlin -library libui/libui -linkerOpts "%LFLAGS%" -o test
