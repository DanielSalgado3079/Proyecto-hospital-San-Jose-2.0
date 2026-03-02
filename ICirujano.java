/**
 * Interfaz que define el comportamiento de un médico cirujano.
 * <p>
 * Toda clase que implemente esta interfaz debe proporcionar
 * la lógica para verificar el estado del quirófano y tomar
 * una decisión respecto a la realización de una operación.
 */
public interface ICirujano {

    /**
     * Verifica el estado de disponibilidad del quirófano.
     *
     * @param disponible estado actual del quirófano
     * @return true si el quirófano está disponible, false si está ocupado
     */
    boolean verificarQuirofano(boolean disponible);

    /**
     * Toma la decisión de realizar o no una operación
     * según la disponibilidad del quirófano.
     */
    void tomarDecision();
}