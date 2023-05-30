package com.example.hotdealverse.review.application.port.in;

import com.example.hotdealverse.review.adapter.dto.req.CreateReviewReqDto;
import com.example.hotdealverse.review.adapter.dto.req.GetReviewsReqDto;
import com.example.hotdealverse.review.adapter.dto.res.GetReviewResDto;

import java.util.List;

public interface ReviewUseCase {
    List<GetReviewResDto> getReviews(GetReviewsReqDto getReviewsReqDto);

    Long getTotalReviewsCnt(GetReviewsReqDto getReviewsReqDto);

    void createReview(CreateReviewReqDto createReviewReqDto, Long userId);

    void deleteReview(Long reviewId, Long userId);
}
