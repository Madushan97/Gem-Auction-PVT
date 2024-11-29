package com.madushan.Web.Auction.controller;

import com.madushan.Web.Auction.bean.AuctionBean;
import com.madushan.Web.Auction.service.AuctionService;
import com.madushan.Web.Auction.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auction")
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionService auctionService;

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createAuction(@RequestBody AuctionBean auctionBean) {
        String createdAuction = auctionService.createAuction(auctionBean);
        return new ResponseEntity<>(
                new StandardResponse(
                        HttpStatus.CREATED.value(),
                        "Auction created",
                        createdAuction
                ),
                HttpStatus.CREATED
        );
    }
}
