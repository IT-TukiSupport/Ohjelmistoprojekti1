package hh.sof5.ohjelmistoprojekti1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class QueryController {

    @GetMapping(value = "/queries")
        public String allQueries(Model model){
            return "query"; //query.html
        }

    @GetMapping(value = "/addquery")
    public String addNewQuery() {
        return "newqueryform"; //newQueryForm.html
    }
    
}
    

