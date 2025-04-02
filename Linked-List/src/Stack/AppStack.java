package Stack;
public class AppStack {
    public static void main(String[] args) throws Exception {

        testIsFull();

    }

    public static void testPush() {
        Stack<Integer> s = new Stack<>(10);

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        s.printStack();
    }

    public static void testPop() {
        Stack<String> s = new Stack<>(10);

        s.push("Silas");
        s.push("Renan");
        s.push("Henry");
        s.push("Kaio");
        s.push("Ricardo");

        s.printStack();

        s.pop();

        s.printStack();
    }

    public static void testPeek() {
        Stack<Double> s = new Stack<>(10);

        s.push(1.2);
        s.push(14.1);
        s.push(3.9);
        s.push(8.5);

        s.peek();
    }

    public static void testIsFull() {
        Stack<Integer> s = new Stack<>(3);

        s.push(1);
        s.push(2);
        s.push(3);

        s.isFull();

        Stack<Integer> s1 = new Stack<>(3);

        s1.push(4);
        s1.push(5);

        s1.isFull();
    }
}
