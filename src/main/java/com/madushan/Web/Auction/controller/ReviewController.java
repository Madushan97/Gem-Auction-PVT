package com.madushan.Web.Auction.controller;

import com.madushan.Web.Auction.bean.AuctionBean;
import com.madushan.Web.Auction.bean.ReviewBean;
import com.madushan.Web.Auction.service.AuthenticationService;
import com.madushan.Web.Auction.service.ReviewService;
import com.madushan.Web.Auction.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reviews")
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<StandardResponse> persistReview(@RequestBody ReviewBean reviewBean) {
        String username = authenticationService.getAuthenticatedUsername();
        String createdAuction = reviewService.persistReview(reviewBean, username);
        return new ResponseEntity<>(
                new StandardResponse(
                        HttpStatus.CREATED.value(),
                        "Review persisted",
                        createdAuction
                ),
                HttpStatus.CREATED
        );
    }

}
