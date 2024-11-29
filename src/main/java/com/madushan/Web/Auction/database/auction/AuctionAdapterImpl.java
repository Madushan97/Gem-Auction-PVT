package com.madushan.Web.Auction.database.auction;

import com.madushan.Web.Auction.bean.AuctionBean;
import com.madushan.Web.Auction.database.user.repository.AuctionRepository;
import com.madushan.Web.Auction.useCase.adapter.AuctionAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuctionAdapterImpl implements AuctionAdapter {

    private final AuctionRepository auctionRepository;

    @Override
    public String createAuction(AuctionBean auctionBean) {
        Auction auction = new Auction();
        auction.setAuctionName(auctionBean.getAuctionName());
        auction.setDescription(auctionBean.getDescription());
        auction.setStartDate(auctionBean.getStartDate());
        auction.setEndDate(auctionBean.getEndDate());
        auction.setStartPrice(auctionBean.getStartPrice());
        Auction createdAuction = auctionRepository.save(auction);
        return "Auction created with id: " + createdAuction.getId();
    }
}
