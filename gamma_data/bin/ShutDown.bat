@echo off
IF [%1] == [] (
	echo Missing Argument Session Id.
	GOTO EXIT
)
set sessionId=%1
wmic process where "caption='java.exe' and commandline like '%%%sessionId%%%'"  Call Terminate
wmic process where "caption='cxxparser.exe' and commandline like '%%%sessionId%%%'"  Call Terminate
wmic process where "caption='Acellere.Corona.CSharp.Parser.exe' and commandline like '%%%sessionId%%%'"  Call Terminate
wmic process where "caption='cppcheck.exe'"  Call Terminate

:EXIT