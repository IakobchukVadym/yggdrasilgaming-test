package game.request;

public enum Function {
    AUTHENTICATE("authenticate"),
    PLAY("play");

    private String name;

    Function(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
