@echo off
echo -------------------------------
echo  Compilando todos los archivos .java
echo -------------------------------

if not exist bin (
    mkdir bin
)

javac -cp ".;lib/mysql-connector-j-9.3.0.jar" -d bin src\main\.java src\dao\.java src\model\*.java

if %errorlevel% neq 0 (
    echo  Error al compilar. Verifica los errores en el código.
    pause
    exit /b
)

echo  Compilación exitosa

echo -------------------------------
echo ▶ Ejecutando MainCRUD
echo -------------------------------
java -cp "bin;lib/mysql-connector-j-9.3.0.jar" main.MainCRUD

pause