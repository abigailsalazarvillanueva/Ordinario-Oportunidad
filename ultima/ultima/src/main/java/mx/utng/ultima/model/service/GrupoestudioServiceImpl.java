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

import mx.utng.ultima.model.dao.IGrupoestudioDao;
import mx.utng.ultima.model.entity.Grupoestudio;





/* 
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class GrupoestudioServiceImpl implements IGrupoestudioService{ //public class es para que otras clases accedan a otras 

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IGrupoestudioDao grupoestudioDao;

    @Transactional(readOnly = true)
    @Override
    public List<Grupoestudio> list() {
        return grupoestudioDao.list();
    }

    @Transactional
    @Override
    public void save(Grupoestudio grupoestudio) {
        grupoestudioDao.save(grupoestudio);
    }

    @Transactional(readOnly = true)
    @Override
    public Grupoestudio getById(Long id) {
        return grupoestudioDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        grupoestudioDao.delete(id);
    }

    @Override
    public void save(@Valid IGrupoestudioDao grupoestudio) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }



   /*  @Override
    public void save(Subject subject) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
     */
}






