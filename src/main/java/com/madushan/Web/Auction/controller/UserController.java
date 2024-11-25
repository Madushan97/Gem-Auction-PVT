package com.madushan.Web.Auction.controller;

import com.madushan.Web.Auction.bean.GetUserBean;
import com.madushan.Web.Auction.bean.UserBean;
import com.madushan.Web.Auction.service.UserService;
import com.madushan.Web.Auction.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createUser(@RequestBody UserBean userBean) {
        if (!userService.userExist(userBean)) {
            GetUserBean createdUser = userService.createUser(userBean);
            return new ResponseEntity<>(
                    new StandardResponse(
                            HttpStatus.CREATED.value(),
                            "User created",
                            createdUser
                    ),
                    HttpStatus.CREATED
            );
        } else {
            return new ResponseEntity<>(
                    new StandardResponse(
                            HttpStatus.BAD_REQUEST.value(),
                            "User already registered",
                            userBean
                    ),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
