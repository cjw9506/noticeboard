package example.noticeboard.repository;

import example.noticeboard.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class PostRepositoryTest {

    @Autowired PostRepository postRepository;

    @Test
    void save() {
        //given
        Post post = new Post("123", "123", "123");
        //when
        Long savePost = postRepository.save(post);
        //then
        Assertions.assertThat(post).isEqualTo(postRepository.findOne(savePost));
    }



}