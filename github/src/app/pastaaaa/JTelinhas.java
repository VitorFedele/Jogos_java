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
        this.setSize(970,970);
        this.setResizable(false);
        this.panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        matbutao = new JbuttonEspaco[C.NUM_LINHAS][C.NUM_COLUNAS];
        
        int n = 0;
        for(int i = 0; i < C.NUM_LINHAS; i++){
            for( int j = 0; j < C.NUM_COLUNAS; j++){
       
                matbutao[i][j] = new JbuttonEspaco(this.c, this);
                c.getEspaco(i, j).setbotao(matbutao[i][j]);
               // matbutao[i][j].linha = i;
               // matbutao[i][j].coluna = j;
                matbutao[i][j].setPos(i, j);
                matbutao[i][j].setSize(50,50);
                matbutao[i][j].setLocation(50*i, 50*j);
               // matbutao[i][j].setText(Integer.toString(n++));
                panel.add(matbutao[i][j]);
            }
        }
        this.setVisible(true);
    }
    public void revelarMnias(){
      
        for(int i = 0; i < C.NUM_LINHAS; i++){
            for( int j = 0; j < C.NUM_COLUNAS; j++){
                if(matbutao[i][j].e.minado);{
                    matbutao[i][j].MiRevela("☼");
             }
            
            }
        }
    }
    public void estado(){
        System.out.println("verificando ganhador");
        if (this.c.IsVencido()){
            System.out.println("venceu");
        }
        
       } 
    }

