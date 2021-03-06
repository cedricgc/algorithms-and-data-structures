import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Data structure uses the lazy Quick Union algorithm
class QuickUnionUF {
  private int[] id;
  private int count;

  public QuickUnionUF(int n) {
    id = new int[n];
    count = n;
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }

  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);

    // components are already connected
    if (pRoot == qRoot) {
      return;
    }

    id[pRoot] = qRoot;
    count--;
  }

  boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int start) {
    validate(start);
    int mover = id[start];
    // Reached root when index value matches index
    while (id[mover] != mover) {
      mover = id[mover];
    }

    return mover;
  }

  private void validate(int p) {
    if (p < 0 || p >= id.length) {
      throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (id.length-1));
    }
  }

  public int count() {
    return count;
  }

  public static void main(String[] args) {
    int N = StdIn.readInt();
    QuickUnionUF uf = new QuickUnionUF(N);
    while (!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if (uf.connected(p, q)) {
        continue;
      }
      uf.union(p, q);
      StdOut.println(p + " " + q);
    }
    StdOut.println(uf.count() + " components");
  }
}
