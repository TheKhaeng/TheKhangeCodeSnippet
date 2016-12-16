/****************************************/
/** Created by TheKhaeng on 7/20/2016. **/
/****************************************/
[ Thread ]  - run in background.
            - must be thread.interrupt(); by myself.
            - A thread managed by the activity should terminate when the activity stops or is destroyed.

[ HandlerThread ] - its Thread has own looper.
                  - must be backgroundHandlerThread.quit(); by myself.
[ Handler ] - must bind with looper.
            - post msg to looper and handle msg.

[ Asynctask ] - run 1 Asynctask per 1 app. its mean synchonous
                // sampleAsyncTask.execute( ... );
              - but you can use Execute Thread pool to use asynchonous
                // In android Thread pool count = Number of CPU cores.
                // sampleAsyncTask.executeOnExecutor( AsyncTask.THREAD_POOL_EXECUTOR, ... );
              - It has Thread and Handler.
              - must be sampleAsyncTask.cancel( true ); by myself.
              - work with short-time process (< 5 sec)

[ Service ] - Its an application component that can perform long-running operations in the background
            - Its not an alternative to background threads but it provides another scope in which to run your worker threads!
            - Caution: A service runs in the main thread of its hosting process—the service does not create
              its own thread and does not run in a separate process (unless you specify otherwise).
              This means that, if your service is going to do any CPU intensive work or blocking operations
              (such as MP3 playback or networking), you should create a new thread within the service to do that work.
              By using a separate thread, you will reduce the risk of Application Not Responding (ANR) errors


[ IntentService ]
