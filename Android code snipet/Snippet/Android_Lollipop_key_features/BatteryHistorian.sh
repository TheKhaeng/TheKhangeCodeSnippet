# /****************************************/
# /** Created by TheKhaeng on 7/21/2016. **/
# /****************************************/
# https://github.com/google/battery-historian
# https://developer.android.com/studio/profile/battery-historian-charts.html

# run localhost server
cd $GOPATH/src/github.com/google/battery-historian
go run cmd/battery-historian/battery-historian.go --port 9999

# In Andnroid studio
adb bugreport > bugreport.txt
