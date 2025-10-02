package model;

public enum Category{
    ACASA("Acasă"),
    SCOALA("Școală"),
    MUNCA("Muncă"),
    PERSONAL("Personal"),
    CUMPARATURI("Cumpărături");
    
    private String displayName;
    
    Category(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
