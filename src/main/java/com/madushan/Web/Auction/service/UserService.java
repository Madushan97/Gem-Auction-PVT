package com.madushan.Web.Auction.service;

import com.madushan.Web.Auction.bean.GetUserBean;
import com.madushan.Web.Auction.bean.UserBean;
import com.madushan.Web.Auction.useCase.CreateUserUseCase;
import com.madushan.Web.Auction.useCase.UserExistUseCase;
import com.madushan.Web.Auction.useCase.UserVerifyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CreateUserUseCase createUserUseCase;
    private final UserExistUseCase userExistUseCase;
    private final UserVerifyUseCase userVerifyUseCase;

    public GetUserBean createUser(UserBean userBean) {
        return createUserUseCase.createUser(userBean);
    }

    public boolean userExist(UserBean userBean) {
        return userExistUseCase.userExist(userBean);
    }

    public String verify(UserBean userBean) {
        return userVerifyUseCase.verifyUser(userBean);
    }
}
