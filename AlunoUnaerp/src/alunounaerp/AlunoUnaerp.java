//Gustavo Cardoso Ribeiro
//833.588

package alunounaerp;

import javax.swing.JOptionPane;

public class AlunoUnaerp {
    public static void main(String[] args) {
        Aluno aluno[] = new Aluno[10];
        int i, count=0;
        float parcial, exame;
        String lista = "";
        
        for(i=0; i<10; i++) {//coleta os dados dos alunos
            parcial = Float.parseFloat(JOptionPane.showInputDialog("Insira a nota PARCIAL do aluno " + (i+1) + ":"));
            exame = Float.parseFloat(JOptionPane.showInputDialog("Insira a nota do EXAME do aluno " + (i+1) + ":"));
            
            //vai guardando no array
            aluno[i] = new Aluno(parcial, exame);
        }
        
        for(i=0; i<10; i++) {//vai carregando a Strings com as informações coletadas
            lista = lista + "Aluno " + (i+1) + ":\n"
                + "Média: " + aluno[i].Media() + "    "
                + "Status: " + aluno[i].StringStatus() + "\n\n";

            count++;
                
            if(count >= 5) {//sempre que a String já está preenchida com 5 informações
                //printa a String
                JOptionPane.showMessageDialog(null, lista);
                //zera a String
                lista = "";
                count = 0;
            }
        }
    }
}
