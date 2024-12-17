package com.madushan.Web.Auction.util;

import com.madushan.Web.Auction.bean.GetUserBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse {

    private int code;
    private String message;
    private Object data;
}
