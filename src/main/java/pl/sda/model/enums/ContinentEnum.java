package pl.sda.model.enums;

public enum ContinentEnum {
    AFRICA("Africa"), ASIA("Asia"), EUROPE("Europe"), NORTH_AMERICA("North America"), SOUTH_AMERICA("South America"),
    ANTARCTICA("Antarctica"), AUSTRALIA("Australia");
    String name;

    ContinentEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
