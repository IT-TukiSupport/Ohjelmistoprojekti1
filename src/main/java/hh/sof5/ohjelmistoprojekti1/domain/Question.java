package hh.sof5.ohjelmistoprojekti1.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private Long questionid;

    public enum QuestionType { TEXT, CHOICE };
    @Enumerated(EnumType.ORDINAL)
    private QuestionType questionType;

    private String questionText;

    @ManyToOne
    @JsonIgnoreProperties("questions")
    @JoinColumn(name = "queryid") //FK
    private Query query;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonIgnoreProperties("question")
    private List<Answer> answers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonIgnoreProperties("question")
    private List<Choice> choices; 

    // Constructors

    public Question(QuestionType questionType ,String questionText, Query query, List<Choice> choices) {
        this.questionType = questionType;
        this.questionText = questionText;
        this.query = query;
        this.choices =  choices;
    }

    public Question() {

    }

    // Getters
        public Long getQuestionid() {
            return questionid;
        }

        public String getQuestionText() {
            return questionText;
        }

        public Query getQuery() {
            return query;
        }

        public List<Choice> getChoices() {
            return choices;
        }

    // Setters

        public void setAnswers(List<Answer> answers) {
            this.answers = answers;
        }

        public List<Answer> getAnswers() {
            return answers;
        }

        public void setQuestionid(Long questionid) {
            this.questionid = questionid;
        }

        public void setQuestionText(String questionText) {
            this.questionText = questionText;
        }

        public void setQuery(Query query) {
            this.query = query;
        }

        public void setChoices(List<Choice> choices) {
            this.choices = choices;
        }

        public void addChoice(Choice choice){
            choices.add(choice);
        }
        
    // toString

    @Override
    public String toString() {
        return "Question [questionid=" + questionid + ", questionText=" + questionText + "]";
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
