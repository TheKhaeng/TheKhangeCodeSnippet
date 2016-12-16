// No
SecureRandom random = new SecureRandom(
  String.valueOf(new Date().getTime().getBytes())
);

// Yes
// no use same seed
byte[] randomBytes = new btye[128];
SecureRandom random = new SecureRandom();
random.nextBytes( randomBytes );
