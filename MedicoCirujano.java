import java.util.List;

/**
 * Representa a un médico cirujano dentro del sistema hospitalario.
 * <p>
 * Hereda de la clase Medico e implementa la interfaz ICirujano.
 * Añade información específica relacionada con el quirófano
 * y la capacidad de tomar decisiones sobre operaciones.
 */
public class MedicoCirujano extends Medico implements ICirujano {

    /**
     * Número del quirófano asignado al cirujano.
     */
    private String numQuirofano;

    /**
     * Indica si el quirófano está disponible.
     */
    private boolean quirofanoDisponible;

    /**
     * Constructor por defecto.
     */
    public MedicoCirujano() {
    }

    /**
     * Constructor con atributos propios del cirujano.
     *
     * @param numQuirofano        número del quirófano asignado
     * @param quirofanoDisponible estado de disponibilidad del quirófano
     */
    public MedicoCirujano(String numQuirofano, boolean quirofanoDisponible) {
        this.numQuirofano = numQuirofano;
        this.quirofanoDisponible = quirofanoDisponible;
    }

    /**
     * Constructor completo que inicializa atributos heredados
     * de Persona y Medico, además de los propios del cirujano.
     *
     * @param nombre              nombre del cirujano
     * @param DNI                 documento de identidad
     * @param edad                edad en años
     * @param genero              género
     * @param especialidad        especialidad médica
     * @param numeroDeRegistro    número de registro profesional
     * @param listaPacientes      lista de pacientes asignados
     * @param numQuirofano        número del quirófano
     * @param quirofanoDisponible estado del quirófano
     */
    public MedicoCirujano(String nombre, String DNI, int edad, String genero,
                          String especialidad, String numeroDeRegistro,
                          List<Paciente> listaPacientes,
                          String numQuirofano, boolean quirofanoDisponible) {
        super(nombre, DNI, edad, genero, especialidad, numeroDeRegistro, listaPacientes);
        this.numQuirofano = numQuirofano;
        this.quirofanoDisponible = quirofanoDisponible;
    }

    /**
     * Verifica si el quirófano está disponible.
     *
     * @param disponible estado del quirófano a evaluar
     * @return true si está disponible, false en caso contrario
     */
    @Override
    public boolean verificarQuirofano(boolean disponible) {
        return disponible;
    }

    /**
     * Toma la decisión de operar según la disponibilidad del quirófano.
     * Si el quirófano está disponible, se realiza la operación.
     * En caso contrario, se informa que está ocupado.
     */
    @Override
    public void tomarDecision() {
        if (verificarQuirofano(quirofanoDisponible)) {
            System.out.println("El cirujano " + nombre
                    + " está operando en el quirófano " + numQuirofano);
        } else {
            System.out.println("Quirófano " + numQuirofano
                    + " ocupado. El cirujano " + nombre + " buscará otro quirófano.");
        }
    }

    /**
     * Implementación del método presentarse para aplicar polimorfismo.
     *
     * @return información de presentación del cirujano
     */
    @Override
    public String presentarse() {
        return "[Médico Cirujano] Dr. " + nombre
                + " - Especialidad: " + getEspecialidad()
                + " - Quirófano: " + numQuirofano;
    }

    /**
     * @return número del quirófano
     */
    public String getNumQuirofano() {
        return numQuirofano;
    }

    /**
     * @param numQuirofano nuevo número de quirófano
     */
    public void setNumQuirofano(String numQuirofano) {
        this.numQuirofano = numQuirofano;
    }

    /**
     * @return true si el quirófano está disponible
     */
    public boolean isQuirofanoDisponible() {
        return quirofanoDisponible;
    }

    /**
     * @param disponible nuevo estado del quirófano
     */
    public void setQuirofanoDisponible(boolean disponible) {
        this.quirofanoDisponible = disponible;
    }
}