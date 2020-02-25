
@echo off
rem set the path here
set PATH=%PATH%;C:\Program Files\Java\jdk-10.0.1\bin

cls
rem setlocal enabledelayedexpansion
cd ..

REM Variables for batch
set ERRMSG=
set PRAC_BIN=.\bin
set PRAC_DOCS=.\docs
set PRAC_LIB=.\lib\*
set PRAC_SRC=.\src

DEL /S %PRAC_BIN%\*.class
RMDIR /Q /S %PRAC_DOCS%\JavaDocs
IF /I "%ERRORLEVEL%" NEQ "0" (
    echo !!! Error cleaning project !!!
)

javac -sourcepath %PRAC_SRC% -cp "%PRAC_BIN%;%PRAC_LIB%" -d %PRAC_BIN% %PRAC_SRC%\Main.java
cls
java -cp %PRAC_BIN%;%PRAC_LIB% Main

GOTO END

cd %PRAC_DOCS%
pause