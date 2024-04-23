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
import mx.utng.ultima.model.entity.Planificacionviaje;







@Repository
public class PlanificacionviajeDaoImpl implements IPlanificacionviajeDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Planificacionviaje> list() {
        return em.createQuery("from Planificacionviaje").getResultList();
    }

    @Override
    public void save(Planificacionviaje planificacionviaje) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(planificacionviaje.getId() != null && planificacionviaje.getId()>0){
            em.merge(planificacionviaje);
        }else{
            //Registro nuevo al usar persist
            em.persist(planificacionviaje);
        }
    } 

    @Override
    public Planificacionviaje getById(Long id) {
        return em.find(Planificacionviaje.class, id);
    }

    @Override
    public void delete(Long id) {
      Planificacionviaje planificacionviaje = getById(id);
      em.remove(planificacionviaje);
    }
    

}



