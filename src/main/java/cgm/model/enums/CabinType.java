package cgm.model.enums;

import lombok.Getter;

@Getter
public enum CabinType {
    INSIDE("Вътрешна"),
    OUTSIDE("Външна"),
    BALCONY("Балкон"),
    SUITE("Апартамент");

    public final String label;

    CabinType(String label){
        this.label = label;
    }
}
