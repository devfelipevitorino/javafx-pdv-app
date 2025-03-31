module com.devfelipevitorino.pdv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.devfelipevitorino.pdv to javafx.fxml;
    exports com.devfelipevitorino.pdv;
}