package cgm.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name="first-name")
    private String firstName;

    @Column(name="last-name", nullable = false)
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<RoleEntity> role;

    @ManyToOne(optional = false)
    private BranchEntity branch;


}
