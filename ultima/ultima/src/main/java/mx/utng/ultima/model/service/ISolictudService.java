
package mx.utng.ultima.model.service;


/** author Guadalupe Abigail Salazar Villanueva
** grupo GDS0624
** DATE 22/abriñ/2024
**/

import java.util.List;
import jakarta.validation.Valid;
import mx.utng.ultima.model.dao.ISolicitudDao;
import mx.utng.ultima.model.entity.Solicitud;


public interface ISolictudService {
    List<Solicitud> list();
    void save(@Valid ISolicitudDao solicitud);
    Solicitud getById(Long id);
    void delete(Long id);
    void save(@Valid Solicitud solicitud);
}


