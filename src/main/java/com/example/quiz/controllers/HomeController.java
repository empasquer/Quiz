package com.example.quiz.controllers;

import com.example.quiz.models.Quiz;
import com.example.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired QuizService quizService;

    @GetMapping("")
    public String index(Model model) {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        model.addAttribute("quizzes",quizzes);
        return "home/index";
    }
}
