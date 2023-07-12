public enum Color {
    ROJO("Rojo"),
    AMARILLO("Amarillo"),
    AZUL("Azul"),
    BLANCO("Blanco"),
    GRIS("Gris Oscuro"),
    NARANJO("Naranja");

    private final String color;

    //Si hago un constructor tendre que dar argumento a cada 1 de sus atributos
    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    //si implementamos el toString de forma automatica mostrara  argumentos de sus atributos
    @Override
    public String toString() {
        return this.color;
    }
}

