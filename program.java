/*
 * Сформировать и сделать обход дерева, для которого у каждого узла может быть больше 2-х потомков


* Сложный пример ПОДУМАТЬ
         1
       /   \
      2      3
     /     /   \
    4     5     6
  / | \        / \
 7  8  9     11   20
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class program {
    public static void main(String[] args) {

        // #region
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n11 = new Node(11);
        Node n20 = new Node(20);
        // #endregion

        // #region

        root.childrens = Arrays.asList(n2, n3);
        n2.childrens = Arrays.asList(n4);
        n3.childrens = Arrays.asList(n5, n6);
        n4.childrens = Arrays.asList(n7, n8, n9);
        n6.childrens = Arrays.asList(n11, n20);
        // #endregion

        order(root);
    }

    private static void order(Node root) {

        System.out.printf("%d", root.value);

        if (root.childrens != null) {
            System.out.printf("(");

            Iterator<Node> child = root.childrens.iterator();
            while (true) {
                order(child.next());
                if (child.hasNext()) {
                    System.out.printf(",");
                }
                else break;
            }
            System.out.printf(")");
        }
    }
}

/**
 * program
 */
class Node {
    int value;

    public Node(int value) {
        this.value = value;
    }

    List<Node> childrens;
}