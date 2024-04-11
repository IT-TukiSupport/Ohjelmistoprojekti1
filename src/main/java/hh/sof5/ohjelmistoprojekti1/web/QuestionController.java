package hh.sof5.ohjelmistoprojekti1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof5.ohjelmistoprojekti1.domain.Query;
import hh.sof5.ohjelmistoprojekti1.domain.QueryRepository;
import hh.sof5.ohjelmistoprojekti1.domain.Question;
import hh.sof5.ohjelmistoprojekti1.domain.QuestionRepository;

@Controller
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QueryRepository queryRepository;

    @GetMapping(value = "/addquestiontoquery/{queryid}")
    public String addQuestion(@PathVariable("queryid") Long queryid, Model model) {

        Long id = queryid;

        model.addAttribute("queryid", id);
        model.addAttribute("newquestion", new Question()); 
        
        return "questionform";
    }

    @PostMapping(value = "/savequestion")
    public String saveQuestionToQuery(@ModelAttribute Question newQuestion, Long queryid) {

        Query query = queryRepository.findById(queryid).orElse(null);
        newQuestion.setQuery(query);
        questionRepository.save(newQuestion);

        return "redirect:/showquery/" + queryid;
    }

}
