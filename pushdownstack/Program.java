import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

class Program {
  public static void main(String[] args) {
    PushDownStack<Integer> r;
    r = new PushDownStack<Integer>();

    r.push(2);
    r.push(3);
    r.push(4);

    Iterator<Integer> it = r.iterator();

    while(it.hasNext()) {
      StdOut.println(it.next());
    }

    int x = r.pop();
    StdOut.println("Last number is " + x);
  }
}
