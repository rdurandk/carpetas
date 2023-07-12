import java.sql.SQLOutput;

public class ProyectoCatalogo {
    public static void main(String[] args) {
        IProducto[] productos = new Producto[6];

        productos[0]= new IPhone(1500,"Samsung", "Azul", "SAMSUNG G23");
        productos[1]= new TvLcd(2500,"Lg",50);
        productos[2]= new Libro(20,"Eric Gamma", "Elementos reusables POO", "Alguna...");
        productos[3]= new Comics(15,"Stanlin","The amazing spiderman","SPD-130","Spiderman");
        productos[4]= new TvLcd(3000,"Panasonic",70);
        productos[5]= new Libro(35,"Alejandro Taboada", "Patrones de diseño", "Alguna...");


        for(IProducto producto: productos){
            System.out.print("Tipo de: " + producto.getClass().getName());
            System.out.print(" - ");
            System.out.print("Precio: " + "S/" +producto.getPrecio());
            System.out.print(" - ");
            System.out.print("Precio final con descuento: " + producto.getPrecioVenta());

            if(producto instanceof IElectronico){
                System.out.print(" - ");
                System.out.print("Fabricante: " + ((IElectronico) producto).getFabricante());

                // Para los IPhone ============
                if (producto instanceof IPhone) {
                    System.out.print(" - ");
                    System.out.print("Modelo: " + ((IPhone) producto).getModelo());
                    System.out.print(" - ");
                    System.out.print("Color: " + ((IPhone) producto).getColor());
                }

                // Para los LCD  ============
                if (producto instanceof TvLcd) {
                    System.out.print(" - ");
                    System.out.print("Pulgadas: " + ((TvLcd) producto).getPulgada());
                }
            }

            if(producto instanceof ILibro){
                System.out.print(" - ");
                System.out.print("Fecha de Publicacion: " + ((ILibro) producto).getFechaPublicacion());
                System.out.print(" - ");
                System.out.print("Autor: " + ((ILibro) producto).getAutor());
                System.out.print(" - ");
                System.out.print("Titulo: " + ((ILibro) producto).getTitulo());
                System.out.print(" - ");
                System.out.print("Editorial: " + ((ILibro) producto).getEditorial());

                if (producto instanceof Comics) {
                    System.out.print(" - ");
                    System.out.print("Personaje: " + ((Comics) producto).getPersonaje());
                }
            }
            System.out.println();
        }
    }
}
