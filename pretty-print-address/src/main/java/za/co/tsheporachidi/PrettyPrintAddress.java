package za.co.tsheporachidi;

import com.google.gson.Gson;
import za.co.tsheporachidi.address.Address;
import za.co.tsheporachidi.address.AddressLineDetails;
import za.co.tsheporachidi.address.EnumAddressType;
import za.co.tsheporachidi.address.validate.ValidationRule;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Pretty print address, this class is used to prett print the address to a format
 * Type: Line details - city - province/state - postal code - country!
 */
public class PrettyPrintAddress {

    // example Java function definition
    // a)Write a function to return a pretty print version of an address
    public String prettyPrintAddress(Address address) {
        return new StringBuilder().append(address.getType().getName())
                .append(": ")
                .append(lineDetails(address.getAddressLineDetail()))
                .append(" - ")
                .append(address.getCityOrTown())
                .append(" - ")
                .append(address.getProvinceOrState() != null ? address.getProvinceOrState().getName() : "")
                .append(" - ")
                .append(address.getPostalCode())
                .append(" - ")
                .append(address.getCountry() != null ? address.getCountry().getName() : "")
                .toString();
    }

    private String lineDetails(AddressLineDetails lineDetails) {
        StringBuilder sb = new StringBuilder();
        if (lineDetails != null) {
            sb.append(lineDetails.getLine1())
                    .append(" ")
                    .append(lineDetails.getLine2());
        }
        return sb.toString();
    }

    //b) Write a function to pretty print all the addresses in the attached file
    public void processAndPrintAddressInJsonFile() {
        FileInputStream fileReader = null;
        try {
            File addressFile = new File(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource("addresses.json")).getFile());
            fileReader = new FileInputStream(addressFile);
            byte[] bf = new byte[(int) addressFile.length()];
            fileReader.read(bf);
            String jsonAddresses = new String(bf);

            Gson gson = new Gson();
            Address[] addresses = gson.fromJson(jsonAddresses, Address[].class);

            for (Address address :
                    addresses) {
                System.out.println(addressValidate(address));
                System.out.println(prettyPrintAddress(address));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //c) Write a function to print an address of a certain type (postal, physical, business)
    public void printAddress(Address address) {
        if (address.getType() != null && (EnumAddressType.BUSINESS.getName().equals(address.getType().getName())
                || EnumAddressType.PHYSICAL.getName().equals(address.getType().getName())
                || EnumAddressType.POSTAL.getName().equals(address.getType().getName()))) {
            prettyPrintAddress(address);
        } else {
            StringBuilder sb = new StringBuilder();
            for (EnumAddressType enumAddressType :
                    EnumAddressType.values()) {
                sb.append(enumAddressType.getName()).append(" ");
            }
            throw new IllegalArgumentException("Address Type not allowed\nOnly :" + sb.toString());
        }
    }

    public String addressValidate(Address address) {
        final StringBuilder sb = new StringBuilder();
        List<ValidationRule> rules = new ArrayList<>();
        rules.add(new ValidatePostalCode());
        rules.add(new ValidateCountry());
        rules.add(new ValidateAddressLine());

        List<String> errors = new ArrayList<>();
        rules.forEach(rule -> {
            final String valid = rule.validate(address);
            if (!valid.trim().equals("")) {
                errors.add(valid);
            }
        });
        if (!errors.isEmpty()) {
            sb.append("\n***************************ERROR IDENTIFIED: START***************************\nValidation Error for Address ID: ")
                    .append(address.getId()).append("\n");
            errors.forEach(error -> sb.append(error).append("\n"));
            sb.append("***************************ERROR IDENTIFIED: END*****************************\n");
        }
        return sb.toString();
    }
}
