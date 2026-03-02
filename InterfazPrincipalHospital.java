import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase principal que representa la interfaz gráfica
 * del sistema de Gestión Hospital San José.
 * Permite ejecutar acciones relacionadas con pacientes,
 * médicos, cirujanos y procesos administrativos.
 */
public class InterfazPrincipalHospital extends JFrame {

    private JPanel panel1;
    private JPanel panelBotones;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JTextArea textArea1;
    private JLabel Titulo;

    private List<Medico> medicos;
    private List<MedicoCirujano> cirujanos;
    private List<Paciente> pacientes;
    private AtencionGestion atencion;

    /**
     * Constructor principal.
     * Configura la ventana e inicializa
     * datos, diseño y eventos.
     */
    public InterfazPrincipalHospital() {
        setTitle("🏥 Gestión Hospital San José");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);

        inicializarDatos();
        personalizarDiseño();
        registrarEventos();
    }

    /**
     * Configura el diseño visual de la interfaz.
     */
    private void personalizarDiseño() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(5, 5));
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        Color fondo = Color.decode("#F3F8FC");
        panel1.setBackground(fondo);

        Titulo.setBackground(fondo);
        Titulo.setOpaque(true);
        panel1.add(Titulo, BorderLayout.NORTH);

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 3, 20, 30));
        panelBotones.setBorder(BorderFactory.createTitledBorder("Opciones"));
        panelBotones.setBackground(fondo);

        Dimension tamañoBoton = new Dimension(150, 80);

        JButton[] botones = {button1, button2, button3, button4, button5, button6};
        for (JButton b : botones) {
            if (b != null) {
                b.setPreferredSize(tamañoBoton);
                b.setFocusPainted(false);
                b.setFont(new Font("Segoe UI", Font.BOLD, 12));
                b.setBorderPainted(false);
                b.setContentAreaFilled(true);
                b.setBackground(fondo);
                panelBotones.add(b);
            }
        }
        panel1.add(panelBotones, BorderLayout.CENTER);

        textArea1 = new JTextArea();
        textArea1.setEditable(false);
        textArea1.setFont(new Font("Consolas", Font.PLAIN, 14));
        textArea1.setBorder(BorderFactory.createTitledBorder("Información del Sistema"));

        JScrollPane scroll = new JScrollPane(textArea1);
        scroll.setPreferredSize(new Dimension(300, 280));
        scroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 300));
        panel1.add(scroll, BorderLayout.SOUTH);

        setContentPane(panel1);
    }

    /**
     * Inicializa los datos de pacientes,
     * médicos y cirujanos.
     */
    private void inicializarDatos() {

        Paciente p1 = new Paciente("Juan Gómez", "1001", 35, "M", "H001", "Sanitas", 200.0, "Infarto");
        Paciente p2 = new Paciente("Lucía Lara", "1002", 28, "F", "H002", "Sura", 30.0, "Fiebre");
        Paciente p3 = new Paciente("Pedro Ruiz", "1003", 45, "M", "H003", "Nueva EPS", 150.0, "Dolor");
        Paciente p4 = new Paciente("María Torres", "1004", 52, "F", "H004", "Compensar", 80.0, "Infarto");
        Paciente p5 = new Paciente("Carlos Vega", "1005", 67, "M", "H005", "Sanitas", 300.0, "Fiebre");
        Paciente p6 = new Paciente("Ana Suárez", "1006", 19, "F", "H006", "Sura", 10.0, "Dolor");
        Paciente p7 = new Paciente("Luis Herrera", "1007", 41, "M", "H007", "Nueva EPS", 95.0, "Infarto");
        Paciente p8 = new Paciente("Sara Méndez", "1008", 33, "F", "H008", "Compensar", 175.0, "Fiebre");
        Paciente p9 = new Paciente("Tomás Ríos", "1009", 58, "M", "H009", "Sanitas", 60.0, "Dolor");
        Paciente p10 = new Paciente("Elena Pardo", "1010", 24, "F", "H010", "Sura", 120.0, "Infarto");
        Paciente p11 = new Paciente("Diego Núñez", "1011", 37, "M", "H011", "Nueva EPS", 45.0, "Fiebre");
        Paciente p12 = new Paciente("Carmen Flores", "1012", 61, "F", "H012", "Compensar", 85.0, "Dolor");

        pacientes = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);

        medicos = new ArrayList<>();
        medicos.add(new Medico("Carlos Pérez", "CC101", 45, "M", "Cardiología", "REG-001", Arrays.asList(p1, p2, p3)));
        medicos.add(new Medico("Ana Ríos", "CC102", 38, "F", "Pediatría", "REG-002", Arrays.asList(p4, p5, p6)));
        medicos.add(new Medico("Luis Mora", "CC103", 52, "M", "Medicina General", "REG-003", Arrays.asList(p7, p8, p9)));
        medicos.add(new Medico("Elena Sanz", "CC104", 41, "F", "Ginecología", "REG-004", Arrays.asList(p10, p11, p12)));

        cirujanos = new ArrayList<>();
        cirujanos.add(new MedicoCirujano("Marta Casas", "CC201", 47, "F", "Neurocirugía", "REG-005", Arrays.asList(p1, p3), "5", true));
        cirujanos.add(new MedicoCirujano("Jorge Valdés", "CC202", 55, "M", "Traumatología", "REG-006", Arrays.asList(p4, p7), "3", false));
        cirujanos.add(new MedicoCirujano("Sofía Ruiz", "CC203", 39, "F", "Cirugía Plástica", "REG-007", Arrays.asList(p2, p8), "7", true));
        cirujanos.add(new MedicoCirujano("Andrés Gil", "CC204", 50, "M", "Cirugía Cardiovascular", "REG-008", Arrays.asList(p5, p9), "2", false));

        atencion = new AtencionGestion();
    }

    /**
     * Registra los eventos de los botones.
     */
    private void registrarEventos() {
        button1.addActionListener(e -> new InterfazPacientes(pacientes).setVisible(true));
        button2.addActionListener(e -> mostrarMedicos());
        button3.addActionListener(e -> evaluarSintomas());
        button4.addActionListener(e -> verificarPago());
        button5.addActionListener(e -> operarCirujano());
        button6.addActionListener(e -> procesarIngreso());
    }

    /**
     * Muestra la información de médicos y cirujanos.
     */
    private void mostrarMedicos() {
        textArea1.setText("===== MÉDICOS =====\n\n");
        for (Medico m : medicos) textArea1.append(m.presentarse() + "\n\n");
        textArea1.append("===== CIRUJANOS =====\n\n");
        for (MedicoCirujano mc : cirujanos) textArea1.append(mc.presentarse() + "\n\n");
    }

    /**
     * Evalúa la prioridad de los pacientes según su síntoma.
     */
    private void evaluarSintomas() {
        textArea1.setText("===== EVALUACIÓN =====\n\n");
        for (Medico dr : medicos) {
            textArea1.append("Doctor: " + dr.getNombre() + "\n");
            for (Paciente p : dr.getListaPacientes()) {
                int prioridad = switch (p.getSintoma()) {
                    case "Infarto" -> 1;
                    case "Fiebre" -> 2;
                    case "Dolor" -> 3;
                    default -> 4;
                };
                textArea1.append("Paciente: " + p.getNombre() +
                        " | Sintoma: " + p.getSintoma() +
                        " | Prioridad: " + prioridad + "\n");
            }
            textArea1.append("---------------------------------\n");
        }
    }

    /**
     * Verifica el presupuesto de los pacientes.
     */
    private void verificarPago() {
        textArea1.setText("===== PAGOS =====\n\n");
        for (Paciente p : pacientes)
            textArea1.append(p.verificarPresupuesto(50.0) + "\n");
    }

    /**
     * Verifica disponibilidad de quirófano y muestra el estado.
     */
    private void operarCirujano() {
        textArea1.setText("===== CIRUGÍAS =====\n\n");
        for (MedicoCirujano mc : cirujanos) {
            if (mc.isQuirofanoDisponible()) {
                textArea1.append(mc.getNombre() + " operando en quirófano " + mc.getNumQuirofano() + "\n");
            } else {
                textArea1.append("Quirófano " + mc.getNumQuirofano() +
                        " ocupado — " + mc.getNombre() + " en espera\n");
            }
        }
    }

    /**
     * Procesa el ingreso hospitalario de los pacientes.
     */
    private void procesarIngreso() {
        textArea1.setText("===== INGRESOS =====\n\n");
        for (Paciente p : pacientes)
            textArea1.append(atencion.procesarIngreso(p) + "\n");
    }
}