package hh.sof5.ohjelmistoprojekti1.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import hh.sof5.ohjelmistoprojekti1.domain.Query;
import hh.sof5.ohjelmistoprojekti1.domain.QueryRepository;
import hh.sof5.ohjelmistoprojekti1.domain.Question;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class QueryController {

    @Autowired
    private QueryRepository queryRepository;

    @GetMapping(value = "/")
        public String allQueries(Model model){

            model.addAttribute("queries", queryRepository.findAll());

            return "querylist"; //querylist.html
        }

    @GetMapping(value = "/addquery")
    public String addNewQuery(Model model) {
        model.addAttribute("query", new Query());
        return "newqueryform"; //newQueryForm.html
    }

    @PostMapping(value = "/savequery")
    public String saveQuery(@ModelAttribute Query query, @ModelAttribute Question question) {
        queryRepository.save(query);


        return "redirect:/queries";
    }
    
    @GetMapping(value = "/editquery/{queryid}")
        public String editQuery(@PathVariable("queryid") Long queryid, Model model){
            Query query = queryRepository.findByqueryid(queryid);
            List <Question> questions = query.getQuestions();
            model.addAttribute("questions", questions);
            return "/editquery";
        }

    @GetMapping(value ="/showquery/{queryid}")
        public String showQuery(@PathVariable("queryid") Long queryid, Model model){
            Query query = queryRepository.findByqueryid(queryid);
            List <Question> questions = query.getQuestions();

            model.addAttribute("queryid", queryid);
            model.addAttribute("queries", queryRepository.findByqueryid(queryid));
            model.addAttribute("questions", questions);
            
            return "query";
        }

    @GetMapping(value = "/apidocumentation")
    public String showApiDocumentation() {
        return "apidocumentation";
    }
    

}
    

