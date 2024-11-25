package com.madushan.Web.Auction.useCase;

import com.madushan.Web.Auction.bean.GetUserBean;
import com.madushan.Web.Auction.bean.UserBean;
import com.madushan.Web.Auction.useCase.adapter.UserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserAdapter userAdapter;


    public GetUserBean createUser(UserBean userBean) {
        return userAdapter.createUser(userBean);
    }
}
