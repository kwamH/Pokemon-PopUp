import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class Game implements ActionListener{
    final int MAX_BUTTONS = 9;
    JFrame frame = new JFrame();
    JPanel button_panel = new JPanel();
    JButton[] buttons = new JButton[MAX_BUTTONS];
    Icon[] icon = new ImageIcon[MAX_BUTTONS];
    ImageIcon image;



    Game() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

       File file = new File("pokemonS1.wav");
       AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
       Clip clip = AudioSystem.getClip();
       clip.open(audiostream);
       clip.start();


        icon[0] = new ImageIcon("alakazam1.png");
        icon[1] = new ImageIcon("Bulbasaur1.png");
        icon[2] = new ImageIcon("charmander1.png");
        icon[3] = new ImageIcon("Deoxys1.png");
        icon[4] = new ImageIcon("electabuzz1.png");
        icon[5] = new ImageIcon("gengar1.png");
        icon[6] = new ImageIcon("mew1.png");
        icon[7] = new ImageIcon("pikachu1.png");
        icon[8] = new ImageIcon("squirtle1.png");








        image = new ImageIcon("pokeball.png");
        Icon question = new ImageIcon("pokequest.png");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("POKEMON POP - UP");
        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.setIconImage(image.getImage());

        button_panel.setLayout(new GridLayout(3, 3));
        for(int i = 0; i < MAX_BUTTONS; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(new Color(128, 0, 0));
            button_panel.add(buttons[i]);
            buttons[i].setFocusable(false);
            buttons[i].setIcon(question);
            buttons[i].addActionListener(this);
        }
        frame.add(button_panel);
        frame.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < MAX_BUTTONS; i++) {
            if(e.getSource() == buttons[i]) {
                buttons[i].setIcon(icon[i]);
            }
        }
    }
}
