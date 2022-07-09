package app.pastaaaa;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app.App;

public class JTelinhas extends JFrame {
    JPanel panel;
    JbuttonEspaco[][] matbutao;
    int n;
    campo c;
    JButton resetBut;
    JButton facilButton;
    JButton medButton;
    JButton hardbuton;
    JButton cusButton;
    public JTelinhas(){
       confIni();
       
    }
    public void HardRest(){
        App.hardRest();
        this.dispose();
    }

        private void confIni(){
            
        this.c = new campo();
        c.addMinas();
        this.panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        matbutao = new JbuttonEspaco[C.NUM_LINHAS][C.NUM_COLUNAS];
        
        int n = 0;
        for(int i = 0; i < C.NUM_LINHAS; i++){
            for( int j = 0; j < C.NUM_COLUNAS; j++){
                matbutao[i][j] = new JbuttonEspaco(this.c, this);
                c.getEspaco(i, j).setbotao(matbutao[i][j]);
                matbutao[i][j].setPos(i, j);
                matbutao[i][j].setSize(48,48);
                matbutao[i][j].setLocation(48*i, 48*j);
                panel.add(matbutao[i][j]);
        }
    }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920,1080);
        this.setResizable(false);
        this.setVisible(true);

    this.resetBut = new JButton("😀reset😀");
    this.resetBut.addActionListener((java.awt.event.ActionEvent evt) ->{
        this.reset();
    });
    this.resetBut.setSize(200, 200);
    this.resetBut.setLocation(1400,80 );
    this.panel.add(this.resetBut);


this.facilButton = new JButton("facil");
this.facilButton.addActionListener((java.awt.event.ActionEvent evt) ->{
    C.NUM_COLUNAS = 8;
    C.NUM_LINHAS = 8;
    C.NUM_MINAS = 10;
    this.HardRest();
});
this.facilButton.setSize(100,100);
this.facilButton.setLocation(1400,300);
this.panel.add(this.facilButton);


this.medButton= new JButton("medio");
this.medButton.addActionListener((java.awt.event.ActionEvent evt) ->{
    C.NUM_COLUNAS = 12;
    C.NUM_LINHAS = 12;
    C.NUM_MINAS = 15;
    this.HardRest();
});
this.medButton.setSize(100,100);
this.medButton.setLocation(1500,300);
this.panel.add(this.medButton);

this.hardbuton= new JButton("dificil");
this.hardbuton.addActionListener((java.awt.event.ActionEvent evt) ->{
    C.NUM_COLUNAS = 17;
    C.NUM_LINHAS = 17;
    C.NUM_MINAS= 20;
    this.HardRest();

});
this.hardbuton.setSize(100,100);
this.hardbuton.setLocation(1400,400);
this.panel.add(this.hardbuton);

this.cusButton = new JButton("custom");
this.cusButton.addActionListener((java.awt.event.ActionEvent evt) ->{
    
 int l = Integer.parseInt(JOptionPane.showInputDialog("insira 'linha, linha não pode ser maior que 28'"));
C.NUM_LINHAS = l;
 int c = Integer.parseInt(JOptionPane.showInputDialog("insira 'coluna, colunha não pode ser maior que 18'"));
C.NUM_COLUNAS = c;
 int m = Integer.parseInt(JOptionPane.showInputDialog("insira 'minas'"));
C.NUM_MINAS = m;
this.HardRest(); 
  
});
this.cusButton.setSize(100,100);
this.cusButton.setLocation(1500,400);
this.panel.add(this.cusButton);

}

 
public void reset(){
    for(int i = 0; i < C.NUM_LINHAS; i++){
        for( int j = 0; j < C.NUM_COLUNAS; j++){
            matbutao[i][j].reset();
        }
    }
    this.c.addMinas();
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
    public void desativaBotoes(){
        for(int i = 0; i < C.NUM_LINHAS; i++){
            for( int j = 0; j < C.NUM_COLUNAS; j++){
                matbutao[i][j].setEnabled(false);
                
            }
        }
    }
    public void estado(){
        System.out.println("verificando...");
        if (this.c.IsVencido()){
            System.out.println("venceu");
            this.desativaBotoes();

        }
        if (this.c.IsPerdido()){
            System.out.println("perdeu");
            this.desativaBotoes();
           

       } 
    }
}

