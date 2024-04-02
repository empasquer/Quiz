CREATE DATABASE IF NOT EXISTS `ems_quiz`;
USE `ems_quiz`;

CREATE USER IF NOT EXISTS 'quiz_taker'@'localhost' IDENTIFIED BY 'quiz_taker';
GRANT USAGE ON *.* TO `quiz_taker`@`localhost`;
GRANT SELECT, INSERT, UPDATE, DELETE ON ems_quiz.* TO 'quiz_taker'@`localhost`;

DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS answer_option;
DROP TABLE IF EXISTS correct_option;
DROP TABLE IF EXISTS user_response;
DROP TABLE IF EXISTS quiz;

CREATE TABLE quiz (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    duration INT
);

CREATE TABLE question (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quiz_id INT,
    question_text TEXT,
    FOREIGN KEY (quiz_id) REFERENCES quiz(id)
);

CREATE TABLE answer_option (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_id INT,
    answer_option_text TEXT,
    FOREIGN KEY (question_id) REFERENCES question(id)
);

CREATE TABLE correct_option (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_id INT,
    answer_option_id INT,
    FOREIGN KEY (question_id) REFERENCES question(id),
    FOREIGN KEY (answer_option_id) REFERENCES answer_option(id)
);

CREATE TABLE user_response (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quiz_id INT,
    question_id INT,
    answer_option_id INT,
    FOREIGN KEY (quiz_id) REFERENCES quiz(id),
    FOREIGN KEY (question_id) REFERENCES question(id),
    FOREIGN KEY (answer_option_id) REFERENCES answer_option(id)
);

-- Insert Quizzes
INSERT INTO quiz (title, description, duration) VALUES
('How Well Do You Know Me?', 'Test your knowledge about me with these questions.', 60);

-- Insert Questions
INSERT INTO question (quiz_id, question_text) VALUES
(1, 'What is my favorite color? (Multiple answers)'),
(1, 'What is my favorite food?'),
(1, 'What is my favorite hobby?');

-- Insert Options
INSERT INTO answer_option (question_id, answer_option_text) VALUES
(1, 'Blue'),
(1, 'Red'),
(1, 'Green'),
(1, 'Yellow'),
(2, 'Sushi'),
(2, 'Pasta'),
(2, 'Burger'),
(2, 'Pizza'),
(3, 'Drawing'),
(3, 'Coding'),
(3, 'Reading'),
(3, 'Playing video games');

-- Insert Correct Options
INSERT INTO correct_option (question_id, answer_option_id) VALUES
(1, 1), -- Blue is correct
(1, 3), -- Green is correct
(2, 2), -- Pasta is correct
(3, 1), -- Drawing is correct
(3, 2), -- Coding is correct
(3, 3), -- Reading is correct
(3, 4); -- Playing video games is correct

