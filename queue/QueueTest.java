import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class QueueTest {
  public static void main(String[] args) {
    Queue<Integer> q;
    q = new Queue<Integer>();

    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);

    assert !q.isEmpty();

    Iterator<Integer> it = q.iterator();

    while (it.hasNext()) {
      StdOut.println(it.next());
    }

    assert q.dequeue() == 1;
  }
}
