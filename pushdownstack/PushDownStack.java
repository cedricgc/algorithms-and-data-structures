import java.util.Iterator;

public class PushDownStack<Item> implements Iterable<Item> {
  private Node first;
  private int N;

  private class Node {
    Node next;
    Item item;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return N;
  }

  public void push(Item item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    N++;
  }

  public Item pop() {
    Item item = first.item;
    first = first.next;
    N--;

    return item;
  }

  public Iterator iterator() {
    return new StackIterator();
  }

  private class StackIterator implements Iterator<Item> {
    private Node it;

    StackIterator() {
      it = first;
    }

    public boolean hasNext() {
      return it.next != null;
    }

    public Item next() {
      Item item = it.item;
      it = it.next;

      return item;
    }

    public void remove() {}
  }
}
