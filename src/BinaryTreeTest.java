import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    @Test
    void insert() {
        BinaryTree tree = new BinaryTree();
        Asociacion<String, String> association = new Asociacion<>("hello", "hola");

        tree.insert(association);

        assertEquals(association, tree.getData());
    }
    @Test
    void printInOrder() {
        BinaryTree tree = new BinaryTree();
        tree.insert(new Asociacion<>("hello", "hola"));
        tree.insert(new Asociacion<>("world", "mundo"));
        tree.insert(new Asociacion<>("goodbye", "adios"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        tree.printInOrder();

        String expectedOutput = "(goodbye, adios)\n(hello, hola)\n(world, mundo)\n"; // Actualizamos la salida esperada
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void search() {
        BinaryTree tree = new BinaryTree();
        Asociacion<String, String> association = new Asociacion<>("hello", "hola");
        tree.insert(association);

        Asociacion<String, String> result = tree.search("hello");

        assertEquals(association, result);
    }
}