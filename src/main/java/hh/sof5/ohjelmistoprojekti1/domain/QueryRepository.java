package hh.sof5.ohjelmistoprojekti1.domain;

import org.springframework.data.repository.CrudRepository;

public interface QueryRepository extends CrudRepository<Query, Long> {

    Query findByName(String name);
    Query findByqueryid(Long queryid);

}
