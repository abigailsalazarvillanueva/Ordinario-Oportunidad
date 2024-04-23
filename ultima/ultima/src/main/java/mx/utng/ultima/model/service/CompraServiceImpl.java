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
import mx.utng.ultima.model.dao.ICompraDao;
import mx.utng.ultima.model.entity.Compra;



/* 
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class CompraServiceImpl implements ICompraService{ //public class es para que otras clases accedan a otras 

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private ICompraDao compraDao;

    @Transactional(readOnly = true)
    @Override
    public List<Compra> list() {
        return compraDao.list();
    }

    @Transactional
    @Override
    public void save(Compra compra) {
        compraDao.save(compra);
    }

    @Transactional(readOnly = true)
    @Override
    public Compra getById(Long id) {
        return compraDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        compraDao.delete(id);
    }

    @Override
    public void save(@Valid ICompraDao compra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

   /*  @Override
    public void save(Subject subject) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
     */
}






