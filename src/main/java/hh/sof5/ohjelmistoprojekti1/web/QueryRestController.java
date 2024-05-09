package hh.sof5.ohjelmistoprojekti1.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof5.ohjelmistoprojekti1.domain.Query;
import hh.sof5.ohjelmistoprojekti1.domain.QueryRepository;

@CrossOrigin
@Controller
public class QueryRestController {

    @Autowired
    private QueryRepository queryRepository;

    @GetMapping(value = "/querys")
        public @ResponseBody List<Query> findAllQueries() {
            return (List<Query>) queryRepository.findAll();
        }
}
