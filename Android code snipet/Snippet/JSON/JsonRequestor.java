/****************************************/
/** Created by TheKhaeng on 7/10/2016. **/
/****************************************/

______________________________________________________________________________
// [ Overview ]
// Parameter: requestQueue = VolleySingleton.getInstance().getRequestQueue();

// 1. create JsonObjectRequest jsObjRequest = new JsonObjectRequest(...);
// 2. requestQueue.add(request);
______________________________________________________________________________


public void requestJSON(RequestQueue requestQueue, String url) {
    JsonObjectRequest jsObjRequest = new JsonObjectRequest
            (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

        @Override
        public void onResponse(JSONObject res) {
          // TODO parse JSONObject to JAVA object
        }
    }, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
           handleVolleyError( error );
        }
    });

    requestQueue.add(request);
}

private void handleVolleyError( VolleyError error ){
    if( error instanceof TimeoutError ||
          error instanceof NoConnectionError){

    }else if( error instanceof AuthFailureError ){

    }else if( error instanceof ServerError ){

    }else if( error instanceof NetworkError ){

    }else if( error instanceof ParseError ){

    }
}
