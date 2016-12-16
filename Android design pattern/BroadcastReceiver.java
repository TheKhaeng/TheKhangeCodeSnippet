public class MyBroadcastReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    Toast.makeText(context, "Broadcast Received!", Toast.LENGTH_SHORT).show();
  }
}

--------------------------------

<receiver android:name=".MyBroadcastReceiver">
  <intent-filter>
    <action android:name="com.dutsonpa.helloandroid.MyBroadcastReceiver" />
  </intent-filter>
</receiver>

--------------------------------

@Override
protected void onResume() {
  super.onResume();
  registerReceiver(new MyBroadcastReceiver(),
  new IntentFilter(com.dutsonpa.helloandroid.MyBroadcastReceiver));
}
...
@Override
protected void onPause() {
  super.onPause();
  unregisterReceiver(MyBroadcastReceiver);
}
...
