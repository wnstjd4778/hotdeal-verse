package com.example.hotdealverse.post.adapter.in.web;

import com.example.hotdealverse.post.application.port.in.PostUseCase;
import com.example.hotdealverse.post.dto.req.GetPostsReqDto;
import com.example.hotdealverse.post.dto.res.GetPostResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostUseCase postUseCase;

    @GetMapping("/posts")
    public ResponseEntity<List<GetPostResDto>> getPosts(
            GetPostsReqDto getPostsReqDto
    ) {
        List<GetPostResDto> getPostResDtoList = this.postUseCase.getPosts(getPostsReqDto);
        return new ResponseEntity<>(getPostResDtoList, HttpStatus.OK);
    }

}
