package escape.code.controllers;

import com.google.inject.Inject;
import escape.code.core.stageManager.StageManager;
import escape.code.utils.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controls fxml file for the how to play scene
 */
public class HowToPlayController {

    @FXML
    private Button backToGame;

    @Inject
    private static StageManager stageManager;

    /**
     * Returns the scene to the main menu
     *
     * @param event
     * @throws IOException
     */
    public void backToMenu(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) this.backToGame.getScene().getWindow();
        stageManager.loadSceneToStage(currentStage, Constants.MENU_FXML_PATH);
    }
}
