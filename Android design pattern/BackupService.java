// to store a small amount of user data.
// 1MB per account per application.

<meta-data android:name="com.google.android.backup.api_key"
android:value="ABcDe1FGHij2KlmN3oPQRs4TUvW5xYZ" />

<application android:label="MyApp" android:backupAgent="MyBackupAgent">

import android.app.backup.BackupAgentHelper;
import android.app.backup.FileBackupHelper;
public class MyBackupAgent extends BackupAgentHelper {
  // set the name(s) of a preference file to backup
  static final String HIGH_SCORES_FILENAME = "scores";
  static final String INVENTORY_FILENAME = "inventory";
  // create a key to identify the backup data set
  static final String FILES_BACKUP_KEY = "mybackupfileskey";
  // allocate the helper and add it to the backup agent

  // set the names of the preferences to back up
  // these should match values used in getSharedPreferences()
  static final String PREFS_OPTIONS = "optionsprefs";
  static final String PREFS_SCORES = "highscores";
  // create a key to use with your preferences backup
  static final String PREFS_BACKUP_KEY = "myprefsbackupkey";

  @Override
  void onCreate() {
    // back up file
    FileBackupHelper helper = new FileBackupHelper(this, HIGH_SCORES_FILENAME, INVENTORY_FILENAME);
    addHelper(FILES_BACKUP_KEY, helper);
    // back up pref
    SharedPreferencesBackupHelper helper = new SharedPreferencesBackupHelper(this, PREFS_OPTIONS, PREFS_SCORES);
    addHelper(PREFS_BACKUP_KEY, helper);
  }

  // To begin a backup process, you need to use the BackupManager and dataChanged()
  // method to request a backup. After the request happens, the backup manager calls the
  // onBackup() method and the backup will be performed.
  public void requestBackup() {
    BackupManager bm = new BackupManager(this);
    bm.dataChanged();
  }
}
