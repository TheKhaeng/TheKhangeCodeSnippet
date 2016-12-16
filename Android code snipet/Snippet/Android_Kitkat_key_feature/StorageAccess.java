/****************************************/
/** Created by TheKhaeng on 7/17/2016. **/
/****************************************/

// Before Kitkat:
Intent intent = new Intent( Intent.ACTION_GET_CONTENT );
intent.setType("file/*");
// intent.setType( "image/*" );
startActivityForResult( intent, RESULT_CODE );

// After Kitkat:
Intent intent = new Intent( Intent.ACTION_OPEN_DOCUMENT );
intent.addCategory( Intent.CATEGORY_OPENABLE );
intent.setType( "image/*" );
fragment.startActivityForResult( intent, REQUEST_SAF_PICK_IMAGE );

 @Override
 public void onActivityResult( int requestCode, int resultCode, Intent data ){
     super.onActivityResult( requestCode, resultCode, data );
     Uri uri = null;
     if( resultCode == RESULT_OK ){
         switch( requestCode ){
             case REQUEST_SAF_PICK_IMAGE:
                 uri = data.getData();
                 ...
                 break;
         }
     }
 }
