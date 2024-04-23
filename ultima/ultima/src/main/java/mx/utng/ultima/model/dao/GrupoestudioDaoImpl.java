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
import mx.utng.ultima.model.entity.Grupoestudio;






@Repository
public class GrupoestudioDaoImpl implements IGrupoestudioDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Grupoestudio> list() {
        return em.createQuery("from Grupoestudio").getResultList();
    }

    @Override
    public void save(Grupoestudio grupoestudio) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(grupoestudio.getId() != null && grupoestudio.getId()>0){
            em.merge(grupoestudio);
        }else{
            //Registro nuevo al usar persist
            em.persist(grupoestudio);
        }
    } 

    @Override
    public Grupoestudio getById(Long id) {
        return em.find(Grupoestudio.class, id);
    }

    @Override
    public void delete(Long id) {
      Grupoestudio grupoestudio = getById(id);
      em.remove(grupoestudio);
    }
    

}



