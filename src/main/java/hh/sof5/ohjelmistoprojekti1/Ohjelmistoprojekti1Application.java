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
import hh.sof5.ohjelmistoprojekti1.domain.Choice;
import hh.sof5.ohjelmistoprojekti1.domain.ChoiceRepository;
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
	public CommandLineRunner ohjelmistoprojekti1(QueryRepository queryRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, ChoiceRepository choiceRepository) {
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

			Question question1 = new Question(Question.QuestionType.TEXT, 
				"Minä vuonna olet aloittanut opiskelusi?", query1, null
			);

			Question question2 = new Question(Question.QuestionType.TEXT,
				"Oletko tykännyt opiskella Haaga-Heliassa?", query1, null
			);

			Question question3 = new Question(Question.QuestionType.TEXT,
				"Suosittelisitko Haaga-Heliaa kavereillesi?", query1, null
			);

			Question question4 = new Question(Question.QuestionType.TEXT, "Onko kampus ollut viihtyisä?", query1, null
			);

			Question question5 = new Question(Question.QuestionType.TEXT, "Missä asioissa Haaga-Helialla olisi parantamisen varaa?", query1, null
			);


			question1.setQuery(query1);
			question2.setQuery(query1);
			question3.setQuery(query1);
			question4.setQuery(query1);
			question5.setQuery(query1);

			List<Question> questions1 = new ArrayList<>();
			questions1.add(question1);
			questions1.add(question2);
			questions1.add(question3);
			questions1.add(question4);
			questions1.add(question5);

			query1.setQuestions(questions1);
			queryRepository.save(query1);

			Question questionChoice1 = new Question(Question.QuestionType.CHOICE, "Missä asut", query1, null);

			List<Choice> mtestChoices = new ArrayList<>();

			mtestChoices.add(new Choice("Helsinki", questionChoice1));
			mtestChoices.add(new Choice("Vantaa", questionChoice1));
			mtestChoices.add(new Choice("Espoo", questionChoice1));
			mtestChoices.add(new Choice("Muu", questionChoice1));

			questionChoice1.setChoices(mtestChoices);

			Answer mmChoice = new Answer(mtestChoices.get(0).getChoiceText(), questionChoice1);
			Answer mmChoice2 = new Answer(mtestChoices.get(1).getChoiceText(), questionChoice1);
			Answer mmChoice3 = new Answer(mtestChoices.get(2).getChoiceText(), questionChoice1);
			Answer mmChoice4 = new Answer(mtestChoices.get(3).getChoiceText(), questionChoice1);
			

			questionRepository.save(questionChoice1);
			choiceRepository.saveAll(mtestChoices);
			answerRepository.save(mmChoice);
			answerRepository.save(mmChoice2);
			answerRepository.save(mmChoice3);
			answerRepository.save(mmChoice4);

			Question questionChoice0 = new Question(Question.QuestionType.CHOICE, "Minkä ikäinen olet?", query1, null);

			List<Choice> mtestChoices0 = new ArrayList<>();

			mtestChoices0.add(new Choice("Alle 18", questionChoice0));
			mtestChoices0.add(new Choice("18-25", questionChoice0));
			mtestChoices0.add(new Choice("26-35", questionChoice0));
			mtestChoices0.add(new Choice("Yli 35", questionChoice0));

			questionChoice1.setChoices(mtestChoices);

			Answer mmChoice0 = new Answer(mtestChoices0.get(1).getChoiceText(), questionChoice0);
			Answer mmChoice20 = new Answer(mtestChoices0.get(2).getChoiceText(), questionChoice0);
			Answer mmChoice30 = new Answer(mtestChoices0.get(2).getChoiceText(), questionChoice0);
			Answer mmChoice40 = new Answer(mtestChoices0.get(1).getChoiceText(), questionChoice0);
			Answer mmChoice50 = new Answer(mtestChoices0.get(1).getChoiceText(), questionChoice0);
			Answer mmChoice70 = new Answer(mtestChoices0.get(3).getChoiceText(), questionChoice0);



			questionRepository.save(questionChoice0);
			choiceRepository.saveAll(mtestChoices0);
			answerRepository.save(mmChoice0);
			answerRepository.save(mmChoice20);
			answerRepository.save(mmChoice30);
			answerRepository.save(mmChoice40);
			answerRepository.save(mmChoice50);
			answerRepository.save(mmChoice70);



			Question questionTest = new Question(Question.QuestionType.TEXT, 
				"Sukunimi", query2, null
			);

			Question questionTest2 = new Question(Question.QuestionType.TEXT, 
				"Etunimi", query2, null
			);

			questionTest.setQuery(query2);
			questionTest2.setQuery(query2);

			List<Question> questionsTest = new ArrayList<>();
			questionsTest.add(questionTest);
			questionsTest.add(questionTest2);

			query2.setQuestions(questionsTest);
			queryRepository.save(query2);

			Question questionChoice = new Question(Question.QuestionType.CHOICE, "Missä asut", query2, null);

			List<Choice> testChoices = new ArrayList<>();

			testChoices.add(new Choice("Helsinki", questionChoice));
			testChoices.add(new Choice("Vantaa", questionChoice));
			testChoices.add(new Choice("Rovaniemi", questionChoice));

			questionChoice.setChoices(testChoices);

			Answer mChoice = new Answer(testChoices.get(0).getChoiceText(), questionChoice);
			Answer mChoice2 = new Answer(testChoices.get(0).getChoiceText(), questionChoice);
			Answer mChoice3 = new Answer(testChoices.get(2).getChoiceText(), questionChoice);
			Answer mChoice4 = new Answer(testChoices.get(1).getChoiceText(), questionChoice);

			questionRepository.save(questionChoice);
			choiceRepository.saveAll(testChoices);
			answerRepository.save(mChoice);
			answerRepository.save(mChoice2);
			answerRepository.save(mChoice3);
			answerRepository.save(mChoice4);


			Question questionChoice2 = new Question(Question.QuestionType.CHOICE, "Lempi vuodenaika?", query2, null);

			List<Choice> seasonChoices = new ArrayList<>();

			seasonChoices.add(new Choice("Kevät", questionChoice2));
			seasonChoices.add(new Choice("Kesä", questionChoice2));
			seasonChoices.add(new Choice("Syksy", questionChoice2));
			seasonChoices.add(new Choice("Talvi", questionChoice2));

			questionChoice2.setChoices(seasonChoices);

			Answer nChoice = new Answer(seasonChoices.get(0).getChoiceText(), questionChoice2);
			Answer nChoice2 = new Answer(seasonChoices.get(0).getChoiceText(), questionChoice2);
			Answer nChoice3 = new Answer(seasonChoices.get(2).getChoiceText(), questionChoice2);
			Answer nChoice4 = new Answer(seasonChoices.get(1).getChoiceText(), questionChoice2);

			questionRepository.save(questionChoice2);
			choiceRepository.saveAll(seasonChoices);
			answerRepository.save(nChoice);
			answerRepository.save(nChoice2);
			answerRepository.save(nChoice3);
			answerRepository.save(nChoice4);

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
				"Esimerkki", questionTest
			);

			Answer answerTest2 = new Answer(
				"Erkki", questionTest2
			);

			answerRepository.save(answerTest);
			answerRepository.save(answerTest2);

		};
	}
}
