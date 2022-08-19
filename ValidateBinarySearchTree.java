class Solution{
    public boolean res = true;

    public boolean isValidBST(TreeNode root){
        checkValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return res;
    }

    private void checkValid(TreeNode root, long low, long high){
        if(root == null) return;

        checkValid(root.left, low, root.val);
        checkValid(root.right, root.val, high);

        if(root.val >= high || root.val <= low){
            res = false;
        }      
    }
}