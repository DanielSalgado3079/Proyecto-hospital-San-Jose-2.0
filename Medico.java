import java.util.List;

/**
 * Representa a un médico que trabaja en el hospital.
 * <p>
 * Hereda de la clase Persona e incluye información específica
 * como especialidad, número de registro profesional y la lista
 * de pacientes asignados.
 */
public class Medico extends Persona {

    /**
     * Especialidad médica del doctor.
     */
    private String especialidad;

    /**
     * Número de registro profesional del médico.
     */
    private String numeroDeRegistro;

    /**
     * Lista de pacientes asignados al médico.
     */
    private List<Paciente> listaPacientes;

    /**
     * Constructor por defecto.
     */
    public Medico() {
    }

    /**
     * Constructor con atributos propios del médico.
     *
     * @param especialidad     especialidad médica
     * @param numeroDeRegistro número de registro profesional
     * @param listaPacientes   lista de pacientes asignados
     */
    public Medico(String especialidad, String numeroDeRegistro, List<Paciente> listaPacientes) {
        this.especialidad = especialidad;
        this.numeroDeRegistro = numeroDeRegistro;
        this.listaPacientes = listaPacientes;
    }

    /**
     * Constructor completo que inicializa atributos heredados de Persona
     * y los propios del médico.
     *
     * @param nombre           nombre del médico
     * @param DNI              documento de identidad
     * @param edad             edad en años
     * @param genero           género
     * @param especialidad     especialidad médica
     * @param numeroDeRegistro número de registro profesional
     * @param listaPacientes   lista de pacientes asignados
     */
    public Medico(String nombre, String DNI, int edad, String genero,
                  String especialidad, String numeroDeRegistro,
                  List<Paciente> listaPacientes) {
        super(nombre, DNI, edad, genero);
        this.especialidad = especialidad;
        this.numeroDeRegistro = numeroDeRegistro;
        this.listaPacientes = listaPacientes;
    }

    /**
     * Muestra en consola la lista de pacientes asignados al médico.
     * Utiliza un ciclo for-each para recorrer la lista.
     */
    public void revisarPacientes() {
        System.out.println("Dr. " + nombre + " revisando lista de pacientes:");
        for (Paciente paciente : listaPacientes) {
            System.out.println("  Paciente: " + paciente.getNombre());
        }
    }

    /**
     * Evalúa el síntoma de cada paciente y asigna un nivel de prioridad
     * utilizando una estructura switch.
     * <p>
     * Prioridades:
     * 1 - Infarto
     * 2 - Fiebre
     * 3 - Dolor
     * 4 - Otros casos
     */
    public void asignarPrioridad() {
        for (Paciente paciente : listaPacientes) {
            String sintoma = paciente.mostrarSintomas();
            int prioridad;

            switch (sintoma) {
                case "Infarto":
                    prioridad = 1;
                    break;
                case "Fiebre":
                    prioridad = 2;
                    break;
                case "Dolor":
                    prioridad = 3;
                    break;
                default:
                    prioridad = 4;
                    break;
            }

            System.out.println("El Dr. " + nombre + " evaluó el síntoma ["
                    + sintoma + "] y asignó Prioridad [" + prioridad + "]");
        }
    }

    /**
     * Implementación del método abstracto heredado de Persona.
     * Permite aplicar polimorfismo al presentar la información del médico.
     *
     * @return información de presentación del médico
     */
    @Override
    public String presentarse() {
        return "[Médico] Dr. " + nombre + " - Especialidad: " + especialidad;
    }

    /**
     * @return especialidad médica
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad nueva especialidad médica
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return número de registro profesional
     */
    public String getNumeroDeRegistro() {
        return numeroDeRegistro;
    }

    /**
     * @param reg nuevo número de registro profesional
     */
    public void setNumeroDeRegistro(String reg) {
        this.numeroDeRegistro = reg;
    }

    /**
     * @return lista de pacientes asignados
     */
    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    /**
     * @param lista nueva lista de pacientes asignados
     */
    public void setListaPacientes(List<Paciente> lista) {
        this.listaPacientes = lista;
    }
}