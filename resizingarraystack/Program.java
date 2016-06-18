import edu.princeton.cs.algs4.StdOut;

class Program {
  public static void main(String[] args) {
    ResizingArrayStack<Integer> r;
    r = new ResizingArrayStack<Integer>();

    r.push(2);
    r.push(3);

    int x = r.pop();
    StdOut.println("Last number is " + x);
  }
}
