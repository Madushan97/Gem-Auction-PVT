package com.madushan.Web.Auction.database.auction;

import com.madushan.Web.Auction.bean.AuctionBean;
import com.madushan.Web.Auction.database.auction.repository.AuctionRepository;
import com.madushan.Web.Auction.useCase.adapter.AuctionAdapter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuctionAdapterImpl implements AuctionAdapter {

    private final Logger LOGGER = LoggerFactory.getLogger(AuctionAdapterImpl.class);
    private final AuctionRepository auctionRepository;

    @Override
    public String createAuction(AuctionBean auctionBean, String userName) {
        Auction auction = new Auction();
        auction.setAuctionName(auctionBean.getAuctionName());
        auction.setDescription(auctionBean.getDescription());
        auction.setStartDate(auctionBean.getStartDate());
        auction.setEndDate(auctionBean.getEndDate());
        auction.setStartPrice(auctionBean.getStartPrice());
        auction.setUserName(userName);
        auction.setExpired(false);
        Auction createdAuction = auctionRepository.save(auction);
        return "Auction created with id: " + createdAuction.getId();
    }

    @Override
    public List<Auction> getAllAuctions(String username) {
        List<Auction> auctionList = auctionRepository.findAllByUserName(username);
        LOGGER.info("Get all auctions for user: " + username + " successfully");
        return  auctionList;
    }

    @Override
    public Auction getAuctionById(int auctionId) {
        return auctionRepository.findById(auctionId).get();
    }
}
