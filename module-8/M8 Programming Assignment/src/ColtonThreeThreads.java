/*
Colton Kohler
Module 8 Programming Assignment
4/27/2025
This program creates a window with a text area and uses three separate threads
to output random letters, numbers, and symbols. Each thread outputs 10,000 characters.
*/

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ColtonThreeThreads extends JFrame {
    private JTextArea textArea = new JTextArea(20, 50); // 20 lines tall, 50 characters wide

    public ColtonThreeThreads() {
        setTitle("Three Threads Output");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        setVisible(true);

        Thread letterThread = new Thread(new CharacterRunnable("letters"));
        Thread numberThread = new Thread(new CharacterRunnable("numbers"));
        Thread symbolThread = new Thread(new CharacterRunnable("symbols"));

        letterThread.start();
        numberThread.start();
        symbolThread.start();
    }


    class CharacterRunnable implements Runnable {
        private String type;
        private Random rand = new Random();

        public CharacterRunnable(String type) {
            this.type = type;
        }

        public void run() {
            for (int i = 0; i < 10000; i++) {
                char ch;
                switch (type) {
                    case "letters":
                        ch = (char) ('a' + rand.nextInt(26));
                        break;
                    case "numbers":
                        ch = (char) ('0' + rand.nextInt(10));
                        break;
                    case "symbols":
                        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
                        ch = symbols[rand.nextInt(symbols.length)];
                        break;
                    default:
                        ch = '?'; // Fallback in case of error
                }
                textArea.append(Character.toString(ch));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColtonThreeThreads());
    }
}
