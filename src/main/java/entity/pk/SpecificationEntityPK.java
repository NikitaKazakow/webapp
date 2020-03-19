package entity.pk;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SpecificationEntityPK implements Serializable {
    private int idSpecification;
    private int idComplectationSpecificationFk;
    private String vinNumberCarSpecificationFk;

    @Column(name = "id_specification", nullable = false)
    @Id
    public int getIdSpecification() {
        return idSpecification;
    }

    public void setIdSpecification(int idSpecification) {
        this.idSpecification = idSpecification;
    }

    @Column(name = "id_complectation_specification_fk", nullable = false)
    @Id
    public int getIdComplectationSpecificationFk() {
        return idComplectationSpecificationFk;
    }

    public void setIdComplectationSpecificationFk(int idComplectationSpecificationFk) {
        this.idComplectationSpecificationFk = idComplectationSpecificationFk;
    }

    @Column(name = "vin_number_car_specification_fk", nullable = false, length = 17)
    @Id
    public String getVinNumberCarSpecificationFk() {
        return vinNumberCarSpecificationFk;
    }

    public void setVinNumberCarSpecificationFk(String vinNumberCarSpecificationFk) {
        this.vinNumberCarSpecificationFk = vinNumberCarSpecificationFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecificationEntityPK that = (SpecificationEntityPK) o;

        if (idSpecification != that.idSpecification) return false;
        if (idComplectationSpecificationFk != that.idComplectationSpecificationFk) return false;
        if (vinNumberCarSpecificationFk != null ? !vinNumberCarSpecificationFk.equals(that.vinNumberCarSpecificationFk) : that.vinNumberCarSpecificationFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSpecification;
        result = 31 * result + idComplectationSpecificationFk;
        result = 31 * result + (vinNumberCarSpecificationFk != null ? vinNumberCarSpecificationFk.hashCode() : 0);
        return result;
    }
}
