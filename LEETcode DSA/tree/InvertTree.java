import java.util.Stack;

public class InvertTree {

    public TreeNode buildBST(int[] preorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        
        for (int i = 1; i < preorder.length; i++) {
            TreeNode temp = null;
            while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                temp = stack.pop();
            }
            if (temp != null) {
                temp.right = new TreeNode(preorder[i]);
                stack.push(temp.right);
            } else {
                stack.peek().left = new TreeNode(preorder[i]);
                stack.push(stack.peek().left);
            }
        }
        return root;
    }


    public static TreeNode InvertTreee(TreeNode root)
    {
        if(root == null)
        {
            return root;
        }
        
        TreeNode left = InvertTreee(root.left);
        TreeNode right = InvertTreee(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
    
    
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeBuilder builder = new BinaryTreeBuilder();

        int[] preorder = {4,2,7,1,3,6,9};
      
        TreeNode root = builder.buildBST(preorder);
        root = InvertTreee(root);
        preorderTraversal(root);
    
    }
}
