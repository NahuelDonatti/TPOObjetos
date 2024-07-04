import java.util.ArrayList;

public class Ganancias {
    private ArrayList<Auto> vendidos;
    private double ganancias;


    public Ganancias(){
        vendidos = new ArrayList<Auto>();
        ganancias = 0.0;
    }

    public ArrayList<Auto> venderAuto(ArrayList<Auto> a){
        Auto.mostrarAutos(a);
        int elegido = Menu.pedirUnNumero(0, a.size()-1, "Seleccione el auto a vender: ");
        vendidos.add(a.get(elegido));
        ganancias += a.get(elegido).getPrecio();
        a.remove(elegido);

        return vendidos;

    }

    public double getGanancias() {
        return ganancias;
    }

    public ArrayList<Auto> getVendidos() {
        return vendidos;
    }
}
