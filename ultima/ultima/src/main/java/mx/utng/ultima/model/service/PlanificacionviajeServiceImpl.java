

  
package mx.utng.ultima.model.service;

    /** 
 * @author Guadalupe Abigail Salazar Villanueva
 * @grupo GDS0624
 * @DATE 22/abril/2024
*/


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import mx.utng.ultima.model.dao.IPlanificacionviajeDao;
import mx.utng.ultima.model.entity.Planificacionviaje;



/* 
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class PlanificacionviajeServiceImpl implements IPlanificacionviajeService{ //public class es para que otras clases accedan a otras 

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IPlanificacionviajeDao planificacionviajeDao;

    @Transactional(readOnly = true)
    @Override
    public List<Planificacionviaje> list() {
        return planificacionviajeDao.list();
    }

    @Transactional
    @Override
    public void save(Planificacionviaje planificacionviaje) {
        planificacionviajeDao.save(planificacionviaje);
    }

    @Transactional(readOnly = true)
    @Override
    public Planificacionviaje getById(Long id) {
        return planificacionviajeDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        planificacionviajeDao.delete(id);
    }

    @Override
    public void save(@Valid IPlanificacionviajeDao planificacionviaje) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }



   /*  @Override
    public void save(Subject subject) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
     */
}







