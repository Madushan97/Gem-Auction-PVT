package com.madushan.Web.Auction.mapper;

import com.madushan.Web.Auction.bean.ReviewBean;
import com.madushan.Web.Auction.database.auction.Auction;
import com.madushan.Web.Auction.database.review.Review;
import com.madushan.Web.Auction.database.user.User;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review toEntity(ReviewBean reviewBean, Auction auction, User user) {
        Review review = new Review();
        review.setAuction(auction);
        review.setComment(reviewBean.getComment());
        review.setRating(reviewBean.getRating());
        review.setUser(user);
        return review;
    }
}

