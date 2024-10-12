package tn.uvt.training.bookreservation.controller;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.uvt.training.bookreservation.AdminApplication;
import tn.uvt.training.bookreservation.UserService;

@Controller
public class LoginController {
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label passwordFeedback;
    @FXML
    private Button loginButton;

    @Autowired
    private UserService userService;
    private final BooleanProperty error = new SimpleBooleanProperty(false);
    private final BooleanProperty pending = new SimpleBooleanProperty(false);

    @FXML
    public void initialize() {
        passwordFeedback.textProperty().bind(Bindings.createStringBinding(
                () -> error.get() ? "Wrong Password" : "", error
        ));
        passwordField.textProperty().addListener((_, _, _) -> {
            error.set(false);
        });
        loginButton.disableProperty().bind(pending);
        System.out.println(userService);
    }

    @FXML
    protected void onLogin() throws InterruptedException {
        pending.set(true);
        new Thread(() -> {
            var success = userService.connectToDatabase("booker", passwordField.getText());
            Platform.runLater(() -> {
                // if password is incorrect show error message
                if (success) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(AdminApplication.class.getResource("views/dashboard.fxml"));
                        Parent root = fxmlLoader.load();

                        // Get the current stage and set the new scene
                        Stage stage = (Stage) loginButton.getScene().getWindow();  // Get the current stage from the TextField
                        Screen screen = Screen.getPrimary();
                        Rectangle2D bounds = screen.getVisualBounds();

                        stage.setX(bounds.getMinX());
                        stage.setY(bounds.getMinY());
                        stage.setWidth(bounds.getWidth());
                        stage.setHeight(bounds.getHeight());
                        stage.setMaximized(true);
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                        return;
                    } catch (Exception e) {
                    }
                } else {
                    error.set(true);
                }
                pending.set(false);
            });
        }).start();
    }
}