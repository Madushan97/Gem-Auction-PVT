package com.madushan.Web.Auction.service;

import com.madushan.Web.Auction.bean.ReviewBean;
import com.madushan.Web.Auction.useCase.PersistReviewUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final PersistReviewUseCase persistReviewUseCase;


    public String persistReview(ReviewBean reviewBean, String username) {
        return persistReviewUseCase.persistReview(reviewBean, username);
    }
}
