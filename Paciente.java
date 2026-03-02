/**
 * Representa a un paciente dentro del sistema hospitalario.
 * <p>
 * Hereda de la clase Persona y añade información específica
 * como número de historial clínico, EPS, saldo disponible
 * y síntoma principal.
 */
public class Paciente extends Persona {

    /**
     * Número de historial clínico del paciente.
     */
    private String numeroHistorial;

    /**
     * EPS a la que está afiliado el paciente.
     */
    private String EPS;

    /**
     * Saldo disponible del paciente para pagar consultas.
     */
    private double saldo;

    /**
     * Síntoma principal del paciente.
     */
    private String sintoma;

    /**
     * Constructor por defecto.
     */
    public Paciente() {
    }

    /**
     * Constructor con parámetros básicos.
     *
     * @param numeroHistorial número de historial clínico
     * @param DNI             documento de identidad
     * @param saldo           saldo disponible
     */
    public Paciente(String numeroHistorial, String DNI, double saldo) {
        this.numeroHistorial = numeroHistorial;
        this.DNI = DNI;
        this.saldo = saldo;
    }

    /**
     * Constructor completo que inicializa todos los atributos.
     *
     * @param nombre          nombre del paciente
     * @param DNI             documento de identidad
     * @param edad            edad en años
     * @param genero          género del paciente
     * @param numeroHistorial número de historial clínico
     * @param EPS             entidad prestadora de salud
     * @param saldo           saldo disponible
     * @param sintoma         síntoma principal
     */
    public Paciente(String nombre, String DNI, int edad, String genero,
                    String numeroHistorial, String EPS, double saldo, String sintoma) {
        super(nombre, DNI, edad, genero);
        this.numeroHistorial = numeroHistorial;
        this.EPS = EPS;
        this.saldo = saldo;
        this.sintoma = sintoma;
    }

    /**
     * Retorna el síntoma principal del paciente.
     *
     * @return síntoma del paciente
     */
    public String mostrarSintomas() {
        return sintoma;
    }

    /**
     * Verifica si el paciente tiene saldo suficiente para pagar una consulta.
     * Si tiene saldo suficiente, se descuenta el valor correspondiente.
     *
     * @param precioConsulta costo de la consulta
     * @return mensaje indicando el resultado del pago
     */
    public String verificarPresupuesto(double precioConsulta) {
        String resultado;
        if (this.saldo >= precioConsulta) {
            this.saldo -= precioConsulta;
            resultado = "Éxito";
        } else {
            resultado = "Rechazado (Fondos insuficientes)";
        }

        return String.format(
                "El paciente %s intenta pagar $%.1f. Saldo actual: $%.1f -> Resultado: %s",
                nombre,
                precioConsulta,
                saldo + (resultado.equals("Éxito") ? precioConsulta : 0),
                resultado
        );
    }

    /**
     * Implementación del método abstracto heredado de Persona.
     * Permite aplicar polimorfismo en la clase principal.
     *
     * @return información de presentación del paciente
     */
    @Override
    public String presentarse() {
        return "[Paciente] " + nombre
                + " - EPS: " + EPS
                + " - Síntoma: " + sintoma;
    }

    /**
     * @return número de historial clínico
     */
    public String getNumeroHistorial() {
        return numeroHistorial;
    }

    /**
     * @param numeroHistorial nuevo número de historial clínico
     */
    public void setNumeroHistorial(String numeroHistorial) {
        this.numeroHistorial = numeroHistorial;
    }

    /**
     * @return EPS del paciente
     */
    public String getEPS() {
        return EPS;
    }

    /**
     * @param EPS nueva EPS
     */
    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    /**
     * @return saldo disponible
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo nuevo saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return síntoma del paciente
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * @param sintoma nuevo síntoma
     */
    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }
}