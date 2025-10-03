
public enum Category {
    ACASA("Acasă"),
    SCOALA("Școală"),
    MUNCA("Muncă"),
    PERSONAL("Personal"),
    CUMPARATURI("Cumpărături");

    private String Title;

    Category(String displayName) {
        this.Title = displayName;
    }

    public String getTitle() {
        return Title;
    }
}
