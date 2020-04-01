package entity;

import entity.pk.ComplectationEntityPK;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "complectation", schema = "public", catalog = "webapp")
@IdClass(ComplectationEntityPK.class)
public class ComplectationEntity {
    private int idComplectation;
    private String vinNumberCarFk;
    private String nameComplectation;
    private BigInteger priceComplectation;
    private CarEntity carByVinNumberCarFk;
    private Collection<SpecificationEntity> specifications;

    @Id
    @Column(name = "id_complectation", nullable = false)
    public int getIdComplectation() {
        return idComplectation;
    }

    public void setIdComplectation(int idComplectation) {
        this.idComplectation = idComplectation;
    }

    @Id
    @Column(name = "vin_number_car_fk", nullable = false, length = 17)
    public String getVinNumberCarFk() {
        return vinNumberCarFk;
    }

    public void setVinNumberCarFk(String vinNumberCarFk) {
        this.vinNumberCarFk = vinNumberCarFk;
    }

    @Basic
    @Column(name = "name_complectation", nullable = false, length = 30)
    public String getNameComplectation() {
        return nameComplectation;
    }

    public void setNameComplectation(String nameComplectation) {
        this.nameComplectation = nameComplectation;
    }

    @Basic
    @Column(name = "price_complectation", nullable = false)
    public BigInteger getPriceComplectation() {
        return priceComplectation;
    }

    public void setPriceComplectation(BigInteger priceComplectation) {
        this.priceComplectation = priceComplectation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplectationEntity that = (ComplectationEntity) o;

        if (idComplectation != that.idComplectation) return false;
        if (!Objects.equals(vinNumberCarFk, that.vinNumberCarFk))
            return false;
        if (!Objects.equals(nameComplectation, that.nameComplectation))
            return false;
        return Objects.equals(priceComplectation, that.priceComplectation);
    }

    @Override
    public int hashCode() {
        int result = idComplectation;
        result = 31 * result + (vinNumberCarFk != null ? vinNumberCarFk.hashCode() : 0);
        result = 31 * result + (nameComplectation != null ? nameComplectation.hashCode() : 0);
        result = 31 * result + (priceComplectation != null ? priceComplectation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "vin_number_car_fk", referencedColumnName = "vin_number_car", insertable = false, updatable = false)
    public CarEntity getCarByVinNumberCarFk() {
        return carByVinNumberCarFk;
    }

    public void setCarByVinNumberCarFk(CarEntity carByVinNumberCarFk) {
        this.carByVinNumberCarFk = carByVinNumberCarFk;
    }

    @OneToMany(mappedBy = "complectation")
    public Collection<SpecificationEntity> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Collection<SpecificationEntity> specifications) {
        this.specifications = specifications;
    }
}
