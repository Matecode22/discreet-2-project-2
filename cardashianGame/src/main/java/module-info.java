module com.example.cardashiangame1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.almasb.fxgl.all;
    requires annotations;

    opens com.example.cardashiangame1 to javafx.fxml;
    exports com.example.cardashiangame1;
}