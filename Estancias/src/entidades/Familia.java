package entidades;

public class Familia {

    // Atributos
    private int id;
    private String nombre;
    private int edadMinima;
    private int edadMaxima;
    private int numHijos;
    private String email;

    // Constructor por defecto
    public Familia() {
    }

    // Constructor con todos los atributos
    public Familia(int id, String nombre, int edadMinima, int edadMaxima, int numHijos, String email) {
        this.id = id;
        this.nombre = nombre;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.numHijos = numHijos;
        this.email = email;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método toString para mostrar la información de la clase
    @Override
    public String toString() {
        return "Familia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edadMinima=" + edadMinima +
                ", edadMaxima=" + edadMaxima +
                ", numHijos=" + numHijos +
                ", email='" + email + '\'' +
                '}';
    }
}
