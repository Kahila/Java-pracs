@ECHO OFF
set PATH=%PATH%;C:\Program Files\Java\jdk-10.0.1\bin
cd ..

set PRAC_SRC=src/csc2a/desc/
set PRAC_BIN=./bin
set PRAC_SRC_MAIN=./src

javac -sourcepath %PRAC_BIN% -cp %PRAC_BIN% -d %PRAC_BIN% %PRAC_SRC%/*.java
javac -sourcepath %PRAC_BIN% -cp %PRAC_BIN% -d %PRAC_BIN% %PRAC_SRC_MAIN%/Main.java
java -cp %PRAC_BIN% Main

pause