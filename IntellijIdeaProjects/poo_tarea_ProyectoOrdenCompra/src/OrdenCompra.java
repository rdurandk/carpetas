import java.util.Date;

public class OrdenCompra {
    private int id;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Productos[] productos;
    public static int ultimoId;
    private int indiceProducto;

    public OrdenCompra(String descripcion){
        this.id = ++ultimoId;
        this.descripcion = descripcion;
        this.productos = new Productos[4];
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Productos[] getProductos() {
        return productos;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addProducto(Productos producto){
        this.productos[indiceProducto++] = producto;
    }

    public double granTotal(){
        double precioTotal=0;
        for(int i=0;i<this.productos.length;i++){
            precioTotal += this.productos[i].getPrecio();
        }
        return  precioTotal;
    }

}
