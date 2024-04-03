package hh.sof5.ohjelmistoprojekti1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof5.ohjelmistoprojekti1.domain.Query;
import hh.sof5.ohjelmistoprojekti1.domain.QueryRepository;
import hh.sof5.ohjelmistoprojekti1.domain.Question;
import hh.sof5.ohjelmistoprojekti1.domain.QuestionRepository;

@SpringBootApplication
public class Ohjelmistoprojekti1Application {

	private static final Logger log = LoggerFactory.getLogger(Ohjelmistoprojekti1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Ohjelmistoprojekti1Application.class, args);
	}

	@Bean
	public CommandLineRunner ohjelmistoprojekti1(QueryRepository queryRepository, QuestionRepository questionRepository) {
		return (args) -> {


			log.info("Lets Save couple test querys");

			Query query1 = new Query(
				"query1",
				"First query"
			);

			log.info("lets save couple test questions");

			Question question1 = new Question(
				"Firstname?"
			);

			Question question2 = new Question(
				"Lastname?"
			);

			question1.setQuery(query1);
			question2.setQuery(query1);

			List<Question> questions = new ArrayList<>();
			questions.add(question1);
			questions.add(question2);


			query1.setQuestions(questions);

			queryRepository.save(query1);

		

		};
	}
}
