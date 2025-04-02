package stack;

public class Stack<T> {

  private StackNode<T> head;
  private int size;
  private int currentSize;
  
  public Stack(int size) {
    this.head = null;
    this.size = size;
    this.currentSize = 0;
  }

  public boolean isEmpty() {
    return (this.head == null);
  }

  public int getSize() {
    return size;
  }

  public void push(T data) {
    StackNode<T> newStackNode = new StackNode<>(data);

    if (isEmpty()) {
      this.head = newStackNode;
      this.currentSize++;
    } else if (this.size == this.currentSize) {
      System.out.println("Limite da pilha atingido");
    } else {
      newStackNode.setNext(head);
      this.head = newStackNode;
      this.currentSize++;
    }
  }

  public void pop() {
    if (isEmpty()) {
      System.out.println("Pilha sem nenhum StackNode :(");
    } else {
      this.head = head.getNext();
      this.currentSize--;
    }
  }

  public void peek() {
    System.out.println("Elemento no topo da Pilha: " + this.head.getData());
  }

  public void isFull() {
    if (this.currentSize == this.size) {
      System.out.println("Pilha cheia: [" + this.currentSize + "/" + this.size + "]");
    } else {
      System.out.println("Pilha ainda possui espaço [" + this.currentSize + "/" + this.size + "]");
    }
  }

  public void printStack() {
    StackNode<T> current = this.head;
    
    System.out.print("HEAD ---> [");
    while (current.getNext() != null) {
      System.out.print(current.getData() + ", ");
      current = current.getNext();
    }
    System.out.println(current.getData() + "]");
  }

  @Override
  public String toString() {
    return "Stack [Head=" + head + ", Size = [" + currentSize + "/" + size + "]";
  }

}
