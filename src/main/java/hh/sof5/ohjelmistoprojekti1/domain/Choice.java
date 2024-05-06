package hh.sof5.ohjelmistoprojekti1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Choice")
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long choiceId;
    private String choiceText;

    @ManyToOne
    @JsonIgnoreProperties("choices")
    @JoinColumn(name = "questionid") //FK
    private Question question;

    public Choice(String choiceText, Question question) {
        this.choiceText = choiceText;
        this.question = question;
    }

    public Choice() {

    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public Question getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Choice [choiceId=" + choiceId + ", choiceText=" + choiceText + ", question=" + question + "]";
    }
}
