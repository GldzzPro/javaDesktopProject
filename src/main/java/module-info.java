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

    opens tn.uvt.training.bookreservation to javafx.fxml;
    exports tn.uvt.training.bookreservation;
}