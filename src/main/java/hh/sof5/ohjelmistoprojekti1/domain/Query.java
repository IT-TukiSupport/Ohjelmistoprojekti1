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

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "query")
        @JsonIgnoreProperties ("query")
        private List<Question> questions;

    //Constructor

        public Query(String name, String desc, List<Question> questions) {
            super();
            this.name = name;
            this.desc = desc;
            this.questions = questions;
        }

    //Null Constructor

        public Query(){

        }

    // Setters

        public void setQueryid(Long queryid) {
            this.queryid = queryid;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setQuestions(List<Question> questions) {
            this.questions = questions;
        }

    // Getters

        public Long getQueryid() {
            return queryid;
        }

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }

        public List<Question> getQuestions() {
            return questions;
        }

    // ToString

        @Override
        public String toString() {
            return "Query [name=" + name + ", desc=" + desc + ", questions=" + questions + "]";
        }
}
