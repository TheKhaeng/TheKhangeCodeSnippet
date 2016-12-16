class Mutable {
  private int[] array = new int[10];
  public int[] getArray() {
    return array;
  }
  public void setArray(int[] i) {
    array = i;
  }
}

// Wrap mutable class
class Immutable extends Mutable {
  @Override
  public int[] getArray() {
    return super.getArray().clone();
  }
  @Override
  public void setArray(int[] i) {
    throw new UnsupportedOperationException();
  }
}
// ...
private Mutable mutable = new MutableProtector();
// May be safely invoked by untrusted caller having read ability
public Mutable getMutable() {return mutable; }
