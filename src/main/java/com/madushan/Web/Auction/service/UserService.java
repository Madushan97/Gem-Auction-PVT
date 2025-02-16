package com.madushan.Web.Auction.service;

import com.madushan.Web.Auction.bean.GetUserBean;
import com.madushan.Web.Auction.bean.UserBean;
import com.madushan.Web.Auction.database.user.User;
import com.madushan.Web.Auction.exception.UserAlreadyExistsException;
import com.madushan.Web.Auction.useCase.GetUserByGivenUsernameUseCase;
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
    private final GetUserByGivenUsernameUseCase getUserByGivenUsernameUseCase;

    public GetUserBean createUser(UserBean userBean) {
        if (checkUserExistUseCase.userExist(userBean)) {
            throw new UserAlreadyExistsException("A user with this username already exists");
        }
        return persistUserUseCase.createUser(userBean);
    }

    public String verify(UserBean userBean) {
        return userVerifyUseCase.verifyUser(userBean);
    }

    public User getUserByUsername(String username) {
        return getUserByGivenUsernameUseCase.getUserByUsername(username);
    }
}
