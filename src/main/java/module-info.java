module com.example.otp2demo3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.otp2demo3 to javafx.fxml;
    exports com.example.otp2demo3;
}