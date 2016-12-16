/****************************************/
/** Created by TheKhaeng on 7/10/2016. **/
/****************************************/
______________________________________________________________________________
// [ Overview ]
// getSupportFragmentManager() --> use in Activity.
// getFragmentManager() --> use in Fragment it's use same FragmentManager in Activity.

// .add(...)
// .remove(...)
// .replace(...) = .add(...) + .remove(...) it's not save state.
// .addToBackStack( null ) --> store this "transaction" into Backstack.
//                         --> save state if fragment destroyed.

// .attach( fragment )
// .detach( fragment ) --> just pull out on you screen(just destroy UI). It's still has Lifecycle(save state when Activty destroyed)
//                         in FragmentManager.
______________________________________________________________________________

public void changeFragment(){
   Fragment fragment = getFragmentManager()
           .findFragmentById( R.id.contentContainer );

   // don't forgot to change "Fragment"
   if( !(fragment instanceof Fragment ) ){
      getSupportFragmentManager().beginTransaction()
              // .setTransition( FragmentTransition.TRANSIT_FRAGMENT_...)
              // .setCustomAnimations( ANIM_ENTER, ANIM_EXIT,
              //                      ANIM_POP_ENTER, ANIM_POP_EXIT )
              .replace( R.id.contentContainer,
                      Fragment.newInstance() )
              // .add( R.id.contentContainer,
              //         Fragment.newInstance(), TAG )
              .addToBackStack( null )
              .commit();
            }
   }


   //[ Example ]
   //Immediately put fragment and detach for save state
   Fragment fragment = getFragmentManager()
           .findFragmentById( R.id.contentContainer );
   if( !(fragment instanceof Fragment ) ){
      getSupportFragmentManager().beginTransaction()
              .add( R.id.contentContainer,
                      Fragment.newInstance() )
              .detach( Fragment.newInstance() ) //save state when detach
              .addToBackStack( null )
              .commit();
   }
}


getFragmentManager().popBackStack();
