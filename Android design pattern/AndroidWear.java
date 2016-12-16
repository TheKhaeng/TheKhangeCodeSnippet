dependencies {
  ...
  compile 'com.google.android.support:wearable:+'
  compile 'com.google.android.gms:play-services-wearable:+'
  ...
}

@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_wear);
  WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);

  stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
    @Override public void onLayoutInflated(WatchViewStub stub) {
      // the view has been inflated and can now be used
      TextView tv = (TextView) stub.findViewById(R.id.text);
      // rest of your code
    }
  });
}

_______________________________

// [ Communicating with Android Wear ]
// By default, notifications are automatically bridged to Wear devices.

int notificationId = 007;
Intent viewIntent = new Intent(this, ViewEventActivity.class);
viewIntent.putExtra(EXTRA_EVENT_ID, eventId);
PendingIntent viewPendingIntent = PendingIntent.getActivity(this, 0, viewIntent, 0);
// create the action that will trigger on tap
NotificationCompat.Action action = new NotificationCompat.Action.Builder(
      R.drawable.ic_action,
      getString(R.string.label), actionPendingIntent).build();
// create notification using support library
NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
      .setSmallIcon(R.drawable.ic_event)
      .setContentTitle(eventTitle)
      .setContentText(eventLocation)
      .setContentIntent(viewPendingIntent)
      .addAction( action );
//    .extend(new WearableExtender().addAction(action)); //only want visible on a Wear device
// set up instance of NotificationManager service
NotificationManagerCompat notificationManager =
NotificationManagerCompat.from(this);
// Use notify() to build the notification and send
notificationManager.notify(notificationId, notificationBuilder.build());

________________________________

// [ Sending Data ]
// Github: https://github.com/googlesamples/android-FindMyPhone/
// Wearable Data Layer API component objects
// ■ DataItem : Object that stores data to be synced between handheld and wearable devices.
// ■ Asset : Object that stores binary blob data; assets will be automatically cached to improve
//           Bluetooth performance.
// ■ DataListener : Used for determining when data layer events are in the foreground; note
//                  that it will only work when your app is in the foreground.
// ■ WearableListenerService : When not working exclusively in the foreground, WearableListenerService
//                             should be extended, allowing the system to control the
//                             lifecycle and data binding.
// ■ ChannelApi : This API is useful for transferring files that are large, such as movies, music,
//                and other media files. Use of the ChannelApi allows you to transfer files without creating
//                a container file first and then synchronizing the data.
// ■ MessageApi : Small payload messages use the MessageApi . These are messages such as
//                media player commands and one-way directives.


// Note: Google Play Services, you need to create a client to access the Wearable Data Layer.
GoogleApiClient myGoogleApiClient = new GoogleApiClient.Builder(this)
  .addConnectionCallbacks(new ConnectionCallbacks() {
        @Override
        public void onConnected(Bundle connectionHint) {
          Log.d(TAG, "onConnected: " + connectionHint);
          // Data Layer ready for use
        }
        @Override
        public void onConnectionSuspended(int cause) {
          // log the cause of connection pause
          Log.d(TAG, "onConnectionSuspended: " + cause);
        }
      }).addOnConnectionFailedListener(new OnConnectionFailedListener() {
            @Override
            public void onConnectionFailed(ConnectionResult result) {
            // log reason for connection failure
            Log.d(TAG, "onConnectionFailed: " + result);
          }
        }).addApi(Wearable.API).build();

// When sending messages with the MessageApi , you can choose a specific node or available
// connections between the Wear and connected device, or you can broadcast to all of them.
// Specifying the node and capabilities creates a more streamlined service, but will require extra
// implementation to handle the hand-off between different nodes (such as Bluetooth and Wi-Fi
// switching on and off).
// The following snippet of code shows you how to find all available nodes and return them in a
// HashSet of String s that can then be used for sending a message:
private Collection<String> getNodes() {
  HashSet<String> results = new HashSet<String>();
  NodeApi.GetConnectedNodesResult nodes =
  Wearable.NodeApi.getConnectedNodes(myGoogleApiClient).await();
  for (Node node : nodes.getNodes()) {
    results.add(node.getId());
  }
  return results;
}
