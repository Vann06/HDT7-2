/*
Universidad del Valle de Guatemala
Facultad de Ingenieria
Algoritmos y Estructura de Datos
Vianka Castro 23201
Clase BinaryTree
 */
public class BinaryTree {


    private Asociacion<String, String> data;
    private BinaryTree izq;
    private BinaryTree der;

    public BinaryTree(){
        this(null);
    }

    public BinaryTree(Asociacion<String, String> data){
        this.data = data;
        this.izq = null;
        this.der = null;
    }

    public void insert(Asociacion<String, String> asoc) {
        if (data == null) {
            data = asoc;
        } else if (asoc.getKey().compareToIgnoreCase(data.getKey()) <= 0) {
            if (izq == null) {
                izq = new BinaryTree(asoc);
            } else {
                izq.insert(asoc);
            }
        } else {
            if (der == null) {
                der = new BinaryTree(asoc);
            } else {
                der.insert(asoc);
            }
        }
    }


    public void printInOrder() {
        if (izq != null) {
            izq.printInOrder();
        }
        System.out.println(data);
        if (der != null) {
            der.printInOrder();
        }
    }

}
