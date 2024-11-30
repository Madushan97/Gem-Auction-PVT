package com.madushan.Web.Auction.service;

import com.madushan.Web.Auction.bean.GetUserBean;
import com.madushan.Web.Auction.bean.UserBean;
import com.madushan.Web.Auction.useCase.PersistUserUseCase;
import com.madushan.Web.Auction.useCase.CheckUserExistUseCase;
import com.madushan.Web.Auction.useCase.UserVerifyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PersistUserUseCase persistUserUseCase;
    private final CheckUserExistUseCase checkUserExistUseCase;
    private final UserVerifyUseCase userVerifyUseCase;

    public GetUserBean createUser(UserBean userBean) {
        return persistUserUseCase.createUser(userBean);
    }

    public boolean userExist(UserBean userBean) {
        return checkUserExistUseCase.userExist(userBean);
    }

    public String verify(UserBean userBean) {
        return userVerifyUseCase.verifyUser(userBean);
    }
}
