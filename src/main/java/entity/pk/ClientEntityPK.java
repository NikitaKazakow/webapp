package entity.pk;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ClientEntityPK implements Serializable {
    private String passportSeriesClient;
    private String passportNumberClient;

    @Column(name = "passport_series_client", nullable = false, length = 4)
    @Id
    public String getPassportSeriesClient() {
        return passportSeriesClient;
    }

    public void setPassportSeriesClient(String passportSeriesClient) {
        this.passportSeriesClient = passportSeriesClient;
    }

    @Column(name = "passport_number_client", nullable = false, length = 6)
    @Id
    public String getPassportNumberClient() {
        return passportNumberClient;
    }

    public void setPassportNumberClient(String passportNumberClient) {
        this.passportNumberClient = passportNumberClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntityPK that = (ClientEntityPK) o;

        if (!Objects.equals(passportSeriesClient, that.passportSeriesClient))
            return false;
        return Objects.equals(passportNumberClient, that.passportNumberClient);
    }

    @Override
    public int hashCode() {
        int result = passportSeriesClient != null ? passportSeriesClient.hashCode() : 0;
        result = 31 * result + (passportNumberClient != null ? passportNumberClient.hashCode() : 0);
        return result;
    }
}
