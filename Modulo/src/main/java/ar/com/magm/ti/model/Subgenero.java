package ar.com.magm.ti.model;
// Generated 08/11/2017 23:33:49 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Subgenero generated by hbm2java
 */
public class Subgenero  implements java.io.Serializable {


     private Integer idSubgenero;
     private Genero genero;
     private String nombre;
     private Set cancions = new HashSet(0);

    public Subgenero() {
    }

    public Subgenero(Genero genero, String nombre, Set cancions) {
       this.genero = genero;
       this.nombre = nombre;
       this.cancions = cancions;
    }
   
    public Integer getIdSubgenero() {
        return this.idSubgenero;
    }
    
    public void setIdSubgenero(Integer idSubgenero) {
        this.idSubgenero = idSubgenero;
    }
    public Genero getGenero() {
        return this.genero;
    }
    
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getCancions() {
        return this.cancions;
    }
    
    public void setCancions(Set cancions) {
        this.cancions = cancions;
    }




}


