package com.example.quiz.controllers;

import com.example.quiz.models.Question;
import com.example.quiz.models.Quiz;
import com.example.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class QuizController {

    @Autowired
    QuizService quizService;

/*    @GetMapping("/quiz/{quizId}")
    public String getQuiz(@PathVariable int quizId, Model model) {
        // Call the service method to fetch the quiz questions
        Quiz quiz = quizService.getQuizWithQuestions(quizId);

        // Add the quiz object to the model
        model.addAttribute("quiz", quiz);

        // Return the name of the Thymeleaf template to render
        return "home/quiz";
    }*/

    @GetMapping("/quiz/{quizId}")
    public String showQuiz(@PathVariable("quizId") int quizId, Model model) {
        // Fetch the quiz by its ID
        Quiz quiz = quizService.getQuizById(quizId);

        // Group questions by their IDs
        Map<Integer, List<Question>> groupedQuestions = quiz.getQuestions().stream()
                .collect(Collectors.groupingBy(Question::getId));

        // Convert the grouped questions to a list of lists
        List<List<Question>> questionGroups = new ArrayList<>(groupedQuestions.values());

        // Pass the grouped questions to the template
        model.addAttribute("quiz", quiz);
        model.addAttribute("questionGroups", questionGroups);

        return "/home/quiz";
    }
}
