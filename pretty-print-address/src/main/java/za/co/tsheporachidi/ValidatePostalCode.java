package za.co.tsheporachidi;

import za.co.tsheporachidi.address.Address;
import za.co.tsheporachidi.address.validate.ValidationRule;

import java.util.regex.Pattern;

public class ValidatePostalCode implements ValidationRule {
    private final static String POSTAL_CODE_PATTERN = "[0-9]+";
    private Pattern postalCodePattern = Pattern.compile(POSTAL_CODE_PATTERN);

    @Override
    public String validate(Address address) {
        StringBuilder sb = new StringBuilder();
        if(!postalCodePattern.matcher(address.getPostalCode()).matches()){
            sb.append("Postal Code for Address id: ")
                    .append(address.getId())
            .append(" can only be Numbers");
        }
        return sb.toString();
    }
}
