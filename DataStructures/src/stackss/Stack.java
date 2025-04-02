package stackss;
public class Stack<T> {

  private NodeStack<T> head;
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
    NodeStack<T> newNodeStack = new NodeStack<>(data);

    if (isEmpty()) {
      this.head = newNodeStack;
      this.currentSize++;
    } else if (this.size == this.currentSize) {
      System.out.println("Limite da pilha atingido");
    } else {
      newNodeStack.setNext(head);
      this.head = newNodeStack;
      this.currentSize++;
    }
  }

  public void pop() {
    if (isEmpty()) {
      System.out.println("Pilha sem nenhum NodeStack :(");
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
    NodeStack<T> current = this.head;
    
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
