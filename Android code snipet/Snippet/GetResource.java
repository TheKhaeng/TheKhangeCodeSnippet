/****************************************/
/** Created by TheKhaeng on 7/10/2016. **/
/****************************************/

private void getResource(){
    // A) drawables without theme attributes
       ResourcesCompat.getDrawable(getResources(), R.drawable.name, null);

    // B) drawables with theme attributes
       ContextCompat.getDrawable(getActivity(), R.drawable.name);

    // EXTRA) drawables with theme attributes from another theme
       ResourcesCompat.getDrawable(getResources(), R.drawable.name, anotherTheme);


       ContextCompat.getColor( context, R.color.YOUR_COLOR );
       mContext.getResources().getString( R.string.YOUR_STRING );
}
