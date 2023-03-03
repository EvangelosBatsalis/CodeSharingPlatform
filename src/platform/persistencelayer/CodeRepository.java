package platform.persistencelayer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import platform.businesslayer.Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CodeRepository extends CrudRepository<Code, Integer> {

    //fin code by id using CRUD
    Code findCodeById(Integer id);

    //find last 10 by order desc using crud
    List<Code> findFirst10ByOrderByIdDesc();

    //find last entry from database using last entity record
    Code findTopByOrderByIdDesc();

    Optional<Code> findByCodeUUID(String aaa);

    //No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call; nested exception is javax.persistence.TransactionRequiredException: No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call] with root cause
    //because of that error checking the spring documentation it looks like by default the PersistenceContext is of type Transaction
    //so I annotated with @Transactional
    @Transactional
    void deleteByCodeUUID(String uuid);

    List<Code> findFirst10ByRestrictionByDateIsAccessibleIsTrueAndRestrictionByViewsIsAccessibleIsTrueOrderByLocalDateTimeDesc();

    List<Code> findFirst10ByRemainingTimeLessThanAndRemainingViewsLessThan(int remainingViews, int remainingTime);
//    @Deprecated(since = "version 1", forRemoval = true)
//    @Query(value = "select id,name,roll_no from USER_INFO_TEST where rollNo = ?1", nativeQuery = true)
//    ArrayList<Code> findUserUsingId(long id);

    @Query(value = "SELECT * FROM CODES WHERE REMAINING_TIME = 0 AND REMAINING_VIEWS = 0 ORDER BY DATE DESC LIMIT 10", nativeQuery = true)
    ArrayList<Code> findLastTenByQuery();
}
