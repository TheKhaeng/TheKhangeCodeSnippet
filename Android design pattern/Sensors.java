//supported by Android 5.0:
// ■ Accelerometer : Hardware
// ■ Ambient temperature : Hardware
// ■ Gravity : Software or hardware
// ■ Gyroscope : Hardware
// ■ Light : Hardware
// ■ Linear acceleration : Software or hardware
// ■ Magnetic field : Hardware
// ■ Pressure : Hardware
// ■ Proximity : Hardware
// ■ Relative humidity : Hardware
// ■ Rotation vector : Software or hardware

// create object
private SensorManager mySensorManager;
// in your onCreate or similar method:
mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
// get all device sensors:
List<Sensor> allSensors = mySensorManager.getSensorList(Sensor.TYPE_ALL);

// Note: it may seem confusing that a list is used for what appears to be a single
// sensor. A list is used because there may be multiple sensors on the device, and some "by specific
// manufacturers" that you may want to use. In this case, you could create a logic check that looks
// for a specific sensor and vendor before allowing the sensor to be used.
// Example: see if the device has a proximity sensor
if (mySensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) != null) {
  // get just the proximity sensor(s):
  List<Sensor> proxSensors = mySensorManager.getSensorList(Sensor.TYPE_PROXIMITY);
  // loop through the sensors to find a Samsung version 1 sensor
  for(int i=0; i<proxSensors.size(); i++) {
    if ((proxSensors.get(i).getVendor().contains("Samsung"))
        && (proxSensors.get(i).getVersion() == 1)) {
      // Success! set a variable to the sensor
      mySensor = proxSensors.get(i);
      break;
    }
  }
}
__________________________________________

// Reading Sensor Data
// implements SensorEventListener
// - onAccuracyChanged(Sensor sensor, int accuracy)
//    accuracy:
//        ■ SENSOR_STATUS_UNRELIABLE
//        ■ SENSOR_STATUS_ACCURACY_LOW
//        ■ SENSOR_STATUS_ACCURACY_MEDIUM
//        ■ SENSOR_STATUS_ACCURACY_HIGH
// - onSensorChanged(SensorEvent event)


@Override
public final void onAccuracyChanged(Sensor sensor, int accuracy) {
// Custom logic goes here for sensor accuracy changes
}

@Override
public final void onSensorChanged(SensorEvent event) {
// The "event" may return multiple values
// Create variables to contain event values
// Perform custom logic based on sensor values
}

// ■ SENSOR_DELAY_GAME : 20,000-microsecond delay
// ■ SENSOR_DELAY_UI : 60,000-microsecond delay
// ■ SENSOR_DELAY_FASTEST : 0-microsecond delay
@Override
protected void onResume() {
  super.onResume();
// SENSOR_DELAY_NORMAL --> sampling speed default 200,000 microseconds.
  mySensorManager.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
}

@Override
protected void onPause() {
  super.onPause();
  mySensorManager.unregisterListener(this);
}
