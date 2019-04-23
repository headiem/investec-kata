package za.co.tsheporachidi.address.validate;

import za.co.tsheporachidi.address.Address;

/**
 * this is an interface which is used as a basic validation rule base.
 * all our validation rules will implement this interface.
 */
public interface ValidationRule {
    String validate(Address address);
}
