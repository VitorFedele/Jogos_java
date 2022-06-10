package ppspspspss;

public class pessoaFisica extends pessoa{
    private String CPF;
    private double base;

    public pessoaFisica(String CPF, String Nome, int AnoInscricao){ 
    }   
       
    public double calcBonus(int Ano) {
        return Ano;
    }
    public String getCPF(){
        return CPF;
    }
    public void setBase(double base){
    }
    public double getbase(){
       return base;
    }
 
    }

