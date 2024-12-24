package com.madushan.Web.Auction.useCase;

import com.madushan.Web.Auction.database.auction.Auction;
import com.madushan.Web.Auction.useCase.adapter.AuctionAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllAuctionUsecase {

    private final AuctionAdapter auctionAdapter;

    public List<Auction> getAllAuctions(String username) {
        return auctionAdapter.getAllAuctions(username);
    }
}
