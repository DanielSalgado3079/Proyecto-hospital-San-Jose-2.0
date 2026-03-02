/**
 * Clase abstracta que representa a una persona dentro del sistema hospitalario.
 * <p>
 * Contiene los atributos comunes que comparten los médicos y los pacientes.
 * No puede ser instanciada directamente porque es una clase base del modelo.
 * <p>
 * Las clases Medico y Paciente heredan de esta clase.
 */
public abstract class Persona {

    /**
     * Nombre completo de la persona.
     */
    protected String nombre;

    /**
     * Documento Nacional de Identidad.
     */
    protected String DNI;

    /**
     * Edad en años.
     */
    protected int edad;

    /**
     * Género de la persona.
     */
    protected String genero;

    /**
     * Constructor por defecto.
     * Permite crear el objeto sin inicializar los atributos.
     */
    public Persona() {
    }

    /**
     * Constructor con parámetros que inicializa todos los atributos.
     *
     * @param nombre nombre completo de la persona
     * @param DNI    documento de identidad
     * @param edad   edad en años
     * @param genero género de la persona
     */
    public Persona(String nombre, String DNI, int edad, String genero) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.genero = genero;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre de la persona.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el documento de identidad.
     *
     * @return DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Modifica el documento de identidad.
     *
     * @param DNI nuevo documento
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @return edad en años
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Modifica la edad de la persona.
     *
     * @param edad nueva edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el género de la persona.
     *
     * @return género
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Modifica el género de la persona.
     *
     * @param genero nuevo género
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Método abstracto que debe ser implementado por las clases hijas.
     * Permite que cada tipo de persona defina su propia forma de presentación.
     *
     * @return información de presentación
     */
    public abstract String presentarse();
}