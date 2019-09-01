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

        NodeAndParrent nodeAndParrent = doFind(value);
        if (nodeAndParrent.node != null) return false;

        Node<E> previous = nodeAndParrent.parent;

        if (previous.shouldBeLeft(value)) previous.setLeftChild(node);
        else previous.setRightChild(node);

        size++;
        return true;
    }

    private NodeAndParrent doFind(E value){
        Node<E> parent = null;
        Node<E> current = this.root;

        while (current != null){
            if (current.getValue().equals(value)) return new NodeAndParrent(current,parent);
            parent = current;

            if (current.shouldBeLeft(value)) current = current.getLeftChild();
            else current = current.getLeftChild();
        }

        return new NodeAndParrent(null,parent);
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

    public boolean isBallanced() {
        return false;
    }

    private class NodeAndParrent{
        Node<E> node;
        Node<E> parent;
        public NodeAndParrent(Node<E> node, Node<E> parent) {
            this.node = node;
            this.parent = parent;
        }
    }

}
