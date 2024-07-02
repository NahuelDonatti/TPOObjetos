import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Marca> marcas = Marca.leerCSV();
        ArrayList<Auto> autos = Auto.leerCSV();
        Menu menuPrincipal = new Menu();
        Menu menuAuto = new Menu();
        Menu menuMarcas = new Menu();
        menuPrincipal.agregarOpcion(new OpcionMenu("Ver autos disponibles") {
            @Override
            public void ejecutar() {
            }
        });
        menuPrincipal.agregarOpcion(new OpcionMenu("Agregar, modificar o eliminar un auto") {
            @Override
            public void ejecutar() {
                Auto.agregarAuto(sc, autos, marcas);
            }
        });
        menuPrincipal.agregarOpcion(new OpcionMenu("Ver marcas") {
            @Override
            public void ejecutar() {
                Marca.mostrarMarcas(marcas);
            }
        });
        menuPrincipal.agregarOpcion(new OpcionMenu("Agregar, modificar o eliminar una marca") {
            @Override
            public void ejecutar() {
                Marca.elegirMarca(marcas);
            }
        });



    menuPrincipal.ejecutar();
    Auto.escribirCSV(autos);
    Marca.escribirCSV(marcas);
     }

}

