/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

/**
 *
 * @author prasannjitk
 */
public class BTree {
    static public class BTreeNode {
        int[] keys; //array of keys to be stored int the tree
        int t;      //degree of the btree
        BTreeNode[] child;  //array of the child pointers
        int n;      //number of keys in the current node
        boolean leaf;   //is the current node a leaf node
        BTreeNode(int deg, boolean isLeaf) {
            t = deg;
            leaf = isLeaf;
            keys = new int[2 * t - 1];
            child = new BTreeNode[2 * t];
            n = 0;
        }
        void traverse() {
            int i;
            for(i = 0; i < n; i++) {
                if(!leaf) {
                    child[i].traverse();             
                }
                System.out.println(keys[i]);
            }
            if(!leaf)
                child[i].traverse();
        }
        BTreeNode search(int k) {
            int i;
            for(i = 0; i < n && k > keys[i]; i++) ;
            
            if(k == keys[i])
                return this;
            
            if(leaf)
                return null;
            
            return child[i].search(k);
        }
        void insertNonFull(int k){
            int i = n - 1;
            if(leaf) {
                while(i >= 0 && keys[i] > k) {
                    keys[i + 1] = keys[i];
                    i--;
                }
                keys[i + 1] = k;
                n = n + 1;
            } else {
                while(i >= 0 && keys[i] > k)
                    i--;
                if(child[i + 1].n == 2 * t - 1) {
                    splitChild(i + 1, child[i + 1]);
                    
                    if(keys[i + 1] < k) i++;
                }
                child[i + 1].insertNonFull(k);
            }        
        }
        //a utility function to split the child y of this node
        //y must be full when this function is called
        void splitChild(int i, BTreeNode y) {
            //create a new node which is going to store t - 1
            //keys of y
            BTreeNode s = new BTreeNode(y.t, y.leaf);
            s.n = t - 1;
            
            //copy the last t - 1 keys of y to s
            for(int j = 0; j < t - 1; j++) {
                s.keys[j] = y.keys[j + t];
            }
            //copy the last t children of y to s
            if(!y.leaf) {
                for(int j = 0; j < t; j++) {
                    s.child[j] = y.child[j + t];
                }
            }
            //reduce the number of keys in y
            y.n = t - 1;
            
            //since this node is going to have a new child
            //create space of new child
            for(int j = n; j >= i + 1; j--) {
                child[j + 1] = child[j];
            }
            
            //link the new child to this node
            child[i + 1] = s;
            
            //a key of y mwill move to this node.
            //find location of the new key and move
            //all greater keys one space ahead.
            for(int j = n - 1; j >= i; j--) {
                keys[j + 1] = keys[j];
            }
            
            //copy the middle key of y to this node.
            keys[i] = y.keys[t - 1];
            
            //increment the count of keys in this node.
            n = n + 1;
        }
    }
    BTreeNode root;
    int deg;
    BTree(int _deg) {
        root = null;
        deg = _deg;
    }
    void traverse() {
        if(root != null)
            root.traverse();
    }
    BTreeNode search(int key) {
        return root == null ? null : root.search(key);
    }
    void insert(int val) {
        if(root == null) {
            root = new BTreeNode(deg, true);
            root.keys[0] = val;
            root.n = 1;
        } else {
            if(root.n == 2 * deg - 1) {
                BTreeNode s = new BTreeNode(deg, false);
                s.child[0] = root;
                s.splitChild(0, root);
                
                int i = 0;
                if(s.keys[0] < val) {
                    i++;
                }
                s.child[i].insertNonFull(val);
                root = s;
            } else {
                root.insertNonFull(val);
            }
        }
    }
    public static void main(String[] args) {
        BTree myTree = new BTree(3);
        myTree.insert(10);
        myTree.insert(20);
        myTree.insert(5);
        myTree.insert(6);
        myTree.insert(12);
        myTree.insert(30);
        myTree.insert(7);
        myTree.insert(17);
        
        System.out.println("traversing the tree");
        myTree.traverse();
        
        int k = 6;
        if(myTree.search(k) == null) {
            System.out.println("not present");
        } else
            System.out.println("present");
        k = 15;
        if(myTree.search(k) == null) {
            System.out.println("not present");
        } else
            System.out.println("present");
    }
}
