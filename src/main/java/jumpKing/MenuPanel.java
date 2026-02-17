package jumpKing;

import javax.swing.*;
import java.awt.*;

/**
 * Main menu panel.
 * Displays title and Start button.
 * When Start is clicked, it runs the provided callback.
 */
public class MenuPanel extends JPanel {

    public MenuPanel(Runnable onStart) {

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // ===== Title =====
        JLabel title = new JLabel("JUMP KING", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 72));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(150, 0, 100, 0));

        // ===== Button Panel =====
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);

        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 32));
        startButton.setFocusPainted(false);
        startButton.setBackground(Color.WHITE);
        startButton.setForeground(Color.BLACK);
        startButton.setPreferredSize(new Dimension(250, 80));

        // When clicked → run callback from Game class
        startButton.addActionListener(e -> {
            if (onStart != null) {
                onStart.run();
            }
        });

        buttonPanel.add(startButton);

        // ===== Add to layout =====
        add(title, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
