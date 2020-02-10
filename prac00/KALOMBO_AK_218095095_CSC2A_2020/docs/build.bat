@ECHO OFF
set PATH=%PATH%;C:\Program Files\Java\jdk-10.0.1\bin

cd ..

set PRAC_SRC=./src
set PRAC_BIN=./bin
set PRAC_DOCS=./docs

javac -sourcepath %PRAC_SRC% -cp %PRAC_BIN% -d %PRAC_BIN% %PRAC_SRC%/Main.java
java -cp %PRAC_BIN% Main
javap %PRAC_SRC%/Converter.java >> %PRAC_DOCS%/ByteCode.txt
pause
