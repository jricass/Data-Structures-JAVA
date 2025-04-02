package LinkedList;
public class NodeLL<T> {

  private T data;
  private NodeLL<T> next;
  
  public NodeLL(T data) {
    this.data = data;
    this.next = null;
  }

  public NodeLL(T data, NodeLL<T> next) {
    this.data = data;
    this.next = next;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public NodeLL<T> getNext() {
    return next;
  }

  public void setNext(NodeLL<T> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return "NodeLL [Head = " + data + ", Next = " + next + "]";
  }

}
