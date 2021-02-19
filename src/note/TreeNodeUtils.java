package note;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class TreeNodeUtils {

    public TreeNodeUtils(){
        throw new RuntimeException("�벻Ҫʵ����!");
    }

    /**
     * ���������� ���ղ�α�������
     * @param list   ��������
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
     * ȡ���е�ͷԪ�����ɽڵ�
     * @param list ��������
     * @return ���ɵĽڵ�
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
     * ��������������
     * @param list  ��������
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
     * ��ָ���Ķ�������ӽڵ�(����������)
     * @param root ���������ڵ�
     * @param newTreeNode �½ڵ�
     * @return ��Ķ��������ڵ�
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
        //todo deleteNode ��Ҫ����

        return root;
    }

    /**
     * ��������ƽ����
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
        //���ڶ�����
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
     * ������ǰ�����(�ݹ�)   ��-> ��-> ��
     * @param node    �������ڵ�
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
     * �������������(�ݹ�)   ��-> ��-> ��
     * @param node   �������ڵ�
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
     * �������������(�ݹ�)   ��-> ��-> ��
     * @param node    �������ڵ�
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
     * ��α���
     * @param root �������ڵ�
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
     * ǰ����� �ǵݹ�
     * @param node �������ڵ�
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
     * ������� �ǵݹ�
     * @param node �������ڵ�
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
     * ������� �ǵݹ�
     * @param node �������ڵ�
     */
    public static void postOrderTraversalWithStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        TreeNode lastVisit = null;   //���ÿ�α������һ�η��ʵĽڵ�
        while(treeNode!=null || !stack.isEmpty()){//�ڵ㲻Ϊ�գ������ջ������ָ����һ������
            if(treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //ջ��Ϊ��
            else {
                //��ջ
                treeNode = stack.pop();
                //����ڵ���Һ��Ӳ�Ϊ�գ���û�б����ʹ����Ͱ�����ڵ�ŵ�ջ��
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