#!/bin/bash

if [ $DEBUG_PORT -ge 0 ];
  then
    echo "USE DEBUG MODE"
    java  -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:$DEBUG_PORT -cp app:app/lib/* $MAIN_CLASS_NAME
   else
     echo "NORMAL STARTUP"
     java  -cp app:app/lib/* $MAIN_CLASS_NAME
fi