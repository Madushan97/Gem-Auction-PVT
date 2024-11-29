package com.madushan.Web.Auction.service;

import com.madushan.Web.Auction.bean.AuctionBean;
import com.madushan.Web.Auction.useCase.CreateAuctionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final CreateAuctionUseCase createAuctionUseCase;

    public String createAuction(AuctionBean auctionBean) {
        return createAuctionUseCase.createAuction(auctionBean);
    }
}
