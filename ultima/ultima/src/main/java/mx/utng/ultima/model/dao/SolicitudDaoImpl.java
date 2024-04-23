package mx.utng.ultima.model.dao;

    /** 
 * @author Guadalupe Abigail Salazar Villanueva
 * @grupo GDS0624
 * @DATE 22/abril/2024
*/

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Solicitud;








@Repository
public class SolicitudDaoImpl implements ISolicitudDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Solicitud> list() {
        return em.createQuery("from Planificacionviaje").getResultList();
    }

    @Override
    public void save(Solicitud solicitud) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(solicitud.getId() != null && solicitud.getId()>0){
            em.merge(solicitud);
        }else{
            //Registro nuevo al usar persist
            em.persist(solicitud);
        }
    } 

    @Override
    public Solicitud getById(Long id) {
        return em.find(Solicitud.class, id);
    }

    @Override
    public void delete(Long id) {
      Solicitud solicitud = getById(id);
      em.remove(solicitud);
    }
    

}



