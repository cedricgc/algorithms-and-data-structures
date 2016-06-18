import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
  private Item[] a = (Item[]) new Object[1];
  private int N = 0;

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void push(Item item) {
    if(N == a.length) {
      int newSize = a.length * 2;
      resize(newSize);
    }

    a[N] = item;
    N++;
  }

  public Item pop() {
    N--;
    Item item = a[N];
    a[N] = null;
    if(N <= a.length/4) {
      resize(a.length/2);
    }

    return item;
  }

  private void resize(int max) {
    Item[] temp = (Item[]) new Object[max];
    for(int i = 0; i < N; i++) {
      temp[i] = a[i];
    }

    a = temp;
  }

  public Iterator iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i = N;

    public boolean hasNext() {
      return i > 0;
    }

    public Item next() {
      i--;
      Item item = a[i];

      return item;
    }

    public void remove() {}
  }
}
