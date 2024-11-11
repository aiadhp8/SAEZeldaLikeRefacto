module com.example.zeldalike {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.management;
    requires java.sql;
    requires junit;


    opens com.example.zeldalike to javafx.fxml;
    exports com.example.zeldalike;
    exports com.example.zeldalike.controlleurs;
    opens com.example.zeldalike.controlleurs to javafx.fxml;
    exports com.example.zeldalike.modele;
    opens com.example.zeldalike.modele to javafx.fxml;
    exports com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme;
    opens com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme to javafx.fxml;
    exports com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.gun;
    opens com.example.zeldalike.modele.entity.objetImmobile.objetRecuperable.arme.gun to javafx.fxml;
}