public interface Tree<E> {

    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    boolean find(E value);
    boolean add(E value);
    boolean remove(E value);
    void display();

    int size();
    boolean isEmpty();

    boolean isBallanced();

    void traverse (TraverseMode mode);
}
