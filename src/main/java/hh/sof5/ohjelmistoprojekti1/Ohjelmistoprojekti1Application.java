package hh.sof5.ohjelmistoprojekti1;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof5.ohjelmistoprojekti1.domain.Answer;
import hh.sof5.ohjelmistoprojekti1.domain.AnswerRepository;
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
	public CommandLineRunner ohjelmistoprojekti1(QueryRepository queryRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
		return (args) -> {


			log.info("Lets Save couple test querys");

			Query query1 = new Query(
				"Haaga-Helia tyytyväisyyskysely",
				"Tällä kyselyllä selvitetään opiskelijoiden mielipiteitä Haaga-Helian ammattikorkeakoulusta."
			);

			Query query2 = new Query(
				"Test",
				"This is a test"
			);

			log.info("lets save couple test questions");

			Question question1 = new Question(
				"Minä vuonna olet aloittanut opiskelusi?", query1
			);

			Question question2 = new Question(
				"Oletko tykännyt opiskella Haaga-Heliassa?", query1
			);

			Question question3 = new Question(
				"Suosittelisitko Haaga-Heliaa kavereillesi?", query1
			);

			Question question4 = new Question("Onko kampus ollut viihtyisä?", query1
			);

			Question question5 = new Question("Missä asioissa Haaga-Helialla olisi parantamisen varaa?", query1
			);


			question1.setQuery(query1);
			question2.setQuery(query1);
			question3.setQuery(query1);
			question4.setQuery(query1);
			question5.setQuery(query1);

			Question questionTest = new Question(
				"Sukunimi", query2
			);

			Question questionTest2 = new Question(
				"Etunimi", query2
			);

			questionTest.setQuery(query2);
			questionTest2.setQuery(query2);

			List<Question> questionsTest = new ArrayList<>();
			questionsTest.add(questionTest);
			questionsTest.add(questionTest2);

			query2.setQuestions(questionsTest);
			queryRepository.save(query2);

			List<Question> questions = new ArrayList<>();
			questions.add(question1);
			questions.add(question2);
			questions.add(question3);
			questions.add(question4);
			questions.add(question5);

			query1.setQuestions(questions);

			queryRepository.save(query1);

			Answer answer1 = new Answer(
				"Aloitin opintoni vuonna 2023.", question1
			);

			Answer answer2 = new Answer(
			"Olen tykännyt opiskella Haaga-Heliassa.", question2	
			);

			Answer answer3 = new Answer(
				"Voisin suositella Haaga-Heliaa kavereilleni.", question3
			);

			Answer answer4 = new Answer(
				"Pasilan kampus on viihtyisä.", question4
			);

			Answer answer5 = new Answer(
				"Aloitin opintoni 2022.", question1
			);

			Answer answer6 = new Answer(
				"Haaga-Helia on ok.", question2
			);

			answerRepository.save(answer1);
			answerRepository.save(answer2);
			answerRepository.save(answer3);
			answerRepository.save(answer4);
			answerRepository.save(answer5);
			answerRepository.save(answer6);

			Answer answerTest = new Answer(
				"Nuppi", questionTest
			);

			Answer answerTest2 = new Answer(
				"Tero", questionTest2
			);

			answerRepository.save(answerTest);
			answerRepository.save(answerTest2);

		};
	}
}
