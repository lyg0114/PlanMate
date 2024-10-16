package com.planmate.service;

import com.planmate.model.entity.Comment;
import com.planmate.model.entity.Plan;
import com.planmate.model.entity.User;
import com.planmate.repository.CommentRepository;
import com.planmate.repository.PlanRepository;
import com.planmate.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Rollback(value = false)
@SpringBootTest
class PlanServiceTest {

    @Autowired
    PlanService planService;
    @Autowired
    PlanRepository planRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    EntityManager em;


    @Test
    void test() {
        // given
        User user1 = userRepository.save(User.builder().username("user-1").email("user-1@gmail.com").build());
        User user2 = userRepository.save(User.builder().username("user-2").email("user-2@gmail.com").build());
        User user3 = userRepository.save(User.builder().username("user-3").email("user-3@gmail.com").build());

        Plan plan1 = planRepository.save(Plan.builder().title("hello-title-1").content("hello-contnet-1").user(user1).build());
        Comment comment1 = commentRepository.save(Comment.builder().plan(plan1).user(user2).commentContent("comment-str-1").build());
        Comment comment2 = commentRepository.save(Comment.builder().plan(plan1).user(user2).commentContent("comment-str-2").build());
        Comment comment3 = commentRepository.save(Comment.builder().plan(plan1).user(user3).commentContent("comment-str-3").build());

        Plan plan2 = planRepository.save(Plan.builder().title("hello-title-2").content("hello-contnet-2").user(user2).build());
        Comment commen4 = commentRepository.save(Comment.builder().plan(plan2).user(user3).commentContent("comment-str-4").build());

        em.flush();
        em.clear();

        // when
        Plan plan_1 = planRepository.findById(plan1.getPlanId()).get();
        List<Comment> comments = plan_1.getComments();
        for (Comment comment : comments) {
            System.out.println("comment = " + comment);
        }

        // then

    }

}