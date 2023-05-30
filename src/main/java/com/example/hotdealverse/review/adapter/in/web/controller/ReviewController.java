package com.example.hotdealverse.review.adapter.in.web.controller;

import com.example.hotdealverse.common.aop.Authenticated;
import com.example.hotdealverse.common.aop.CurrentUser;
import com.example.hotdealverse.common.payload.ApiTotalBaseResponse;
import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import com.example.hotdealverse.review.adapter.dto.req.CreateReviewReqDto;
import com.example.hotdealverse.review.adapter.dto.req.GetReviewsReqDto;
import com.example.hotdealverse.review.adapter.dto.res.GetReviewResDto;
import com.example.hotdealverse.review.application.port.in.ReviewUseCase;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "review")
@Slf4j
@RequiredArgsConstructor
@RestController()
public class ReviewController {

    private final ReviewUseCase reviewUseCase;

    @GetMapping("/reviews")
    public ResponseEntity<ApiTotalBaseResponse> getReviews(
            GetReviewsReqDto getReviewsReqDto
    ) {
        List<GetReviewResDto> reviewResDtoList = this.reviewUseCase.getReviews(getReviewsReqDto);
        Long total = this.reviewUseCase.getTotalReviewsCnt(getReviewsReqDto);
        ApiTotalBaseResponse apiTotalBaseResponse = new ApiTotalBaseResponse(reviewResDtoList, total);
        return new ResponseEntity<>(apiTotalBaseResponse, HttpStatus.OK);
    }

    @PostMapping("/reviews")
    @Authenticated
    public ResponseEntity createReview(
            @RequestBody CreateReviewReqDto createReviewReqDto,
            @CurrentUser UserPrincipal userPrincipal
    ) {
        this.reviewUseCase.createReview(createReviewReqDto, userPrincipal.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/reviews/{reviewId}")
    @Authenticated
    public ResponseEntity deleteReview(
            @PathVariable("reviewId") Long reviewId,
            @CurrentUser UserPrincipal userPrincipal
    ) {
        this.reviewUseCase.deleteReview(reviewId, userPrincipal.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
