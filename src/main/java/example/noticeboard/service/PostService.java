package example.noticeboard.service;

import example.noticeboard.domain.Post;
import example.noticeboard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    //게시글 작성
    @Transactional //변경
    public Long write(Post post) {
        postRepository.save(post);
        return post.getId();
    }
    // 전체 게시글 조회
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findOne(Long postId) {
        return postRepository.findOne(postId);
    }
}
