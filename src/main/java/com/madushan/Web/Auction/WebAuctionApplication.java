package com.madushan.Web.Auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebAuctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAuctionApplication.class, args);
	}

}
