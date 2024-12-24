package com.madushan.Web.Auction.useCase.adapter;

import com.madushan.Web.Auction.bean.AuctionBean;
import com.madushan.Web.Auction.database.auction.Auction;

import java.util.List;

public interface AuctionAdapter {

    String createAuction(AuctionBean auctionBean, String userName);

    List<Auction> getAllAuctions(String username);
}
