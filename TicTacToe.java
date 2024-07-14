
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class TicTacToe implements ActionListener {
    Cursor mycursor=new Cursor(Cursor.HAND_CURSOR);
    Random random=new Random();
    JFrame f=new JFrame();
    JPanel titlepanel=new JPanel();
    JPanel button=new JPanel();
    JLabel textfield = new JLabel();
    JButton[]buttons=new JButton[9];
	boolean player1_turn;

    TicTacToe() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,800);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(Color.MAGENTA);
        f.setLayout(new BorderLayout());
        f.setVisible(true);

        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.BLUE);
        textfield.setFont(new Font("Arial",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Toc Toe");
        textfield.setOpaque(true);

        titlepanel.setLayout(new BorderLayout());
        titlepanel.setBounds(0,0,800,100);

        button.setLayout((new GridLayout(3,3)));
        button.setCursor(mycursor);
        button.setBackground(Color.CYAN);

        for (int i = 0; i < 9; i++) {
            buttons[i] =new JButton();
            button.add(buttons[i]);
            buttons[i].setFont(new Font("Arial",Font.BOLD,120));
            buttons[i].setFocusCycleRoot(false);
            buttons[i].addActionListener(this);

        }
        titlepanel.add(textfield);
        f.add(titlepanel,BorderLayout.NORTH);
		f.add(button);

        firstTurn();
    }

    public void actionPerformed(ActionEvent e){

        for (int i = 0; i < 9; i++) {
           if(e.getSource()==buttons[i]){
            if(player1_turn){
                if(buttons[i].getText()==""){
                    buttons[i].setForeground(Color.GREEN);
                    buttons[i].setText("X");
                    player1_turn=false;
                    textfield.setText("O turn");
                    check();
                }
            }
            else{
                if(buttons[i].getText()==""){
                    buttons[i].setForeground(Color.ORANGE);
                    buttons[i].setText("O");
                    player1_turn=true;
                    textfield.setText("X turn");
                    check();
             }
           } 
        }
    }
}

    public void firstTurn(){

        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X turn");
        }
        else{
            player1_turn=false;
            textfield.setText("O turn"); 
        }

    }
    public void check(){
        if(
            (buttons[0].getText()=="X") &&
            (buttons[1].getText()=="X") &&
            (buttons[2].getText()=="X")
        ){
            xWins(0,1,2);
        }

        if(
            (buttons[3].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[5].getText()=="X")
        ){
            xWins(3,4,5);
        }

        if(
            (buttons[6].getText()=="X") &&
            (buttons[7].getText()=="X") &&
            (buttons[8].getText()=="X")
        ){
            xWins(6,7,8);
        }

        if(
            (buttons[0].getText()=="X") &&
            (buttons[3].getText()=="X") &&
            (buttons[6].getText()=="X")
        ){
            xWins(0,3,6);
        }

        if(
            (buttons[1].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[7].getText()=="X")
        ){
            xWins(1,4,7);
        }

        if(
            (buttons[2].getText()=="X") &&
            (buttons[5].getText()=="X") &&
            (buttons[8].getText()=="X")
        ){
            xWins(2,5,8);
        }

        if(
            (buttons[0].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[8].getText()=="X")
        ){
            xWins(0,4,8);
        }

        if(
            (buttons[2].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[6].getText()=="X")
        ){
            xWins(2,4,6);
        }



        if(
            (buttons[0].getText()=="O") &&
            (buttons[1].getText()=="O") &&
            (buttons[2].getText()=="O")
        ){
            oWins(0,1,2);
        }

        if(
            (buttons[3].getText()=="O") &&
            (buttons[4].getText()=="O") &&
            (buttons[5].getText()=="O")
        ){
            oWins(3,4,5);
        }

        if(
            (buttons[6].getText()=="O") &&
            (buttons[7].getText()=="O") &&
            (buttons[8].getText()=="O")
        ){
            oWins(6,7,8);
        }

        if(
            (buttons[0].getText()=="O") &&
            (buttons[3].getText()=="O") &&
            (buttons[6].getText()=="O")
        ){
            oWins(0,3,6);
        }

        if(
            (buttons[1].getText()=="O") &&
            (buttons[4].getText()=="O") &&
            (buttons[7].getText()=="O")
        ){
            oWins(1,4,7);
        }

        if(
            (buttons[2].getText()=="O") &&
            (buttons[5].getText()=="O") &&
            (buttons[8].getText()=="O")
        ){
            oWins(2,5,8);
        }

        if(
            (buttons[0].getText()=="O") &&
            (buttons[4].getText()=="O") &&
            (buttons[8].getText()=="O")
        ){
            oWins(0,4,8);
        }

        if(
            (buttons[2].getText()=="O") &&
            (buttons[4].getText()=="O") &&
            (buttons[6].getText()=="O")
        ){
            oWins(2,4,6);
        }



    }

    public void xWins(int a,int b ,int c){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0 ; i < 9 ; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X WIN`S");
    }

    public void oWins(int a,int b ,int c){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0 ; i < 9 ; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O WIN`S");
    }

    
}
