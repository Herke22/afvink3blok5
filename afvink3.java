import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class afvink3 extends JPanel {
    // buttons worden gemaakt
    JButton[] buttons = new JButton[9];
    int beurt = 0; // bepaald wie aan de beurt is
    int beurten = 9;

    public static void main(String[] args) {
        // frame word gemaakt
        JFrame f = new JFrame("afvink 3");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new afvink3());
        f.setBounds(600, 600, 600, 600);
        f.setVisible(true);

    }

    public afvink3() {
        // zet de layout van de buttons
        setLayout(new GridLayout(3, 3));
        createGUI();

    }

    public void createGUI() {

        // buttons worden neergezet en een functie gegeven
        for (int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new knopfunctie());
            add(buttons[i]);
        }
    }

    public void reset() {
        // op de buttons word een lege str gezet
        for (int i = 0; i <= 8; i++) {
            buttons[i].setText("");
        }
    }

    private class knopfunctie implements ActionListener {
        // wanneer er op de knop word gedrukt word de tekst erop veranderd
        // met de functie wincondition word gekeken of er iemand gewonnen heeft
        public void actionPerformed(ActionEvent e) {
            JButton klik = (JButton) e.getSource();
            if (beurten% 2 == 0){
                klik.setText(":)");
                beurten--; }
            else {
                klik.setText(">:(");
                beurten--;}
            // als iemand wint of het gelijk spel is word dit door een melding verteld en word het spel gereset
            if (beurten == 0){
                JOptionPane.showMessageDialog(null, "tie");
                reset();}
            else if (wincondition()) {
                if (beurten % 2 == 0){
                    JOptionPane.showMessageDialog(null, ">:( wint, GG");
                    reset();}
                else if (beurten % 2 !=0)
                    JOptionPane.showMessageDialog(null, ":) wint, GG");
                    reset();}
                }
            }


        public boolean wincondition() {
            // er word gekeken of de aangrenzende knoppen hetzelfde zijn.
            if (ffchecken(0, 1) && ffchecken(1, 2))
                return true;
            else if (ffchecken(3, 4) && ffchecken(4, 5))
                return true;
            else if (ffchecken(6, 7) && ffchecken(7, 8))
                return true;
            else if (ffchecken(0, 3) && ffchecken(3, 6))
                return true;
            else if (ffchecken(1, 4) && ffchecken(4, 7))
                return true;
            else if (ffchecken(2, 5) && ffchecken(5, 8))
                return true;
            else if (ffchecken(0, 4) && ffchecken(4, 8))
                return true;
            else if (ffchecken(2, 4) && ffchecken(4, 6))
                return true;
            else
                return false;
        }

        public boolean ffchecken(int a, int b) {
            // kijkt of de aangrenzende knoppen hetzelfde zijn.
            if (buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals(""))
                return true;
            else
                return false;
        }

        }