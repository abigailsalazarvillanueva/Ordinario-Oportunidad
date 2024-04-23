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
public class Compra {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // es un entero largo y grande el auto es la incrementacion 

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String producto; //cadena de texto es string  el nullanle = false significa que no puede ser null solo falso 

    @Column (length = 100, nullable = false)
    @NotEmpty
    private String cantidad;

    @Column (length = 100, nullable = false) // trabajar 
    @NotEmpty
    private String total;

    @Temporal(TemporalType.DATE)
    private Date fechaCompra; // si cambia ya que date es la fecha t

    @PrePersist
    public void PrePersist(){
        fechaCompra = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }


    //GETTERS Y SETTERS   // get es para obtener set es para poner el dato
    
}


