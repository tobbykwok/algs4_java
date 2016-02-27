package com.tobbyinside;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**
 * Created by tobby on 16/2/27.
 */
public class BST_1<Key extends Comparable<Key>, Value> {
    private class Node {
        Value val;
        Key key;
        Node left, right;
        int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    private Node root;

    /*
        增删改查遍历
     */


    public BST_1() {

    }

    /*
        插入:
            检查当前BST是否已存在此key
     */
    public void put(Key key, Value val) {
        if (key == null) throw new NullPointerException("key cannot be null");
        if (val == null) {
            this.delete(key);
        }
        this.root = this.put(this.root, key, val);

    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
//        // 这种插入方式会重复插入key值相同的项, 而不是替换相同key的项
//        boolean gt = x.key.compareTo(key) > 0;
//        if (gt) {
//            // set to left
//            x.left = this.put(x.left, key, val);
//        } else {
//            x.right = this.put(x.right, key, val);
//        }
//        x.N++;


        // 替换相同key的方法
        int cmp = x.key.compareTo(key);
        if (cmp == 0) {
            x.val = val;
        } else if (cmp > 0) {
            x.left = this.put(x.left, key, val);
        } else {
            x.right = this.put(x.right, key, val);
        }

        x.N = 1 + this.size(x.left) + this.size(x.right);
        return x;
    }

    /*
        查找是否存在某一键
     */
    public boolean contains(Key key) {
        return this.get(key) != null;
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    /*
        取得某一键的值
     */
    public Value get(Key key) {
        if (key == null) throw new NullPointerException("key cannot be null");
        Node result = this.get(this.root, key);
        if (result != null) {
            return result.val;
        }
        return null;
    }

    /*
        中序遍历输出key-val
     */
    public void output_order() {
        this.output_order(this.root);
    }

    private void output_order(Node x) {
        if (x != null) {
            this.output_order(x.left);
            StdOut.println(x.key + " - " + x.val);
            this.output_order(x.right);
        } else {
            return;
        }
    }

    private Node get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = x.key.compareTo(key);
        if (cmp > 0) {
            return this.get(x.left, key);
        } else if (cmp < 0) {
            return this.get(x.right, key);
        } else {
            return x;
        }
    }

    /*
        删除某一键
     */
    public void delete(Key key) {
        // 找到该键位置
        // 判断该键左右节点
        // (1) 没有左节点-> 返回右节点
        // (2) 没有右节点-> 返回左节点
        // (3) 没有节点-> 返回null
        // (4) 有两个节点-> 找到其中一个子树与当前节点最接近的(左侧最大或右侧最小), 替换当前节点, 最终删除那个最接近的节点
        // (5) 还要处理找到的那个节点是否存在子节点, 把他的子节点放到那个节点的父节点的子节点位置上

        this.root = this.delete(this.root, key);
    }

    private Node delete(Node x, Key key) {      //x是对象的副本(指向原对象)
        if (x == null) return null;

        int cmp = x.key.compareTo(key);
        if (cmp == 0) {
            if (x.left == null) {
                //返回该节点右子树
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }
            //有两个节点
            //选其中一个子树与当前key最接近的
            //此处选择左侧树最大的节点
//            Node close = this.max(x.left);

//
//            Node temp = x;   //把当前节点保存 x是引用值, 此时temp与x指向同一个对象
//            x = min(temp.right);            //修改了x的引用值, x指向了右子树最小的那个对象
//            x.right = deleteMin(temp.right);    //右子树最小的对象的右子树等于
//            x.left = temp.left;

            Node test_min = x.right;        //子节点最接近待删除的node
            while (test_min.left != null) {
                test_min = test_min.left;
            }

            test_min.right = this.deleteMin(x.right);
            test_min.left = x.left;
        } else if (cmp < 0) {
            x.right = this.delete(x.right, key);
        } else {
            x.left = this.delete(x.left, key);
        }

        x.N = this.size(x.left) + this.size(x.right) + 1;
        return x;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        else return this.max(x.right);
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else return this.min(x.left);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = this.deleteMin(x.left);
        x.N = this.size(x.left) + this.size(x.right) + 1;
        return x;
    }

    /**
     * Unit tests the <tt>BST</tt> data type.
     */
    public static void main(String[] args) {
        BST_1<String, Integer> st = new BST_1<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
            if (i == 10) {
                break;
            }
        }
        st.output_order();
        StdOut.println("----------");
        st.delete("A");
        st.output_order();
    }
}
