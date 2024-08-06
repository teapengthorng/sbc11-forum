package co.istad.forum.database;


import co.istad.forum.model.Answer;
import co.istad.forum.model.Question;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
    public class ForumDatabase {

        @Bean
        List<Question> questions() {

            Question q1 = new Question();
            q1.setId(1);
            q1.setSlug("docker-gets-error-failed-to-compute-cache-key-not-found-runs-fine-in-visual-studio");
            q1.setTitle("Docker gets error failed to compute cache key: not found - runs fine in Visual Studio");
            q1.setDescription("Docker gets error failed to compute cache key: not found - runs fine in Visual Studio");
            q1.setViewCount(0L);
            q1.setCreatedAt(LocalDate.now());
            q1.setCreatedBy("admin");
            q1.setAnswers(List.of(
                    Answer.builder()
                            .id(8)
                            .uuid("3446-77555-9877")
                            .content("jj asd asd")
                            .isAccepted(true)
                            .createdAt(LocalDate.now().plusDays(1))
                            .createdBy("kanha")
                            .build(),
                    Answer.builder()
                            .id(2)
                            .uuid("123-76544-766")
                            .content("as asd hhh")
                            .isAccepted(false)
                            .createdAt(LocalDate.now().minusDays(1))
                            .createdBy("kanha")
                            .build()
            ));

            Question q2 = new Question();
            q2.setId(2);
            q2.setSlug("run-unlimited-analysis-on-our-most-powerful-servers");
            q2.setTitle("Run unlimited analysis on our most powerful servers");
            q2.setDescription("Docker gets error failed to compute cache key: not found - runs fine in Visual Studio");
            q2.setViewCount(0L);
            q2.setCreatedAt(LocalDate.now());
            q2.setCreatedBy("dara");
            q2.setAnswers(List.of());

            return new ArrayList<>(List.of(q1,q2)); //Muablte
        }

    @Bean
    List<Answer> answers(){

        Answer a1 = new Answer();
        a1.setId(1);
        a1.setContent("Run unlimited analysis on our most powerful servers");
        a1.setIsAccepted(true);
        a1.setCreatedAt(LocalDate.now());
        a1.setCreatedBy("Pengthorng");

        Answer a2 = new Answer();
        a2.setId(2);
        a2.setContent("Docker gets error failed to compute cache");
        a2.setIsAccepted(false);
        a2.setCreatedAt(LocalDate.now());
        a2.setCreatedBy("Jonh");
        return List.of(a1,a2);
    }
    }
