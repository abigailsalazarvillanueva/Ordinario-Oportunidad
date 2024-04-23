package mx.utng.ultima.model.service;

/** author Guadalupe Abigail Salazar Villanueva
** grupo GDS0624
** DATE 19/marzo/2024
**/

import java.util.List;
import jakarta.validation.Valid;
import mx.utng.ultima.model.dao.ICompraDao;
import mx.utng.ultima.model.entity.Compra;




public interface ICompraService {
    List<Compra> list();
    void save(@Valid ICompraDao compra);
    Compra getById(Long id);
    void delete(Long id);
    void save(@Valid Compra compra);
}


