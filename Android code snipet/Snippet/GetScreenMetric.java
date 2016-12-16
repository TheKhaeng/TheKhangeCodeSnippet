/****************************************/
/** Created by TheKhaeng on 9/23/2016. **/
/****************************************/
DisplayMetrics displaymetrics = new DisplayMetrics();
getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
int height = displaymetrics.heightPixels;
int width = displaymetrics.widthPixels;

or

Resources.getSystem().getDisplayMetrics().widthPixels;
Resources.getSystem().getDisplayMetrics().heightPixels;
