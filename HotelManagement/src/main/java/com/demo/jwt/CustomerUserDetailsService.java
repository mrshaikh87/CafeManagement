package com.demo.jwt;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerUsersDetailsService implements UserDetailsService {
    private final UserDao userDao;
    private User userDetail;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername {}", username);
        userDetail = userDao.findByEmailId(username);
        if(!Objects.isNull(userDetail))
            return new org.springframework.security.core.userdetails.User(userDetail.getEmail(), userDetail.getPassword(),new ArrayList<>());
        else throw new UsernameNotFoundException("User not found");
    }
    public User getUserDetail(){
        return userDetail;
    }
}