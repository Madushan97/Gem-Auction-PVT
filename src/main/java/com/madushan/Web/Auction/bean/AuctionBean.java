package com.madushan.Web.Auction.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuctionBean {

    private String auctionName;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal startPrice;
}
