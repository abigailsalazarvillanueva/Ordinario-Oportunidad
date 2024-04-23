
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
import mx.utng.ultima.model.dao.ISolicitudDao;
import mx.utng.ultima.model.entity.Solicitud;





/* 
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class SolicitudServiceImpl implements ISolictudService{ //public class es para que otras clases accedan a otras 

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private ISolicitudDao solicitudDao;

    @Transactional(readOnly = true)
    @Override
    public List<Solicitud> list() {
        return solicitudDao.list();
    }

    @Transactional
    @Override
    public void save(Solicitud solicitud) {
        solicitudDao.save(solicitud);
    }

    @Transactional(readOnly = true)
    @Override
    public Solicitud getById(Long id) {
        return solicitudDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        solicitudDao.delete(id);
    }

    @Override
    public void save(@Valid ISolicitudDao solicitud) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }



   /*  @Override
    public void save(Subject subject) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
     */
}







