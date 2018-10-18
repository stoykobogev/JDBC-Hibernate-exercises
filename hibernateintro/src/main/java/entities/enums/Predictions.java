package entities.enums;

public enum Predictions {
    HOME_WIN("Home Team Win"),
    DRAW("Draw Game"),
    GUEST_WIN("Away Team Win");

    private final String prediction;
    Predictions(String prediction) {
        this.prediction = prediction;
    }

    public String getPrediction() {
        return this.prediction;
    }
}
