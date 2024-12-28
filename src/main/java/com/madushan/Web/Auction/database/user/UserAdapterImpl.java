package com.madushan.Web.Auction.database.user;

import com.madushan.Web.Auction.bean.DateRangeBean;
import com.madushan.Web.Auction.bean.GetUserBean;
import com.madushan.Web.Auction.bean.UserBean;
import com.madushan.Web.Auction.database.user.repository.UserRepository;
import com.madushan.Web.Auction.service.JwtService;
import com.madushan.Web.Auction.useCase.adapter.UserAdapter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAdapterImpl implements UserAdapter {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EntityManager entityManager;

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

    @Override
    public List<User> filterUserByDateRange(DateRangeBean dateRangeBean) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        if (dateRangeBean != null) {
            String startDateString = dateRangeBean.getStartDate() + " 00:00:00";
            String endDateString = dateRangeBean.getEndDate() + " 23:59:59";

            Timestamp startDate = Timestamp.valueOf(startDateString);
            Timestamp endDate = Timestamp.valueOf(endDateString);

            predicates.add(criteriaBuilder.between(root.get("createdAt"), startDate, endDate));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);
        List<User> filterResults = typedQuery.getResultList();
        return filterResults;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}
