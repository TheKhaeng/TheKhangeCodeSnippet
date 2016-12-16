/****************************************/
/** Created by TheKhaeng on 7/10/2016. **/
/****************************************/

private void alertDialog(){
    //@See http://www.androidsnippets.com/simple-alert-dialog-popup-with-title-message-icon-and-button
    /** Support v7 **/
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle);
    builder.setTitle("AppCompatDialog");
    builder.setMessage("Lorem ipsum dolor...");
    builder.setPositiveButton( "OK", new DialogInterface.OnClickListener(){
        @Override
        public void onClick( DialogInterface dialog, int which ){

        }
    } );
    builder.setNegativeButton( "Cancel", new DialogInterface.OnClickListener(){
        @Override
        public void onClick( DialogInterface dialog, int which ){

        }
    } );
    builder.show();


    /** Support v4 **/
    AlertDialog alertDialog = new AlertDialog.Builder(this).create();
    alertDialog.setTitle("Title");
    alertDialog.setMessage("Message");
    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
       public void onClick(DialogInterface dialog, int which) {
           //@ TODO Add your code for the button here.
       }
    });
    // Set the Icon for the Dialog
    alertDialog.setIcon(R.drawable.icon);
    alertDialog.show();
}
