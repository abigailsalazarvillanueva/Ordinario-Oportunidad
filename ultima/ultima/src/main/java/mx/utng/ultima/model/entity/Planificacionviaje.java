
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
public class Planificacionviaje {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // es un entero largo y grande el auto es la incrementacion 

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String destino; //cadena de texto es string  el nullanle = false significa que no puede ser null solo falso 

    @Temporal(TemporalType.DATE)
    private Date fechaPartida; // si cambia ya que date es la fecha t

    @PrePersist
    public void PrePersist(){
        fechaPartida = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaPartida() {
        return fechaPartida;
    }

    public void setFechaPartida(Date fechaPartida) {
        this.fechaPartida = fechaPartida;
    }

    

}