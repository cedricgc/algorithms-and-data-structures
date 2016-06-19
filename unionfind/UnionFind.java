

// Data structure uses the lazy Quick Union algorithm
class UnionFind {
  int[] id;

  UnionFind(int n) {
    id = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }

  void union(int p, int q) {
    int pRoot = root(p);
    int qRoot = root(q);

    id[pRoot] = qRoot;
  }

  boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  private int root(int start) {
    int mover = id[start];
    // Reached root when index value matches index
    while (id[mover] != mover) {
      mover = id[mover];
    }

    return mover;
  }

  int find(int p) { return 0; }

  int count() {
    return id.length;
  }
}
