#!/bin/bash

export PATH="$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools:$PATH"

DEPS="$ANDROID_HOME/installed-dependencies"

if [ ! -e $DEPS ]; then
    echo "Downloading Android SDK now!"
    cp -r /usr/local/android-sdk-linux $ANDROID_HOME &&
    echo y | android update sdk -u -a -t android-24 &&
    echo y | android update sdk -u -a -t build-tools-27.0.3 &&
    echo y | android update sdk -u -a -t tools &&
    echo y | android update sdk -u -a -t platform-tools &&
    echo y | android update sdk -u -a -t extra-google-m2repository &&
    echo y | android update sdk -u -a -t extra-android-m2repository &&
    echo y | android update sdk -u -a -t extra-android-support &&
    touch $DEPS
else
    echo "SDK is cached"
fi