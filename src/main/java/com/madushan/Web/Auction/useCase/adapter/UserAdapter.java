package com.madushan.Web.Auction.useCase.adapter;

import com.madushan.Web.Auction.bean.GetUserBean;
import com.madushan.Web.Auction.bean.UserBean;

public interface UserAdapter {

    GetUserBean createUser(UserBean user);

    boolean userExist(UserBean userBean);

    String verifyUser(UserBean userBean);
}
