package com.madushan.Web.Auction.useCase;

import com.madushan.Web.Auction.bean.UserBean;
import com.madushan.Web.Auction.useCase.adapter.UserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserVerifyUseCase {

    private final UserAdapter userAdapter;

    public String verifyUser(UserBean userBean) {
        return userAdapter.verifyUser(userBean);
    }
}
