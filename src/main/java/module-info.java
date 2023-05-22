module spaceinvader.spaceinvader {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                    requires org.kordamp.bootstrapfx.core;
                requires com.almasb.fxgl.all;
    requires javafx.graphics;

    opens spaceinvader.spaceinvader to javafx.fxml;
    exports spaceinvader.spaceinvader;
    exports spaceinvader.spaceinvader.controller;
    opens spaceinvader.spaceinvader.controller to javafx.fxml;
    exports spaceinvader.spaceinvader.model;
    opens spaceinvader.spaceinvader.model to javafx.fxml;
}