package net.bytem0use.origins.enums;

public enum AbilityCategory {
    BLOCK("Block"),
    MOVEMENT("Movement"),
    CHARGE("Charge"),
    MODIFIER("Modifier"),
    COMBO("Combo");

    private String tag;

    private AbilityCategory(String tag) {
        this.tag = tag;
    }

    public String toString() {
        return this.tag;
    }
}
