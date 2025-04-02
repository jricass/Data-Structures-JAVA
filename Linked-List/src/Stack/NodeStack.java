package Stack;
public class NodeStack<T> {

  private T data;
  private NodeStack<T> next;

  public NodeStack(T data) {
    this.data = data;
    this.next = null;
  }

  public NodeStack(T data, NodeStack<T> next) {
    this.data = data;
    this.next = next;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public NodeStack<T> getNext() {
    return next;
  }

  public void setNext(NodeStack<T> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return "NodeStack [Data = " + data + ", Next = " + next + "]";
  }

}
