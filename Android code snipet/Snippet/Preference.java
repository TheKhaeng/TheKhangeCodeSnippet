/****************************************/
/** Created by TheKhaeng on 7/10/2016. **/
/****************************************/

private void preference(){
    SharedPreferences prefs = getActivity().getSharedPreferences( "dummy", Context.MODE_PRIVATE );
    // Get Data
    String value = prefs.getString( "hello", null );

    SharedPreferences.Editor editor = prefs.edit();
    // Add/Edit/Delete
    editor.putString("hello","world");
    editor.apply();
}
