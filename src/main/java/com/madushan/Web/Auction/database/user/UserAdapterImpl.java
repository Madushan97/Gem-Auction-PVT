package com.madushan.Web.Auction.database.user;

import com.madushan.Web.Auction.bean.GetUserBean;
import com.madushan.Web.Auction.bean.UserBean;
import com.madushan.Web.Auction.database.user.repository.UserRepository;
import com.madushan.Web.Auction.useCase.adapter.UserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAdapterImpl implements UserAdapter {

    private final UserRepository userRepository;

    @Override
    public GetUserBean createUser(UserBean user) {

        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setAddress(user.getAddress());
        newUser.setEmail(user.getEmail());

        User createdUser = userRepository.save(newUser);

        GetUserBean getUserBean = new GetUserBean();
        getUserBean.setUserName(createdUser.getUserName());
        getUserBean.setAddress(createdUser.getAddress());
        getUserBean.setEmail(createdUser.getEmail());
        getUserBean.setCreatedAt(createdUser.getCreatedAt());
        getUserBean.setUpdatedAt(createdUser.getUpdatedAt());
        getUserBean.setId(createdUser.getId());
        return getUserBean;
    }

    @Override
    public boolean userExist(UserBean userBean) {
        User existingUser = userRepository.findByUserName(userBean.getUserName());
        if (existingUser == null) {
            return false;
        } else {
            return true;
        }
    }
}
