package entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "car", schema = "public", catalog = "webapp")
public class CarEntity {
    @Id
    @Column(name = "vin_number_car", nullable = false, length = 17)
    private String vinNumberCar;

    @Basic
    @Column(name = "year_of_issue_car", nullable = false)
    private Integer yearOfIssueCar;

    @Basic
    @Column(name = "colour_car", nullable = false, length = 30)
    private String colourCar;

    @Basic
    @Column(name = "mark_car", nullable = false, length = 30)
    private String markCar;

    @Basic
    @Column(name = "model_car", nullable = false, length = 30)
    private String modelCar;

    @Basic
    @Column(name = "manufacture_country", nullable = false, length = 50)
    private String manufactureCountry;

    @Basic
    @Column(name = "name_complectation_fk", length = 30)
    private String nameComplectationFk;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComplectationEntity> complectations;

    @OneToOne(mappedBy = "carByVinNumberCarFk")
    private SaleEntity sale;
}
