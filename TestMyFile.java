/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ljmc2
 */
public class TestMyFile {

    static MyFile mf = new MyFile();
    static Scanner lea = new Scanner(System.in);

    public static void main(String[] args) {

        int option = 0;
        do {
            System.out.println("MENU"
                    + "\n1. Set el archivo/folder"
                    + "\n2. Ver info"
                    + "\n3. Crear archivo"
                    + "\n4. Crear folder"
                    + "\n5. Borrar"
                    + "\n6. Imprimir contenidos"
                    + "\n7. Mostrar directorio"
                    + "\n8. Salir"
                    + "\nElija una opcion.");
            try {
                option = lea.nextInt();
                switch (option) {
                    case 1:
                        set();

                        break;
                    case 2:
                        mf.info();

                        break;
                    case 3:
                        mf.crearArchivo();

                        break;
                    case 4:
                        mf.crearFolder();

                        break;
                    case 5:
                        mf.borrarArchivo(mf.getFile());

                        break;
                    case 6:
                        mf.tree();

                        break;
                    case 7:
                        mf.mostrarDir();
                        
                        break;
                }
            } catch (InputMismatchException e) {
                lea.nextLine();
                System.out.println("Por favor ingrese una opcion correcta");
            } catch (NullPointerException e) {
                System.out.println("Debe seeccionar la opcion 1 por lo menos una vez");
            } catch (IOException e) {
                System.out.println("Error en Disco: " + e.getMessage());
            }

        } while (option != 8);

    }

    private static void set() {
        System.out.println("Direccion: ");
        mf.setFile(lea.next());
    }

}
