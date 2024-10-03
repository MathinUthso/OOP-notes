import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class body extends JFrame implements ActionListener{

     private JButton [] [] buttons = new JButton[3][3];
     private boolean playerXturn =true;
     private static int movesCounter = 0;


     public body(){
         setTitle("Tic Tac Toe");
         setSize(500,500);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new GridLayout(3,3));
         setButtons();
     }

     private void setButtons(){
         for(int i = 0; i < buttons.length; i++){
             for(int j = 0; j < buttons.length; j++){
                 buttons[i][j] = new JButton("");
                 buttons[i][j].setFont(new Font("Arial",Font.PLAIN,50));
                 buttons[i][j].addActionListener(this);
                 buttons[i][j].setFocusPainted(false);
                 add(buttons[i][j]);
             }

         }
     }
     private void checkWinner(){
         for(int i=0;i<3;i++){
             //for rows
                 if(buttons[i][0].getText().equals(buttons[i][1].getText())&&
                     buttons[i][0].getText().equals(buttons[i][2].getText())&&
                         !buttons[i][0].getText().isEmpty())
                                showWinner(buttons[i][0].getText());

              //for columns
                if(buttons[0][i].getText().equals(buttons[1][i].getText())&&
                         buttons[0][i].getText().equals(buttons[2][i].getText())&&
                         !buttons[i][i].getText().isEmpty())
                     showWinner(buttons[0][i].getText());
                
               //for diagonals
                if(buttons[0][2].getText().equals(buttons[2][0].getText())&&
                         buttons[0][2].getText().equals(buttons[1][1].getText())&&
                         !buttons[0][2].getText().isEmpty())
                     showWinner(buttons[0][2].getText());

                if(buttons[0][0].getText().equals(buttons[1][1].getText())&&
                        buttons[0][0].getText().equals(buttons[2][2].getText())&&
                        !buttons[0][0].getText().isEmpty())
                    showWinner(buttons[0][0].getText());
         }
        if(movesCounter==9){
            JOptionPane.showMessageDialog(this,"Match drawn");
            JOptionPane.showMessageDialog(this,"Now, Dr. Yunus will do a lapdance");
            resetBoard();
        }
     }
     private void showWinner(String s){
         JOptionPane.showMessageDialog(this,"Player "+s+" Won");
            JOptionPane.showMessageDialog(this,"Now suck his D");
          resetBoard();
     }
     private void resetBoard(){
         for(int i=0;i<3;i++){
             for(int j=0;j<3;j++){
                 buttons[i][j].setText("");
             }
         }
         playerXturn=true;
         movesCounter=0;
     }

     @Override
     public void actionPerformed(ActionEvent e){
         JButton clickedButton = (JButton) e.getSource();

         if(!clickedButton.getText().isEmpty())return; //Return nothing if the BOX is already fixed;

         if(playerXturn)clickedButton.setText("X");
         else clickedButton.setText("O");
         playerXturn=!playerXturn;
         movesCounter++;

         checkWinner();
     }




    public static void main(String[] args) {
      SwingUtilities.invokeLater(()->
      {
          body tictactoe = new body();
          tictactoe.setVisible(true);
      });

}
}



