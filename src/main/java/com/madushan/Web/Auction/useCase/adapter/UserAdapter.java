package com.madushan.Web.Auction.useCase.adapter;

import com.madushan.Web.Auction.bean.DateRangeBean;
import com.madushan.Web.Auction.bean.GetUserBean;
import com.madushan.Web.Auction.bean.UserBean;
import com.madushan.Web.Auction.database.user.User;

import java.util.List;

public interface UserAdapter {

    GetUserBean createUser(UserBean user);

    boolean userExist(UserBean userBean);

    String verifyUser(UserBean userBean);

    List<User> filterUserByDateRange(DateRangeBean dateRangeBean);
}
