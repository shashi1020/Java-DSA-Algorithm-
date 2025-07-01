import java.util.Stack;

public class IsSymmetricTree {
    
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
    public boolean isSymmetric(TreeNode root)
    {
       if(root == null)
       {
        return true;
       }
       return isMirror(root.left, root.right);
    }
    public static boolean isMirror(TreeNode p, TreeNode q)
    {
        if(p == null && q==null)
        {
            return true;
        }
        if(p==null||q==null)
        {
            return flase;
        }

        return (p==q) && isMirror(p.left,q.right) && isMirror(p.right, q.left);

    }

    public static void main(String[] args) {
        int preorder[] = {1,2,2,3,4,4,3};
        IsSymmetricTree obj = new IsSymmetricTree();
        TreeNode root = obj.buildBST(preorder);
        System.out.println(obj.isSymmetric(root));

    }
}
