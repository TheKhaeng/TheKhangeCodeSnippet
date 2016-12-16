/****************************************/
/** Created by TheKhaeng on 7/10/2016. **/
/****************************************/

private void file(){
    // get Internal Storage Path ==> /data/user/0/<package name>/files
    File dir = getActivity().getFilesDir();
    // get Internal Storage Path ==> /data/user/0/<package name>/Image
    File dir = getActivity().getDir( "Image", Context.MODE_PRIVATE ); //create dir
    // get Internal Storage Path ==> /data/user/0/<package name>/cache
    File dir = getActivity().getCacheDir();

    Log.i( TAG, "init: " + dir.toString() );
    File file = new File( dir, "testFile.txt" );
    try{
        FileOutputStream fos = new FileOutputStream( file );
        fos.write( "hello".getBytes() );
        fos.close();
    }catch( FileNotFoundException e ){
        e.printStackTrace();
    }catch( IOException e ){
        e.printStackTrace();
    }
}
