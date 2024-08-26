import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/?envType=daily-question&envId=2024-08-26
public class NAryTreePostOrderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public static void dfs(Node root, List<Integer> res) {
        if (root != null) {
            if (root.children != null) {
                for (Node node : root.children) {
                    dfs(node, res);
                }
            }
            res.add(root.val);
        }
    }
}
