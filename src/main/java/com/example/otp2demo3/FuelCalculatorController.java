package com.example.otp2demo3;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Locale;
import java.util.ResourceBundle;
public class FuelCalculatorController {
    @FXML
    public Button btnEN, btnFR, btnJP, btnIR;
    @FXML private Label distanceLabel;
    @FXML private Label fuelLabel;
    @FXML private Button calculateButton;
    @FXML private Label resultLabel;
    @FXML private TextField distanceField;
    @FXML private TextField fuelField;


    private ResourceBundle bundle;
    private Locale locale;

    public void initialize() {
        // Default language (English)
        setLanguage("en", "US");  // Set the default to English
    }

    // Method to load the language based on language code and country code
    private void setLanguage(String lang, String country) {
        Locale locale = new Locale(lang, country);  // Create a new locale using language and country codes
        bundle = ResourceBundle.getBundle("message", locale);  // Load the ResourceBundle based on locale

        // Now update UI components with localized strings
        LoadLanguage();  // No parameters needed here
    }

    // Load language-specific values to UI components
    private void LoadLanguage() {
        distanceLabel.setText(bundle.getString("distance.label"));
        fuelLabel.setText(bundle.getString("fuel.label"));
        calculateButton.setText(bundle.getString("calculate.button"));
        resultLabel.setText(bundle.getString("result.label"));
    }

    // Method to handle button click event for English language button
    @FXML
    private void onbtnENClick() {
        setLanguage("en", "US");  // Set to English
    }

    // Method to handle button click event for French language button
    @FXML
    private void onbtnFRClick() {
        setLanguage("fr", "FR");  // Set to French
    }

    // Method to handle button click event for Japanese language button
    @FXML
    private void onbtnJPClick() {
        setLanguage("ja", "JP");  // Set to Japanese
    }

    // Method to handle button click event for Persian language button
    @FXML
    private void onbtnIRClick() {
        setLanguage("fa", "IR");  // Set to Persian (Farsi)
    }

    // Method to calculate fuel consumption when the Calculate button is clicked
    @FXML
    private void calculateFuelConsumption() {
        try {
            // Get the input values from the text fields
            String distanceText = distanceField.getText();
            String fuelText = fuelField.getText();

            // Convert input to double values
            double distance = Double.parseDouble(distanceText);
            double fuelUsed = Double.parseDouble(fuelText);

            // Validate inputs
            if (distance <= 0 || fuelUsed <= 0) {
                showInvalidInputMessage();
                return;
            }

            // Calculate the fuel consumption (liters per 100 km)
            double consumption = (fuelUsed / distance) * 100;

            // Display the result in the resultLabel
            resultLabel.setText(String.format(bundle.getString("result.label"), consumption));

        } catch (NumberFormatException e) {
            // Handle invalid input (non-numeric)
            showInvalidInputMessage();
        }
    }

    // Helper method to show an invalid input message
    private void showInvalidInputMessage() {
        resultLabel.setText(bundle.getString("invalid.input"));
    }

}
