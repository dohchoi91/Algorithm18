package inflearn.theinterview.list;


public class LinkedRecursionList {

    public class LinkedNode {
        LinkedNode next;
        Integer data;
        public LinkedNode(Integer data) {
            this.data = data;
        }
    }

    LinkedNode root;

    private void add(Integer num) {
        this.root = addNode(this.root, num);
    }

    private LinkedNode addNode(LinkedNode node, Integer num) {
        if (node != null) {
            node.next = addNode(node.next, num);
            return node;
        }
        LinkedNode newNode = new LinkedNode(num);
        return newNode;
    }
    private void print() {
        printNode(root);
    }

    private void printNode(LinkedNode node) {
        if (node.data != null) {
            System.out.print(node.data + " ");
        }
        if (node.next != null) {
            printNode(node.next);
        }
    }

    public static void main(String args[]) {
        LinkedRecursionList linkedList = new LinkedRecursionList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.print();
    }

}
