//Gustavo Cardoso Ribeiro
//833.588

package cadastrarproduto;

public class Produto {
    String codigo, descricao;
    float preco_custo, preco_venda;
    
    //seta valores no produto
    Produto (String c, String d, float pc, float pv) {
        this.codigo = c;
        this.descricao = d;
        this.preco_custo = pc;
        this.preco_venda = pv;
    }
    
    //aplica desconto
    int Desconto (float porcentagem) {
        if((this.preco_venda - (this.preco_venda * (porcentagem/100))) < this.preco_custo)//se o desconto der prejuizo
            return 0;//não deu certo
        else {//se não der prejuizo
            this.preco_venda = this.preco_venda - (this.preco_venda * (porcentagem/100));
            return 1;//deu certo
        }
    }
    
    //aplica aumento
    void Aumento (float porcentagem) {
        this.preco_venda = this.preco_venda * (1 + (porcentagem/100));
    }
    
    //altera descrição
    void AlterarDescricao (String nova) {
        this.descricao = nova;
    }
    
    //retorna String do produto formatada para imprimir
    String StringImprime(int indice) {
        return "ITEM " + indice + ":\n" 
                + "Código: " + this.codigo + "\n" 
                + "Descrição: " + this.descricao + "\n"
                + "Preço: " + this.preco_venda + "\n\n";
    }
}
