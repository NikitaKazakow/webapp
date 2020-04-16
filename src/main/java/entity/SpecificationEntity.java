package entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@RequiredArgsConstructor
@Table(name = "specification", schema = "public", catalog = "webapp")
@SequenceGenerator(name = "seq_specification", sequenceName = "seq_specification", catalog = "webapp", schema = "public", allocationSize = 1)
public class SpecificationEntity {
    @Id
    @Column(name = "id_specification")
    @GeneratedValue(generator = "seq_specification")
    private Integer idSpecification;

    @Basic
    @Setter
    @NonNull
    @Column(name = "engine_type_specification", nullable = false, length = 30)
    private String engineTypeSpecification;

    @Basic
    @Setter
    @NonNull
    @Column(name = "engine_cylinder_count_specification", nullable = false)
    private int engineCylinderCountSpecification;

    @Basic
    @Setter
    @NonNull
    @Column(name = "engine_power_specification", nullable = false)
    private int enginePowerSpecification;

    @Basic
    @Setter
    @NonNull
    @Column(name = "body_type_specification", nullable = false, length = 30)
    private String bodyTypeSpecification;

    @Basic
    @Setter
    @NonNull
    @Column(name = "drive_type_specification", nullable = false, length = 15)
    private String driveTypeSpecification;

    @Basic
    @Setter
    @NonNull
    @Column(name = "gear_box_type_specification", nullable = false, length = 15)
    private String gearBoxTypeSpecification;

    @Basic
    @Setter
    @NonNull
    @Column(name = "doors_count_specification", nullable = false)
    private int doorsCountSpecification;
}
