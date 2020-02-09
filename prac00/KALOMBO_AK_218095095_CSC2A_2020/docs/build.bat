@ECHO OFF
set PATH=%PATH%;C:\Program Files\Java\jdk-10.0.1\bin

cd ..

set PRAC_SRC=./src
set PRAC_BIN=./bin

javac -sourcepath %PRAC_SRC% -cp %PRAC_BIN% -d %PRAC_BIN% %PRAC_SRC%/Main.java
java -cp %PRAC_BIN% Main
pause