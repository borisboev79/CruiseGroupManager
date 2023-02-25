package cgm.service;

import cgm.model.entity.RoleEntity;
import cgm.model.entity.UserEntity;
import cgm.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class ApplicationUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public ApplicationUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return
        userRepository.
            findUserEntityByUsername(username).
            map(this::map).
            orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));
  }

  private UserDetails map(UserEntity userEntity) {
    return new User(
        userEntity.getUsername(),
        userEntity.getPassword(),
        extractAuthorities(userEntity)
    );
  }

  private List<GrantedAuthority> extractAuthorities(UserEntity userEntity) {
    return userEntity.
        getRole().
        stream().
        map(this::mapRole).
        toList();
  }

  private GrantedAuthority mapRole(RoleEntity roleEntity) {
    return new SimpleGrantedAuthority("ROLE_" + roleEntity.getRole().name());
  }
}
