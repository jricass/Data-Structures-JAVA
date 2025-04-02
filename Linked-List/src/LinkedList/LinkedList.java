package LinkedList;
public class LinkedList<T> {

  private NodeLL<T> head;
  private NodeLL<T> tail;
  private int size;
  private final int NAO_ENCONTRADO = -1;
  private final String LISTA_VAZIA = "Lista Vazia: []";
  private final String POSICAO_INVALIDA = "Posição Inválida!";

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return (this.head == null);
  }

  private NodeLL<T> getNodeLL(int pos) {
    if (pos < 0 && pos > this.size) {
      throw new IllegalArgumentException(POSICAO_INVALIDA);
    }
    NodeLL<T> current = this.head;
    for (int i = 0; i < pos; i++) {
      current = current.getNext();
    }
    return current;
  }

  public T getByIndex(int pos) {
    return this.getNodeLL(pos).getData();
  }

  public int getPosByData(T data) {
    NodeLL<T> current = this.head;
    int pos = 0;

    while (current != null) {
      if (current.getData().equals(data)) {
        return pos;
      }
      pos++;
      current = current.getNext();
    }
    return NAO_ENCONTRADO;
  }

  public void cleanList() {
    if (isEmpty()) {
      System.out.println(LISTA_VAZIA);
    } else {
      NodeLL<T> current = this.head;

      while (current != null) {
        NodeLL<T> next = current.getNext();
        current.setData(null);
        current.setNext(null);
        current = next;
        size--;
      }
    }
  }

  public void addHead(T data) {
    NodeLL<T> newNodeLL = new NodeLL<T>(data);
    if (isEmpty()) {
      this.head = newNodeLL;
    } else {
      newNodeLL.setNext(head);
      this.head = newNodeLL;
    }
    this.size++;
  }

  public void addTail(T data) {
    NodeLL<T> newNodeLL = new NodeLL<T>(data);
    if (isEmpty()) {
      this.head = newNodeLL;
    } else {
      this.tail.setNext(newNodeLL);
      this.tail = newNodeLL;
    }
    this.size++;
  }

  public void insert(int pos, T data) {
    if (pos < 0 || pos > this.size) {
      throw new IllegalArgumentException(POSICAO_INVALIDA);
    }
    if (pos == 0) {
      this.addHead(data);
    } else if (pos == this.size) {
      this.addTail(data);
    } else {
      NodeLL<T> prevNodeLL = this.getNodeLL(pos);
      NodeLL<T> nextNodeLL = prevNodeLL.getNext();
      NodeLL<T> newNodeLL = new NodeLL<T>(data);
      newNodeLL.setNext(nextNodeLL);
      prevNodeLL.setNext(newNodeLL);
      this.size++;
    }
  }

  public T removeHead() {
    if (isEmpty()) {
      throw new RuntimeException(LISTA_VAZIA);
    } else if (size == 1) {
      return this.removeHead();
    }
    T removed = this.head.getData();
    this.head = this.head.getNext();
    this.size--;

    return removed;
  }

  public T removeTail() {
    if (isEmpty()) {
      throw new RuntimeException(LISTA_VAZIA);
    } else if (size == 1) {
      return this.removeHead();
    }
    NodeLL<T> prevLast = this.getNodeLL(this.size - 2);
    T removed = prevLast.getNext().getData();
    prevLast.setNext(null);
    this.tail = prevLast;
    this.size--;

    return removed;
  }

  public T delete(int pos) {
    if (isEmpty()) {
      throw new RuntimeException(LISTA_VAZIA);
    } else if (pos < 0 || pos > this.size) {
      throw new RuntimeException(POSICAO_INVALIDA);
    } else if (pos == this.size) {
      throw new RuntimeException(POSICAO_INVALIDA);
    } else if (pos == 0) {
      return this.removeHead();
    } else if (pos == this.size - 1) {
      return this.removeTail();
    } else {
      NodeLL<T> prevNodeLL = this.getNodeLL(pos - 1);
      NodeLL<T> current = prevNodeLL.getNext();
      NodeLL<T> nexNodeLL = current.getNext();
      prevNodeLL.setNext(nexNodeLL);
      current.setNext(null);
      size--;

      return current.getData();
    }
  }

  public void printFromHead() {
    NodeLL<T> current = this.head;
    if (isEmpty()) {
      System.out.println("[]");
    } else {
      System.out.print("[");
      for (int i = 0; i < this.size - 1; i++) {
        System.out.print(current.getData() + ", ");
        current = current.getNext();
      }
      System.out.print(current.getData() + "]");
    }
  }

  @Override
  public String toString() {
    return "LinkedList [Head = " + head + ", Tail = " + tail + ", size = " + size + "]";
  }

}
