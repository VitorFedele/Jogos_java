package app.pastaaaa;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JTelinhas extends JFrame {
    JPanel panel;
    JbuttonEspaco[][] matbutao;
    int n;
    campo c;
    public JTelinhas(campo c){
        this.c = c; 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(460,540);
        this.setResizable(false);
        this.panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        matbutao = new JbuttonEspaco[C.NUM_LINHAS][C.NUM_COLUNAS];
        
        for(int i = 0; i < C.NUM_LINHAS; i++){
            for( int j = 0; j < C.NUM_COLUNAS; j++){
       
                matbutao[i][j] = new JbuttonEspaco(this.c);
               // matbutao[i][j].linha = i;
               // matbutao[i][j].coluna = j;
                matbutao[i][j].setPos(i, j);
                matbutao[i][j].setSize(40,40);
                matbutao[i][j].setLocation(40*i, 40*j);
               // matbutao[i][j].setText(Integer.toString(n++));
                panel.add(matbutao[i][j]);
            }
        }
        this.setVisible(true);
    }
    
}