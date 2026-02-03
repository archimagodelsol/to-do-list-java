package modelo;

public class Tarea {
    // Atributos
    private String titulo;
    private String descripcion;
    private String prioridad;
    private boolean completada;

    // Constructor

    public Tarea(String tarea, String descripcion, String prioridad){
        this.tarea = tarea;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false;
    }

    // Metodos

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

    public String getCompletada(){
        return completada;
    }

    //
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
