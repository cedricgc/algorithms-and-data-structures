import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
  private Node first;
  private Node last;
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

  public void enqueue(Item item) {
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    // needed since we are working with singly linked list
    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
    N++;
  }

  public Item dequeue() {
    Item item = first.item;
    first = first.next;
    // ensure isEmpty and iterator work
    if (isEmpty()) {
      last = null;
    }
    N--;
    return item;
  }

  public Iterator iterator() {
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<Item> {
    Node it;

    QueueIterator() {
      it = first;
    }

    public boolean hasNext() {
      return it != null;
    }

    public Item next() {
      Item item = it.item;
      it = it.next;

      return item;
    }

    public void remove() {}
  }
}
