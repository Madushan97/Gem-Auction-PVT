package com.madushan.Web.Auction.database.user.repository;

import com.madushan.Web.Auction.database.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Integer> {

}
