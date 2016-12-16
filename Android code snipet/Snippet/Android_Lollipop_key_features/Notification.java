/****************************************/
/** Created by TheKhaeng on 7/21/2016. **/
/****************************************/

 public void sendNotification() {

     // This intent is fired when notification is clicked
     Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stacktips.com/"));
     PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

     /* Add Big View Specific Configuration */
     NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
     inboxStyle.setBigContentTitle("Big Title Details:");


     // Use NotificationCompat.Builder to set up our notification.
     NotificationCompat.Builder builder =
        new NotificationCompat.Builder(this)
           .setSmallIcon(R.drawable.ic_stat_notification)
           .setContentTitle("Notifications Title")
           .setContentText("Your notification content here.")
           .setSubText("Tap to view documentation about notifications.")
           .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
           .setContentIntent(pendingIntent)
           .setStyle(inboxStyle);

     NotificationManager notificationManager =
            (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

     // Will display the notification in the notification bar
     notificationManager.notify(NOTIFICATION_ID, builder.build());
 }
