import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Auto implements FormatoCSV {
    private String marca;
    private String modelo;

    private String color;
    private int anio;
    private double precio;

    public Auto(String marca, String modelo,String color, int anio, double precio){
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anio = anio;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String darFormatoCSV(){
        return this.marca+";"+this.modelo+";"+this.color+";"+this.anio+";"+this.precio;
    }

    @Override
    public String toString(){
        return marca+" "+modelo;
    }

    public static void mostrarAutos(ArrayList<Auto> autos){
        int index = 0;
        for (Auto auto : autos){
            System.out.println("ID: "+index+" Marca: "+auto.marca+" Modelo: "+auto.modelo+" Color: "+auto.color+" Año: "+auto.anio+" Precio: U$D "+auto.precio);
            index++;
        }
    }


    public static ArrayList<Auto> agregarAuto(Scanner sc, ArrayList<Auto> autos, ArrayList<Marca> marcas){
        Auto a;
        String op;
        String marca;
        String modelo;
        String color;
        int anio;
        double precio;
        do{
            System.out.println("Escriba -1 para salir o presione enter para cargar");
            op = sc.nextLine();
            if (!op.equals("-1")){
                marca = Marca.elegirMarca(marcas).getNombre();
                System.out.println("Modelo: ");
                modelo = sc.nextLine();
                System.out.println("Color: ");
                color = sc.nextLine();
                System.out.println("Año: ");
                anio = Integer.parseInt(sc.nextLine());
                System.out.println("Precio: ");
                precio = Double.parseDouble(sc.nextLine());
                a = new Auto(marca, modelo, color, anio, precio);
                autos.add(a);
            }
        }while (!op.equals("-1"));
        return autos;
    }

    public static Auto modificarAuto(Scanner sc, Auto auto, ArrayList<Marca> marcas){
        String op;
        String marca;
        String modelo;
        String color;
        int anio;
        double precio;
        marca = Marca.elegirMarca(marcas).getNombre();
        System.out.println("Modelo: ");
        modelo = sc.nextLine();
        System.out.println("Color: ");
        color = sc.nextLine();
        System.out.println("Año: ");
        anio = Integer.parseInt(sc.nextLine());
        System.out.println("Precio: ");
        precio = Double.parseDouble(sc.nextLine());
        auto.setMarca(marca);
        auto.setModelo(modelo);
        auto.setColor(color);
        auto.setAnio(anio);
        auto.setPrecio(precio);
        return auto;
    }





    public static void escribirCSV(ArrayList<Auto> autos) {
        File f = new File("./autos.csv");
        try(FileWriter fw = new FileWriter(f)){
            for (Auto auto : autos){
                fw.write(auto.darFormatoCSV()+"\n");
            }
        }catch (Exception e){
            System.out.println("Se produjo un error");
        }
    }


    public static ArrayList<Auto> leerCSV() {
        Auto a;
        String[] datos;
        ArrayList<Auto> autos = new ArrayList<Auto>();
        try(Scanner scFile = new Scanner(new File("./autos.csv"))){
            while (scFile.hasNextLine()){
                datos = scFile.nextLine().split(";");
                a = new Auto(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), Double.parseDouble(datos[4]));
                autos.add(a);

            }
        }catch (Exception e){
            System.out.println("Error leyendo el archivo");
        }
        return autos;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

