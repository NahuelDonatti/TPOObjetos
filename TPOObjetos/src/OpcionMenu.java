public abstract class OpcionMenu {
    private String descripcion;

    public OpcionMenu(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public abstract void ejecutar();
}

