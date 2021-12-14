@echo off
REM Set server root for future reference
set server_root=C:\xampp\tomcat

REM Remove second layer backup
RD /S /Q %server_root%\webapps\ROOT_SECOND

REM create a second layer backup to prevent accidental builds
rename %server_root%\webapps\ROOT_BACKUP ROOT_SECOND

REM Creating backup of prev package by renaming the root directory
rename %server_root%\webapps\ROOT ROOT_BACKUP

REM CI process (Integration)
REM Initiating Code Build ---> Getting ready for deployment
mvn clean compile test site package install


REM CD process (Deployment)
REM Shutting down tomcat server
REM %server_root%\bin\shutdown

REM Initiating the server for up and run again
REM %server_root%\bin startup

REM Note --> Please include JAVA_HOME / JRE_HOME variable
REM Assign the above variable in %server_root%\bin\JAVA_HOME
