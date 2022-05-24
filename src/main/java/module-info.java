module hu.leczildiko.tictactoefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens hu.leczildiko.tictactoefx to javafx.fxml;
    exports hu.leczildiko.tictactoefx;
}