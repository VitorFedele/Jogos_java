package app.pastaaaa;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class telinhas extends JFrame {
    JPanel panel;
    JButton[][] matbutao;
    public telinhas(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550,550);
        this.setResizable(false);
        this.panel = new JPanel();
        this.add(panel);
        matbutao = new JButton[C.NUM_LINHAS][C.NUM_COLUNAS];
        for(int i = 0; i < C.NUM_LINHAS; i++){
            for( int j = 0; j < C.NUM_COLUNAS; j++){
                matbutao[i][j] = new JButton();
                matbutao[i][j].setSize(40,40);
                matbutao[i][j].setLocation(20*i, 20*j);
                panel.add(matbutao[i][j]);
            }
        }
        this.setVisible(true);
    }
    
}