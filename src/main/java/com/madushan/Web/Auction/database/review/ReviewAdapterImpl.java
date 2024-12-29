package com.madushan.Web.Auction.database.review;

import com.madushan.Web.Auction.bean.ReviewBean;
import com.madushan.Web.Auction.database.review.repository.ReviewRepository;
import com.madushan.Web.Auction.service.AuctionService;
import com.madushan.Web.Auction.service.UserService;
import com.madushan.Web.Auction.useCase.adapter.ReviewAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewAdapterImpl implements ReviewAdapter {

    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final AuctionService auctionService;

    @Override
    public String persistReview(Review review, String username) {
        reviewRepository.save(review);
        return "Review successfully persisted";
    }

}
