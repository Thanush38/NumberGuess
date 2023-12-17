import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuess extends JFrame {

    private int randomNumber;
    private JTextField guessTextField;
    private JLabel resultLabel;

    public NumberGuess() {
        // Set up the frame
        setTitle("Number Guessing Game");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        randomNumber = generateRandomNumber();
        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100:");
        guessTextField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        resultLabel = new JLabel("");

        // Set up layout
        setLayout(new FlowLayout());
        add(instructionLabel);
        add(guessTextField);
        add(guessButton);
        add(resultLabel);

        // Add action listener to the guess button
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        // make text field call checkGuess() when enter is pressed
        guessTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(guessTextField.getText());
            if (userGuess == randomNumber) {
                resultLabel.setText("Congratulations! You're right!");
            } else if (userGuess < randomNumber) {
                resultLabel.setText("Too low. Try again.");
            } else {
                resultLabel.setText("Too high. Try again.");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGuess().setVisible(true);
            }
        });
    }
}
