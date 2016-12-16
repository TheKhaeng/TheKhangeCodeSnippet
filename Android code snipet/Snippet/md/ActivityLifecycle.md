# Acitivty lifecycle

<https://github.com/xxv/android-lifecycle>

**Activity have 6 states**

- Created
- Started (visible)
- Resumed (visible)
- Paused (partially visible)
- Stopped (hidden)
- Destroyed

**Activity lifecycle have 7 methods**

```java
onCreate()
onRestart()
onStart()
onResume()
onPause()
onStop()
onDestroy()
```

--------------------------------------------------------------------------------

## onCreate():

Called when the activity is first created. It's heavy weight method. This is where you should do all of set up:

- create views
- bind data to lists
- etc.

This method also provides you with a Bundle containing the activity's previously "_save state_", if there was one. Always followed by onStart().

## onRestart():

Called after your activity has been **stopped**, prior to it being started again. Always followed by onStart()

## onStart():

Called when the activity is becoming visible to the user. Followed by onResume()

if the activity comes to the foreground, **or** onStop() if it becomes hidden.

## onResume():

Called when the activity will start **interacting with the user**. At this point your activity is at the top of the activity stack, with user input going to it. Always followed by onPause().

## onPause():

Called as part of the activity lifecycle when an activity is going into the background, but has not (yet) been killed. The counterpart to onResume(). When activity B is launched in front of activity A, this callback will be invoked on A. **B will not be created until A's onPause() returns**, so be sure to not do anything lengthy here.

```java
FIRST Activity onCreate
FIRST Activity onStart
FIRST Activity onResume
FIRST Activity onPause
SECOND Activity onCreate
SECOND Activity onStart
SECOND Activity onResume
FIRST Activity onStop
```

## onStop():

Called when you are no longer visible to the user. You will next receive either onRestart(), onDestroy(), or nothing, depending on later user activity.

Note: that this method may **never be called, in low memory situations** where the system does not have enough memory to keep your activity's process running after its onPause() method is called. it's will save state and followed to onDestroy()

## onDestroy():

The final call you receive before your activity is destroyed. This can happen either because the activity is finishing (someone called finish() on it, or because the system is temporarily destroying this instance of the activity to save space. You can distinguish between these two scenarios with the isFinishing() method.

## onRestoreInstanceState():

This method is called between

```java
onStart();
onRestoreInstanceState(saveBundle); // call after onStart();
onPostCreate(saveBundle);
```

## onSaveInstanceState():

If called, this method will occur before onStop(). There are **no guarantees** about whether When it occur after onResume().

### When the Activity first time loads the events are called as below:

Situations

- #### When open the app

  onCreate() --> onStart() --> onResume()

- #### When back button pressed and exit the app

  onPaused() -- > onStop() --> onDestory()

- #### When home button pressed

  onPaused() --> onStop()

- #### After pressed home button when again open app from recent task list or clicked on icon

  onRestart() --> onStart() --> onResume()

- #### When open app another app from notification bar or open settings

  onPaused() --> onStop()

- #### Back button pressed from another app or settings then used can see our app

  onRestart() --> onStart() --> onResume()

- #### When any dialog open on screen

  onPause()

- #### After dismiss the dialog or back button from dialog

  onResume()

- #### Any phone is ringing and user in the app

  onPause() --> onResume()

- #### When user pressed phone's answer button

  onPause()

- #### After call end

  onResume()
