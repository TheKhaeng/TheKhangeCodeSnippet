// Manifest
<uses-permission android:name="android.permission.GET_ACCOUNTS"></uses-permission>
<uses-permission android:name="android.permission.AUTHENTICATE_ACCOUNTS">
</uses-permission>

AccountManager myAccountManager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
Account[] list = myAccountManager.getAccounts();
String googleAccount = "No Google Account";
for(Account account: list) {
  if(account.type.equalsIgnoreCase("com.google")) {
    googleAccount = account.name;
    break;
  }
}
// set text view to googleAccount
TextView tv = (TextView) findViewById(R.id.myTextView);
tv.setText(googleAccount);
