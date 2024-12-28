package com.madushan.Web.Auction.database.review.repository;

import com.madushan.Web.Auction.database.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
