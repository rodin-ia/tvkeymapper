# Key mapper
Introducing you simple app that allows to bind keys on your remote to run specific apps or do othe
r stuff

# How to build
mkdir -p ~/Android/Sdk/cmdline-tools
cd /tmp

wget https://dl.google.com/android/repository/commandlinetools-linux-13114758_latest.zip
unzip commandlinetools-linux-13114758_latest.zip

mv cmdline-tools ~/Android/Sdk/cmdline-tools/lates

export ANDROID_HOME="$HOME/Android/Sdk"
export ANDROID_SDK_ROOT="$ANDROID_HOME"
export PATH="$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools:$PATH"
export JAVA_HOME=$HOME/.bin/jdk-17.0.20+8/


sdkmanager "platform-tools" "platforms;android-35" "build-tools;35.0.0"

./gradlew assembleDebug

# How to change functionality

# How to set up working environment
- Enable developer mode on your TV; 
- Allow debugging via usb;
- Install adb client on your computer;
- Open Android Studio IDE and write `adb connect {{ ip_address_of_your_TV }}` command in terminal;
- You are all set.
