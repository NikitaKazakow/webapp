package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "car", schema = "public", catalog = "webapp")
public class CarEntity {
    private String vinNumberCar;
    private Integer yearOfIssueCar;
    private String colourCar;
    private String markCar;
    private String modelCar;
    private String manufactureCountry;
    private Collection<ComplectationEntity> complectationsByVinNumberCar;
    private Collection<SaleEntity> salesByVinNumberCar;

    @Id
    @Column(name = "vin_number_car", nullable = false, length = 17)
    public String getVinNumberCar() {
        return vinNumberCar;
    }

    public void setVinNumberCar(String vinNumberCar) {
        this.vinNumberCar = vinNumberCar;
    }

    @Basic
    @Column(name = "year_of_issue_car", nullable = false)
    public Integer getYearOfIssueCar() {
        return yearOfIssueCar;
    }

    public void setYearOfIssueCar(Integer yearOfIssueCar) {
        this.yearOfIssueCar = yearOfIssueCar;
    }

    @Basic
    @Column(name = "colour_car", nullable = false, length = 30)
    public String getColourCar() {
        return colourCar;
    }

    public void setColourCar(String colourCar) {
        this.colourCar = colourCar;
    }

    @Basic
    @Column(name = "mark_car", nullable = false, length = 30)
    public String getMarkCar() {
        return markCar;
    }

    public void setMarkCar(String markCar) {
        this.markCar = markCar;
    }

    @Basic
    @Column(name = "model_car", nullable = false, length = 30)
    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    @Basic
    @Column(name = "manufacture_country", nullable = false, length = 50)
    public String getManufactureCountry() {
        return manufactureCountry;
    }

    public void setManufactureCountry(String manufactureCountry) {
        this.manufactureCountry = manufactureCountry;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarEntity carEntity = (CarEntity) o;

        if (!Objects.equals(vinNumberCar, carEntity.vinNumberCar))
            return false;
        if (!Objects.equals(yearOfIssueCar, carEntity.yearOfIssueCar))
            return false;
        if (!Objects.equals(colourCar, carEntity.colourCar)) return false;
        if (!Objects.equals(modelCar, carEntity.modelCar)) return false;
        if (!Objects.equals(markCar, carEntity.markCar)) return false;
        return  Objects.equals(manufactureCountry, carEntity.manufactureCountry);
    }

    @Override
    public int hashCode() {
        int result = vinNumberCar != null ? vinNumberCar.hashCode() : 0;
        result = (31 * result) + ((yearOfIssueCar != null) ? yearOfIssueCar.hashCode() : 0);
        result = (31 * result) + ((colourCar != null) ? colourCar.hashCode() : 0);
        result = (31 * result) + ((modelCar != null) ? modelCar.hashCode() : 0);
        result = (31 * result) + ((manufactureCountry != null) ? manufactureCountry.hashCode() : 0);
        result = (31 * result) + ((markCar != null) ? markCar.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "carByVinNumberCarFk")
    public Collection<ComplectationEntity> getComplectationsByVinNumberCar() {
        return complectationsByVinNumberCar;
    }

    public void setComplectationsByVinNumberCar(Collection<ComplectationEntity> complectationsByVinNumberCar) {
        this.complectationsByVinNumberCar = complectationsByVinNumberCar;
    }

    @OneToMany(mappedBy = "carByVinNumberCarFk")
    public Collection<SaleEntity> getSalesByVinNumberCar() {
        return salesByVinNumberCar;
    }

    public void setSalesByVinNumberCar(Collection<SaleEntity> salesByVinNumberCar) {
        this.salesByVinNumberCar = salesByVinNumberCar;
    }
}
