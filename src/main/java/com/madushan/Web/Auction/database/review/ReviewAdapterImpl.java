package com.madushan.Web.Auction.database.review;

import com.madushan.Web.Auction.bean.ReviewBean;
import com.madushan.Web.Auction.database.auction.Auction;
import com.madushan.Web.Auction.database.review.repository.ReviewRepository;
import com.madushan.Web.Auction.database.user.User;
import com.madushan.Web.Auction.exception.UnknownRatingException;
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
    public String persistReview(ReviewBean reviewBean, String username) {
        Review review = new Review();
        Auction auction = auctionService.getAuctionById(reviewBean.getAuctionId());
        review.setAuction(auction);
        review.setComment(reviewBean.getComment());
        if (reviewBean.getRating() > 0 && reviewBean.getRating() < 6) {
            review.setRating(reviewBean.getRating());
        } else {
            throw new UnknownRatingException("Rates must between 1 and 5");
        }
        User user = userService.getUserByUsername(username);
        review.setUser(user);
        reviewRepository.save(review);
        return "Review successfully persist";
    }
}
