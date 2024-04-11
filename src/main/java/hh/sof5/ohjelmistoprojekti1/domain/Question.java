package hh.sof5.ohjelmistoprojekti1.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Question")
public class Question {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String questionText;

    @ManyToOne
    @JsonIgnoreProperties("questions")
    @JoinColumn(name = "queryid") //FK
    private Query query;

    @OneToMany
    @JsonIgnoreProperties("question")
    private List<Answer> answers;

    // Constructors

    
    public Question(String questionText) {
        this.questionText = questionText;
    }

    public Question() {

    }

    // Getters
        public Long getId() {
            return id;
        }

        public String getQuestionText() {
            return questionText;
        }

        public Query getQuery() {
            return query;
        }

    // Setters

        public void setId(Long id) {
            this.id = id;
        }

        public void setQuestionText(String questionText) {
            this.questionText = questionText;
        }

        public void setQuery(Query query) {
            this.query = query;
        }
        
    // toString
    
    @Override
    public String toString() {
        return "Question [questionid=" + id + ", questionText=" + questionText + "]";
    }


}
