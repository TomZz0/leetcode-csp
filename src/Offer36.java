public class Offer36 {
    Node pre, left;

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;
        Node node = new Offer36().treeToDoublyList(node4);
        for (int i = 0; i <5 ;i++) {
            System.out.println(node.val);
            node=node.right;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(node.val);
            node=node.left;
        }
    }

    public Node treeToDoublyList(Node root) {
        solu(root);
        pre.right = left;
        left.left = pre;
        int val = left.val;
        Node l = left.right;
        while (l.val!=val){
            if (l.right.left!=l) l.right.left=l;
            l=l.right;
        }
        return left;
    }

    public void solu(Node node) {
        if (node == null) return;
        solu(node.left);
        if (node.left == null) {
            node.left = pre;
            if (left==null)left = node;
        }
        if (pre!=null&&pre.right == null) {
            pre.right = node;
        }
        pre = node;
        solu(node.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};