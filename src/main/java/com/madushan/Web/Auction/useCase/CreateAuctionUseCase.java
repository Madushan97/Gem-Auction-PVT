package com.madushan.Web.Auction.useCase;

import com.madushan.Web.Auction.bean.AuctionBean;
import com.madushan.Web.Auction.useCase.adapter.AuctionAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAuctionUseCase {

    private final AuctionAdapter auctionAdapter;

    public String createAuction(AuctionBean auctionBean) {
        return auctionAdapter.createAuction(auctionBean);
    }
}
