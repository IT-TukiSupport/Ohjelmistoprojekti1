package hh.sof5.ohjelmistoprojekti1.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof5.ohjelmistoprojekti1.domain.Choice;
import hh.sof5.ohjelmistoprojekti1.domain.ChoiceRepository;
import hh.sof5.ohjelmistoprojekti1.domain.Query;
import hh.sof5.ohjelmistoprojekti1.domain.QueryRepository;
import hh.sof5.ohjelmistoprojekti1.domain.Question;
import hh.sof5.ohjelmistoprojekti1.domain.QuestionRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QueryRepository queryRepository;

    @Autowired 
    private ChoiceRepository choiceRepository;

    @GetMapping(value = "/addquestiontoquery/{queryid}")
    public String addQuestion(@PathVariable("queryid") Long queryid, Model model) {

        Long id = queryid;

        model.addAttribute("queryid", id);
        model.addAttribute("newquestion", new Question()); 
        
        return "questionform";
    }

    @PostMapping(value = "/savequestion")
    public String saveQuestionToQuery(@ModelAttribute Question newQuestion, Long queryid) {

        newQuestion.setQuestionType(Question.QuestionType.TEXT);
        Query query = queryRepository.findById(queryid).orElse(null);
        newQuestion.setQuery(query);
        questionRepository.save(newQuestion);

        return "redirect:/showquery/" + queryid;
    }

    @GetMapping(value = "/addmultiplechoicetoquery/{queryid}")
    public String addMultipleChoiceQuestion(@PathVariable("queryid") Long queryid, Model model) {
        
        model.addAttribute("queryid", queryid);
        model.addAttribute("newquestion", new Question());
        model.addAttribute("choice", new Choice());

        return "multiplechoiceform";
    }

    @GetMapping(value = "/setchoice")
    public String setChoice(@ModelAttribute Question newQuestion, Choice choice, Long queryid, Model model){

        newQuestion.addChoice(choice);

        model.addAttribute("queryid", queryid);
        model.addAttribute("newquestion", newQuestion);
        model.addAttribute("choice", new Choice());

        return "multiplechoiceform";
    }
    

    @PostMapping(value = "/savemultiplechoicequestion")
    public String saveMultiChoiceQuestionToQuery(@ModelAttribute Question newQuestion, Long queryid){

        newQuestion.setQuestionType(Question.QuestionType.CHOICE);
        List<Choice> nullchoices = new ArrayList<>();
        
        newQuestion.setChoices(nullchoices);

        Query query = queryRepository.findById(queryid).orElse(null);
        newQuestion.setQuery(query);

        questionRepository.save(newQuestion);

        return "redirect:/showquery/" + queryid;
    }
    
    @GetMapping(value = "/showquestionchoices/{questionid}")
    public String showQuestionsChoices(@PathVariable("questionid") Long questionid, Model model){

        model.addAttribute("question", questionRepository.findById(questionid));
        model.addAttribute("choices", choiceRepository.findAllByQuestion(questionRepository.findById(questionid)));
        model.addAttribute("newChoice", new Choice());
        
        return "showchoices";
    }

    @PostMapping(value = "/savechoice")
    public String saveChoice(@ModelAttribute Choice newChoice, Long questionid) {

        Question question = questionRepository.findById(questionid).orElse(null);

        question.addChoice(newChoice);
        newChoice.setQuestion(questionRepository.findById(questionid).orElse(null));
        questionRepository.save(question);

        return "redirect:/showquestionchoices/" + questionid;
    }
    
    

}
