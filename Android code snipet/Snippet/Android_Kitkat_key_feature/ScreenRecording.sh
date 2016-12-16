/****************************************/
/** Created by TheKhaeng on 7/17/2016. **/
/****************************************/

# ADB:Android Debug Bridge
# text command
adb devices
# start reccord
adb shell screenrecord /sdcard/video.mp4
# Ctrl-c to end reccording
# pull video to your computer
adb pull /sdcard/video.mp4

# Setting > Developer options > Input > Show touches
