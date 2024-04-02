package com.example.quiz.services;

import com.example.quiz.models.Quiz;
import com.example.quiz.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
   @Autowired
   QuizRepository quizRepository;

    public List<Quiz> getAllQuizzes() {
        return quizRepository.getAllQuizzes();
    }

    public Quiz getQuizWithQuestions(int quizId) {
        return quizRepository.getQuizById(quizId);
    }

    public Quiz getQuizById(int quizId) {
        return quizRepository.getQuizById(quizId);
    }
}
