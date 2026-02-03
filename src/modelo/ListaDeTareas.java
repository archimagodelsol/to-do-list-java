package modelo;
import java.util.ArrayList;
public class ListaDeTareas {
    // Atributos
  private ArrayList<Tarea> tareas;
  private String nombre;

  // Constructor
  public ListaDeTareas(String nombre){
    this.tareas = new ArrayList<>();
    this.nombre = nombre;
  }

  // Metodos

  public void añadirTarea(Tarea tarea){
       tareas.add(tarea);
  }

  public Tarea obtenerTarea(int indice){
    if(indice >= 0 && indice < tareas.size()){
        tareas.get(indice);
        return tareas.get(indice);
    }
    else{
        return null;
    }
  }

  public void eliminarTarea(int posicion){
    if(posicion >= 0 && posicion < tareas.size()){
         tareas.remove(posicion);
    }
    else{
        System.out.println("La posicion no es valida");
    }
     
  }

  public void mostrarTareas(){
    System.out.println("\n====" + nombre + "===");
    if(tareas.isEmpty()){
        System.out.println("No hay tareas de momento");
    }
    else{
        for(int i = 0; i < tareas.size(); i++){
            System.out.println(i + "." + tareas.get(i));
        }
    }
  }

  public void mostrarPendientes(){
    System.out.println("\n====" + "TAREAS PENDIENTES" + "===");
            for(int i = 0; i < tareas.size(); i++){
            Tarea tarea = tareas.get(i);
            if(!tarea.isCompletada()){
               System.out.println(i + ". " + tarea);
            }
            
        }
    
  }

  // Getters
  public ArrayList<Tarea> getTareas(){
      return tareas;
  }

  public String getNombre(){
    return nombre;
  }

}
