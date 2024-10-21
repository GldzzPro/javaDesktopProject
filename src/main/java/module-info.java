module tn.uvt.training.bookreservation {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires org.jfxtras.styles.jmetro;
    requires java.logging;
    requires spring.context;
    requires spring.boot;
    requires spring.beans;
    requires java.sql;

    opens tn.uvt.training.bookreservation;
    opens tn.uvt.training.bookreservation.controller;
    exports tn.uvt.training.bookreservation;
    exports tn.uvt.training.bookreservation.controller;
}