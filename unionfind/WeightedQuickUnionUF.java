import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Data structure uses the lazy Quick Union algorithm
class WeightedQuickUnionUF {
  private int[] id;
  private int[] size;
  private int count;

  public WeightedQuickUnionUF(int n) {
    id = new int[n];
    size = new int[n];
    count = n;
    for (int i = 0; i < n; i++) {
      id[i] = i;
      size[i] = 1;
    }
  }

  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);

    // components are already connected
    if (pRoot == qRoot) {
      return;
    }

    // smaller tree points to larger one
    if (size[pRoot] < size[qRoot]) {
      id[pRoot] = qRoot;
      size[qRoot] += size[pRoot];
    } else {
      id[qRoot] = pRoot;
      size[pRoot] += size[qRoot];
    }

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
      // Path Compression: make non-terminal node point to grandparent to
      // flatten tree
      id[mover] = id[id[mover]];
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
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
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
