import modelo.ListaDeTareas;
import modelo.Tarea;

public class Prueba {
   public static void main(String[] args){
        ListaDeTareas miLista = new ListaDeTareas("Mis Tareas del Día");
        
        Tarea tarea1 = new Tarea("Comprar leche", "Ir al supermercado", "Alta");
        Tarea tarea2 = new Tarea("Estudiar Java", "Repasar POO", "Media");
        Tarea tarea3 = new Tarea("Hacer ejercicio", "Correr 30 minutos", "Baja");
        Tarea tarea4 = new Tarea("Leer libro", "Terminar capítulo 5", "Media");
        
     
        miLista.añadirTarea(tarea1);
        miLista.añadirTarea(tarea2);
        miLista.añadirTarea(tarea3);
        miLista.añadirTarea(tarea4);
        
        
        System.out.println("\n--- MOSTRANDO TODAS LAS TAREAS ---");
        miLista.mostrarTareas();
        
        
        System.out.println("\n--- MARCANDO TAREAS COMO COMPLETADAS ---");
        tarea1.marcarCompletada();
        tarea3.marcarCompletada();
        System.out.println("Tareas 0 y 2 marcadas como completadas");
        
    
        System.out.println("\n--- TAREAS DESPUÉS DE MARCAR ---");
        miLista.mostrarTareas();
        
       
        System.out.println("\n--- MOSTRANDO SOLO TAREAS PENDIENTES ---");
        miLista.mostrarPendientes();
        
        
        System.out.println("\n--- OBTENIENDO TAREA EN POSICIÓN 1 ---");
        Tarea tareaObtenida = miLista.obtenerTarea(1);
        if(tareaObtenida != null) {
            System.out.println("Tarea obtenida: " + tareaObtenida);
        }
        
      
        System.out.println("\n--- ELIMINANDO TAREA EN POSICIÓN 0 ---");
        miLista.eliminarTarea(0);
        
        
        System.out.println("\n--- TAREAS DESPUÉS DE ELIMINAR ---");
        miLista.mostrarTareas();
        
      
        System.out.println("\n--- PROBANDO VALIDACIÓN ---");
        miLista.eliminarTarea(100); // Debería mostrar mensaje de error
        Tarea tareaInvalida = miLista.obtenerTarea(-5); // Debería retornar null
        System.out.println("Tarea con índice inválido: " + tareaInvalida);
   }
}
