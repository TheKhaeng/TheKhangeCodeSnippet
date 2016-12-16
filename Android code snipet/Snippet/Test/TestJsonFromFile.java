/****************************************/
/** Created by TheKhaeng on 9/15/2016. **/
/****************************************/

    /*****************/
    /** Mock method **/
    /******************/
    //<editor-fold desc="Mock function folding">
    private <T> T getPackageGroupMock(String fileName, Class<T> className){
        String json = getJsonFromResources( fileName );
        Gson gson = new GsonBuilder() .create();
        return gson.fromJson( json, className );
    }

    private String getJsonFromResources( String fileName){
        BufferedReader reader = null;
        String mLineResult = "";
        try{
            reader = new BufferedReader(
                    new InputStreamReader( this.getClass().getClassLoader().getResourceAsStream( fileName ), "UTF-8" ) );

            // do reading, usually loop until end of file reading
            String mLine = null;
            while( ( mLine = reader.readLine() ) != null ){
                mLineResult += mLine;
            }
        }catch( IOException e ){
            //log the exception
        }finally{
            if( reader != null ){
                try{
                    reader.close();
                }catch( IOException e ){
                    //log the exception
                }
            }
        }

        return mLineResult;
    }
    //</editor-fold>
