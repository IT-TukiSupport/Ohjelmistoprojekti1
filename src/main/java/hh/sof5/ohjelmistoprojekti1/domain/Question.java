package hh.sof5.ohjelmistoprojekti1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Question")

public class Question {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionid;
    private String question;

    @ManyToOne
    @JsonIgnoreProperties("questions")
    @JoinColumn(name = "queryid") //FK
    private Query query;

    // Constructors
    public Question() {
    }
    
    public Question(String question) {
        this.question = question;
    }

    // Getters
        public Long getQuestionid() {
            return questionid;
        }

        public String getQuestion() {
            return question;
        }

        public Query getQuery() {
            return query;
        }

    // Setters
        public void setQuestionid(Long questionid) {
            this.questionid = questionid;
        }
        public void setQuestion(String question) {
            this.question = question;
        }
        public void setQuery(Query query) {
            this.query = query;
        }
        
    // toString
    
    @Override
    public String toString() {
        return "Question [questionid=" + questionid + ", question=" + question + "]";
    }





    
    

    
}
