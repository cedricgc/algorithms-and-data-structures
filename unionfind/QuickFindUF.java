import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Data structure uses the Quick Find algorithm
class QuickFindUF {
  private int[] id;
  private int count;

  public QuickFindUF(int n) {
    id = new int[n];
    count = n;
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }

  public void union(int p, int q) {
    validate(p);
    validate(q);
    int marker = id[p];
    int newMarker = id[q];

    // already in same component
    if (marker == newMarker) {
      return;
    }

    for(int i = 0; i < id.length; i++) {
      if(id[i] == marker) {
        id[i] = newMarker;
      }
    }

    count--;
  }

  public int find(int p) {
    validate(p);
    return id[p];
  }

  public boolean connected(int p, int q) {
    validate(p);
    validate(q);
    return id[p] == id[q];
  }

  public int count() {
    return count;
  }

  private void validate(int p) {
    int length = id.length;
    if (p < 0 || p >= length) {
      throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (length-1));
    }
  }

  public static void main(String[] args) {
    int N = StdIn.readInt();
    QuickFindUF uf = new QuickFindUF(N);
    while (!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if (!uf.connected(p, q)) {
        uf.union(p, q);
        StdOut.println(p + " " + q);
      }
    }

    assert uf.connected(1, 6);
  }
}
