module com.devfelipevitorino.pdv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.devfelipevitorino.pdv to javafx.fxml;
    exports com.devfelipevitorino.pdv.Login;
    opens com.devfelipevitorino.pdv.Login to javafx.fxml;
}