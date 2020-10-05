@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  Kotlin_Sample startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and KOTLIN_SAMPLE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\Kotlin_Sample.jar;%APP_HOME%\lib\javalin-3.10.1.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.3.72.jar;%APP_HOME%\lib\guice-multibindings-4.2.0.jar;%APP_HOME%\lib\guice-4.2.0.jar;%APP_HOME%\lib\vertx-redis-client-3.9.3.jar;%APP_HOME%\lib\vertx-core-3.9.3.jar;%APP_HOME%\lib\kmongo-4.1.2.jar;%APP_HOME%\lib\kmongo-jackson-mapping-4.1.2.jar;%APP_HOME%\lib\kmongo-id-jackson-4.1.2.jar;%APP_HOME%\lib\jackson-module-loader-0.1.0.jar;%APP_HOME%\lib\jackson-module-kotlin-2.11.2.jar;%APP_HOME%\lib\jackson-databind-2.11.2.jar;%APP_HOME%\lib\slf4j-simple-1.8.0-beta4.jar;%APP_HOME%\lib\slf4j-api-1.8.0-beta4.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.3.72.jar;%APP_HOME%\lib\kmongo-core-4.1.2.jar;%APP_HOME%\lib\kmongo-property-4.1.2.jar;%APP_HOME%\lib\kmongo-shared-4.1.2.jar;%APP_HOME%\lib\kmongo-data-4.1.2.jar;%APP_HOME%\lib\kreflect-1.0.0.jar;%APP_HOME%\lib\kmongo-id-4.1.2.jar;%APP_HOME%\lib\kotlin-reflect-1.4.0.jar;%APP_HOME%\lib\kotlin-stdlib-1.4.0.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.4.0.jar;%APP_HOME%\lib\jetty-webapp-9.4.31.v20200723.jar;%APP_HOME%\lib\websocket-server-9.4.31.v20200723.jar;%APP_HOME%\lib\jetty-servlet-9.4.31.v20200723.jar;%APP_HOME%\lib\jetty-security-9.4.31.v20200723.jar;%APP_HOME%\lib\jetty-server-9.4.31.v20200723.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\aopalliance-1.0.jar;%APP_HOME%\lib\guava-23.6-android.jar;%APP_HOME%\lib\jackson-annotations-2.11.2.jar;%APP_HOME%\lib\jackson-core-2.11.2.jar;%APP_HOME%\lib\websocket-servlet-9.4.31.v20200723.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\websocket-client-9.4.31.v20200723.jar;%APP_HOME%\lib\jetty-client-9.4.31.v20200723.jar;%APP_HOME%\lib\jetty-http-9.4.31.v20200723.jar;%APP_HOME%\lib\websocket-common-9.4.31.v20200723.jar;%APP_HOME%\lib\jetty-io-9.4.31.v20200723.jar;%APP_HOME%\lib\jetty-xml-9.4.31.v20200723.jar;%APP_HOME%\lib\jsr305-1.3.9.jar;%APP_HOME%\lib\checker-compat-qual-2.0.0.jar;%APP_HOME%\lib\error_prone_annotations-2.1.3.jar;%APP_HOME%\lib\j2objc-annotations-1.1.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.14.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.49.Final.jar;%APP_HOME%\lib\netty-codec-http2-4.1.49.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.49.Final.jar;%APP_HOME%\lib\netty-handler-4.1.49.Final.jar;%APP_HOME%\lib\netty-resolver-dns-4.1.49.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.49.Final.jar;%APP_HOME%\lib\netty-codec-dns-4.1.49.Final.jar;%APP_HOME%\lib\netty-codec-4.1.49.Final.jar;%APP_HOME%\lib\netty-transport-4.1.49.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.49.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.49.Final.jar;%APP_HOME%\lib\netty-common-4.1.49.Final.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\mongodb-driver-sync-4.1.0.jar;%APP_HOME%\lib\bson4jackson-2.11.0.jar;%APP_HOME%\lib\jetty-util-9.4.31.v20200723.jar;%APP_HOME%\lib\websocket-api-9.4.31.v20200723.jar;%APP_HOME%\lib\mongodb-driver-core-4.1.0.jar;%APP_HOME%\lib\bson-4.1.0.jar


@rem Execute Kotlin_Sample
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %KOTLIN_SAMPLE_OPTS%  -classpath "%CLASSPATH%" com.sample.AppKt %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable KOTLIN_SAMPLE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%KOTLIN_SAMPLE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
