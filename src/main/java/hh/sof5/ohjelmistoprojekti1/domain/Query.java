package hh.sof5.ohjelmistoprojekti1.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Query {

    //Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long queryid;
    private String name;
    private String desc;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Question")
    @JsonIgnoreProperties ("query")
    private List <Question> questions;

    //Constructor

    public Query(String name, String desc, List<Question> questions) {
        this.name = name;
        this.desc = desc;
        this.questions = questions;
    }

    //Null Constructor

    public Query(){

    }
    

    

}
