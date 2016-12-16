/****************************************/
/** Created by TheKhaeng on 8/13/2016. **/
/****************************************/
______________________________________________________________________________
______________________________________________________________________________

public void launchDialog(){
        FragmentManager fm = getFragmentManager();
        AddAllPersonDialogFragment alertDialog = AddAllPersonDialogFragment.newInstance();
        alertDialog.setTargetFragment( this, RESULT_ADD_ALL_PERSON );
        alertDialog.show( fm, AddAllPersonDialogFragment.TAG );
}
