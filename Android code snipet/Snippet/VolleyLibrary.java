/****************************************/
/** Created by TheKhaeng on 7/10/2016. **/
/****************************************/
______________________________________________________________________________
// [ Overview ]
// github.com/mcxiaoke/android-volley
// Manifest.xml : <uses-permission android:name="android.permission.INTERNET" />
// NOTE:Volley is designed to queue all your requests. It wouldn't make sense to have more than one queue,and that's why it's a singleton
______________________________________________________________________________
// [ Usage ]
getRequestQueue().add( request ); // JsonObjectRequest, StringRequest, ...

//1. Upon being attached to a request, onResponse(response, true) will be invoked to reflect any cached data
//   that was already available. If the data was available, response.getBitmap() will be non-null.
//2. After a network response returns, only one of the following cases will happen:
//     - onResponse(response, false) will be called if the image was loaded. or
//     - onErrorResponse will be called if there was an error loading the image.
getImageLoader().get( url , new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    // Example
                    holder.movieThumbnail.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
______________________________________________________________________________


public class VolleySingleton {
    private static VolleySingleton instance=null;
    private ImageLoader mImageLoader;
    private RequestQueue mRequestQueue;
    private Context mContext;

    public static VolleySingleton getInstance(){
        if(instance==null) {
            instance=new VolleySingleton();
        }
        return instance;
    }

    private VolleySingleton(){
        mContext = Contextor.getInstance().getContext();
        // don't do every Fragment/Activity use Singleton is BasePractice
        // Because it's expensive statement
        mRequestQueue=getRequestQueue();
        mImageLoader=getImageLoader();
    }

    public void addStringGetRequest(String url){
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                  new Response.Listener<String>() {
          @Override
          public void onResponse(String response) {
              // Display the first 500 characters of the response string.
          }
        }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            // Show error
          }
        });
        // Add the request to the RequestQueue.
        mRequestQueue.add(stringRequest);
    }



    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext);
        }
        return mRequestQueue;
    }


    public ImageLoader getImageLoader(){
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(mRequestQueue,new ImageLoader.ImageCache() {
                // Recommend use LruCache for cache image
                private LruCache<String, Bitmap> cache=new LruCache<>((int)(Runtime.getRuntime().maxMemory()/1024)/8);

                @Override
                public Bitmap getBitmap(String url) {
                    return cache.get(url);
                }

                @Override
                public void putBitmap(String url, Bitmap bitmap) {
                    cache.put(url, bitmap);
                }
            });
        }
        return mImageLoader;
    }
}
