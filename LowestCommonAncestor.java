// public class TreeNode{
// 	int val;
// 	TreeNode left;
// 	TreeNode right;
// 	TreeNode(int x){ val = x;}
// }


// LCA = Lowest Common Ancestor
class Solution{
	private TreeNode ans;

	public Solution(){
		this.ans = null;
	}

	private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q){

		// If end of branch reached
		if(currentNode == null) return false;

		// Left recursion
		// if left recursion returns true
		// Mark left int (flag variable) =1
		int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

		// Right recursion
		// flag
		int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

		// If currentNode is either p or q
		// Make int mid =1 (flag variable)

		int mid = (currentNode == p || currentNode == q) ? 1 : 0;

		// Now checking if we have foun the LCA
		if((mid + left + right) >= 2){
			this.ans = currentNode;
		}

		// return true if either mid or right or left is 1
		return (mid + left + right > 0);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

		this.recurseTree(root, p , q);
		return this.ans;
	}
}