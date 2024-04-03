package hh.sof5.ohjelmistoprojekti1.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import hh.sof5.ohjelmistoprojekti1.domain.Query;
import hh.sof5.ohjelmistoprojekti1.domain.QueryRepository;
import hh.sof5.ohjelmistoprojekti1.domain.Question;
import hh.sof5.ohjelmistoprojekti1.domain.QuestionRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class QueryController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QueryRepository queryRepository;

    @GetMapping(value = "/queries")
        public String allQueries(Model model){

            model.addAttribute("queries", queryRepository.findAll());

            return "query"; //query.html
        }

    @GetMapping(value = "/addquery")
    public String addNewQuery(Model model) {
        model.addAttribute("query", new Query());
        // List<Question> questions = new ArrayList<>();
        // Question questions = new Question();

        return "newqueryform"; //newQueryForm.html
    }

    @PostMapping(value = "/savequery")
    public String saveQuery(@ModelAttribute Query query, @ModelAttribute Question question) {
        // question.setQuery(query);
        //query.addQuestion(question);
        queryRepository.save(query);
        // questionRepository.save(question);


        return "redirect:/queries";
    }

    @GetMapping(value = "/addquestiontoquery/{queryid}")
    public String addQuestionToQuery(@PathVariable("queryid") Long queryid, Model model) {
        model.addAttribute("kys", queryRepository.findById(queryid));
        model.addAttribute("newquestion", new Question()); 
        
        return "questionform";
    }

    @PostMapping(value = "/savequestion")
    public String saveQuestionToQuery(@ModelAttribute Question newQuestion) {

        questionRepository.save(newQuestion);

        return "redirect:/queries";
    }
    


    @GetMapping(value = "/editquery/{queryid}")
        public String editQuery(@PathVariable("queryid") Long queryid, Model model){
            Query query = queryRepository.findByqueryid(queryid);
            List <Question> questions = query.getQuestions();
            model.addAttribute("questions", questions);
            return "/editquery";
        }
    
    
}
    

