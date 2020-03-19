package entity.pk;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ComplectationEntityPK implements Serializable {
    private int idComplectation;
    private String vinNumberCarFk;

    @Column(name = "id_complectation", nullable = false)
    @Id
    public int getIdComplectation() {
        return idComplectation;
    }

    public void setIdComplectation(int idComplectation) {
        this.idComplectation = idComplectation;
    }

    @Column(name = "vin_number_car_fk", nullable = false, length = 17)
    @Id
    public String getVinNumberCarFk() {
        return vinNumberCarFk;
    }

    public void setVinNumberCarFk(String vinNumberCarFk) {
        this.vinNumberCarFk = vinNumberCarFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplectationEntityPK that = (ComplectationEntityPK) o;

        if (idComplectation != that.idComplectation) return false;
        if (vinNumberCarFk != null ? !vinNumberCarFk.equals(that.vinNumberCarFk) : that.vinNumberCarFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idComplectation;
        result = 31 * result + (vinNumberCarFk != null ? vinNumberCarFk.hashCode() : 0);
        return result;
    }
}
