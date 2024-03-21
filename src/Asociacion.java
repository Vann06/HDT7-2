/*
Universidad del Valle de Guatemala
Facultad de Ingenieria
Algoritmos y Estructura de Datos
Vianka Castro 23201
Clase Asociacion<K, V>
 */

import java.util.HashMap;
import java.util.HashMap;

public class Asociacion<K, V> {

    private K key;
    private V value;

    /**
     * Constructor que crea una nueva asociación con la clave y el valor especificados.
     *
     * @param key la clave de la asociación
     * @param value el valor de la asociación
     */
    public Asociacion(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Obtiene la clave de la asociación.
     *
     * @return la clave de la asociación
     */
    public K getKey() {
        return key;
    }

    /**
     * Establece la clave de la asociación.
     *
     * @param key la nueva clave de la asociación
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Obtiene el valor de la asociación.
     *
     * @return el valor de la asociación
     */
    public V getValue() {
        return value;
    }

    /**
     * Establece el valor de la asociación.
     *
     * @param value el nuevo valor de la asociación
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Devuelve una representación en forma de cadena de la asociación, en el formato "(clave, valor)".
     *
     * @return una representación en forma de cadena de la asociación
     */
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
