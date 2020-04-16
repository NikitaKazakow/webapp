package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "client", schema = "public", catalog = "webapp")
public class ClientEntity {
    @Id
    @Column(name = "passport_number_client", nullable = false, length = 10)
    private String passportNumber;

    @Basic
    @Column(name = "full_name_client", length = 50)
    private String fullNameClient;

    @Basic
    @Column(name = "phone_number_client", length = 11)
    private String phoneNumberClient;

    @Basic
    @Column(name = "home_address_client", length = 50)
    private String homeAddressClient;
}
