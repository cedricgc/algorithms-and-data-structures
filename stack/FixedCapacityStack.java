public class FixedCapacityStack<Item> {
  private Item[] container;
  private int pointer;

  FixedCapacityStack(int cap) {
    container = (Item[]) new Object[cap];
    pointer = 0;
  }

  public void push(Item item) {
    container[pointer] = item;
    pointer++;
  }

  public Item pop() {
    pointer--;
    Item item = container[pointer];

    return item;
  }

  public boolean isEmpty() {
    return pointer == 0;
  }

  public int size() {
    return pointer;
  }

  public static void main(String[] args) {
    FixedCapacityStack<String> s;
    s = new FixedCapacityStack<String>(100);
  }
}
