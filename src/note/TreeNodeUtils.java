package note;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class TreeNodeUtils {

    public TreeNodeUtils(){
        throw new RuntimeException("请不要实例化!");
    }

    /**
     * 构建二叉树 按照层次遍历创建
     * @param list   输入序列
     * @return
     */
    public static TreeNode createBinaryTreeByLevel(LinkedList<Integer> list){
        TreeNode node = createTreeNode(list);
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (node != null){
            queue.add(node);
        }
        while (!list.isEmpty()){
            TreeNode pop = queue.pop();
            pop.leftChild = createTreeNode(list);
            if (pop.leftChild != null){
                queue.add(pop.leftChild);
            }
            pop.rightChild = createTreeNode(list);
            if(pop.rightChild != null){
                queue.add(pop.rightChild);
            }
        }
        return node;
    }

    /**
     * 取序列的头元素生成节点
     * @param list 输入序列
     * @return 生成的节点
     */
    private static TreeNode createTreeNode(LinkedList<Integer> list){
        TreeNode node = null;
        Integer data = list.removeFirst();
        if (data!=null){
            node = new TreeNode(data);
        }
        return node;
    }

    public static TreeNode createSearchTree(Integer... data){
        return createSearchTree(new LinkedList<Integer>(Arrays.asList(data)));
    }

    public static TreeNode createSearchTree(List<Integer> list){
        return createSearchTree(new LinkedList<Integer>(list));
    }

    /**
     * 创建二叉搜索树
     * @param list  输入序列
     * @return
     */
    private static TreeNode createSearchTree(LinkedList<Integer> list){
        if (list == null){
            return null;
        }
        TreeNode root = new TreeNode(list.removeFirst());
        while (!list.isEmpty()){
            Integer first = list.removeFirst();
            addNode(root, first);
        }
        return root;
    }
    private static TreeNode addNodeList(TreeNode root,Integer... data){
        return addNodeList(root,Arrays.asList(data));
    }
    private static TreeNode addNodeList(TreeNode root,List<Integer> list){
        return addNodeList(root,new LinkedList<>(list));
    }
    private static TreeNode addNodeList(TreeNode root,LinkedList<Integer> list){
        if (list == null){
            return root;
        }
        if (root == null) {
            root = new TreeNode(list.removeFirst());
        }
        while (!list.isEmpty()){
            Integer first = list.removeFirst();
            addNode(root, first);
        }
        return root;
    }
    /**
     * 给指定的二叉树添加节点(二叉搜索树)
     * @param root 二叉树根节点
     * @param newTreeNode 新节点
     * @return 后的二叉树根节点
     */
    private static TreeNode addNode(TreeNode root,TreeNode newTreeNode){
        if (newTreeNode == null){
            return root;
        }
        TreeNode treeNode = root;
        boolean flag = true;
        while (flag){
            if (newTreeNode.data < treeNode.data){
                if (treeNode.leftChild == null){
                    treeNode.leftChild = newTreeNode;
                    flag = false;
                }else {
                    treeNode = treeNode.leftChild;
                }
            }
            if (newTreeNode.data > treeNode.data){
                if (treeNode.rightChild == null){
                    treeNode.rightChild = newTreeNode;
                    flag = false;
                }else {
                    treeNode = treeNode.rightChild;
                }
            }
        }

        return root;
    }
    private static TreeNode addNode(TreeNode root,Integer data){
        return addNode(root,new TreeNode(data));
    }

    private static TreeNode deleteNode(TreeNode root,TreeNode deleteNode){

        return deleteNode(root,deleteNode.data);
    }

    private static TreeNode deleteNode(TreeNode root,Integer data){
        //todo deleteNode 需要调整

        return root;
    }

    /**
     * 创建二叉平衡树
     * @param list
     * @return
     */
    private static TreeNode createBalanceTree(LinkedList<Integer> list){
        if (list == null){
            return null;
        }
        TreeNode treeNode = new TreeNode(list.removeFirst());
        if (!list.isEmpty()){
            Integer first = list.removeFirst();
            if (first > treeNode.data){
                treeNode.leftChild = createBalanceTree(list);
            }else if (first < treeNode.data){
                treeNode.rightChild = createBalanceTree(list);
            }
        }
        //调节二叉树
        reTreeNode(treeNode);

        return treeNode;
    }

    private static void reTreeNode(TreeNode treeNode) {
        int left = 0,right = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
//        while (treeNode != null || Math.abs(left - right) < 2){
//            if (treeNode == null){
//                treeNode = stack.pop();
//            }
//            if (treeNode.leftChild != null){
//                left++;
//                treeNode = treeNode.leftChild;
//                stack.push(treeNode);
//            }else if (treeNode.rightChild != null){
//                right++;
//                treeNode = treeNode.rightChild;
//                stack.push(treeNode);
//            }
//        }

    }

    /**
     * 二叉树前序遍历(递归)   根-> 左-> 右
     * @param node    二叉树节点
     */
    public static void preOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }
    /**
     * 二叉树中序遍历(递归)   左-> 根-> 右
     * @param node   二叉树节点
     */
    public static void inOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.data+" ");
        inOrderTraversal(node.rightChild);
    }
    /**
     * 二叉树后序遍历(递归)   左-> 右-> 根
     * @param node    二叉树节点
     */
    public static void postOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.data+" ");
    }

    /**
     * 层次遍历
     * @param root 二叉树节点
     */
    public static void levelOrder(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.pop();
            System.out.print(root.data+" ");
            if(root.leftChild!=null) queue.add(root.leftChild);
            if(root.rightChild!=null) queue.add(root.rightChild);
        }
    }

    /**
     * 前序遍历 非递归
     * @param node 二叉树节点
     */
    public static void preOrderTraversalWithStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        while(treeNode != null || !stack.isEmpty()){
            if (treeNode != null){
                System.out.print(treeNode.data+" ");
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }else {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 中序遍历 非递归
     * @param node 二叉树节点
     */
    public static void inOrderTraversalWithStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        while(treeNode!=null || !stack.isEmpty()){
            if (treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }else {
                treeNode = stack.pop();
                System.out.print(treeNode.data+" ");
                treeNode = treeNode.rightChild;
            }

        }
    }

    /**
     * 后序遍历 非递归
     * @param node 二叉树节点
     */
    public static void postOrderTraversalWithStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        TreeNode lastVisit = null;   //标记每次遍历最后一次访问的节点
        while(treeNode!=null || !stack.isEmpty()){//节点不为空，结点入栈，并且指向下一个左孩子
            if(treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //栈不为空
            else {
                //出栈
                treeNode = stack.pop();
                //如果节点的右孩子不为空，且没有被访问过，就把这个节点放到栈中
                if (treeNode.rightChild != null && treeNode.rightChild != lastVisit){
                    stack.push(treeNode);
                    treeNode = treeNode.rightChild;
                }else {
                    lastVisit = treeNode;
                    System.out.print(treeNode.data+" ");
                    treeNode = null;
                }

            }

        }
    }
    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(7,1,3,9,4,8,5,6,2));
        TreeNode treeNode = TreeNodeUtils.createSearchTree(7,1,3,9,4,8,5,6,2);
        TreeNodeUtils.levelOrder(treeNode);
//        addNode(treeNode,10);
        System.out.println();
        addNodeList(treeNode,10,12,14);
        TreeNodeUtils.levelOrder(treeNode);
    }
}