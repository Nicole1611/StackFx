module com.mycompany.stackfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.stackfx.controller to javafx.fxml;
    exports com.mycompany.stackfx;
    exports com.mycompany.stackfx.controller;
    exports com.mycompany.stackfx.model;
    exports com.mycompany.stackfx.view;
}
