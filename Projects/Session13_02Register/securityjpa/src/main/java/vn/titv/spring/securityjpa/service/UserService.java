package vn.titv.spring.securityjpa.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import vn.titv.spring.securityjpa.entity.User;

public interface UserService extends UserDetailsService {
    public User findByUsername(String username);
    public void save(User user);
}
