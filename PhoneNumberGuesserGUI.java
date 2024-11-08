import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberGuesser {

    private static Map<String, String> countryCodes = new HashMap<>();
    private static Map<String, Integer> countryDigitLimits = new HashMap<>();

    static {
        // Country codes and their corresponding names
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

        // Expected lengths including dialing codes
        countryDigitLimits.put("1", 11);   // USA/Canada (1 + 10 digits)
        countryDigitLimits.put("7", 11);   // Russia/Kazakhstan (7 + 10 digits)
        countryDigitLimits.put("20", 11);  // Egypt (20 + 9 digits)
        countryDigitLimits.put("27", 11);  // South Africa (27 + 9 digits)
        countryDigitLimits.put("30", 11);  // Greece (30 + 10 digits)
        countryDigitLimits.put("31", 10);   // Netherlands (31 + 9 digits)
        countryDigitLimits.put("32", 9);    // Belgium (32 + 8 digits)
        countryDigitLimits.put("33", 9);    // France (33 + 8 digits)
        countryDigitLimits.put("34", 9);    // Spain (34 + 8 digits)
        countryDigitLimits.put("36", 9);    // Hungary (36 + 8 digits)
        countryDigitLimits.put("39", 10);   // Italy (39 + 9 digits)
        countryDigitLimits.put("40", 10);   // Romania (40 + 9 digits)
        countryDigitLimits.put("41", 9);    // Switzerland (41 + 8 digits)
        countryDigitLimits.put("43", 9);    // Austria (43 + 8 digits)
        countryDigitLimits.put("44", 10);   // United Kingdom (44 + 9 digits)
        countryDigitLimits.put("45", 8);    // Denmark (45 + 7 digits)
        countryDigitLimits.put("46", 9);    // Sweden (46 + 8 digits)
        countryDigitLimits.put("47", 8);    // Norway (47 + 7 digits)
        countryDigitLimits.put("48", 9);    // Poland (48 + 8 digits)
        countryDigitLimits.put("49", 10);   // Germany (49 + 9 digits)
        countryDigitLimits.put("51", 9);    // Peru (51 + 8 digits)
        countryDigitLimits.put("52", 10);   // Mexico (52 + 10 digits)
        countryDigitLimits.put("53", 8);    // Cuba (53 + 7 digits)
        countryDigitLimits.put("54", 10);   // Argentina (54 + 10 digits)
        countryDigitLimits.put("55", 11);   // Brazil (55 + 10 digits)
        countryDigitLimits.put("56", 9);    // Chile (56 + 8 digits)
        countryDigitLimits.put("57", 10);   // Colombia (57 + 10 digits)
        countryDigitLimits.put("58", 10);   // Venezuela (58 + 10 digits)
        countryDigitLimits.put("60", 10);   // Malaysia (60 + 9 digits)
        countryDigitLimits.put("61", 9);    // Australia (61 + 8 digits)
        countryDigitLimits.put("62", 11);   // Indonesia (62 + 10 digits)
        countryDigitLimits.put("63", 10);   // Philippines (63 + 9 digits)
        countryDigitLimits.put("64", 9);    // New Zealand (64 + 8 digits)
        countryDigitLimits.put("65", 8);    // Singapore (65 + 7 digits)
        countryDigitLimits.put("66", 9);    // Thailand (66 + 8 digits)
        countryDigitLimits.put("81", 11);   // Japan (81 + 10 digits)
        countryDigitLimits.put("82", 11);   // South Korea (82 + 10 digits)
        countryDigitLimits.put("84", 11);   // Vietnam (84 + 10 digits)
        countryDigitLimits.put("86", 11);   // China (86 + 10 digits)
        countryDigitLimits.put("90", 10);   // Turkey (90 + 9 digits)
        countryDigitLimits.put("91", 12);   // India (91 + 10 digits)
        countryDigitLimits.put("92", 11);   // Pakistan (92 + 10 digits)
        countryDigitLimits.put("93", 11);   // Afghanistan (93 + 10 digits)
        countryDigitLimits.put("94", 11);   // Sri Lanka (94 + 10 digits)
        countryDigitLimits.put("95", 11);   // Myanmar (95 + 10 digits)
        countryDigitLimits.put("98", 11);   // Iran (98 + 10 digits)
        countryDigitLimits.put("211", 13);  // South Sudan (211 + 12 digits)
        countryDigitLimits.put("212", 9);    // Morocco (212 + 8 digits)
        countryDigitLimits.put("213", 9);    // Algeria (213 + 8 digits)
        countryDigitLimits.put("216", 8);    // Tunisia (216 + 7 digits)
        countryDigitLimits.put("218", 9);    // Libya (218 + 8 digits)
        countryDigitLimits.put("220", 9);    // Gambia (220 + 8 digits)
        countryDigitLimits.put("221", 9);    // Senegal (221 + 8 digits)
        countryDigitLimits.put("222", 9);    // Mauritania (222 + 8 digits)
        countryDigitLimits.put("223", 9);    // Mali (223 + 8 digits)
        countryDigitLimits.put("224", 9);    // Guinea (224 + 8 digits)
        countryDigitLimits.put("225", 10);   // Ivory Coast (225 + 9 digits)
        countryDigitLimits.put("226", 10);   // Burkina Faso (226 + 9 digits)
        countryDigitLimits.put("227", 9);    // Niger (227 + 8 digits)
        countryDigitLimits.put("228", 8);    // Togo (228 + 7 digits)
        countryDigitLimits.put("229", 8);    // Benin (229 + 7 digits)
        countryDigitLimits.put("230", 9);    // Mauritius (230 + 8 digits)
        countryDigitLimits.put("231", 8);    // Liberia (231 + 7 digits)
        countryDigitLimits.put("232", 9);    // Sierra Leone (232 + 8 digits)
        countryDigitLimits.put("233", 10);   // Ghana (233 + 9 digits)
        countryDigitLimits.put("234", 11);   // Nigeria (234 + 10 digits)
        countryDigitLimits.put("235", 11);   // Chad (235 + 10 digits)
        countryDigitLimits.put("236", 10);   // Central African Republic (236 + 9 digits)
        countryDigitLimits.put("237", 10);   // Cameroon (237 + 9 digits)
        countryDigitLimits.put("238", 9);    // Cape Verde (238 + 8 digits)
        countryDigitLimits.put("239", 9);    // Sao Tome and Principe (239 + 8 digits)
        countryDigitLimits.put("240", 10);   // Equatorial Guinea (240 + 9 digits)
        countryDigitLimits.put("241", 9);    // Gabon (241 + 8 digits)
        countryDigitLimits.put("242", 11);   // Republic of the Congo (242 + 10 digits)
        countryDigitLimits.put("243", 12);   // Democratic Republic of the Congo (243 + 11 digits)
        countryDigitLimits.put("244", 10);   // Angola (244 + 9 digits)
        countryDigitLimits.put("245", 9);    // Guinea-Bissau (245 + 8 digits)
        countryDigitLimits.put("246", 10);   // British Indian Ocean Territory (246 + 9 digits)
        countryDigitLimits.put("248", 9);    // Seychelles (248 + 8 digits)
        countryDigitLimits.put("249", 10);   // Sudan (249 + 9 digits)
        countryDigitLimits.put("250", 10);   // Rwanda (250 + 9 digits)
        countryDigitLimits.put("251", 10);   // Ethiopia (251 + 9 digits)
        countryDigitLimits.put("252", 9);    // Somalia (252 + 8 digits)
        countryDigitLimits.put("253", 9);    // Djibouti (253 + 8 digits)
        countryDigitLimits.put("254", 10);   // Kenya (254 + 9 digits)
        countryDigitLimits.put("255", 10);   // Tanzania (255 + 9 digits)
        countryDigitLimits.put("256", 10);   // Uganda (256 + 9 digits)
        countryDigitLimits.put("257", 9);    // Burundi (257 + 8 digits)
        countryDigitLimits.put("258", 10);   // Mozambique (258 + 9 digits)
        countryDigitLimits.put("260", 10);   // Zambia (260 + 9 digits)
        countryDigitLimits.put("261", 10);   // Madagascar (261 + 9 digits)
        countryDigitLimits.put("262", 10);   // Reunion (262 + 9 digits)
        countryDigitLimits.put("263", 10);   // Zimbabwe (263 + 9 digits)
        countryDigitLimits.put("264", 10);   // Namibia (264 + 9 digits)
        countryDigitLimits.put("265", 9);    // Malawi (265 + 8 digits)
        countryDigitLimits.put("266", 9);    // Lesotho (266 + 8 digits)
        countryDigitLimits.put("267", 10);   // Botswana (267 + 9 digits)
        countryDigitLimits.put("268", 9);    // Eswatini (268 + 8 digits)
        countryDigitLimits.put("269", 9);    // Comoros (269 + 8 digits)
        countryDigitLimits.put("290", 9);    // Saint Helena (290 + 8 digits)
        countryDigitLimits.put("291", 9);    // Eritrea (291 + 8 digits)
        countryDigitLimits.put("297", 10);   // Aruba (297 + 9 digits)
        countryDigitLimits.put("298", 10);   // Faroe Islands (298 + 9 digits)
        countryDigitLimits.put("299", 10);   // Greenland (299 + 9 digits);
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
            int expectedTotalLength = entry.getValue();

            // Check if the cleaned number starts with the country code
            if (cleanedNumber.startsWith(code)) {
                if (cleanedNumber.length() == expectedTotalLength) {
                    return "The phone number is valid.";
                } else {
                    return "The phone number is invalid. Expected total length (including dialing code): " + expectedTotalLength;
                }
            }
        }

        return "Unknown country code.";
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Phone Number Guesser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);  // Increased height for better layout

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
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(10, 120, 340, 150);
        panel.add(scrollPane);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNumber = userText.getText();
                String result = guessCountry(inputNumber);
                resultArea.setText(result);
            }
        });

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputNumber = userText.getText();
                String validationResult = validatePhoneNumberLength(inputNumber);
                resultArea.setText(validationResult);
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}

