package com.madushan.Web.Auction.service;

import com.madushan.Web.Auction.bean.ReviewBean;
import com.madushan.Web.Auction.database.review.Review;
import com.madushan.Web.Auction.useCase.ReviewUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewUseCase reviewUseCase;

    public String persistReview(ReviewBean reviewBean, String username) {
        return reviewUseCase.persistReview(reviewBean, username);
    }
}
