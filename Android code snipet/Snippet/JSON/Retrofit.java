/****************************************/
/** Created by TheKhaeng on 7/10/2016. **/
/****************************************/
______________________________________________________________________________
// [ Retrofit 2 Overview ]
// Use Gson converter
// Manifest.xml : <uses-permission android:name="android.permission.INTERNET" />

// 1. create YOUR_DAO
// 2. create HTTP API into a Java interface.
// 3. create Retrofit object with YOUR_INTERFACE
// 4. create YOUR_CALLBACK --> onResponse(...), onFailure(...)
// 5. get Call from YOUR_INTERFACE and call.enqueue( YOUR_CALLBACK );
// Gson other usage
Movie movie = new Gson().fromJson( JSON_STRING, YOUR_DAO.class );
String json = new Gson().toJson( YOUR_DAO_OJECT );
______________________________________________________________________________

//NOTE: you can quickly generate JSON to DAO class ---> http://www.jsonschema2pojo.org/
______________________________________________________________________________

// 1. create YOUR_DAO
public class ExampleDao{
    @SerializedName( "token" )      private String token;
    @SerializedName( "name" )       private String name;
    @SerializedName( "email" )      private String email;
    @SerializedName( "phone" )      private String phone;
    @SerializedName( "image" )      private String image;
    @SerializedName( "friends" )    private ArrayList<String> friends;
    @SerializedName( "animations" ) private ArrayList<String> animations;
    ...

}
______________________________________________________________________________

// 2. create HTTP API into a Java interface.
public interface ApiService{

    @POST("list")
    Call<PhotoItemCollectionDao> loadPhotoList();

    ...

    @POST("list/before/{id}")
    Call<PhotoItemCollectionDao> loadPhotoListBeforeId( @Path("id") int id );
}

______________________________________________________________________________

// 3. create Retrofit object and create with YOUR_INTERFACE
private ApiService getService(){
    mContext = Contextor.getInstance().getContext();

    //Date format each Server not same we will handle it
    Gson gson = new GsonBuilder()
            .setDateFormat( "yyy-MM-dd'T'HH:mm:ssZ" )
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://example.com/example1/")
            .addConverterFactory( GsonConverterFactory.create(gson) )
            .build();

    service = retrofit.create( ApiService.class );
    return service
}

______________________________________________________________________________

// 4. create YOUR_CALLBACK
private class retrofitCallback implements Callback<YOUR_DAO>{

    ...

    @Override
    public void onResponse( Call<YOUR_DAO> call, Response<YOUR_DAO> response ){
        swipeRefreshLayout.setRefreshing( false );
        if( response.isSuccessful() ){
            YOUR_DAO dao = response.body();
            // TODO: handle YOUR_DAO
        }else{
            // Can connect but not success ex. "404 not found"
            try{
                // TODO: show error "response.errorBody().string()"
            }catch( IOException e ){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure( Call<YOUR_DAO> call, Throwable t ){
        clearLoadingMoreFlagIfCapble( mode );
        swipeRefreshLayout.setRefreshing( false );
        Utils.getInstance().showToast( t.toString(), Toast.LENGTH_LONG );
    }

    ...
}

______________________________________________________________________________

// 5. get Call from YOUR_INTERFACE and call.enqueue( YOUR_CALLBACK );
Call<YOUR_DAO> call = ...getService().loadPhotoListBeforeId( minId );
call.enqueue( retrofitCallback );
