import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Ventana secundaria que muestra la lista completa
 * de pacientes registrados en el hospital.
 * <p>
 * Se abre desde la interfaz principal y presenta
 * la información en una tabla no editable.
 */
public class InterfazPacientes extends JFrame {

    private JPanel panel1;
    private JTextField textField1;

    /**
     * Constructor que recibe la lista de pacientes
     * y construye la tabla con su información.
     *
     * @param pacientes lista de pacientes del hospital
     */
    public InterfazPacientes(List<Paciente> pacientes) {
        setTitle("📋 Pacientes - Hospital San José");
        setSize(820, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel1 = new JPanel(new BorderLayout(10, 10));
        panel1.setBackground(new Color(15, 23, 42));
        panel1.setBorder(new EmptyBorder(12, 12, 12, 12));

        JLabel titulo = new JLabel("Lista de Pacientes Registrados", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setForeground(new Color(96, 165, 250));
        titulo.setBorder(new EmptyBorder(0, 0, 10, 0));
        panel1.add(titulo, BorderLayout.NORTH);

        String[] columnas = {"#", "Nombre", "DNI", "Edad", "Género",
                "Historial", "EPS", "Saldo ($)", "Síntoma"};

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {

            /**
             * Indica que las celdas no son editables.
             *
             * @param r fila
             * @param c columna
             * @return false siempre
             */
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        int i = 1;
        for (Paciente p : pacientes) {
            modelo.addRow(new Object[]{
                    i++,
                    p.getNombre(),
                    p.getDNI(),
                    p.getEdad(),
                    p.getGenero(),
                    p.getNumeroHistorial(),
                    p.getEPS(),
                    String.format("%.2f", p.getSaldo()),
                    p.getSintoma()
            });
        }

        JTable tabla = new JTable(modelo);
        tabla.setBackground(new Color(30, 41, 59));
        tabla.setForeground(new Color(226, 232, 240));
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabla.setRowHeight(26);
        tabla.setShowGrid(false);
        tabla.setIntercellSpacing(new Dimension(0, 0));

        tabla.getTableHeader().setBackground(new Color(37, 99, 235));
        tabla.getTableHeader().setForeground(Color.WHITE);
        tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));

        /**
         * Renderizador personalizado que cambia el color
         * del texto según el síntoma del paciente.
         */
        tabla.getColumnModel().getColumn(8)
                .setCellRenderer(new DefaultTableCellRenderer() {

                    @Override
                    public Component getTableCellRendererComponent(
                            JTable t, Object val,
                            boolean sel, boolean focus,
                            int row, int col) {

                        super.getTableCellRendererComponent(
                                t, val, sel, focus, row, col);

                        String sintoma = val.toString();

                        if (sintoma.equals("Infarto")) {
                            setForeground(new Color(248, 113, 113));
                        } else if (sintoma.equals("Fiebre")) {
                            setForeground(new Color(251, 191, 36));
                        } else if (sintoma.equals("Dolor")) {
                            setForeground(new Color(167, 139, 250));
                        } else {
                            setForeground(new Color(226, 232, 240));
                        }

                        setBackground(sel
                                ? new Color(51, 65, 85)
                                : new Color(30, 41, 59));

                        return this;
                    }
                });

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(51, 65, 85)));
        scroll.getViewport().setBackground(new Color(30, 41, 59));
        panel1.add(scroll, BorderLayout.CENTER);

        JLabel lbl = new JLabel(
                "Total: " + pacientes.size() + " pacientes registrados",
                SwingConstants.RIGHT);

        lbl.setForeground(new Color(148, 163, 184));
        lbl.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        panel1.add(lbl, BorderLayout.SOUTH);

        setContentPane(panel1);
    }
}