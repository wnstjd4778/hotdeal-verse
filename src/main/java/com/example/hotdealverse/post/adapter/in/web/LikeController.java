package com.example.hotdealverse.post.adapter.in.web;

import com.example.hotdealverse.common.security.CurrentUser;
import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import com.example.hotdealverse.post.application.port.in.LikeUseCase;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Like")
@RestController("/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeUseCase likeUseCase;

    @Operation(summary = "게시글 좋아요 등록")
    @PostMapping("/posts/{postId}")
    public ResponseEntity enrollLike(
            @CurrentUser UserPrincipal userPrincipal,
            @PathVariable("postId") Long postId
    ) {
        likeUseCase.enrollLike(userPrincipal.getId(), postId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "게시글 좋아요 취소")
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity unenrollLike(
            @CurrentUser UserPrincipal userPrincipal,
            @PathVariable("postId") Long postId
    ) {
        likeUseCase.unenrollLike(userPrincipal.getId(), postId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
