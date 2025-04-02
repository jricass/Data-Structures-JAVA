package queue;

public class QueueApp {
  public static void main(String[] args) {
    
    testPeek();

  }

  public static void testAdd() {
    Queue<Integer> q = new Queue<>();
  
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
  
    q.printQueue();
  }

  public static void testRemove() {
    Queue<Integer> q = new Queue<>();
  
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
  
    q.printQueue();

    q.remove();

    q.printQueue();
  }

  public static void testPeek() {
    Queue<Integer> q = new Queue<>();
  
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
  
    q.peek();
  }
}


