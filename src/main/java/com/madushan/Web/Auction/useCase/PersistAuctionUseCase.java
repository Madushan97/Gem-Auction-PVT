package com.madushan.Web.Auction.useCase;

import com.madushan.Web.Auction.bean.AuctionBean;
import com.madushan.Web.Auction.useCase.adapter.AuctionAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersistAuctionUseCase {

    private final AuctionAdapter auctionAdapter;

    public String createAuction(AuctionBean auctionBean, String userName) {
        return auctionAdapter.createAuction(auctionBean, userName);
    }
}
