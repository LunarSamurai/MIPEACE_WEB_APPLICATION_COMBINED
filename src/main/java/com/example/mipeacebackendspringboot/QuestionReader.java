package com.example.mipeacebackendspringboot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.print.DocFlavor.URL;
import com.example.mipeacebackendspringboot.TestResponse;
import org.springframework.stereotype.Component;

@Component
public class QuestionReader {
    private String directoryPath = "/QuestionsFiles/";

    public List<Question> readQuestionsFromDirectory() throws IOException {
        List<Question> questions = new ArrayList<>();

        java.net.URL resource = getClass().getResource(directoryPath);
        if (resource != null) {
            File directory = new File(resource.getFile());
            File[] files = directory.listFiles();
            if (files != null) {
                // Choose a file based on your criteria, such as the first file
                File chosenFile = files[0];
                List<Question> questionsFromFile = readQuestionsFromFile(chosenFile);
                questions.addAll(questionsFromFile);
            }
        }

        return questions;
    }

    private List<Question> readQuestionsFromFile(File file) throws IOException {
        List<Question> questions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            if ((line = reader.readLine()) != null) {
                TestResponse testResponse = new TestResponse();
                // Set the scaleName using TestResponse's setScaleName() method
                testResponse.setScaleName(line.trim());
            }

            while ((line = reader.readLine()) != null) {
                // Skip lines starting with '[' and the last line
                if (line.startsWith("[") || line.trim().isEmpty()) {
                    continue;
                }

                // Find the index of '|' character
                int pipeIndex = line.indexOf('|');
                if (pipeIndex >= 0) {
                    String questionText = line.substring(0, pipeIndex).trim();

                    // Create a Question object with the question text and default values
                    Question question = new Question(questionText, 0, "");
                    questions.add(question);
                }
            }
        }

        return questions;
    }

}
