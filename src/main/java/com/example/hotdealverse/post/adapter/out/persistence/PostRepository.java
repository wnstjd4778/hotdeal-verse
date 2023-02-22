package com.example.hotdealverse.post.adapter.out.persistence;

import com.example.hotdealverse.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
