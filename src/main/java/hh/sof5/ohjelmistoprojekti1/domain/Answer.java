package hh.sof5.ohjelmistoprojekti1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Answer")
public class Answer {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long answerid;
    private String answerText;

    @ManyToOne
    @JsonIgnoreProperties("answers")
    @JoinColumn(name = "questionid") //FK
    private Question question;

    // Construstors
    
    public Answer(String answerText, Question question) {
        this.answerText = answerText;
        this.question = question;
    }


    public Answer() {

    }
    
    // Getters
    public Long getAnswerid() {
        return answerid;
    }

    public String getAnswerText() {
        return answerText;
    }

    public Question getQuestion() {
        return question;
    }

    // Setters
    public void setAnswerid(Long answerid) {
        this.answerid = answerid;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    // toString
    @Override
    public String toString() {
        return "Answer [answerid=" + answerid + ", answerText=" + answerText + "]";
    }    

}
