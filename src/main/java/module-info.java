module com.praktikum.prak_pt02_2072030 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.praktikum.prak_pt02_2072030 to javafx.fxml;
    exports com.praktikum.prak_pt02_2072030;
    exports com.praktikum.prak_pt02_2072030.model;
    opens com.praktikum.prak_pt02_2072030.model to javafx.fxml;
}