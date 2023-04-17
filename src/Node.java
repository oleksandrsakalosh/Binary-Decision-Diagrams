public class Node {
    String expression;
    Node left, right;

    public Node(String expression){
        this.expression = expression;
        left = right = null;
    }
}
