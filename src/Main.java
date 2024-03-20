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
    public static void main(String[] args) throws FileNotFoundException {

        BinaryTree diccionario = leerDiccionario("diccionario.txt");
        String nom = "diccionario.txt";
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

    private static void cargarPalabra(BinaryTree diccionario, String line) {
        int startParenIndex = 1 + line.indexOf("(");
        int endParenIndex = line.indexOf(")");
        int commaIndex = line.indexOf(",");

        String key = line.substring(startParenIndex, commaIndex).trim();
        String espanol = line.substring(2 + commaIndex, endParenIndex).trim().toLowerCase();

        Asociacion<String, String> asoc = new Asociacion<>(key.toLowerCase(), espanol);
        diccionario.insert(asoc);
    }

    private static void traducirTexto(BinaryTree diccionario, String texto) {
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
    }

    //poder leer un txt y pedirle su nombre
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
