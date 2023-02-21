package platform.persistencelayer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.businesslayer.Code;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface CodeRepository extends CrudRepository<Code, Integer>{

    //fin code by id using CRUD
    Code findCodeById(Integer id);

    //find last 10 by order desc using crud
    List<Code> findFirst10ByOrderByIdDesc();

    //find last entry from database using last entity record
    Code findTopByOrderByIdDesc();

}
