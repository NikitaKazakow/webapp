package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "car", schema = "public", catalog = "webapp")
public class CarEntity {
    private String vinNumberCar;
    private Date yearOfIssueCar;
    private String colourCar;
    private String modelCar;
    private String manufactureCountry;
    private Integer column6;
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
    public Date getYearOfIssueCar() {
        return yearOfIssueCar;
    }

    public void setYearOfIssueCar(Date yearOfIssueCar) {
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

    @Basic
    @Column(name = "column_6", nullable = true)
    public Integer getColumn6() {
        return column6;
    }

    public void setColumn6(Integer column6) {
        this.column6 = column6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarEntity carEntity = (CarEntity) o;

        if (vinNumberCar != null ? !vinNumberCar.equals(carEntity.vinNumberCar) : carEntity.vinNumberCar != null)
            return false;
        if (yearOfIssueCar != null ? !yearOfIssueCar.equals(carEntity.yearOfIssueCar) : carEntity.yearOfIssueCar != null)
            return false;
        if (colourCar != null ? !colourCar.equals(carEntity.colourCar) : carEntity.colourCar != null) return false;
        if (modelCar != null ? !modelCar.equals(carEntity.modelCar) : carEntity.modelCar != null) return false;
        if (manufactureCountry != null ? !manufactureCountry.equals(carEntity.manufactureCountry) : carEntity.manufactureCountry != null)
            return false;
        if (column6 != null ? !column6.equals(carEntity.column6) : carEntity.column6 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vinNumberCar != null ? vinNumberCar.hashCode() : 0;
        result = 31 * result + (yearOfIssueCar != null ? yearOfIssueCar.hashCode() : 0);
        result = 31 * result + (colourCar != null ? colourCar.hashCode() : 0);
        result = 31 * result + (modelCar != null ? modelCar.hashCode() : 0);
        result = 31 * result + (manufactureCountry != null ? manufactureCountry.hashCode() : 0);
        result = 31 * result + (column6 != null ? column6.hashCode() : 0);
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
