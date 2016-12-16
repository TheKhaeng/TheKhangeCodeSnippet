# Kitkat key feature

- **Tools for Analyzing Memory Use**
- **Transitions Framework**
- **Just say "OK Google"**
- **A smarter caller ID**
- **A work of art**
- **A smarter caller ID**
- **full-screen Immersive Display**
- **Print wherever, whenever**
- **Emoji keyboard**
- Transition Framework
- Video capture by ADB
- Chrome web view
- Chromecast support
- Build in Android Device Manager
- Bluetooth MAP support
- Infrared blasting
- Closed captioning (CC)
- Support for Integrated Pedometer

--------------------------------------------------------------------------------

## Tools for Analyzing Memory Use

```java
ActivityManager activityManager =
  (ActivityManager) getSystemService(ACTIVITY_SERVICE);

boolean lowRam = ActivityManager.isLowRamDevice();
if( lowRam ){
  //TODO Modify memory
}
```

## Transitions Framework

## Just say "OK Google"

> You don't need to touch the screen to get things done. When on your home screen or in Google Now, just say "OK Google" to launch voice search

## A smarter caller ID

> Whenever you get a call from a phone number not in your contacts, your phone will look for matches from businesses with a local listing on Google Maps.

## A work of art

> While listening to music on your device, or while projecting movies to Chromecast, you'll see beautiful _full-screen album and movie art when your device is locked._ You can play, pause or seek to a specific moment.

## A smarter caller ID

> Whenever you get a call from a phone number not in your contacts, your phone will look for matches from businesses with a local listing _on Google Maps_

## Full-screen Immersive Display

> Video, map, books and game – now all of these take centre stage with the new _immersive mode_ which automatically hides everything except what you really want to see

```java
View.SYSTEM_UI_FLAG_IMMERSIVE
View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY //persistance
```

```java
mDecorView = getWindow().getDecorView();
```

```java
// This snippet hides the system bars.
private void hideSystemUI() {
    // Set the IMMERSIVE flag.
    // Set the content to appear under the system bars so that the content
    // doesn't resize when the system bars hide and show.
    mDecorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
            | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
            | View.SYSTEM_UI_FLAG_IMMERSIVE);
}

// This snippet shows the system bars. It does this by removing all the flags
// except for the ones that make the content appear under the system bars.
private void showSystemUI() {
    mDecorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
}
```

```java
@Override
public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    if (hasFocus) {
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
}
```

FULLSCREEN + HIDE_NAVIGATION ( can back ) Video players

## Print wherever, whenever

> Now you can print photos, documents and web pages from your phone or tablet.(You can print to any printer connected to Google Cloud Print), to HP _ePrint printers_ and to other printers that have apps in the Google Play Store

## Emoji keyboard

> there's Emoji, the colourful Japanese characters, now available on Google Keyboard.

## Video capture by ADB

## Chrome web view

> Applications that embed web content now use Chrome to render web components accurately and quickly.

## Chromecast support

> With your Android device and a Chromecast, you can enjoy your favourite online entertainment, from BBC iPlayer, Netflix, Youtube and Google Play on your HDTV

## Build in Android Device Manager

> If you ever lose your device, you can find or wipe it

## Bluetooth MAP support

> Android now supports the Message Access Profile (MAP) so Bluetooth-enabled cars can exchange messages with your devices.

## Infrared blasting

> On devices with an infrared (IR) blaster, Android now supports applications for remote control of TVs and other nearby devices.

## Closed captioning

> Android now supports closed captioning and subtitles. To turn on closed captioning, go to Settings > Accessibility and turn on Captions.

## Support for Integrated Pedometer
