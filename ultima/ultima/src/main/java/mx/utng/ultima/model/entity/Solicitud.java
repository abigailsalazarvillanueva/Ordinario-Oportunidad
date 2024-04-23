
package mx.utng.ultima.model.entity;


/* 
**@author Guadalupe Abigail Salazar Villanueva
**@grupo GDS0624
**@DATE 22/abril/2024
*/

import java.lang.String;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Solicitud {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // es un entero largo y grande el auto es la incrementacion 

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String empleado; //cadena de texto es string  el nullanle = false significa que no puede ser null solo falso 

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String fechas;

    @PostPersist
    public void PrePersist(){
        fechas = new String();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    } 

    
    
}

    