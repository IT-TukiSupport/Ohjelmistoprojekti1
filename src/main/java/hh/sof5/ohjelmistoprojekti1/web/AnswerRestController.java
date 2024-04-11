package hh.sof5.ohjelmistoprojekti1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof5.ohjelmistoprojekti1.domain.Answer;
import hh.sof5.ohjelmistoprojekti1.domain.AnswerRepository;

public class AnswerRestController {

    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping(value = "/saveAnswer")
    public @ResponseBody Answer saveAnswer(@RequestBody Answer answer) {
        return answerRepository.save(answer);
    }

}
