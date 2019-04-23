package za.co.tsheporachidi;

import za.co.tsheporachidi.address.Address;
import za.co.tsheporachidi.address.validate.ValidationRule;

public class ValidateAddressLine implements ValidationRule {
    @Override
    public String validate(Address address) {
        if(address.getAddressLineDetail()== null
            || ((address.getAddressLineDetail().getLine1()== null
            || address.getAddressLineDetail().getLine1().trim().equals(""))
            && (address.getAddressLineDetail().getLine2()== null
            || address.getAddressLineDetail().getLine2().trim().equals("")))){
            return "At least one address detail must be present for Address id: " + address.getId();
        }
        return "";
    }
}
