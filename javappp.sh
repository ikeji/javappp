#!/bin/sh

if [ "x$JAVAPPP_PREPROCESS" != "x" ]
then
  JAVAPPP_ARG=-Dpreprocess.classes=$JAVAPPP_PREPROCESS
fi

java -cp bin -Xbootclasspath/p:bin $JAVAPPP_ARG com.sun.tools.javac.Main -source 1.6 -target 1.6 $*

