package modelo;

public class Tarea {
    // Atributos
    private String titulo;
    private String descripcion;
    private String prioridad;
    private boolean completada;

    // Constructor

    public Tarea(String titulo, String descripcion, String prioridad){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false;
    }

    // Metodos

    public void marcarCompletada(){
        this.completada = true;
    }

    public void marcarPendiente(){
        this.completada = false;
    }
    @Override
    public String toString(){
        String estatus;
      if(completada){
        estatus = "[*] " + titulo + " - Prioridad: " + prioridad;
        return estatus;
      }
      else{
        estatus = "[X] " + titulo + " - Prioridad: " + prioridad;
        return estatus;
      }
    }

    // Getters
   public String getTitulo(){
    return titulo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getPrioridad(){
        return prioridad;
    }

    public boolean isCompletada(){
        return completada;
    }

    // Setters
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setPrioridad(String prioridad){
        this.prioridad = prioridad;
    }
    

}
