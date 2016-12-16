/****************************************/
/** Created by TheKhaeng on 7/16/2016. **/
/****************************************/
______________________________________________________________________________
// [Use case]
// FULLSCREEN + HIDE_NAVIGATION ==> Video player
// IMMERSIVE (+ FULLSCREEN + HIDE_NAVIGATION) ==> Book readers, Magazines
// IMMERSIVE_STICKY (+ FULLSCREEN + HIDE_NAVIGATION) ==> Games, Drawing apps
______________________________________________________________________________

View.SYSTEM_UI_FLAG_IMMERSIVE


mDecorView = getWindow().getDecorView();
mDecorView.setOnSystemUiVisibilityChangeListener(
  new View.OnSystemUiVisibilityChangeListener(){
    @Override
    public void onSsystemUiVisibiliityChange(int flages){
      boolean visiblee = ( flags & View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0;
      controlsView.setVisibility( visibble ? View.VISIBLE : View.GONE)
    }
  }
)

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

----

// Persistance When you swipe down the system bars will show in a semi-transparent state
// and automatically hide after a short delay or If the use interacte somewhere.
// NOTE: cannot clear this flag because it's STICKY.
View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY //persistance

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

----

@Override
public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);

    // When the window loses focus (e.g. the action overflow is shown),
    // cancel any pending hide action. When the window gains focus,
    // hide the system UI.
    if (hasFocus) {
        delayedHide(INITIAL_HIDE_DELAY);
    } else {
        mHideHandler.removeMessages(0);
    }
}


private final Handler mHideHandler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        hideSystemUI();
    }
};

private void delayedHide(int delayMillis) {
    mHideHandler.removeMessages(0);
    mHideHandler.sendEmptyMessageDelayed(0, delayMillis);
}

---------

contentView.setClickable(true);
// Avoid simple onClick listeners because they are triggerd by the swipe Gesture
// that shows the system UI
final GestureDetector clickDetector = new GestureDetector(this,
        new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                boolean visible = (mDecorView.getSystemUiVisibility()
                        & View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0;
                if (visible) {
                    hideSystemUI();
                } else {
                    showSystemUI();
                }
                return true;
            }
        });
contentView.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return clickDetector.onTouchEvent(motionEvent);
    }
});
