package entity;

import entity.pk.SpecificationEntityPK;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "specification", schema = "public", catalog = "webapp")
@IdClass(SpecificationEntityPK.class)
public class SpecificationEntity {
    private int idSpecification;
    private int idComplectationSpecificationFk;
    private String vinNumberCarSpecificationFk;
    private String engineTypeSpecification;
    private int engineCylinderCountSpecification;
    private int enginePowerSpecification;
    private String bodyTypeSpecification;
    private String driveTypeSpecification;
    private String gearBoxTypeSpecification;
    private int doorsCountSpecification;
    private ComplectationEntity complectation;

    @Id
    @Column(name = "id_specification", nullable = false)
    public int getIdSpecification() {
        return idSpecification;
    }

    public void setIdSpecification(int idSpecification) {
        this.idSpecification = idSpecification;
    }

    @Id
    @Column(name = "id_complectation_specification_fk", nullable = false)
    public int getIdComplectationSpecificationFk() {
        return idComplectationSpecificationFk;
    }

    public void setIdComplectationSpecificationFk(int idComplectationSpecificationFk) {
        this.idComplectationSpecificationFk = idComplectationSpecificationFk;
    }

    @Id
    @Column(name = "vin_number_car_specification_fk", nullable = false, length = 17)
    public String getVinNumberCarSpecificationFk() {
        return vinNumberCarSpecificationFk;
    }

    public void setVinNumberCarSpecificationFk(String vinNumberCarSpecificationFk) {
        this.vinNumberCarSpecificationFk = vinNumberCarSpecificationFk;
    }

    @Basic
    @Column(name = "engine_type_specification", nullable = false, length = 30)
    public String getEngineTypeSpecification() {
        return engineTypeSpecification;
    }

    public void setEngineTypeSpecification(String engineTypeSpecification) {
        this.engineTypeSpecification = engineTypeSpecification;
    }

    @Basic
    @Column(name = "engine_cylinder_count_specification", nullable = false)
    public int getEngineCylinderCountSpecification() {
        return engineCylinderCountSpecification;
    }

    public void setEngineCylinderCountSpecification(int engineCylinderCountSpecification) {
        this.engineCylinderCountSpecification = engineCylinderCountSpecification;
    }

    @Basic
    @Column(name = "engine_power_specification", nullable = false)
    public int getEnginePowerSpecification() {
        return enginePowerSpecification;
    }

    public void setEnginePowerSpecification(int enginePowerSpecification) {
        this.enginePowerSpecification = enginePowerSpecification;
    }

    @Basic
    @Column(name = "body_type_specification", nullable = false, length = 30)
    public String getBodyTypeSpecification() {
        return bodyTypeSpecification;
    }

    public void setBodyTypeSpecification(String bodyTypeSpecification) {
        this.bodyTypeSpecification = bodyTypeSpecification;
    }

    @Basic
    @Column(name = "drive_type_specification", nullable = false, length = 15)
    public String getDriveTypeSpecification() {
        return driveTypeSpecification;
    }

    public void setDriveTypeSpecification(String driveTypeSpecification) {
        this.driveTypeSpecification = driveTypeSpecification;
    }

    @Basic
    @Column(name = "gear_box_type_specification", nullable = false, length = 15)
    public String getGearBoxTypeSpecification() {
        return gearBoxTypeSpecification;
    }

    public void setGearBoxTypeSpecification(String gearBoxTypeSpecification) {
        this.gearBoxTypeSpecification = gearBoxTypeSpecification;
    }

    @Basic
    @Column(name = "doors_count_specification", nullable = false)
    public int getDoorsCountSpecification() {
        return doorsCountSpecification;
    }

    public void setDoorsCountSpecification(int doorsCountSpecification) {
        this.doorsCountSpecification = doorsCountSpecification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecificationEntity that = (SpecificationEntity) o;

        if (idSpecification != that.idSpecification) return false;
        if (idComplectationSpecificationFk != that.idComplectationSpecificationFk) return false;
        if (engineCylinderCountSpecification != that.engineCylinderCountSpecification) return false;
        if (enginePowerSpecification != that.enginePowerSpecification) return false;
        if (doorsCountSpecification != that.doorsCountSpecification) return false;
        if (!Objects.equals(vinNumberCarSpecificationFk, that.vinNumberCarSpecificationFk))
            return false;
        if (!Objects.equals(engineTypeSpecification, that.engineTypeSpecification))
            return false;
        if (!Objects.equals(bodyTypeSpecification, that.bodyTypeSpecification))
            return false;
        if (!Objects.equals(driveTypeSpecification, that.driveTypeSpecification))
            return false;
        return Objects.equals(gearBoxTypeSpecification, that.gearBoxTypeSpecification);
    }

    @Override
    public int hashCode() {
        int result = idSpecification;
        result = 31 * result + idComplectationSpecificationFk;
        result = 31 * result + (vinNumberCarSpecificationFk != null ? vinNumberCarSpecificationFk.hashCode() : 0);
        result = 31 * result + (engineTypeSpecification != null ? engineTypeSpecification.hashCode() : 0);
        result = 31 * result + engineCylinderCountSpecification;
        result = 31 * result + enginePowerSpecification;
        result = 31 * result + (bodyTypeSpecification != null ? bodyTypeSpecification.hashCode() : 0);
        result = 31 * result + (driveTypeSpecification != null ? driveTypeSpecification.hashCode() : 0);
        result = 31 * result + (gearBoxTypeSpecification != null ? gearBoxTypeSpecification.hashCode() : 0);
        result = 31 * result + doorsCountSpecification;
        return result;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_complectation_specification_fk", referencedColumnName = "id_complectation", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "vin_number_car_specification_fk", referencedColumnName = "vin_number_car_fk", nullable = false, insertable = false, updatable = false)
    })
    public ComplectationEntity getComplectation() {
        return complectation;
    }

    public void setComplectation(ComplectationEntity complectation) {
        this.complectation = complectation;
    }
}
