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

    /**
     * Constructor predeterminado que crea un árbol binario vacío.
     */
    public BinaryTree(){
        this(null);
    }


    /**
     * Constructor que crea un árbol binario con una asociación de clave-valor en el nodo raíz.
     *
     * @param data la asociación de clave-valor para almacenar en el nodo raíz del árbol
     */
    public BinaryTree(Asociacion<String, String> data){
        this.data = data;
        this.izq = null;
        this.der = null;
    }


    /**
     * Inserta una nueva asociación de clave-valor en el árbol binario.
     *
     * @param asoc la asociación de clave-valor a insertar en el árbol
     */
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

    /**
     * Imprime las asociaciones de clave-valor en orden ascendente según las claves.
     * Fuente:
     *  https://dev.to/ronnymedina/estructura-de-datos-binary-tree-arbol-binario-2geb
     */
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
    /**
     * Busca una asociación de clave-valor en el árbol binario según la clave especificada.
     *
     * @param key la clave a buscar en el árbol
     * @return la asociación de clave-valor encontrada, o null si la clave no está presente en el árbol
     */
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

    /**
     * Obtiene la asociación de clave-valor almacenada en este nodo del árbol.
     *
     * @return la asociación de clave-valor almacenada en este nodo del árbol
     */
    public Asociacion<String, String> getData() {
        return data;
    }
}
