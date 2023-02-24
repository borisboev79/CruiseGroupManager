package cgm.service;

import cgm.model.entity.RoleEntity;
import cgm.model.enums.Role;
import cgm.repository.RoleRepository;
import cgm.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public InitService(RoleRepository roleRepository,
                       UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        initRoles();
        initUsers();
    }

    private void initRoles() {
        if (roleRepository.count() == 0) {
            List<RoleEntity> roles = List.of(
                    RoleEntity.builder().role(Role.MANAGER).description("Branch managers can add users.").build(),
                    RoleEntity.builder().role(Role.ADMIN).description("Admins can add groups, users and all.").build(),
                    RoleEntity.builder().role(Role.USER).description("Users can only add guests to groups.").build()
            );

            this.roleRepository.saveAllAndFlush(roles);
        }
    }

    private void initUsers() {
 /*       if (userRepository.count() == 0) {
            initAdmin();
            initModerator();
            initNormalUser();
        }*/
    }

   /* private void initAdmin() {
        var adminUser = new UserEntity().
                setEmail("admin@example.com").
                setFirstName("Admin").
                setLastName("Adminov").
                setPassword(passwordEncoder.encode("topsecret")).
                setRoles(userRoleRepository.findAll());

        userRepository.save(adminUser);
    }

    private void initModerator() {

        var moderatorRole = userRoleRepository.
                findUserRoleEntityByRole(UserRoleEnum.MODERATOR).orElseThrow();

        var moderatorUser = new UserEntity().
                setEmail("moderator@example.com").
                setFirstName("Moderator").
                setLastName("Moderatorov").
                setPassword(passwordEncoder.encode("topsecret")).
                setRoles(List.of(moderatorRole));

        userRepository.save(moderatorUser);
    }

    private void initNormalUser() {

        var normalUser = new UserEntity().
                setEmail("user@example.com").
                setFirstName("User").
                setLastName("Userov").
                setPassword(passwordEncoder.encode("topsecret"));

        userRepository.save(normalUser);
    }*/
}

