import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Marca> marcas = Marca.leerCSV();
        ArrayList<Auto> autos = Auto.leerCSV();
        Ganancias ganancias = new Ganancias();
        Menu menuPrincipal = new Menu();
        Menu menuAuto = new Menu();
        Menu menuMarcas = new Menu();
        menuPrincipal.agregarOpcion(new OpcionMenu("Ver autos disponibles") {
            @Override
            public void ejecutar() {
                Auto.mostrarAutos(autos);
            }
        });
        menuPrincipal.agregarOpcion(new OpcionMenu("Agregar, modificar o eliminar un auto") {
            @Override
            public void ejecutar() {
                menuAuto.ejecutar();
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
                menuMarcas.ejecutar();
            }
        });

        menuPrincipal.agregarOpcion(new OpcionMenu("Vender un auto") {
            @Override
            public void ejecutar() {
                ganancias.venderAuto(autos);
                System.out.println("Auto vendido");
            }
        });

        menuPrincipal.agregarOpcion(new OpcionMenu("Ver vendidos") {
            @Override
            public void ejecutar() {
                Auto.mostrarAutos(ganancias.getVendidos());
                System.out.println("Ganancias totales: U$D "+ganancias.getGanancias());
            }
        });
        menuAuto.agregarOpcion(new OpcionMenu("Agregar un auto") {
            @Override
            public void ejecutar() {
                Auto.agregarAuto(sc, autos, marcas);
            }
        });
        menuAuto.agregarOpcion(new OpcionMenu("Modificar un auto") {
            @Override
            public void ejecutar() {
                Auto.mostrarAutos(autos);
                Auto.modificarAuto(sc, autos.get(Menu.pedirUnNumero(0, autos.size()-1, "Seleccione el auto a modificar: ")), marcas);
                System.out.println("Auto modificado");
            }
        });
        menuAuto.agregarOpcion(new OpcionMenu("Eliminar un auto") {
            @Override
            public void ejecutar() {
                Auto.mostrarAutos(autos);
                autos.remove(Menu.pedirUnNumero(0, autos.size()-1, "Ingrese el auto a eliminar: "));
                System.out.println("El auto fue eliminado con éxito");
            }
        });

        menuMarcas.agregarOpcion(new OpcionMenu("Agregar una marca") {
            @Override
            public void ejecutar() {
                Marca.agregarMarcas(sc, marcas);
            }
        });

        menuMarcas.agregarOpcion(new OpcionMenu("Modificar una marca") {
            @Override
            public void ejecutar() {
                Marca.modificarMarca(sc, marcas);


            }
        });
        menuMarcas.agregarOpcion(new OpcionMenu("Eliminar una marca") {
            @Override
            public void ejecutar() {
                Marca.mostrarMarcas(marcas);
                marcas.remove(Menu.pedirUnNumero(0, marcas.size()-1, "Ingrese la marca a eliminar: "));
                System.out.println("La marca se eliminó con éxito");
            }
        });




    menuPrincipal.ejecutar();
    Auto.escribirCSV(autos);
    Marca.escribirCSV(marcas);
     }

}

