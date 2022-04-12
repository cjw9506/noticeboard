package example.noticeboard.repository;

import example.noticeboard.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    public final EntityManager em;

    //저장
    public Long save(Post post) {
        em.persist(post);
        return post.getId();
    }

    //id로 찾기
    public Post findOne(Long id) {
        return em.find(Post.class, id);
    }
    //모두 찾기
    public List<Post> findAll() {
        return em.createQuery("select p from Post p", Post.class).getResultList();
    }

}
