module com.devfelipevitorino.pdv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;
    requires jbcrypt;

    opens com.devfelipevitorino.pdv to javafx.fxml;
    exports com.devfelipevitorino.pdv.Login.TelaDeLogin;
    opens com.devfelipevitorino.pdv.Login.TelaDeLogin to javafx.fxml;

    exports com.devfelipevitorino.pdv.Login.TelaCadastroUsuario;
    opens com.devfelipevitorino.pdv.Login.TelaCadastroUsuario to javafx.fxml;

    exports com.devfelipevitorino.pdv.TelaDeVendas;
    opens com.devfelipevitorino.pdv.TelaDeVendas to javafx.fxml;
    exports com.devfelipevitorino.pdv;
}