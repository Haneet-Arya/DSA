package binaryTree;

import java.util.*;

public class BinaryTree {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Node root = createTree();
//        inOrder(root);
//        System.out.println();
//        preOrder(root);
//        System.out.println();
//        postOrder(root);
//
//        ArrayList<Integer> ls = new ArrayList<>();
//        Collections.reverse(ls);

        System.out.println(topView(root));


    }
    static Node createTree(){
        Node root = null;
        System.out.println("Enter data: ");
        int data = sc.nextInt();
        if(data==-1) return null;

        root = new Node(data);
        System.out.println("Enter the left for " + data);
        root.left = createTree();
        System.out.println("Enter the right for " + data);
        root.right = createTree();
        return root;
    }

    static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    // height of binary tree
    static int height(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right))+1;
    }

    // size of binary tree
    static int size(Node root){
        if(root==null){
            return 0;
        }
        return size(root.left) + size(root.right)+1;
    }

    // max in binary tree
    static int max(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(max(root.left),max(root.right)));
    }

    // Level Order Traversal **Important
    static void printLevel(Node root, int level){
        if(root == null) return;
        if(level==1){
            System.out.print(root.data + " ");
        }
        else if(level>1){
            printLevel(root.left,level-1);
            printLevel(root.right,level-1);
        }
        System.out.println();
    }

    /*
    for running above code
    for(i in 1...height){
        printLevel
        (root,i);
    }
     */

    // print level order
    static void printLevelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node curr = q.poll();
            if(curr==null){
                if(q.isEmpty()) return;
                q.add(null);
                System.out.println();
                continue;
            }
            System.out.print(curr.data);
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
    }

    // Top and Bottom View to be continued ** very important **

    // Left Side View
    void printLeftView(Node root){
        ArrayList<Node> lst = new ArrayList<>();
        printLeftViewUtil(root, lst, 0);
        for(Node e: lst){
            System.out.print(e.data +" ");
        }
    }
    void printLeftViewUtil(Node root,ArrayList<Node> lst,int level){
        if(root == null) return;
        if(lst.get(level)==null){
            lst.add(root);
        }
        printLeftViewUtil(root.left,lst,level+1);
        printLeftViewUtil(root.right,lst,level+1);

    }
    // Right Side View
    void printRigtView(Node root){
        ArrayList<Node> lst = new ArrayList<>();
        printRightViewUtil(root, lst, 0);
        for(Node e: lst){
            System.out.print(e.data +" ");
        }
    }
    void printRightViewUtil(Node root,ArrayList<Node> lst,int level){
        if(root == null) return;
        if(lst.get(level)==null){
            lst.add(root);
        }
        printRightViewUtil(root.right,lst,level+1);
        printRightViewUtil(root.left,lst,level+1);

    }
    /* another method for rightViewUil function

    void printRightViewUtil(Node root,ArrayList<Node> lst,int level){
        if(root == null) return;

            lst.set(level,root);

        printLeftViewUtil(root.left,lst,level+1);
        printLeftViewUtil(root.right,lst,level+1);

    }

     */

    // Top View of Binary Tree
    static ArrayList<Integer> topView(Node root){
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()){
            Pair cur = q.poll();
            if(!map.containsKey(cur.hd)) map.put(cur.hd, cur.node.data);
            if(cur.node.left!=null) q.add(new Pair(cur.hd - 1, cur.node.left));
            if(cur.node.right!=null) q.add(new Pair(cur.hd + 1, cur.node.right));

        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
    // Bottom View of Binary Tree
    static ArrayList<Integer> bottomView(Node root){
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()){
            Pair cur = q.poll();
            map.put(cur.hd, cur.node.data);
            if(cur.node.left!=null) q.add(new Pair(cur.hd - 1, cur.node.left));
            if(cur.node.right!=null) q.add(new Pair(cur.hd + 1, cur.node.right));

        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }

    static class Pair{
        int hd;
        Node node;
        public Pair(int hd, Node node){
            this.hd=hd;
            this.node = node;
        }
    }
}


class Node{
    Node left, right;
    int data;
    public Node(int data){
        this.data = data;
    }
}
