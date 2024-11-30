package com.madushan.Web.Auction.useCase;

import com.madushan.Web.Auction.bean.UserBean;
import com.madushan.Web.Auction.useCase.adapter.UserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckUserExistUseCase {

    private final UserAdapter userAdapter;

    public boolean userExist(UserBean userBean) {
        return userAdapter.userExist(userBean);
    }
}
