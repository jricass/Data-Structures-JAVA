package queue;

public class Queue<T> {

  private QueueNode<T> head;
  private QueueNode<T> tail;
  private int lenght;

  public boolean isEmpty() {
    return (this.head == null);
  }

  public void add(T data) {
    QueueNode<T> newNode = new QueueNode<>(data);

    if (isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.setNext(newNode);
      this.tail = newNode;
    }
    this.lenght++;
  }

  public void remove() {
    if (isEmpty()) {
      System.out.println("Sem Elementos");
    } else {
      this.head = this.head.getNext();
      this.lenght--;
    }
  }

  public void peek() {
    System.out.println("Head: [" + this.head.getData() + "]");
  }

  public void printQueue() {
    QueueNode<T> current = this.head;

    System.out.print("HEAD --> [");
    while (current.getNext() != null) {
      System.out.print(current.getData() + ", ");
      current = current.getNext();
    }
    System.out.println(current.getData() + "] <-- TAIL");
  }

  public void size() {
    System.out.println("Current size of the Queue: " + this.lenght + " elements.");
  }

}
