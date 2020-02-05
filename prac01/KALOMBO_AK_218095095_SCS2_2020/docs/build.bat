@ECHO OFF
set PATH=%PATH%;C:\Program Files (x86)\Java\jdk1.8.0_241\bin\

cd ..

set PRAC_SRC=./src
set PRAC_BIN=./bin
set PRAC_DOCS=./docs

javac -sourcepath %PRAC_SRC% -cp %PRAC_BIN% -d %PRAC_BIN%\Converter.java
java -cp %PRAC_BIN% Converter
pause
