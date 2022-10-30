package verifyavl;

public class VerifyAVL {
    public static boolean verifyAVL(AVLNode root) {
        /* TODO: Edit this with your code */
        return CheckBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) && isBalanced(root) && CheckHeight(root);
    }
    /* TODO: Add private methods if you want (recommended) */
    private static boolean CheckHeight(AVLNode node){
        if(node == null){
            return true;
        }

        if(node.height != height(node)){
            return false;
        }

        return  CheckHeight(node.right) && CheckHeight(node.left);
    }


    private static boolean CheckBST(AVLNode node, int min, int max)
    {

        if (node == null)
            return true;

        if (node.key < min || node.key > max)
            return false;

        return (CheckBST(node.left, min, node.key) && CheckBST(
                node.right, node.key, max));
    }

    private static boolean isBalanced(AVLNode root)
    {
        if (root == null)
            return true;

        int leftSub = height(root.left);
        int rightSub = height(root.right);

        return Math.abs(leftSub - rightSub) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }



    private static int height(AVLNode node)
    {
        if (node == null)
            return -1;
        else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }
}