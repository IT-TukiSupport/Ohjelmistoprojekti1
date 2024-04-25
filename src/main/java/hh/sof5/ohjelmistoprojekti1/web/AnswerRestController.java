package hh.sof5.ohjelmistoprojekti1.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof5.ohjelmistoprojekti1.domain.Answer;
import hh.sof5.ohjelmistoprojekti1.domain.AnswerRepository;
import hh.sof5.ohjelmistoprojekti1.domain.QueryRepository;
import hh.sof5.ohjelmistoprojekti1.domain.Question;
import hh.sof5.ohjelmistoprojekti1.domain.QuestionRepository;

import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@Controller
public class AnswerRestController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QueryRepository queryRepository;

    @GetMapping(value = "/answers")
    public @ResponseBody List<Answer> getAnswers() {
        return (List<Answer>) answerRepository.findAll();
    }

    @PostMapping(value = "/answers")
    public @ResponseBody List<Answer> saveAnswer(@RequestBody List<Answer> answers) {
        return (List<Answer>) answerRepository.saveAll(answers);
    }

    @GetMapping(value = "/answers/{id}")
    public @ResponseBody List<Answer> getAnswersByQueryId(@PathVariable ("id") Long id) {

        List<Question> questions = (List<Question>) questionRepository.findByQuery(queryRepository.findByqueryid(id));

        List<Answer> answers = (List<Answer>) answerRepository.findAll();
        List<Answer> correctAnswers = new ArrayList<>();

        for (Answer answer : answers) { //Pitää päivittää
            for (Question question : questions) {
                if (answer.getQuestion().getQuestionid() == question.getQuestionid()) {
                    correctAnswers.add(answer);
                }
            }
        }
        return correctAnswers;
    } 
    
}
