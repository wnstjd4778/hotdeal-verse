package com.example.hotdealverse.review.mapper;

import com.example.hotdealverse.item.mapper.ItemMapper;
import com.example.hotdealverse.review.adapter.dto.res.GetReviewResDto;
import com.example.hotdealverse.review.adapter.out.persistence.ReviewJpaEntity;
import com.example.hotdealverse.review.domain.Review;
import com.example.hotdealverse.user.mapper.UserMapper;

public class ReviewMapper {

    public static Review convertEntityToReview(ReviewJpaEntity reviewJpaEntity) {
        return Review.builder()
                .id(reviewJpaEntity.getId())
                .rate(reviewJpaEntity.getRate())
                .content(reviewJpaEntity.getContent())
                .user(UserMapper.convertEntityToUser(reviewJpaEntity.getUser()))
                .item(ItemMapper.convertEntityToItem(reviewJpaEntity.getItem()))
                .createdAt(reviewJpaEntity.getCreatedAt())
                .updatedAt(reviewJpaEntity.getUpdatedAt())
                .build();
    }

    public static GetReviewResDto convertReviewToGetReviewResDto(Review review) {
        return GetReviewResDto.builder()
                .id(review.getId())
                .content(review.getContent())
                .item(ItemMapper.convertItemToGetItemResDto(review.getItem()))
                .name(review.getUser().getName())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }
}
