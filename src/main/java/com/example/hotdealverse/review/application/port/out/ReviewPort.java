package com.example.hotdealverse.review.application.port.out;

import com.example.hotdealverse.review.adapter.dto.req.CreateReviewReqDto;
import com.example.hotdealverse.review.adapter.dto.req.GetReviewsReqDto;
import com.example.hotdealverse.review.domain.Review;

import java.util.List;

public interface ReviewPort {
    List<Review> getReviews(GetReviewsReqDto getReviewsReqDto);

    Long getTotalReviewsCnt(GetReviewsReqDto getReviewsReqDto);

    void createReview(CreateReviewReqDto createReviewReqDto, Long userId);

    void deleteReview(Long reviewId, Long userId);
}
