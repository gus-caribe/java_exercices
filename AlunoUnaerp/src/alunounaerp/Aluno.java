//Gustavo Cardoso Ribeiro
//833.588

package alunounaerp;

public class Aluno {
    float parcial, exame;
    
    //registra os dados dos alunos
    Aluno(float p, float e) {
        this.parcial = p;
        this.exame = e;
    }
    
    //retorna a média
    float Media() {
        return (float)((parcial*0.4) + (exame*0.6));
    }
    
    //retorna o status
    String StringStatus() {
        if(Media() >= 5)
            return "Aprovado";
        else
            return "Reprovado";
    }
}
