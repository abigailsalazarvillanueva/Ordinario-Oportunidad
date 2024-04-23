package mx.utng.ultima.model.dao;


    /** 
 * @author Guadalupe Abigail Salazar Villanueva
 * @grupo GDS0624
 * @DATE 22/abril/2024
*/

import java.util.List;

import mx.utng.ultima.model.entity.Grupoestudio;


public interface IGrupoestudioDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Grupoestudio> list();

    //Guardar un estudiante
    void save(Grupoestudio grupoestudio);

    //Obterner un estudiante en especifico a partir del id
    Grupoestudio getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}








