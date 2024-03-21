/*
Universidad del Valle de Guatemala
Facultad de Ingenieria
Algoritmos y Estructura de Datos
Vianka Castro 23201
Clase Main
 */
import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){

        BinaryTree diccionario = leerDiccionario("diccionario.txt");
        Asociacion<String, String> ascociacion;
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("Bienvenido al Traductor de Ingles-Español!");
            System.out.println("1. Traducir txt");
            System.out.println("2. Ingresar Texto");
            System.out.println("3. Mostrar in-order del arbol");
            System.out.println("4. Salir");
            System.out.println("Elija una opcion > ");

            String opcion = scan.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida, ingrese un numero de opcion");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Traduccion del txt");
                    System.out.println("Ingrese el nombre del archivo de texto a traducir: ");
                    String nombreArchivo = scan.nextLine();
                    String txt = leerArchivo(nombreArchivo);
                    traducirTexto(diccionario, txt);
                    break;
                case 2:
                    System.out.println("Ingrese el texto a traducir: ");
                    String texto = scan.nextLine();
                    traducirTexto(diccionario, texto);
                    break;
                case 3:
                    System.out.println("Mostrando relaciones ordenadas por la palabra en ingles.. ");
                    diccionario.printInOrder();
                    break;
                case 4:
                    System.out.println("Saliendo..");
                    scan.close();
                    return;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }

    /**
     * Lee un diccionario desde un archivo de texto y lo carga en un BinaryTree.
     *
     * @param fileName el nombre del archivo de texto que contiene el diccionario
     * @return un BinaryTree que contiene el diccionario cargado desde el archivo
     * @throws NullPointerException si fileName es null
     */
    public static BinaryTree leerDiccionario(String fileName) {
        BinaryTree diccionario = new BinaryTree();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                cargarPalabra(diccionario, line);
            }
            br.close();
            System.out.println("El diccionario se cargó correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar el diccionario: " + e.getMessage());
        }
        return diccionario;
    }

    /**
     * Carga una palabra y su traducción en español en un BinaryTree.
     *
     * @param diccionario el BinaryTree en el que se cargará la palabra y su traducción
     * @param line la línea del archivo que contiene la palabra y su traducción en el formato "(clave, valor)"
     * @throws NullPointerException si diccionario o line es null
     * @throws IllegalArgumentException si line no está en el formato esperado "(clave, valor)"
     */
    private static void cargarPalabra(BinaryTree diccionario, String line) {
        int startParenIndex = 1 + line.indexOf("(");
        int endParenIndex = line.indexOf(")");
        int commaIndex = line.indexOf(",");

        String key = line.substring(startParenIndex, commaIndex).trim();
        String espanol = line.substring(2 + commaIndex, endParenIndex).trim().toLowerCase();

        Asociacion<String, String> asoc = new Asociacion<>(key.toLowerCase(), espanol);
        diccionario.insert(asoc);
    }

    /**
     * Traduce un texto de inglés a español utilizando un diccionario BinaryTree.
     *
     * @param diccionario el BinaryTree que contiene las asociaciones de palabras inglés-español
     * @param texto el texto que se traducirá
     * @return un StringBuilder que contiene el texto traducido con palabras no encontradas entre asteriscos
     * @throws NullPointerException si diccionario o texto es null
     */
    public static StringBuilder traducirTexto(BinaryTree diccionario, String texto) {
        String[] palabras = texto.split("\\s+");
        StringBuilder traduccion = new StringBuilder();
        //Por cada palabra la busca en el diccionario el key que es en ingles
        for (String palabra : palabras) {
            Asociacion<String, String> asociacion = diccionario.search(palabra.toLowerCase());
            //si existe, imprime el value que es espanol
            if (asociacion != null) {
                traduccion.append(asociacion.getValue()).append(" ");
                //si asociacion es nulo imprime la palabra que no encontro entre * *
            } else {
                traduccion.append("*").append(palabra).append("* ");
            }
        }
        System.out.println("Texto traducido:");
        System.out.println(traduccion);
        return traduccion;
    }

    /**
     * Lee el contenido de un archivo de texto y lo devuelve como una cadena de caracteres.
     *
     * @param nombreArchivo el nombre del archivo de texto que se leerá
     * @return una cadena de caracteres que representa el contenido del archivo
     * @throws NullPointerException si nombreArchivo es null
     */
    private static String leerArchivo(String nombreArchivo) {
        StringBuilder contenido = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return contenido.toString();
    }


}
