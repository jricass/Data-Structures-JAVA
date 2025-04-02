package queue;

public class QueueNode<T> {

  private T data;
  private QueueNode<T> next;
  private QueueNode<T> prev;

  public QueueNode(T data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public QueueNode<T> getNext() {
    return next;
  }

  public void setNext(QueueNode<T> next) {
    this.next = next;
  }

  public QueueNode<T> getPrev() {
    return prev;
  }

  public void setPrev(QueueNode<T> prev) {
    this.prev = prev;
  }

  @Override
  public String toString() {
    return "QueueNode [Data = " + data + ", Next = " + next + ", Prev = " + prev + "]";
  }

}
