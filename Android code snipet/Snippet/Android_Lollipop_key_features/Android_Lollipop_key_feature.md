# Lollipop key feature

- Material Design
- New notifications
- WebView updated
- Project Volta system to save battery (JobScheduler New API)
- New Android Runtime (ART)
- Android Work
- Updated camera
- Game developer support OpenGL ES 3.1
- BLE: Mobile can act Peripheral mode (broadcast).
- Improved Quick Settings
- Tap and Go
- Guest Mode
- Screen capturing and sharing

## Lock screen notifications

You can now view and respond to messages directly from your lock screen, or hide notifications for sensitive content. Turning on Priority mode through your device's volume button will allow only certain people and notifications get through.You can also choose to avoid calls from interrupting the game you are playing or the movie you are watching.

### level (private is default)

- private: _private version_ : content won't show in lock screen.
- private: _public version_ : content will show in lock screen.
- public: always shown.
- secret: not shown in lock screen.

```java
NotificationCompapt.Builder.setVibrate();
NotificationCompapt.Builder.setSound();
```

(please don't work around NotificationManager to vibrate and play sound)

media play back control

```java
NotificationCompapt.MediaStyle
```

- Use Notification.Builder, or create new layouts
- Pick an accent color
- Decide visibility level
- Add a flat to your manifest for settings

## New Android Runtime (ART)

Ahead-of-time (AOT) compilation

Improved garbage collection

Improved development and debugger

## Cammera update

Completely new set of API

You'll be able to capture full resolution frames around 30fps, and shoot in raw formats like YUV and Bayer RAW

![](https://spectrastudy.com/wp-content/uploads/2015/03/Camera2-pipeline.jpg)

Attach surface to CameraDevice. Each surface can be a destination for a stream of image buffers, and you can pass request(asynchronously) through the CaptureSession. Each request will be converted into "one result object".

## Game developer support OpenGL ES 3.1

This give you compute shaders, stencil texture, and texture gather for you games.

## Tap and go

Tap and Go for NFC devices lets you set up your new Android phone by simply tapping it to your old one. Whenever you get a new Android phone or tablet, you can sync your apps from Google Play automatically from any of your old Android devices.
