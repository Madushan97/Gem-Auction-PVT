package com.madushan.Web.Auction.useCase.adapter;

import com.madushan.Web.Auction.bean.ReviewBean;
import com.madushan.Web.Auction.database.review.Review;

public interface ReviewAdapter {

    String persistReview(Review review, String username);
}
