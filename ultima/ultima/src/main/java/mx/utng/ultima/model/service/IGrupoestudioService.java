package mx.utng.ultima.model.service;


/** author Guadalupe Abigail Salazar Villanueva
** grupo GDS0624
** DATE 22/abriñ/2024
**/

import java.util.List;
import jakarta.validation.Valid;
import mx.utng.ultima.model.dao.IGrupoestudioDao;
import mx.utng.ultima.model.entity.Grupoestudio;


public interface IGrupoestudioService {
    List<Grupoestudio> list();
    void save(@Valid IGrupoestudioDao grupoestudio);
    Grupoestudio getById(Long id);
    void delete(Long id);
    void save(@Valid Grupoestudio grupoestudio);
}


