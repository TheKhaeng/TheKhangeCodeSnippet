/****************************************/
/** Created by TheKhaeng on 7/10/2016. **/
/****************************************/
______________________________________________________________________________

<activity android:name="com.your.package.ActivityName"
          android:windowSoftInputMode="stateHidden"  />

______________________________________________________________________________
public void hideKeyboard(){
   InputMethodManager imm = (InputMethodManager) getActivity().getSystemService( Context.INPUT_METHOD_SERVICE );
   imm.hideSoftInputFromWindow( getView().getWindowToken(), 0 );
}
