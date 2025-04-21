module org.example.cpu_on_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.cpu_on_javafx to javafx.fxml;
    exports org.example.cpu_on_javafx;
}