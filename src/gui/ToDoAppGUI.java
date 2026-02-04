package gui;
import javax.swing.*;
import modelo.*;
import java.awt.*;
public class ToDoAppGUI extends JFrame {
   // Atributos de la interfaz

    private JTextField campoTitulo;
    private JTextField campoDescripcion;
    private JComboBox<String> comboPrioridad;
    private JButton btnAgregar;
    private JButton btnMarcarCompletada;
    private JButton btnEliminar;
    private JButton btnMostrarPendientes;
    private JButton btnMostrarTodas;
    private JList<String> listaTareas;
    private DefaultListModel<String> modeloLista;

    private ListaDeTareas miLista;

    public ToDoAppGUI(){
        // Ventana
        setTitle("Gestor de Tareas");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
         
        // Inicializacion
       miLista = new ListaDeTareas("Mis Tareas");
       modeloLista = new DefaultListModel<>();
      
       // Panel superior - Formulario para agregar tareas
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(4, 2, 5, 5));

// Crear componentes del formulario
          JLabel lblTitulo = new JLabel("Título:");
         campoTitulo = new JTextField();

JLabel lblDescripcion = new JLabel("Descripción:");
campoDescripcion = new JTextField();

JLabel lblPrioridad = new JLabel("Prioridad:");
String[] prioridades = {"Alta", "Media", "Baja"};
comboPrioridad = new JComboBox<>(prioridades);

btnAgregar = new JButton("Agregar Tarea");

// Agregar componentes al panel
panelSuperior.add(lblTitulo);
panelSuperior.add(campoTitulo);
panelSuperior.add(lblDescripcion);
panelSuperior.add(campoDescripcion);
panelSuperior.add(lblPrioridad);
panelSuperior.add(comboPrioridad);
panelSuperior.add(new JLabel("")); // Espacio vacío
panelSuperior.add(btnAgregar);

  listaTareas = new JList<>(modeloLista);
  listaTareas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  JScrollPane scrollPane = new JScrollPane(listaTareas);

      // Panel inferior - Botones de acción
JPanel panelInferior = new JPanel();
panelInferior.setLayout(new FlowLayout());

btnMarcarCompletada = new JButton("Marcar Completada");
btnEliminar = new JButton("Eliminar");
btnMostrarPendientes = new JButton("Ver Pendientes");
btnMostrarTodas = new JButton("Ver Todas");

panelInferior.add(btnMarcarCompletada);
panelInferior.add(btnEliminar);
panelInferior.add(btnMostrarPendientes);
panelInferior.add(btnMostrarTodas);
 
add(panelSuperior, BorderLayout.NORTH);
add(scrollPane, BorderLayout.CENTER);
add(panelInferior, BorderLayout.SOUTH);

btnAgregar.addActionListener(e -> agregarTarea());
btnMarcarCompletada.addActionListener(e -> marcarCompletada());
btnEliminar.addActionListener(e -> eliminarTarea());
btnMostrarPendientes.addActionListener(e -> mostrarPendientes());
btnMostrarTodas.addActionListener(e -> actualizarVista());

setVisible(true);


    }

    // Método para agregar una tarea
private void agregarTarea() {
    String titulo = campoTitulo.getText();
    String descripcion = campoDescripcion.getText();
    String prioridad = (String) comboPrioridad.getSelectedItem();
    
    if(titulo.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El título no puede estar vacío");
        return;
    }
    
    Tarea nuevaTarea = new Tarea(titulo, descripcion, prioridad);
    miLista.añadirTarea(nuevaTarea);
    
    // Limpiar campos
    campoTitulo.setText("");
    campoDescripcion.setText("");
    
    actualizarVista();
}

// Método para actualizar la vista
private void actualizarVista() {
    modeloLista.clear();
    for(int i = 0; i < miLista.getTareas().size(); i++) {
        Tarea tarea = miLista.getTareas().get(i);
        modeloLista.addElement(i + ". " + tarea.toString());
    }
}

private void marcarCompletada() {
    int indiceSeleccionado = listaTareas.getSelectedIndex();
    
    if(indiceSeleccionado == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona una tarea primero");
        return;
    }
    
    Tarea tarea = miLista.obtenerTarea(indiceSeleccionado);
    if(tarea != null) {
        tarea.marcarCompletada();
        actualizarVista();
    }
}

private void eliminarTarea() {
    int indiceSeleccionado = listaTareas.getSelectedIndex();
    
    if(indiceSeleccionado == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona una tarea primero");
        return;
    }
    
    miLista.eliminarTarea(indiceSeleccionado);
    actualizarVista();
}

private void mostrarPendientes() {
    modeloLista.clear();
    int contador = 0;
    for(int i = 0; i < miLista.getTareas().size(); i++) {
        Tarea tarea = miLista.getTareas().get(i);
        if(!tarea.isCompletada()) {
            modeloLista.addElement(i + ". " + tarea.toString());
            contador++;
        }
    }
    
    if(contador == 0) {
        JOptionPane.showMessageDialog(this, "No hay tareas pendientes");
    }
}
   
}
