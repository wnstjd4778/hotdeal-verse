package com.example.hotdealverse.review.adapter.out.persistence;

import com.example.hotdealverse.common.exception.CustomException;
import com.example.hotdealverse.common.exception.ErrorCode;
import com.example.hotdealverse.item.adapter.out.persistence.ItemJpaEntity;
import com.example.hotdealverse.item.adapter.out.persistence.ItemRepository;
import com.example.hotdealverse.review.adapter.dto.req.CreateReviewReqDto;
import com.example.hotdealverse.review.adapter.dto.req.GetReviewsReqDto;
import com.example.hotdealverse.review.application.port.out.ReviewPort;
import com.example.hotdealverse.review.domain.Review;
import com.example.hotdealverse.review.mapper.ReviewMapper;
import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import com.example.hotdealverse.user.adapter.out.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewPersistenceAdapter implements ReviewPort {

    private final ReviewRepository reviewRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Override
    public List<Review> getReviews(GetReviewsReqDto getReviewsReqDto) {
        Pageable pageable = PageRequest.of(getReviewsReqDto.getPage(), getReviewsReqDto.getSize(), Sort.by("createdAt").descending());
        List<ReviewJpaEntity> reviewJpaEntityList;

        if(getReviewsReqDto.getItemId() == null) {
            reviewJpaEntityList  = this.reviewRepository.findAllOrderByCreatedAtDesc(pageable).stream().toList();
        } else {
            reviewJpaEntityList = this.reviewRepository.findAllByItemOrderByCreatedAtDesc(getReviewsReqDto.getItemId(), pageable).stream().toList();
        }

        return reviewJpaEntityList.stream().map(review -> ReviewMapper.convertEntityToReview(review)).toList();
    }

    @Override
    public Long getTotalReviewsCnt(GetReviewsReqDto getReviewsReqDto) {

        if(getReviewsReqDto.getItemId() == null) {
            return this.reviewRepository.count();
        } else {
            return this.reviewRepository.countAllByItem(getReviewsReqDto.getItemId());
        }
    }

    @Override
    public void createReview(CreateReviewReqDto createReviewReqDto, Long userId) {

        ItemJpaEntity itemJpaEntity = this.itemRepository.findById(createReviewReqDto.getItemId()).orElseThrow(
                () -> new CustomException(ErrorCode.ITEM_NOT_FOUND)
        );

        UserJpaEntity userJpaEntity = this.userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        ReviewJpaEntity reviewJpaEntity = ReviewJpaEntity.builder()
                .content(createReviewReqDto.getContent())
                .rate(createReviewReqDto.getRate())
                .item(itemJpaEntity)
                .user(userJpaEntity)
                .build();

        this.reviewRepository.save(reviewJpaEntity);
    }

    @Override
    public void deleteReview(Long reviewId, Long userId) {
        UserJpaEntity userJpaEntity = this.userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        ReviewJpaEntity reviewJpaEntity = this.reviewRepository.findById(reviewId).orElseThrow(
                () -> new CustomException(ErrorCode.REVIEW_NOT_FOUND)
        );

        if(reviewJpaEntity.getUser().getId() != userJpaEntity.getId()) {

            throw new CustomException(ErrorCode.REVIEW_NOT_ACCESS);
        }

        this.reviewRepository.delete(reviewJpaEntity);
    }
}
