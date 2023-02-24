package cgm.model.enums;

public enum Transportation {
    BUS("автобус"),
    AIRPLANE("самолет"),
    CAR("собствен транспорт");

    public final String label;

    Transportation(String label) {
        this.label = label;
    }
}
