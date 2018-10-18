package entities;

import entities.enums.Predictions;

import javax.persistence.*;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated
    private Predictions prediction;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Predictions getPrediction() {
        return this.prediction;
    }

    public void setPrediction(Predictions prediction) {
        this.prediction = prediction;
    }
}
