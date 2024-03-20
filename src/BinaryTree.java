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

    //https://dev.to/ronnymedina/estructura-de-datos-binary-tree-arbol-binario-2geb
    public void printInOrder() {
        //imprime hasta la izq
        if (izq != null) {
            izq.printInOrder();
        }
        System.out.println(data);
        //imprime hasta la der
        if (der != null) {
            der.printInOrder();
        }
    }

    //Fuente:
    //Bailey, D. A. (2003). Java structures: Data structures in Java for the principled programmer. McGraw-Hill, Boston, Mau.
    public Asociacion<String, String> search(String key) {
        //si es nulo o si ese mismo es el buscado
        if (data == null || key.equalsIgnoreCase(data.getKey())) {
            return data;
            //se hace busqueda en arbol izquierdo
        } else if (key.compareToIgnoreCase(data.getKey()) < 0 && izq != null) {
            return izq.search(key);
            //luego se verifica si el derecho no es nulo
        } else if (der != null) {
            return der.search(key);
        }
        return null;
    }
}
