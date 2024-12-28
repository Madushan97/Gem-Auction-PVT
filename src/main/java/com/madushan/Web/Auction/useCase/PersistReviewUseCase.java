package com.madushan.Web.Auction.useCase;

import com.madushan.Web.Auction.bean.ReviewBean;
import com.madushan.Web.Auction.useCase.adapter.ReviewAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersistReviewUseCase {

    private final ReviewAdapter reviewAdapter;

    public String persistReview(ReviewBean reviewBean, String username) {
        return reviewAdapter.persistReview(reviewBean, username);
    }
}
