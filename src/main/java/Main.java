import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //testTree1();
        //testTree2();
        testTree3();

    }
    private static void testTree1() {
        Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(70);
        tree.add(67);
        tree.add(81);
        tree.add(40);
        tree.add(31);
        tree.add(45);
        tree.add(55);
        tree.add(57);

        System.out.println("Root is 60: " + tree.find(60));
        System.out.println("Find 70: " + tree.find(70));
        System.out.println("Find 31: " + tree.find(31));
        System.out.println("Find 555: " + tree.find(555));

        tree.traverse(Tree.TraverseMode.PRE_ORDER);
    }

    private static void testTree2(){
        Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(25);
        tree.add(66);
        tree.add(15);
        tree.add(5);
        tree.add(20);
        tree.add(45);
        tree.add(30);
        tree.add(55);
        tree.add(32);

        tree.display();
        tree.remove(66);
        tree.display();
    }

    //Задание 1 и 2
    private static void testTree3() {
        int level = 4; //Максимальный уровень деревьев
        int cntBalTrees = 0; //Количество сбалансированных деревьев
        int qtyTrees = 20; //Количество деревьев

        Random rand = new Random();

        for (int i = 0; i < qtyTrees; i++) {
            Tree<Integer> tree = new TreeImpl<>(level);

            for (int j = 0; j < (int) Math.pow(2,level)-1; j++) {
                tree.add(rand.nextInt(100 * 2 + 1) - 100);
            }

            if (tree.isBalanced()) cntBalTrees++;
        }

        System.out.println("Доля сбалансированных деревьев: " + ((cntBalTrees / (qtyTrees * 1.0)) * 100) + "%");

    }
}
