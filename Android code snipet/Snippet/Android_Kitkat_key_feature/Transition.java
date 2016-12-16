/****************************************/
/** Created by TheKhaeng on 7/17/2016. **/
/****************************************/
______________________________________________________________________________
Transisition Framework
// [ Overview ]
// 1.Get Scenes
// 2.Create Transition
// 3.Changing Scenes
// 4.Dynamic changing view
// 5.Custom TransistionManager

// [ Get Sceense ]
Scene( viewGroup );
Scene.setEnterAction( runnable ); //use runnable to callback
Scene.getSceneForLayout( sceneRoot, R.layout.someId, context );

------------------------------------------------------------------------------
// [ Create Transitions] (scene to scene)
// 1. individually
ChangeBounds(); //change position and size
Fade();

// 2. Sets
TransitionSet set = new TransitionSet();
set.addTransition( new ChangeBounds() ) // run sequientially
    .addTransition( new Fade() );

// 3. From resource files
<transitionSet xmlns:android="http://schemas.android.com/apk/res/android"
    annroid:transitionOrdering="sequential">
    <changeBounds/>
    <fade android:fadingMode="fade_in">
        <targets>
            <target android:targetId="@id/transition_title" />
        </targets>
    </fade>
</transitionSet>

// 4. Create Custom Transitions
Subclass "Transition"
Override 3 method
captureStartValue( transitionValue );
captureEndValues( transitionValue );
createAnimator( viewGroup, transitionValues, transitionValues );
------------------------------------------------------------------------------
// [ Changing Scenes ]

// 1. Without Transition
Scene.enter(); // run the code that was in your Runnable
// 2. With default transition
TransitionManager.go( scene );
// 3. With custom Transition
TransitionManager.go( scene, transition  );
transitionManaber.transitionTo( scene ); //for TransitionManager instance

------------------------------------------------------------------------------
// [ Dynamic Change view ]
TransitionManager.beginDelayedTransition( viewGroup );
setNewSize( R.id.view1, 150, 25);
setNewSize( R.id.view2, 150, 25);
setNewSize( R.id.view3, 150, 25);

private void setNewSize( int id, int width, int height ){
        View view = mSceneRoot.findViewById( id );
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams( params );
    }
------------------------------------------------------------------------------
// [ Custom TransistionManager ]

// if you don't need any custom transitions from scene one to scene two "different",
// you wouldn't care about "Custom TransitionnManager" just run "TransitionManager.go(...)"
mTransitionManager = TransitionInflater.from( getActivity() )
       .inflateTransitionManager( R.transition.transition_manager, mSceneRoot );

// Usage
mTransitionManager.transitionTo( mScene1 );
mTransitionManager.transitionTo( mScene3 );

// XML
<transitionManager xmlns:android="http://schemas.android.com/apk/res/android"
  <transition android:fromScene="@layout/scene1"
              android:toScene="@layout/scene3"
              android:transition="@transition/changebounds_fadeIn"
  <transition android:fromScene="@layout/scene2"
              android:toScene="@layout/scene3"
              android:transition="@transition/changebounds_fadeOut"
  <transition android:toScene="@layout/scene3"
              android:transition="@transition/changebounds_fadein"/>
              ...
</transitionManager>
______________________________________________________________________________
