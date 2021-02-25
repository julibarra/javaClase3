import java.util.Comparator;

public class Persona implements Precedable<Persona>, Comparator<Persona> {
    private String nombre;
    private int dni;

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Persona() {
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {

        return dni;
    }

    public void setDni(int dni) {

        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }

    @Override
    public int precedeA(Persona persona) {


        return this.nombre.compareTo(persona.getNombre());
    }


    @Override
    public int compare(Persona o1, Persona o2) {

        return o1.getNombre().compareTo(o2.getNombre());
    }
}
