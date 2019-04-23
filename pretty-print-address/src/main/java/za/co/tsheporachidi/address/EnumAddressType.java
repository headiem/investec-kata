package za.co.tsheporachidi.address;

public enum EnumAddressType {
    PHYSICAL("Physical Address"), POSTAL("Postal Address"), BUSINESS("Business Address");
    private String name;

    EnumAddressType(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
