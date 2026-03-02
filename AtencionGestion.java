/**
 * Clase de gestión/dependencia encargada de procesar el ingreso
 * de los pacientes y asignarlos a un pabellón según su EPS.
 *
 * <p>
 * Esta clase forma parte de la lógica principal del sistema hospitalario
 * y representa una relación de dependencia, ya que recibe objetos de tipo
 * Paciente para procesar su ingreso.
 * </p>
 *
 * @author Yulieth Paola Domínguez López
 * @author Daniel Jerónimo Bladón Salgado
 * @version 1.0
 */
public class AtencionGestion {

    /**
     * Constructor por defecto de la clase AtencionGestion.
     * <p>
     * No recibe parámetros ya que la clase no necesita atributos
     * propios para funcionar.
     * </p>
     */
    public AtencionGestion() {
    }

    /**
     * Procesa el ingreso de un paciente y lo envía al pabellón correspondiente
     * según su EPS.
     *
     * <p>
     * Se utiliza una estructura {@code switch} para evaluar la EPS del paciente
     * y asignar el pabellón adecuado.
     * </p>
     *
     * <p>
     * IMPORTANTE: En Java, los Strings deben compararse usando equals()
     * y no con el operador ==, ya que este último compara referencias
     * de memoria y no el contenido del texto.
     * </p>
     *
     * @param pacienteNuevo Objeto de tipo Paciente que representa
     *                      al nuevo paciente que ingresa al hospital.
     * @return Un mensaje en formato String indicando el pabellón
     * asignado al paciente según su EPS.
     */
    public String procesarIngreso(Paciente pacienteNuevo) {

        // Variable que almacenará el mensaje final
        String mensaje;

        // Estructura de decisión basada en la EPS del paciente
        switch (pacienteNuevo.getEPS()) {

            case "Sanitas":
                mensaje = "Nuevo paciente ingresando: El paciente "
                        + pacienteNuevo.getNombre()
                        + " ha sido enviado al Pabellón A (Norte)";
                break;

            case "Sura":
                mensaje = "Nuevo paciente ingresando: El paciente "
                        + pacienteNuevo.getNombre()
                        + " ha sido enviado al Pabellón B (Sur)";
                break;

            case "Nueva EPS":
                mensaje = "Nuevo paciente ingresando: El paciente "
                        + pacienteNuevo.getNombre()
                        + " ha sido enviado al Pabellón C (Este)";
                break;

            case "Compensar":
                mensaje = "Nuevo paciente ingresando: El paciente "
                        + pacienteNuevo.getNombre()
                        + " ha sido enviado al Pabellón D (Oeste)";
                break;

            default:
                mensaje = "Nuevo paciente ingresando: EPS '"
                        + pacienteNuevo.getEPS()
                        + "' no registrada. El paciente "
                        + pacienteNuevo.getNombre()
                        + " fue enviado a Recepción General.";
                break;
        }

        // Se imprime el resultado en consola
        System.out.println(mensaje);

        // Se retorna el mensaje generado
        return mensaje;
    }
}