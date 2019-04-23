package za.co.tsheporachidi;

import za.co.tsheporachidi.address.Address;
import za.co.tsheporachidi.address.validate.ValidationRule;

public class ValidateCountry implements ValidationRule {
    @Override
    public String validate(Address address) {
        StringBuilder sb = new StringBuilder();
        if (address.getCountry() == null
                || address.getCountry().getName() == null
                || address.getCountry().getName().trim().equals("")) {
            sb.append("Country for Address id: ").append(address.getId()).append(" can not be null\n");
        }
        if (address.getCountry().getName().equals("ZA")) {
            if (address.getProvinceOrState() == null
                    || address.getProvinceOrState().getName() == null
                    || address.getProvinceOrState().getName().trim().equals("")) {
                sb.append("Country ZA for Address id: ").append(address.getId()).append(", Province is required");
            }
        }
        return sb.toString();
    }
}
