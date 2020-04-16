package entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", schema = "public", catalog = "webapp")
public class UserEntity {
    @Id
    @Column(name = "login_user", nullable = false, length = 20)
    private String loginUser;

    @Basic
    @Column(name = "password_user", nullable = false)
    private String passwordUser;

    @OneToMany(mappedBy = "user")
    private Collection<SaleEntity> salesByLoginUser;
}
