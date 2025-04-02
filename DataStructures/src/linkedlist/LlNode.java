package linkedlist;

public class LlNode<T> {

  private T data;
  private LlNode<T> next;
  
  public LlNode(T data) {
    this.data = data;
    this.next = null;
  }

  public LlNode(T data, LlNode<T> next) {
    this.data = data;
    this.next = next;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public LlNode<T> getNext() {
    return next;
  }

  public void setNext(LlNode<T> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return "LlNode [Head = " + data + ", Next = " + next + "]";
  }

}
