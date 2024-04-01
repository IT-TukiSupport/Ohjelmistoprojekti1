package hh.sof5.ohjelmistoprojekti1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import hh.sof5.ohjelmistoprojekti1.domain.Query;
import hh.sof5.ohjelmistoprojekti1.domain.QueryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class QueryController {

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

        return "newqueryform"; //newQueryForm.html
    }

    @PostMapping(value = "/savequery")
    public String saveQuery(@ModelAttribute Query query) {

        queryRepository.save(query);

        return "redirect:/queries";
    }
    
    
}
    

