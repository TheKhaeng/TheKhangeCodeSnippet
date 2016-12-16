/****************************************/
/** Created by TheKhaeng on 7/10/2016. **/
/****************************************/
______________________________________________________________________________
// [ Otto Overview ]
// http://square.github.io/otto/
// compile 'com.squareup:otto:1.3.8'

// 1. regis bus --> bus.regis( OBJECT ); ex. Activity, Fragment, ...
//    unrgis bus --> bus.unregis( OBJECT );
//    for @Subcribe method which you want to listen "Event object"
// 2. create "Event object" which you want to pass in bus.
// 3. post "Event object" to bus.
______________________________________________________________________________

// 1. regis bus --> bus.regis( OBJECT ); ex. Activity, Fragment, ...
//    unrgis bus --> bus.unregis( OBJECT );
//    for @Subcribe method which you want to listen "Event object"
public class MainFragment extends Fragment{

    ...

    @Override
    public void onResume(){
        super.onResume();
        MainBus.getInstance().register( this );
    }

    @Override
    public void onPause(){
        super.onPause();
        MainBus.getInstance().unregister( this );
    }

    ...

    @Subscribe
    public void receiveEventBus( EventBus event ){
        int action = event.getAction();
        switch( action ){
            case Bluetooth.STATE_CONNECTED:
                break;
                ...
            case Bluetooth.STATE_DISCONNECTING:
                break;
        }
    }

    ...
}
______________________________________________________________________________

// 2. create "Event object" which you want to pass in bus.
public class EventBus{

    private int action;
    private Bundle data;

    public EventBus( int action) {
        this.action = action;
    }
    public EventBus( Bundle data){
        this.data = data;
    }

    public int getAction() {
        return action;
    }

    public void setAction( int param1) {
        this.action = param1;
    }

    public Bundle getData(){
        return data;
    }

    public void setData( Bundle data ){
        this.data = data;
    }
}
______________________________________________________________________________

// 3. post "Event object" to bus.
MainBus.getInstance().post( new Event( ACTION_EVENT ));
