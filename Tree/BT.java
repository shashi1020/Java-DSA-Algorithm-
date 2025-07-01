class BT {
    public static class Node {
        Node left;
        int data;
        Node right;

        Node(int data) {
            this.left = null;
            this.data = data;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1; 

        public Node BuildT(int nodes[]) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }
            Node Newnode = new Node(nodes[idx]);
            Newnode.left = BuildT(nodes);
            Newnode.right = BuildT(nodes);

            return Newnode;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, 11, 10, 6};
        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildT(nodes);
        System.out.println(root.data);
    }
}
