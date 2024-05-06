package hh.sof5.ohjelmistoprojekti1.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;


public interface ChoiceRepository extends CrudRepository<Choice, Long> {

    List<Choice> findAllByQuestion(Optional<Question> optional);
}
