package com.madushan.Web.Auction.useCase;

import com.madushan.Web.Auction.database.user.User;
import com.madushan.Web.Auction.useCase.adapter.UserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetUserByGivenUsernameUseCase {

    private final UserAdapter userAdapter;

    public User getUserByUsername(String username) {
        return userAdapter.getUserByUsername(username);
    }
}
