import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberGuesser1 {

    private static Map<String, String> countryCodes = new HashMap<>();
    private static Map<String, Integer> countryDigitLimits = new HashMap<>();

    static {
        
        countryCodes.put("1", "USA/Canada");
        countryCodes.put("7", "Russia/Kazakhstan");
        countryCodes.put("20", "Egypt");
        countryCodes.put("27", "South Africa");
        countryCodes.put("30", "Greece");
        countryCodes.put("31", "Netherlands");
        countryCodes.put("32", "Belgium");
        countryCodes.put("33", "France");
        countryCodes.put("34", "Spain");
        countryCodes.put("36", "Hungary");
        countryCodes.put("39", "Italy");
        countryCodes.put("40", "Romania");
        countryCodes.put("41", "Switzerland");
        countryCodes.put("43", "Austria");
        countryCodes.put("44", "United Kingdom");
        countryCodes.put("45", "Denmark");
        countryCodes.put("46", "Sweden");
        countryCodes.put("47", "Norway");
        countryCodes.put("48", "Poland");
        countryCodes.put("49", "Germany");
        countryCodes.put("51", "Peru");
        countryCodes.put("52", "Mexico");
        countryCodes.put("53", "Cuba");
        countryCodes.put("54", "Argentina");
        countryCodes.put("55", "Brazil");
        countryCodes.put("56", "Chile");
        countryCodes.put("57", "Colombia");
        countryCodes.put("58", "Venezuela");
        countryCodes.put("60", "Malaysia");
        countryCodes.put("61", "Australia");
        countryCodes.put("62", "Indonesia");
        countryCodes.put("63", "Philippines");
        countryCodes.put("64", "New Zealand");
        countryCodes.put("65", "Singapore");
        countryCodes.put("66", "Thailand");
        countryCodes.put("81", "Japan");
        countryCodes.put("82", "South Korea");
        countryCodes.put("84", "Vietnam");
        countryCodes.put("86", "China");
        countryCodes.put("90", "Turkey");
        countryCodes.put("91", "India");
        countryCodes.put("92", "Pakistan");
        countryCodes.put("93", "Afghanistan");
        countryCodes.put("94", "Sri Lanka");
        countryCodes.put("95", "Myanmar");
        countryCodes.put("98", "Iran");
        countryCodes.put("211", "South Sudan");
        countryCodes.put("212", "Morocco");
        countryCodes.put("213", "Algeria");
        countryCodes.put("216", "Tunisia");
        countryCodes.put("218", "Libya");
        countryCodes.put("220", "Gambia");
        countryCodes.put("221", "Senegal");
        countryCodes.put("222", "Mauritania");
        countryCodes.put("223", "Mali");
        countryCodes.put("224", "Guinea");
        countryCodes.put("225", "Ivory Coast");
        countryCodes.put("226", "Burkina Faso");
        countryCodes.put("227", "Niger");
        countryCodes.put("228", "Togo");
        countryCodes.put("229", "Benin");
        countryCodes.put("230", "Mauritius");
        countryCodes.put("231", "Liberia");
        countryCodes.put("232", "Sierra Leone");
        countryCodes.put("233", "Ghana");
        countryCodes.put("234", "Nigeria");
        countryCodes.put("235", "Chad");
        countryCodes.put("236", "Central African Republic");
        countryCodes.put("237", "Cameroon");
        countryCodes.put("238", "Cape Verde");
        countryCodes.put("239", "Sao Tome and Principe");
        countryCodes.put("240", "Equatorial Guinea");
        countryCodes.put("241", "Gabon");
        countryCodes.put("242", "Republic of the Congo");
        countryCodes.put("243", "Democratic Republic of the Congo");
        countryCodes.put("244", "Angola");
        countryCodes.put("245", "Guinea-Bissau");
        countryCodes.put("246", "British Indian Ocean Territory");
        countryCodes.put("248", "Seychelles");
        countryCodes.put("249", "Sudan");
        countryCodes.put("250", "Rwanda");
        countryCodes.put("251", "Ethiopia");
        countryCodes.put("252", "Somalia");
        countryCodes.put("253", "Djibouti");
        countryCodes.put("254", "Kenya");
        countryCodes.put("255", "Tanzania");
        countryCodes.put("256", "Uganda");
        countryCodes.put("257", "Burundi");
        countryCodes.put("258", "Mozambique");
        countryCodes.put("260", "Zambia");
        countryCodes.put("261", "Madagascar");
        countryCodes.put("262", "Reunion");
        countryCodes.put("263", "Zimbabwe");
        countryCodes.put("264", "Namibia");
        countryCodes.put("265", "Malawi");
        countryCodes.put("266", "Lesotho");
        countryCodes.put("267", "Botswana");
        countryCodes.put("268", "Eswatini");
        countryCodes.put("269", "Comoros");
        countryCodes.put("290", "Saint Helena");
        countryCodes.put("291", "Eritrea");
        countryCodes.put("297", "Aruba");
        countryCodes.put("298", "Faroe Islands");
        countryCodes.put("299", "Greenland");

        countryDigitLimits.put("1", 10);  // USA/Canada
        countryDigitLimits.put("7", 10);  // Russia/Kazakhstan
        countryDigitLimits.put("20", 10); // Egypt
        countryDigitLimits.put("27", 9);  // South Africa
        countryDigitLimits.put("30", 10); // Greece
        countryDigitLimits.put("31", 9);  // Netherlands
        countryDigitLimits.put("32", 9);  // Belgium
        countryDigitLimits.put("33", 9);  // France
        countryDigitLimits.put("34", 9);  // Spain
        countryDigitLimits.put("36", 9);  // Hungary
        countryDigitLimits.put("39", 10); // Italy
        countryDigitLimits.put("40", 10); // Romania
        countryDigitLimits.put("41", 9);  // Switzerland
        countryDigitLimits.put("43", 9);  // Austria
        countryDigitLimits.put("44", 10); // United Kingdom
        countryDigitLimits.put("45", 8);  // Denmark
        countryDigitLimits.put("46", 9);  // Sweden
        countryDigitLimits.put("47", 8);  // Norway
        countryDigitLimits.put("48", 9);  // Poland
        countryDigitLimits.put("49", 10); // Germany
        countryDigitLimits.put("51", 9);  // Peru
        countryDigitLimits.put("52", 10); // Mexico
        countryDigitLimits.put("53", 8);  // Cuba
        countryDigitLimits.put("54", 10); // Argentina
        countryDigitLimits.put("55", 11); // Brazil
        countryDigitLimits.put("56", 9);  // Chile
        countryDigitLimits.put("57", 10); // Colombia
        countryDigitLimits.put("58", 10); // Venezuela
        countryDigitLimits.put("60", 10); // Malaysia
        countryDigitLimits.put("61", 9);  // Australia
        countryDigitLimits.put("62", 11); // Indonesia
        countryDigitLimits.put("63", 10); // Philippines
        countryDigitLimits.put("64", 9);  // New Zealand
        countryDigitLimits.put("65", 8);  // Singapore
        countryDigitLimits.put("66", 9);  // Thailand
        countryDigitLimits.put("81", 10); // Japan
        countryDigitLimits.put("82", 10); // South Korea
        countryDigitLimits.put("84", 10); // Vietnam
        countryDigitLimits.put("86", 11); // China
        countryDigitLimits.put("90", 10); // Turkey
        countryDigitLimits.put("91", 10); // India
        countryDigitLimits.put("92", 10); // Pakistan
        countryDigitLimits.put("93", 9);  // Afghanistan
        countryDigitLimits.put("94", 10); // Sri Lanka
        countryDigitLimits.put("95", 9);  // Myanmar
        countryDigitLimits.put("98", 10); // Iran
        countryDigitLimits.put("211", 9); // South Sudan
        countryDigitLimits.put("212", 9); // Morocco
        countryDigitLimits.put("213", 9); // Algeria
        countryDigitLimits.put("216", 8); // Tunisia
        countryDigitLimits.put("218", 9); // Libya
        countryDigitLimits.put("220", 8); // Gambia
        countryDigitLimits.put("221", 8); // Senegal
        countryDigitLimits.put("222", 8); // Mauritania
        countryDigitLimits.put("223", 8); // Mali
        countryDigitLimits.put("224", 8); // Guinea
        countryDigitLimits.put("225", 8); // Ivory Coast
        countryDigitLimits.put("226", 8); // Burkina Faso
        countryDigitLimits.put("227", 8); // Niger
        countryDigitLimits.put("228", 8); // Togo
        countryDigitLimits.put("229", 8); // Benin
        countryDigitLimits.put("230", 8); // Mauritius
        countryDigitLimits.put("231", 8); // Liberia
        countryDigitLimits.put("232", 8); // Sierra Leone
        countryDigitLimits.put("233", 9); // Ghana
        countryDigitLimits.put("234", 10); // Nigeria
        countryDigitLimits.put("235", 8); // Chad
        countryDigitLimits.put("236", 8); // Central African Republic
        countryDigitLimits.put("237", 9); // Cameroon
        countryDigitLimits.put("238", 7); // Cape Verde
        countryDigitLimits.put("239", 8); // Sao Tome and Principe
        countryDigitLimits.put("240", 9); // Equatorial Guinea
        countryDigitLimits.put("241", 8); // Gabon
        countryDigitLimits.put("242", 9); // Republic of the Congo
        countryDigitLimits.put("243", 9); // Democratic Republic of the Congo
        countryDigitLimits.put("244", 9); // Angola
        countryDigitLimits.put("245", 8); // Guinea-Bissau
        countryDigitLimits.put("246", 7); // British Indian Ocean Territory
        countryDigitLimits.put("248", 7); // Seychelles
        countryDigitLimits.put("249", 8); // Sudan
        countryDigitLimits.put("250", 9); // Rwanda
        countryDigitLimits.put("251", 9); // Ethiopia
        countryDigitLimits.put("252", 9); // Somalia
        countryDigitLimits.put("253", 9); // Djibouti
        countryDigitLimits.put("254", 9); // Kenya
        countryDigitLimits.put("255", 9); // Tanzania
        countryDigitLimits.put("256", 9); // Uganda
        countryDigitLimits.put("257", 7); // Burundi
        countryDigitLimits.put("258", 9); // Mozambique
        countryDigitLimits.put("260", 9); // Zambia
        countryDigitLimits.put("261", 9); // Madagascar
        countryDigitLimits.put("262", 10); // Reunion
        countryDigitLimits.put("263", 9); // Zimbabwe
        countryDigitLimits.put("264", 9); // Namibia
        countryDigitLimits.put("265", 9); // Malawi
        countryDigitLimits.put("266", 8); // Lesotho
        countryDigitLimits.put("267", 7); // Botswana
        countryDigitLimits.put("268", 8); // Eswatini
        countryDigitLimits.put("269", 7); // Comoros
        countryDigitLimits.put("290", 3); // Saint Helena
        countryDigitLimits.put("291", 7); // Eritrea
        countryDigitLimits.put("297", 7); // Aruba
        countryDigitLimits.put("298", 7); // Faroe Islands
        countryDigitLimits.put("299", 7); // Greenland
    }

    public static String guessCountry(String phoneNumber) {
        String cleanedNumber = phoneNumber.replaceAll("[^0-9]", "");
        
        for (String code : countryCodes.keySet()) {
            if (cleanedNumber.startsWith(code)) {
                return countryCodes.get(code);
            }
        }
        
        return "Unknown Country";
    }

    public static String validatePhoneNumberLength(String phoneNumber) {
        String cleanedNumber = phoneNumber.replaceAll("[^0-9]", "");
        
        for (Map.Entry<String, Integer> entry : countryDigitLimits.entrySet()) {
            String code = entry.getKey();
            int expectedLength = entry.getValue();
            
            if (cleanedNumber.startsWith(code)) {
                if (cleanedNumber.length() == expectedLength) {
                    return "The phone number is valid.";
                } else {
                    return "The phone number is invalid. Expected length: " + expectedLength;
                }
            }
        }
        
        return "Unknown country code.";
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Phone Number Guesser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Enter Phone Number:");
        userLabel.setBounds(10, 20, 160, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(180, 20, 165, 25);
        panel.add(userText);

        JButton guessButton = new JButton("Guess Country");
        guessButton.setBounds(10, 80, 150, 25);
        panel.add(guessButton);

        JButton validateButton = new JButton("Validate Length");
        validateButton.setBounds(180, 80, 150, 25);
        panel.add(validateButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 120, 340, 100);
        panel.add(resultArea);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNumber = userText.getText();
                String country = guessCountry(inputNumber);
                resultArea.setText("Country: " + country);
            }
        });

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNumber = userText.getText();
                String validationMessage = validatePhoneNumberLength(inputNumber);
                resultArea.setText(validationMessage);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}





