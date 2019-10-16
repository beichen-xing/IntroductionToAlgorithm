import java.util.LinkedList;
import java.util.Queue;

class Node {
     int val;
     Node left;
     Node right;
     Node parent;
 }

public class BinarySearchTrees {

    public Node createNewNode(Node parent, int k){
        Node a = new Node();
        a.val = k;
        a.left = null;
        a.right = null;
        a.parent = parent;
        return a;
    }

    public Node addRecursive(Node parent, Node current, int value){
        if(current == null){
            return createNewNode(parent,value);
        }

        if(value < current.val){
            current.left = addRecursive(current, current.left,value);
        }else if(value >= current.val){
            current.right = addRecursive(current, current.right,value);
        } else {
            return current;
        }
        return current;
    }

    public Node transPlant(Node root, Node u, Node v){

        if(u.parent == null){
            root = v;
        }else if(u == u.parent.left){
            u.parent.left = v;
        }else {
            u.parent.right = v;
        }

        if(v != null){
            v.parent = u.parent;
        }
        return root;
    }

    public Node treeDelete(Node root, Node z){
        if(z.left == null){
            root = transPlant(root,z,z.right);
        }else if(z.right == null){
            root = transPlant(root,z, z.left);
        }else{
            Node y = treeMin(z.right);
            if(y.parent != z){
                root = transPlant(root,y,y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            root = transPlant(root,z,y);
            y.left = z.left;
            y.left.parent = y;
        }
        return root;
    }

// Such walks' time complexity is equal to O(n)
    public void inorderTreeWalk(Node node) {
            if(node != null){
                inorderTreeWalk(node.left);
                System.out.println("inorder" + node.val);
                inorderTreeWalk(node.right);
            }
    }

    public void preorderTreeWalk(Node node){
            if(node != null){
                System.out.println("preorder" + node.val);
                preorderTreeWalk(node.left);
                preorderTreeWalk(node.right);
            }
    }

    public void postorderTreeWalk(Node node){
        if(node != null){
            postorderTreeWalk(node.left);
            postorderTreeWalk(node.right);
            System.out.println("postorder"+ node.val);
        }
    }

// BFS
    public void traverseOrder(Node node){
        if(node == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()){
            Node n = q.remove();

            System.out.println(n.val);

            if(n.left != null){
                q.add(n.left);
            }
            if(n.right != null){
                q.add(n.right);
            }
        }
    }

    public Node treeMax(Node node){
        while (node.right != null){
            node = node.right;
        }
        return node;
    }

    public Node treeMin(Node node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public Node treeSuccessor(Node node){
        if(node.right != null){
            return treeMin(node.right);
        }
        Node p = node.parent;
        while(p != null && node == p.right){
            node = p;
            p = p.parent;
        }
        return p;
    }

    public Node search(Node x, int k){
        while(x != null && k != x.val){
            if(k < x.val){
                x = x.left;
            }else {
                x = x.right;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        BinarySearchTrees bst = new BinarySearchTrees();
        Node root = null;
        root = bst.addRecursive(root,root,6);
        root = bst.addRecursive(root,root,5);
        root = bst.addRecursive(root,root,7);
        root = bst.addRecursive(root,root,2);
        root = bst.addRecursive(root,root,5);
        root = bst.addRecursive(root,root,8);
        bst.inorderTreeWalk(root);
        bst.preorderTreeWalk(root);
        bst.postorderTreeWalk(root);
        bst.traverseOrder(root);
        System.out.println(bst.search(root, 1));
        System.out.println(bst.treeMax(root).val);
        System.out.println(bst.treeSuccessor(bst.search(root,6)).val);
        root = bst.treeDelete(root,bst.search(root,7));
        bst.traverseOrder(root);
    }
}
