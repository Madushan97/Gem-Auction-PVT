package com.madushan.Web.Auction.service;

import com.madushan.Web.Auction.bean.AuctionBean;
import com.madushan.Web.Auction.database.auction.Auction;
import com.madushan.Web.Auction.useCase.GetAllAuctionUsecase;
import com.madushan.Web.Auction.useCase.PersistAuctionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final PersistAuctionUseCase persistAuctionUseCase;
    private final GetAllAuctionUsecase getAllAuctionUsecase;

    public String createAuction(AuctionBean auctionBean, String username) {
        return persistAuctionUseCase.createAuction(auctionBean, username);
    }

    public List<Auction> getAllAuction(String username) {
        return getAllAuctionUsecase.getAllAuctions(username);
    }
}
