package com.madushan.Web.Auction.database.auction;

import com.madushan.Web.Auction.database.bid.Bid;
import com.madushan.Web.Auction.database.gem.Gem;
import com.madushan.Web.Auction.database.payment.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "auction")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Auction {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "auction_name", length = 200, nullable = false)
    private String auctionName;

    @Column(name = "description", length = 300, nullable = false)
    private String description;

    @Column(name = "start_date", nullable = false, updatable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false, updatable = false)
    private LocalDateTime endDate;

    @Column(name = "start_price", nullable = false, updatable = false)
    private BigDecimal startPrice;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "is_expired")
    private boolean isExpired;

    @Column(name = "user_name")
    private String userName;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Gem> gems;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Bid> bids;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Payment> payments;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
