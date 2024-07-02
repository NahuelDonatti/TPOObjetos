import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<OpcionMenu> opciones;
    private Scanner sc;

    public Menu() {
        opciones = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void agregarOpcion(OpcionMenu opcion) {
        opciones.add(opcion);
    }

    public void imprimir() {
        System.out.println("Elija una opción, escriba 0 para salir:");
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i).getDescripcion());
        }
        System.out.println("0. Salir");
    }

    public void ejecutar() {
        int opcion = -1;
        while (opcion != 0) {
            imprimir();
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            if (opcion > 0 && opcion <= opciones.size()) {
                opciones.get(opcion - 1).ejecutar();
            } else if (opcion != 0) {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        System.out.println("Saliendo...");
    }
}
