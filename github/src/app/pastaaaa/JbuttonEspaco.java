package app.pastaaaa;


import javax.swing.JButton;

public class JbuttonEspaco extends JButton{
    int linha;
    int coluna;
    campo c;
    Espaco e;
    private String text;
   
   
    public JbuttonEspaco(campo c){
        setText("");
        this.setText(getText());
      this.c = c;
            this.addActionListener((java.awt.event.ActionEvent evt) -> {
                botPress(evt);
            
        });
    }
    private void botPress(java.awt.event.ActionEvent evt){
       this.clicar();

    }
    public void clicar(){
        System.out.println("linha: " + linha + " coluna: " + coluna);

        if(e.minado){
            this.setEnabled(false);
            return;
        }
        int ret = e.clicar();
        if(ret == 0){
            return;
        }
    
       this.text = Integer.toString(ret);
       this.setText(text);
       this.setEnabled(false);
    }
    public void setPos(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna; 
     
        this.e = c.getEspaco(linha, coluna);
    }
    
}