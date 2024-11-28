package com.madushan.Web.Auction.database.user;

import com.madushan.Web.Auction.bean.GetUserBean;
import com.madushan.Web.Auction.bean.UserBean;
import com.madushan.Web.Auction.database.user.repository.UserRepository;
import com.madushan.Web.Auction.service.JwtService;
import com.madushan.Web.Auction.useCase.adapter.UserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAdapterImpl implements UserAdapter {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public GetUserBean createUser(UserBean user) {

        User newUser = new User();
        newUser.setUserName(user.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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
        User existingUser = userRepository.findByUserName(userBean.getUsername());
        if (existingUser == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String verifyUser(UserBean userBean) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userBean.getUsername(), userBean.getPassword()));
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(userBean);
        }
        return "failure";
    }
}
