package com.example.hotdealverse.review.application.service;

import com.example.hotdealverse.review.adapter.dto.req.CreateReviewReqDto;
import com.example.hotdealverse.review.adapter.dto.req.GetReviewsReqDto;
import com.example.hotdealverse.review.adapter.dto.res.GetReviewResDto;
import com.example.hotdealverse.review.application.port.in.ReviewUseCase;
import com.example.hotdealverse.review.application.port.out.ReviewPort;
import com.example.hotdealverse.review.domain.Review;
import com.example.hotdealverse.review.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService implements ReviewUseCase {

    private final ReviewPort reviewPort;

    @Override
    public List<GetReviewResDto> getReviews(GetReviewsReqDto getReviewsReqDto) {
        List<Review> reviewList = this.reviewPort.getReviews(getReviewsReqDto);
        return reviewList.stream().map(review -> ReviewMapper.convertReviewToGetReviewResDto(review)).toList();
    }

    @Override
    public Long getTotalReviewsCnt(GetReviewsReqDto getReviewsReqDto) {
        return this.reviewPort.getTotalReviewsCnt(getReviewsReqDto);
    }

    @Override
    public void createReview(CreateReviewReqDto createReviewReqDto, Long userId) {
        this.reviewPort.createReview(createReviewReqDto, userId);
    }

    @Override
    public void deleteReview(Long reviewId, Long userId) {
        this.reviewPort.deleteReview(reviewId, userId);
    }
}
