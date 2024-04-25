package hh.sof5.ohjelmistoprojekti1.domain;


import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question> findByQuery(Query query);

}
