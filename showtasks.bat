call runcrud
if "%ERRORLEVEL%" == "0" goto runwebbrowser
goto error

:runwebbrowser
start chrome http://localhost:8080/crud/v1/tasks
if "%ERRORLEVEL%" == "0" goto end

:error
echo.
echo There were errors.

:end
echo.
echo Work is finished.