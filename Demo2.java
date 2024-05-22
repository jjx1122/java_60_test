import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Demo2 {
    public static void main(String[] args) {

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        System.out.println(connect(root).next);


    }
    public static Node connect(Node root) {
        if (root==null)
            return null;
        Queue<Node> queue=new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            Node prev=null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (prev!=null){
                    prev.next=node;
                }
                prev=node;
                if (node.left!=null){
                    queue.add(node.left);
                }

                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
