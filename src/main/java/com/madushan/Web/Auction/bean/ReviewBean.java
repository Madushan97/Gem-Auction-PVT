package com.madushan.Web.Auction.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewBean {


    private int auctionId;
    private String comment;
    private int rating;
}
