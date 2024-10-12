package tn.uvt.training.bookreservation.controller;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.uvt.training.bookreservation.UserService;

@Service
public class DashboardController {

    @Autowired
    private UserService userService;

    @FXML
    public void initialize() {
    }

}