package com.madushan.Web.Auction.controller;

import com.madushan.Web.Auction.bean.AuctionBean;
import com.madushan.Web.Auction.database.auction.Auction;
import com.madushan.Web.Auction.database.user.User;
import com.madushan.Web.Auction.service.AuctionService;
import com.madushan.Web.Auction.util.CustomUserDetails;
import com.madushan.Web.Auction.util.StandardResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionService auctionService;

    @PostMapping
    public ResponseEntity<StandardResponse> createAuction(@RequestBody AuctionBean auctionBean) {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String createdAuction = auctionService.createAuction(auctionBean, user.getUsername());
        return new ResponseEntity<>(
                new StandardResponse(
                        HttpStatus.CREATED.value(),
                        "Auction created",
                        createdAuction
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllAuction() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Auction> getAllAuction = auctionService.getAllAuction(user.getUsername());
        return new ResponseEntity<>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Get all action for user: " + user.getUsername(),
                        getAllAuction
                ),
                HttpStatus.OK
        );
    }
}
