package com.madushan.Web.Auction.useCase;

import com.madushan.Web.Auction.database.auction.Auction;
import com.madushan.Web.Auction.useCase.adapter.AuctionAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAuctionByIdUseCase {

    private final AuctionAdapter auctionAdapter;

    public Auction getAuctionById(int auctionId) {
        return auctionAdapter.getAuctionById(auctionId);
    }
}
