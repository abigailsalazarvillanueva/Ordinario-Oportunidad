
package mx.utng.ultima.model.service;


/** author Guadalupe Abigail Salazar Villanueva
** grupo GDS0624
** DATE 22/abriñ/2024
**/

import java.util.List;
import jakarta.validation.Valid;
import mx.utng.ultima.model.dao.IPlanificacionviajeDao;
import mx.utng.ultima.model.entity.Planificacionviaje;


public interface IPlanificacionviajeService {
    List<Planificacionviaje> list();
    void save(@Valid IPlanificacionviajeDao planificacionviaje);
    Planificacionviaje getById(Long id);
    void delete(Long id);
    void save(@Valid Planificacionviaje planificacionviaje);
}


