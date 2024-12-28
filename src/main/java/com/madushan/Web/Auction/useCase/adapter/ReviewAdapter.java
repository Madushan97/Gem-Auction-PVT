package com.madushan.Web.Auction.useCase.adapter;

import com.madushan.Web.Auction.bean.ReviewBean;

public interface ReviewAdapter {

    String persistReview(ReviewBean reviewBean, String username);
}
