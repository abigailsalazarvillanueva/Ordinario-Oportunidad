package mx.utng.ultima.model.entity;


/* 
**@author Guadalupe Abigail Salazar Villanueva
**@grupo GDS0624
**@DATE 22/abril/2024
*/

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Grupoestudio {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // es un entero largo y grande el auto es la incrementacion 

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String nombreGrupo; //cadena de texto es string  el nullanle = false significa que no puede ser null solo falso 

    @Column (length = 100, nullable = false)
    @NotEmpty
    private String integrantes;

    
    @Temporal(TemporalType.DATE)
    private Date fecha; // si cambia ya que date es la fecha t

    @PrePersist
    public void PrePersist(){
        fecha = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(String integrantes) {
        this.integrantes = integrantes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




    
}