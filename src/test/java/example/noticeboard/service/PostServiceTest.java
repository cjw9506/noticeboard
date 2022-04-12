package example.noticeboard.service;

import example.noticeboard.domain.Post;
import example.noticeboard.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired PostRepository postRepository;
    @Autowired PostService postService;

    @Test
    //@Rollback(value = false)
    void 게시글_작성() {
        Post post = new Post("title", "content", "author");

        Long writeId = postService.write(post);

        Assertions.assertThat(post).isEqualTo(postRepository.findOne(writeId));
        Assertions.assertThat(post.getAuthor()).isEqualTo("author");
    }
}