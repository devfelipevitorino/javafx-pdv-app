module com.devfelipevitorino.pdv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.devfelipevitorino.pdv to javafx.fxml;
    exports com.devfelipevitorino.pdv.Login;
    opens com.devfelipevitorino.pdv.Login to javafx.fxml;

    exports com.devfelipevitorino.pdv.Cadastrar;
    opens com.devfelipevitorino.pdv.Cadastrar to javafx.fxml;

    exports com.devfelipevitorino.pdv.TelaDeVendas;
    opens com.devfelipevitorino.pdv.TelaDeVendas to javafx.fxml;
}