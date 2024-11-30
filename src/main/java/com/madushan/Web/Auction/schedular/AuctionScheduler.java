package com.madushan.Web.Auction.schedular;

import com.madushan.Web.Auction.database.user.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuctionScheduler {

    private final AuctionRepository auctionRepository;

    @Scheduled(fixedDelay = 5000)
    public void auctionExpirationChecker() {

    }

}
