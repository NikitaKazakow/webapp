package entity;

import entity.pk.ClientEntityPK;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "client", schema = "public", catalog = "webapp")
@IdClass(ClientEntityPK.class)
public class ClientEntity {
    private String passportSeriesClient;
    private String passportNumberClient;
    private String fullNameClient;
    private String phoneNumberClient;
    private String homeAddressClient;
    private Collection<SaleEntity> sales;

    @Id
    @Column(name = "passport_series_client", nullable = false, length = 4)
    public String getPassportSeriesClient() {
        return passportSeriesClient;
    }

    public void setPassportSeriesClient(String passportSeriesClient) {
        this.passportSeriesClient = passportSeriesClient;
    }

    @Id
    @Column(name = "passport_number_client", nullable = false, length = 6)
    public String getPassportNumberClient() {
        return passportNumberClient;
    }

    public void setPassportNumberClient(String passportNumberClient) {
        this.passportNumberClient = passportNumberClient;
    }

    @Basic
    @Column(name = "full_name_client", nullable = false, length = 50)
    public String getFullNameClient() {
        return fullNameClient;
    }

    public void setFullNameClient(String fullNameClient) {
        this.fullNameClient = fullNameClient;
    }

    @Basic
    @Column(name = "phone_number_client", nullable = false, length = 11)
    public String getPhoneNumberClient() {
        return phoneNumberClient;
    }

    public void setPhoneNumberClient(String phoneNumberClient) {
        this.phoneNumberClient = phoneNumberClient;
    }

    @Basic
    @Column(name = "home_address_client", nullable = false, length = 50)
    public String getHomeAddressClient() {
        return homeAddressClient;
    }

    public void setHomeAddressClient(String homeAddressClient) {
        this.homeAddressClient = homeAddressClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (passportSeriesClient != null ? !passportSeriesClient.equals(that.passportSeriesClient) : that.passportSeriesClient != null)
            return false;
        if (passportNumberClient != null ? !passportNumberClient.equals(that.passportNumberClient) : that.passportNumberClient != null)
            return false;
        if (fullNameClient != null ? !fullNameClient.equals(that.fullNameClient) : that.fullNameClient != null)
            return false;
        if (phoneNumberClient != null ? !phoneNumberClient.equals(that.phoneNumberClient) : that.phoneNumberClient != null)
            return false;
        if (homeAddressClient != null ? !homeAddressClient.equals(that.homeAddressClient) : that.homeAddressClient != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = passportSeriesClient != null ? passportSeriesClient.hashCode() : 0;
        result = 31 * result + (passportNumberClient != null ? passportNumberClient.hashCode() : 0);
        result = 31 * result + (fullNameClient != null ? fullNameClient.hashCode() : 0);
        result = 31 * result + (phoneNumberClient != null ? phoneNumberClient.hashCode() : 0);
        result = 31 * result + (homeAddressClient != null ? homeAddressClient.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "client")
    public Collection<SaleEntity> getSales() {
        return sales;
    }

    public void setSales(Collection<SaleEntity> sales) {
        this.sales = sales;
    }
}
