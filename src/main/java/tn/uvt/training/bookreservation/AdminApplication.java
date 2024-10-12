package tn.uvt.training.bookreservation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Objects;


public class AdminApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AdminApplication.class.getResource("views/login.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);  // Let Spring inject the controller
        stage.initStyle(StageStyle.DECORATED);  // Ensure it's decorated

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 320, 240);
        JMetro jMetro = new JMetrgo(Style.LIGHT);
        jMetro.setScene(scene);
        stage.getIcons().add(new Image(Objects.requireNonNull(AdminApplication.class.getResourceAsStream("images/books.png"))));
        stage.setTitle("Book Reservation");
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void stop() throws Exception {
        springContext.close();
    }

    private static ConfigurableApplicationContext springContext;
    @Override
    public void init() throws Exception {
        springContext = new SpringApplicationBuilder(AppConfig.class).run();
    }

    public static void main(String[] args) {
        launch();
    }

}