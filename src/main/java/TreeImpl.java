public class TreeImpl<E extends Comparable <? super E>> implements Tree<E> {

    private Node<E> root;
    private int size;

    public boolean find(E value) {
        Node<E> current = root;
        return doFind(value).node !=null;
    }

    public boolean add(E value) {
        Node<E> node = new Node<>(value);
        if (root == null){
            this.root = node;
            return true;
        }

        NodeAndParent NodeAndParent = doFind(value);
        if (NodeAndParent.node != null) return false;

        Node<E> previous = NodeAndParent.parent;

        if (previous.shouldBeLeft(value)) previous.setLeftChild(node);
        else previous.setRightChild(node);

        size++;
        return true;
    }

    private NodeAndParent doFind(E value){
        Node<E> parent = null;
        Node<E> current = this.root;

        while (current != null){
            if (current.getValue().equals(value)) return new NodeAndParent(current,parent);
            parent = current;

            if (current.shouldBeLeft(value)) current = current.getLeftChild();
            else current = current.getRightChild();
        }

        return new NodeAndParent(null,parent);
    }

    public boolean remove(E value) {
        return false;
    }

    public void display() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown mode: " + mode);
        }
    }

    private void postOrder(Node<E> node) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.println(node.getValue());
    }

    private void preOrder(Node<E> node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getValue());
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeftChild());
        System.out.println(node.getValue());
        inOrder(node.getRightChild());
    }

    public boolean isBallanced() {
        return false;
    }

    private class NodeAndParent{
        Node<E> node;
        Node<E> parent;
        public NodeAndParent(Node<E> node, Node<E> parent) {
            this.node = node;
            this.parent = parent;
        }
    }

}
