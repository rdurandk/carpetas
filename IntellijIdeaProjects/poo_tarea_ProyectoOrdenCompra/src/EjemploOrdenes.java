import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EjemploOrdenes {
    public static void main(String[] args){
        OrdenCompra orden1 = new OrdenCompra("Computadoras");
        orden1.addProducto(new Productos("Asus", "LAPTOP ASUS X515JA", 1300));
        orden1.addProducto(new Productos("Lenovo", "LAPTOP LENOVO IDEAPAD", 1400));
        orden1.addProducto(new Productos("Sony Corporation", "LAPTOP Sony GRANLVL", 1800));
        orden1.addProducto(new Productos("Toshiba", "Laptop Toshiva Intel", 2000));
        orden1.setCliente(new Cliente("Alexander", "Durand"));
        Calendar calendario1 = Calendar.getInstance();
        calendario1.set(2023,02,14,7,40);
        Date fecha1 = calendario1.getTime();
        orden1.setFecha(fecha1);

        OrdenCompra orden2 = new OrdenCompra("Televisores");
        orden2.addProducto(new Productos("Samsung Electronics", "Tv Samsung QLED Smart tv", 4000));
        orden2.addProducto(new Productos("LG Electronics", "Tv Lg QLED UHD8", 2000));
        orden2.addProducto(new Productos("Sony", "Tv Sony QLED 4K FULL HD", 3000));
        orden2.addProducto(new Productos("Panasonic", "Tv Panasonic 4k LCD 4K UHD ", 1300));
        orden2.setCliente(new Cliente("Alvaro", "Alvarez"));
        Calendar calendario2 = Calendar.getInstance();
        calendario2.set(2023,01,30,12,30);
        Date fecha2 = calendario2.getTime();
        orden2.setFecha(fecha2);

        OrdenCompra orden3 = new OrdenCompra("Celulares");
        orden3.addProducto(new Productos("Samsung", "Galaxy S23 ULTRA", 5600));
        orden3.addProducto(new Productos("Apple", "Apple Iphone 14", 5900));
        orden3.addProducto(new Productos("Xiaomi", "Xiaomi redmi 10", 560));
        orden3.addProducto(new Productos("Motorola", "Motorola Smartphone", 1600));
        orden3.setCliente(new Cliente("Mafer", "Alvarez"));
        Calendar calendario3 = Calendar.getInstance();
        calendario3.set(2023,02,05,10,00);
        Date fecha3 = calendario3.getTime();
        orden3.setFecha(fecha3);

        OrdenCompra[] ordenes = {orden1,orden2,orden3};
        for(OrdenCompra orden: ordenes){
            System.out.println(orden.getId()  + ": " + orden.getDescripcion());
            for(Productos producto: orden.getProductos()){
                System.out.println(producto.getFabricante() + ", " + producto.getNombre() + ", " + producto.getPrecio());
            }
            System.out.println("Precio Total: " + orden.granTotal());
            System.out.println(orden.getCliente().getNombre() + " " + orden1.getCliente().getApellido());
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orden.getFecha()));
            System.out.println();
        }

    }
}
