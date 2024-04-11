package hh.sof5.ohjelmistoprojekti1.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof5.ohjelmistoprojekti1.domain.Answer;
import hh.sof5.ohjelmistoprojekti1.domain.AnswerRepository;

@CrossOrigin
@Controller
public class AnswerRestController {

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping(value= "/saveanswer")
    public @ResponseBody List<Answer> getAnswers() {
        return (List<Answer>)answerRepository.findAll();
    }

    @PostMapping(value = "/saveanswer")
    public @ResponseBody Answer saveAnswer(@RequestBody Answer answer) {
        return answerRepository.save(answer);
    }

}
