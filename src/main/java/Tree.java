public interface Tree<E> {

    boolean find(E value);
    boolean add(E value);
    boolean remove(E value);
    void display();

    int size();
    boolean isEmpty();

    boolean isBallanced();
}
