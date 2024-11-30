package com.madushan.Web.Auction.service;

import com.madushan.Web.Auction.bean.AuctionBean;
import com.madushan.Web.Auction.useCase.PersistAuctionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final PersistAuctionUseCase persistAuctionUseCase;

    public String createAuction(AuctionBean auctionBean, int userId) {
        return persistAuctionUseCase.createAuction(auctionBean, userId);
    }
}
