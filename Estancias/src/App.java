import java.util.Scanner;

import persisitencia.*;
import servicios.FamiliaServicio;

public class App {
    public static FamiliaServicio famSERV = new FamiliaServicio();

    public static void main(String[] args) throws Exception {
        // CasaDAO casaDao = new CasaDAO();
        // ComentariosDAO comentariosDao = new ComentariosDAO();
        // ClienteDAO cliDao = new ClienteDAO();
        // EstanciaDAO estDao = new EstanciaDAO();

        // estDao.listarEstancias();
        Scanner lee = new Scanner(System.in);
        int opcion = 0;
        do {
            mostrarOpcionesMenu();
            opcion = seleccionarOpcion(lee);
            procesarOpcion(opcion);

        } while (opcion != 0);

    }

    public static int seleccionarOpcion(Scanner scan) {
        System.out.println("Ingrese opcion: ");
        int op = scan.nextInt();
        scan.nextLine();
        return op;
    }

    public static void mostrarOpcionesMenu() {
        System.out.println("\n--- Menú de Consultas ---");
        System.out.println("1. Familias con al menos 3 hijos y edad máxima menor a 10 años");
        System.out.println("2. Casas disponibles en Reino Unido (1-31 agosto 2020)");
        System.out.println("3. Familias con email Hotmail");
        System.out.println("4. Casas disponibles por fecha y número de días");
        System.out.println("5. Datos de clientes y descripción de casas");
        System.out.println("6. Estancias reservadas por clientes");
        System.out.println("7. Incrementar precio por día en 5% para casas del Reino Unido");
        System.out.println("8. Número de casas por país");
        System.out.println("9. Casas del Reino Unido con comentarios 'limpias'");
        System.out.println("10. Insertar nueva estancia");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void procesarOpcion(int opcion) {

        switch (opcion) {
            case 1:
                famSERV.listarFamiliasConHijos(3, 10);
                break;

            default:
                break;
        }
    }
}
