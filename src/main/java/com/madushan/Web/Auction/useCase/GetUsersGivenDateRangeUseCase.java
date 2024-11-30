package com.madushan.Web.Auction.useCase;

import com.madushan.Web.Auction.bean.DateRangeBean;
import com.madushan.Web.Auction.database.user.User;
import com.madushan.Web.Auction.useCase.adapter.UserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetUsersGivenDateRangeUseCase {

    private final UserAdapter userAdapter;

    public List<User> getUsersGivenDateRange(DateRangeBean dateRangeBean) {
        return userAdapter.filterUserByDateRange(dateRangeBean);
    }
}
