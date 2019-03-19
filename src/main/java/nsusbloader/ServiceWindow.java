package nsusbloader;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

import java.util.Optional;

public class ServiceWindow   {
    /**
     * Create window with notification
     * */
    public static void getErrorNotification(String title, String body){
        Alert alertBox = new Alert(Alert.AlertType.ERROR);
        alertBox.setTitle(title);
        alertBox.setHeaderText(null);
        alertBox.setContentText(body);
        alertBox.getDialogPane().setMinWidth(Region.USE_PREF_SIZE);
        alertBox.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alertBox.setResizable(true);        // Java bug workaround for JDR11/OpenJFX. TODO: nothing. really.
        alertBox.setResizable(false);
        alertBox.getDialogPane().getStylesheets().add(AppPreferences.getInstance().getTheme());
        alertBox.show();
    }
    /**
     * Create notification window with confirm/deny
     * */
    public static boolean getConfirmationWindow(String title, String body){
        Alert alertBox = new Alert(Alert.AlertType.CONFIRMATION);
        alertBox.setTitle(title);
        alertBox.setHeaderText(null);
        alertBox.setContentText(body);
        alertBox.getDialogPane().setMinWidth(Region.USE_PREF_SIZE);
        alertBox.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alertBox.setResizable(true);        // Java bug workaround for JDR11/OpenJFX. TODO: nothing. really.
        alertBox.getDialogPane().getStylesheets().add(AppPreferences.getInstance().getTheme());
        Optional<ButtonType> result = alertBox.showAndWait();

        return (result.isPresent() && result.get() == ButtonType.OK);
    }
}
