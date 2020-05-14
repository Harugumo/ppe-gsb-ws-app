package app.controleur;

import app.MainApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Le controleur pour le layout principal. Le layout principal fournit l'application de base
 * contenant une barre de menu et un espace d'affichage de composants JavaFX.
 * 
 * @author moi
 */
public class ControleurPrincipal {
   // Reference à l'application principale
   private MainApp mainApp;

   /**
    * Est appelé par l'application main pour récuperer sa propre référence.
    * 
    * @param mainApp
    */
   public void setMainApp(MainApp mainApp) {
      this.mainApp = mainApp;
   }
   

   /**
    * Ouvre une boite About.
    */
   @FXML
   private void handleAbout() {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Mission 3");
      alert.setHeaderText("A propos");
      alert.setContentText("Auteur: Quentin PERRET\nVersion: 03/2020\n");
      Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
      stage.getIcons().add(
            new Image(this.getClass().getResource("").toString()));

      alert.showAndWait();
   }

   /**
    * Fermeture de l'application.
    */
   @FXML
   private void handleQuitter() {
      Platform.exit();
   }
}
