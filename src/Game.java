import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {
        new Game();
    }
    public Game(){
     window = new JFrame();
     window.setSize(800, 600);
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     window.getContentPane().setBackground(Color.BLACK);
     window.setLayout(null);
     window.setVisible(true);
     con = window.getContentPane();

     titleNamePanel = new JPanel();
     titleNamePanel.setBounds(100, 100, 600, 150);
     titleNamePanel.setBackground(Color.BLACK);
     titleNameLabel = new JLabel("Medieval");
     titleNameLabel.setForeground(Color.WHITE);
     titleNameLabel.setFont(titleFont);

     startButtonPanel = new JPanel();
     startButtonPanel.setBounds(300, 400, 200, 100);
     startButtonPanel.setBackground(Color.BLACK);

     startButton = new JButton("START");
     startButton.setBackground(Color.BLACK);
     startButton.setForeground(Color.WHITE);
     startButton.setFont(normalFont);
     startButton.addActionListener(tsHandler);
     startButton.setFocusPainted(false);

     titleNamePanel.add(titleNameLabel);
     startButtonPanel.add(startButton);
     con.add(titleNamePanel);
     con.add(startButtonPanel);
    }

    public void createGameScreen(){

        titleNameLabel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area. This game is going to be great. I'm sure of it");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.WHITE);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.BLACK);
        choice2.setForeground(Color.WHITE);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.BLACK);
        choice3.setForeground(Color.WHITE);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.BLACK);
        choice4.setForeground(Color.WHITE);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.blue);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.WHITE);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.WHITE);
        playerPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.WHITE);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.WHITE);
        playerPanel.add(weaponLabelName);

        playerSetup();


    }
    public void playerSetup(){
        playerHP = 15;
        weapon = "knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);

        townGate();
    }

    public void townGate(){
        position = "townGate";
        mainTextArea.setText("You are at the gate of the town. A guard is standing in front of you. \nWhat do you do?");

        choice1.setText("Talk to the guard");
        choice2.setText("Attack the guard");
        choice3.setText("Leave");
        choice4.setText("Steal his sword");
    }
    public void talkGuard(){
        position = "talkGuard";
        mainTextArea.setText("Guard:Hello stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter our town");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }
    public void attackGuard(){
        position = "attackGuard";
        mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You recieve 3 damage");
        playerHP = playerHP -3;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void crossRoad(){
        position = "crossRoad";
        mainTextArea.setText("You are at a crossroad. \nIf you go south, you will go back to the town.");
        choice1.setText("Go North");
        choice2.setText("Go East");
        choice3.setText("Go South");
        choice4.setText("Go West");
    }
    public void stealSword(){
        weapon = "Sword";
        weaponLabelName.setText(weapon);
        townGate();
    }

    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            createGameScreen();

        }
    }
    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch (position){
                case "townGate":
                    switch (yourChoice){
                        case "c1": talkGuard(); break;
                        case "c2": attackGuard(); break;
                        case "c3": crossRoad();break;
                        case "c4": stealSword(); break;
                    }
                    break;
                case "talkGuard":
                    switch (yourChoice){
                        case "c1": townGate(); break;
                    }
                    break;
                case "attackGuard":
                    switch (yourChoice){
                        case "c1": townGate(); break;
                    }
                    break;
                case "crossRoad":
                    switch (yourChoice){
                        case "c1": break;
                        case "c2": break;
                        case "c3": townGate(); break;
                        case "c4": break;
                    }
            }


        }
    }
}
