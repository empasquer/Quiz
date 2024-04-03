package com.example.quiz.repositories;

import com.example.quiz.models.Option;
import com.example.quiz.models.Question;
import com.example.quiz.models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QuizRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Quiz> getAllQuizzes() {
        String query = "SELECT * FROM quiz;";
        RowMapper<Quiz> rowMapper = new BeanPropertyRowMapper<>(Quiz.class);
        return jdbcTemplate.query(query, rowMapper);
    }


    public Quiz getQuizById(int quizId) {
        String query = "SELECT * FROM quiz WHERE id = ?";
        RowMapper<Quiz> rowMapper = new BeanPropertyRowMapper<>(Quiz.class);
        Quiz quiz = jdbcTemplate.queryForObject(query, rowMapper, quizId);

        query = "SELECT * FROM question WHERE quiz_id = ?";
        List<Question> questions = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Question.class), quizId);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            query = "SELECT * FROM answer_option WHERE question_id = ?";
            List<Option> options = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Option.class), question.getId());

            for (Option option : options ){
                System.out.println(option.getId());
                System.out.println(option.getQuestionId());
                System.out.println(option.getAnswerOptionText());
            }
            question.setOptions(options);
        }

        quiz.setQuestions(questions);

        return quiz;
    }



  /*  public Quiz getQuizById(int quizId) {
        String query = "SELECT q.id, q.title, q.description, q.duration, " +
                "qu.id AS question_id, qu.question_text, " +
                "ao.id AS option_id, ao.answer_option_text AS option_text " +
                "FROM quiz q " +
                "LEFT JOIN question qu ON q.id = qu.quiz_id " +
                "LEFT JOIN answer_option ao ON qu.id = ao.question_id " +
                "WHERE q.id = ?";





        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, quizId);

        Quiz quiz = null;
        Map<Integer, Quiz> quizMap = new HashMap<>();

        for (Map<String, Object> row : rows) {
            int id = (int) row.get("id");

            if (quiz == null || quiz.getId() != id) {
                quiz = new Quiz();
                quiz.setId(id);
                quiz.setTitle((String) row.get("title"));
                quiz.setDescription((String) row.get("description"));
                quiz.setDuration((int) row.get("duration"));
                quizMap.put(id, quiz);
            }

            int questionId = (int) row.get("question_id");

            if (questionId != 0) {
                Question question = new Question();
                question.setId(questionId);
                question.setQuestionText((String) row.get("question_text"));

                Option option = new Option();
                option.setId((int) row.get("option_id"));
                option.setOptionText((String) row.get("option_text"));

                System.out.println(option.getOptionText());
                question.addOption(option);
                System.out.println(question.getOptions().get(0).getOptionText());
                quiz.addQuestion(question);
                System.out.println(question.getOptions());
            }
        }

        return quiz;
    }*/

}
