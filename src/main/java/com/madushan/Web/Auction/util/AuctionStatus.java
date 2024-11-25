package com.madushan.Web.Auction.util;


public class AuctionStatus {

    private static final String created = "CREATED";
    private static final String in_progress = "IN-PROGRESS";
    private static final String Paused = "PAUSED";              // The auction has been temporarily paused or suspended.
    private static final String Scheduled = "SCHEDULED";        // The auction is planned and scheduled but hasn't started yet.
    private static final String cancelled = "CANCELLED";        // The auction has been canceled and will not take place.
    private static final String expired = "EXPIRED";            // The auction's time limit has been reached without being completed.
    private static final String failed = "FAILED";              // The auction failed due to an issue (e.g., no bids or technical errors).
    private static final String finalizing = "FINALIZING";      // The auction is in the final stage, where the winning bid is being processed or confirmed.
    private static final String archived = "ARCHIVED";          // The auction has been completed and is now stored for record purposes.

}
