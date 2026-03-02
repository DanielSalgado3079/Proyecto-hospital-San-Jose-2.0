import javax.swing.*;

/**
 * Clase principal del sistema de gestión del Hospital San José.
 * Lanza la interfaz gráfica en el hilo de eventos de Swing (EDT).
 *
 * @author Yulieth Paola Domínguez López
 * @version 6
 */
public class GestionHospital {

    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazPrincipalHospital frame =
                    new InterfazPrincipalHospital();
            frame.setVisible(true);
        });
    }
}