public class LinkedList<T> {

  private Node<T> head;
  private Node<T> tail;
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

  private Node<T> getNode(int pos) {
    if (pos < 0 && pos > this.size) {
      throw new IllegalArgumentException(POSICAO_INVALIDA);
    }
    Node<T> current = this.head;
    for (int i = 0; i < pos; i++) {
      current = current.getNext();
    }
    return current;
  }

  public T getByIndex(int pos) {
    return this.getNode(pos).getData();
  }

  public int getPosByData(T data) {
    Node<T> current = this.head;
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
      Node<T> current = this.head;

      while (current != null) {
        Node<T> next = current.getNext();
        current.setData(null);
        current.setNext(null);
        current = next;
        size--;
      }
    }
  }

  public void addHead(T data) {
    Node<T> newNode = new Node<T>(data);
    if (isEmpty()) {
      this.head = newNode;
    } else {
      newNode.setNext(head);
      this.head = newNode;
    }
    this.size++;
  }

  public void addTail(T data) {
    Node<T> newNode = new Node<T>(data);
    if (isEmpty()) {
      this.head = newNode;
    } else {
      this.tail.setNext(newNode);
      this.tail = newNode;
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
      Node<T> prevNode = this.getNode(pos);
      Node<T> nextNode = prevNode.getNext();
      Node<T> newNode = new Node<T>(data);
      newNode.setNext(nextNode);
      prevNode.setNext(newNode);
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
    Node<T> prevLast = this.getNode(this.size - 2);
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
      Node<T> prevNode = this.getNode(pos - 1);
      Node<T> current = prevNode.getNext();
      Node<T> nexNode = current.getNext();
      prevNode.setNext(nexNode);
      current.setNext(null);
      size--;

      return current.getData();
    }
  }

  public void printFromHead() {
    Node<T> current = this.head;
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
