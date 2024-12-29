package com.madushan.Web.Auction.useCase;

import com.madushan.Web.Auction.bean.ReviewBean;
import com.madushan.Web.Auction.database.auction.Auction;
import com.madushan.Web.Auction.database.review.Review;
import com.madushan.Web.Auction.database.user.User;
import com.madushan.Web.Auction.exception.UnknownRatingException;
import com.madushan.Web.Auction.mapper.ReviewMapper;
import com.madushan.Web.Auction.service.AuctionService;
import com.madushan.Web.Auction.service.UserService;
import com.madushan.Web.Auction.useCase.adapter.ReviewAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewUseCase {

    private final ReviewAdapter reviewAdapter;
    private final ReviewMapper reviewMapper;
    private final AuctionService auctionService;
    private final UserService userService;

    public String persistReview(ReviewBean reviewBean, String username) {
        Auction auction = auctionService.getAuctionById(reviewBean.getAuctionId());
        User user = userService.getUserByUsername(username);
        Review review = reviewMapper.toEntity(reviewBean, auction, user);
        validateRating(reviewBean.getRating());
        return reviewAdapter.persistReview(review, username);
    }

    private void validateRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new UnknownRatingException("Rating must be between 1 and 5");
        }
    }
}
