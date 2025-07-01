import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeBuilder {
    

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


    // Method for testing the tree construction
    public static void main(String[] args) {
        BinaryTreeBuilder builder = new BinaryTreeBuilder();

        int[] preorder = {4,2,7,1,3,6,9};
      
        TreeNode root = builder.buildBST(preorder);
        builder.inorder(root);
    
    }
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        System.out.print( root.val);
        inorder(root.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        {
            return true;
        }

        if(p == null || q==null)
        {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        boolean value = isSameTree(p.left,q.left);
        boolean value2 = isSameTree(p.right,q.right);
        
            return value && value2;
        }
    
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
