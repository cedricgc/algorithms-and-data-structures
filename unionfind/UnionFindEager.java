

// Data structure uses the Quick Find algorithm
class UnionFindEager {
  int[] id;

  UnionFind(int n) {
    id = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }

  void union(int p, int q) {
    int marker = id[p];
    int newMarker = id[q];
    for(int i = 0; i < size; i++) {
      if(id[i] == marker) {
        id[i] = newMarker;
      }
    }
  }

  boolean connected(int p, int q) {
    return id[p] == id[q];
  }

  int find(int p) { return 0; }

  int count() {
    return id.size;
  }
}
