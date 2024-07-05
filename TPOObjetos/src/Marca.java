import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Marca {
    private String nombre;

    public Marca(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return nombre;
    }


    public static ArrayList<Marca> agregarMarcas(Scanner sc, ArrayList<Marca> marcas){
        String nombre;
        Marca m;
        System.out.println("Escriba -1 para salir");
        do{
            System.out.print("Ingrese la nueva marca: ");
            nombre = sc.nextLine();
            if (!nombre.equals("-1")){
                m = new Marca(nombre);
                marcas.add(m);
            }
        } while (!nombre.equals("-1"));
        return marcas;
    }

    public static Marca modificarMarca(Scanner sc, ArrayList<Marca> marcas){
        Marca m = null;
        m = Marca.elegirMarca(marcas);
        System.out.println("Ingrese el nuevo nombre");
        m.nombre = sc.nextLine();
        return m;
    }



    public static void mostrarMarcas(ArrayList<Marca> marcas){
        int index = 0;
        for (Marca marca : marcas){
            System.out.println("Índice: "+index+" Marca: "+marca.getNombre());
            index++;
        }
    }



    public static void escribirCSV(ArrayList<Marca> m){
        Scanner sc = new Scanner(System.in);
        File f = new File("./marcas.csv");
        try(FileWriter fw = new FileWriter(f)){
            for(Marca marca : m){
                fw.write(marca.getNombre()+"\n");
            }

        } catch (Exception e){
            System.out.println("Se ha producido un error");
        }
    }

    public static ArrayList<Marca> leerCSV(){
        ArrayList<Marca> m = new ArrayList<Marca>();
        Marca marca;
        String datos;
        try (Scanner scFile = new Scanner(new File("./marcas.csv"))){
            while(scFile.hasNextLine()){
                datos = scFile.nextLine();
                marca = new Marca(datos);
                m.add(marca);
            }
        } catch (Exception e){
            System.out.println("Error");

        }
        return m;
    }

    public static Marca elegirMarca(ArrayList<Marca> m){
        Scanner sc = new Scanner(System.in);
        mostrarMarcas(m);
        String opcion;
        do{
            System.out.print("Ingrese el índice de la marca: ");
            opcion = sc.nextLine();
            if (!opcion.equals("-1")){
                return m.get(Integer.parseInt(opcion));
            }
        } while (!opcion.equals("-1"));
        return null;
    }

}
