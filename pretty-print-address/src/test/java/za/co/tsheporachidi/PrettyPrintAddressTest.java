package za.co.tsheporachidi;

import org.junit.Assert;
import org.junit.Test;
import za.co.tsheporachidi.address.Address;
import za.co.tsheporachidi.address.AddressLineDetails;
import za.co.tsheporachidi.address.AddressType;
import za.co.tsheporachidi.address.CountryType;
import za.co.tsheporachidi.address.EnumAddressType;
import za.co.tsheporachidi.address.ProvinceOrStateType;

public class PrettyPrintAddressTest {


    private PrettyPrintAddress prettyPrintAddress = new PrettyPrintAddress();
    private static final String EXPECTED_ADDRESS_OUTPUT = "Business Address: 100 Grayston Drive Sandown - Sandton - " +
            "Gauteng - 2196 - South Africa";

    private static Address getAddress(boolean withAddLineDetails, boolean withAddType) {
        Address address = new Address();
        if (withAddLineDetails) {
            AddressLineDetails addressLineDetail = new AddressLineDetails();
            addressLineDetail.setLine1("100 Grayston Drive");
            addressLineDetail.setLine2("Sandown");
            address.setAddressLineDetail(addressLineDetail);
        }
        address.setCityOrTown("Sandton");
        CountryType countryType = new CountryType();
        countryType.setCode("ZA");
        countryType.setName("South Africa");
        address.setCountry(countryType);
        address.setPostalCode("2196");
        if (withAddType) {
            AddressType addressType = new AddressType();
            addressType.setName(EnumAddressType.BUSINESS.getName());
            address.setType(addressType);
        }
        ProvinceOrStateType provinceOrState = new ProvinceOrStateType();
        provinceOrState.setName("Gauteng");
        address.setProvinceOrState(provinceOrState);
        return address;
    }

    @Test
    public void prettyPrintAddress() {
        Address address = getAddress(Boolean.TRUE, Boolean.TRUE);
        Assert.assertEquals("Testing Complete Address", EXPECTED_ADDRESS_OUTPUT
                , prettyPrintAddress.prettyPrintAddress(address));
    }

    @Test
    public void prettyPrintAddressNoAddressDeatils() {
        Address address = getAddress(Boolean.FALSE,Boolean.TRUE);
        Assert.assertEquals("Testing Complete Address", "Business Address:  - Sandton - Gauteng - 2196 - South Africa"
                , prettyPrintAddress.prettyPrintAddress(address));
    }


    @Test
    public void processAndPrintAddressInJsonFile() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void printAddressWithNoTypeProvided() {
        prettyPrintAddress.printAddress(getAddress(Boolean.TRUE,Boolean.FALSE));
    }

    @Test
    public void printAddress() {
        prettyPrintAddress.printAddress(getAddress(Boolean.TRUE,Boolean.TRUE));
    }

    @Test
    public void addressValidate() {
        prettyPrintAddress.processAndPrintAddressInJsonFile();
    }
}