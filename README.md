# OOPL-Phone-Number-Guesser
Overview
Phone Number Guesser is a Java-based GUI application that allows users to input a phone number and identify the associated country. Additionally, the program checks if the phone number length matches the expected format for the detected country. This simple tool is useful for understanding phone number conventions worldwide and validating phone number formats.

Features:
Country Identification: Identifies the country based on the initial digits (country code) of the input phone number.
Length Validation: Verifies if the input phone number's length matches the standard for the detected country and provides feedback.
Simple GUI: Built using JFrame and JPanel to create an intuitive user interface.

Technologies Used:
Java (JDK 8 or higher)
Java Swing for the graphical user interface.

How to Use:
Launch the application: Run the program to open the GUI.
Enter a phone number: Type a phone number into the input field.
Guess the Country:
Click the "Guess Country" button.
The application displays the country corresponding to the entered phone number.
Validate Length:
Click the "Validate Length" button.
The program checks the length of the phone number and indicates whether it matches the expected format for the identified country.

Code Structure:
PhoneNumberGuesser1 class:
Contains HashMap<String, String> for country codes and HashMap<String, Integer> for phone number digit limits.
guessCountry(String phoneNumber): Identifies the country based on the country code.
validatePhoneNumberLength(String phoneNumber): Validates the phone number length based on the identified country.

GUI Components:
JFrame, JPanel, JTextField, JButton, and JTextArea for user interaction.
Action listeners handle button clicks for guessing the country and validating the phone number length.

"Thank you for checking out this project! We hope you find it useful."
