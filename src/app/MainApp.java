package app;

import java.io.IOException;

import app.controleur.ControleurPrincipal;
import app.controleur.IControleurApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    private final String TITRE = "Mission 3";

    private Stage primaryStage;
    private BorderPane principal;

    /**
     * Constructor
     */
    public MainApp() {
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(TITRE);

        // Affecte une icone personnalisée.
        this.primaryStage.getIcons().add(
                new Image(this.getClass()
                        .getResource("").toString())); ///images/balanceblanche.png

        initRootLayout();
    }

    private void initRootLayout() {
        try {
            // Charge la vue racine à partir du fichier fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("vue/VuePrincipale.fxml"));
            principal = (BorderPane) loader.load();

            // Affiche la scene dans le layout racine.
            Scene scene = new Scene(principal);
            primaryStage.setScene(scene);

            // Donne l'accès au controleur à l'application main.
            ControleurPrincipal controleur = loader.getController();
            controleur.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afficheVue(String laVue) {
        try {
            // Charge la vue laVue.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(laVue));
            AnchorPane vuePoids = (AnchorPane) loader.load();

            // Positionne la vuePoids au centre de l'affichage racine.
            principal.setCenter(vuePoids);

            // Donne l'accès au contrôleur par l'application main.
            IControleurApp controleur = loader.getController();
            controleur.setMainApp(this);
            this.primaryStage.setTitle(TITRE + controleur.getNOMMETHODE());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retourne le stage principal.
     * 
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}