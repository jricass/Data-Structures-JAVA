package linkedlist;

public class LinkedList<T> {

  private LlNode<T> head;
  private LlNode<T> tail;
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

  private LlNode<T> getLlNode(int pos) {
    if (pos < 0 && pos > this.size) {
      throw new IllegalArgumentException(POSICAO_INVALIDA);
    }
    LlNode<T> current = this.head;
    for (int i = 0; i < pos; i++) {
      current = current.getNext();
    }
    return current;
  }

  public T getByIndex(int pos) {
    return this.getLlNode(pos).getData();
  }

  public int getPosByData(T data) {
    LlNode<T> current = this.head;
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
      LlNode<T> current = this.head;

      while (current != null) {
        LlNode<T> next = current.getNext();
        current.setData(null);
        current.setNext(null);
        current = next;
        size--;
      }
    }
  }

  public void addHead(T data) {
    LlNode<T> newLlNode = new LlNode<T>(data);
    if (isEmpty()) {
      this.head = newLlNode;
    } else {
      newLlNode.setNext(head);
      this.head = newLlNode;
    }
    this.size++;
  }

  public void addTail(T data) {
    LlNode<T> newLlNode = new LlNode<T>(data);
    if (isEmpty()) {
      this.head = newLlNode;
    } else {
      this.tail.setNext(newLlNode);
      this.tail = newLlNode;
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
      LlNode<T> prevLlNode = this.getLlNode(pos);
      LlNode<T> nextLlNode = prevLlNode.getNext();
      LlNode<T> newLlNode = new LlNode<T>(data);
      newLlNode.setNext(nextLlNode);
      prevLlNode.setNext(newLlNode);
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
    LlNode<T> prevLast = this.getLlNode(this.size - 2);
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
      LlNode<T> prevLlNode = this.getLlNode(pos - 1);
      LlNode<T> current = prevLlNode.getNext();
      LlNode<T> nexLlNode = current.getNext();
      prevLlNode.setNext(nexLlNode);
      current.setNext(null);
      size--;

      return current.getData();
    }
  }

  public void printFromHead() {
    LlNode<T> current = this.head;
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
