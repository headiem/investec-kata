package za.co.tsheporachidi.address;

import java.io.Serializable;

public class Address implements Serializable {
    private String id;
    private AddressType type;
    private AddressLineDetails addressLineDetail;
    private ProvinceOrStateType provinceOrState;
    private String cityOrTown;
    private CountryType country;
    private String postalCode;
    private String suburbOrDistrict;
    private String lastUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public AddressLineDetails getAddressLineDetail() {
        return addressLineDetail;
    }

    public void setAddressLineDetail(AddressLineDetails addressLineDetail) {
        this.addressLineDetail = addressLineDetail;
    }

    public ProvinceOrStateType getProvinceOrState() {
        return provinceOrState;
    }

    public void setProvinceOrState(ProvinceOrStateType provinceOrState) {
        this.provinceOrState = provinceOrState;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public void setCityOrTown(String cityOrTown) {
        this.cityOrTown = cityOrTown;
    }

    public CountryType getCountry() {
        return country;
    }

    public void setCountry(CountryType country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getSuburbOrDistrict() {
        return suburbOrDistrict;
    }

    public void setSuburbOrDistrict(String suburbOrDistrict) {
        this.suburbOrDistrict = suburbOrDistrict;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
