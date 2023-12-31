//Gustavo Cardoso Ribeiro
//833.588

package cadastrarproduto;
import javax.swing.JOptionPane;

public class CadastrarProduto {
    
    public static void main(String[] args) {
        Produto produto[] = new Produto[10];
        int opt, qnt=0, i, ant, count;
        boolean existe;
        String menu, cod, desc, listar;
        float custo, venda, porcent;
        
        //seta string que representa o menu
        menu = "MENU:\n\n"
            + "1 - Cadastrar Produto;\n"
            + "2 - Aplicar Aumento;\n"
            + "3 - Aplicar Desconto;\n"
            + "4 - Editar Descrição;\n"
            + "5 - Listar;\n"
            + "6 - Exibir o(s) Mais Caro(s);\n"
            + "7 - Exibir o(s) Mais Barato(s);\n\n"
            + "0 - Sair;\n\n"
            + "Opção:";
        
        do {//Enquanto a opção escolhida não for "0 - Sair"
            //imprime menu
            opt = Integer.parseInt(JOptionPane.showInputDialog(menu));
            
            switch(opt) {
                default://Opção inválida
                    JOptionPane.showMessageDialog(null, "Opção Inválida.");
                    break;
                
                case 0://Sair
                    break;
                    
                case 1://Cadastrar produto
                    if(qnt >= 10)//se já foram cadastrados 10 produtos (máximo, de acordo com o enunciado)
                        JOptionPane.showMessageDialog(null, "Limite atingido.");
                    else {//se não
                        do {//enquanto o código digitado já estiver cadastrado
                            cod = JOptionPane.showInputDialog("Informe o código do produto: ");
                            
                            existe = false;
                            
                            //procura pra ver se já está cadastrado
                            for(i=0; i<qnt; i++) {
                                if(cod.equals(produto[i].codigo)) {
                                    existe = true;
                                    i = qnt+1;
                                }
                            }
                            
                            if(existe)
                                JOptionPane.showMessageDialog(null, "Código já cadastrado.");
                        } while(existe);
                        
                        desc = JOptionPane.showInputDialog("Informe a descrição do produto: ");
                        custo = Float.parseFloat(JOptionPane.showInputDialog("Informe o preço de custo do produto: "));
                        venda = Float.parseFloat(JOptionPane.showInputDialog("Informe o preço de venda do produto: "));
                        
                        while(venda < custo) {//enquanto o preço de custo inserido for menor que o preço de venda
                            JOptionPane.showMessageDialog(null, "Preço de venda menor que preço de custo.\n\nPreço de custo: " + custo);
                            venda = Float.parseFloat(JOptionPane.showInputDialog("Informe o preço de venda do produto: "));
                        }

                        //cria um novo produto com os dados coletados
                        produto[qnt++] = new Produto(cod, desc, custo, venda);

                        JOptionPane.showMessageDialog(null, "Sucesso.");
                    }
                    break;
                    
                case 2://Aplicar aumento
                    if(qnt == 0) {//se não houver nenhum produto cadastrado
                        JOptionPane.showMessageDialog(null, "Não há produtos.");
                    }
                    else {//se já houver algum produto cadastrado
                        cod = JOptionPane.showInputDialog("Informe o código do produto: ");

                        existe = false;

                        for(i=0; i<qnt; i++) {//vasculha todo o cadastro
                            if(cod.equals(produto[i].codigo)) {//se chegou no no produto com o código digitado
                                porcent = Float.parseFloat(JOptionPane.showInputDialog("Informe a porcentagem do aumento: "));

                                produto[i].Aumento(porcent);

                                JOptionPane.showMessageDialog(null, "Sucesso.");

                                existe = true;
                                i = qnt+1;
                            }
                        }

                        if(!existe)//se o produto inserido não estiver cadastrado
                            JOptionPane.showMessageDialog(null, "Produto não cadastrado.");
                    }
                    break;
                    
                case 3://Aplicar desconto
                    if(qnt == 0) {//se não houver nenhum produto cadastrado
                        JOptionPane.showMessageDialog(null, "Não há produtos.");
                    }
                    else {//se houver algum produto cadastrado
                        cod = JOptionPane.showInputDialog("Informe o código do produto: ");

                        existe = false;

                        for(i=0; i<qnt; i++) {//vasculha todo o cadastro
                            if(cod.equals(produto[i].codigo)) {//se chegou no produto com o código digitado
                                porcent = Float.parseFloat(JOptionPane.showInputDialog("Informe a porcentagem do desconto: "));

                                if(produto[i].Desconto(porcent) == 1)//se o desconto não der prejuizo
                                    JOptionPane.showMessageDialog(null, "Sucesso.");
                                else//se der prejuizo
                                    JOptionPane.showMessageDialog(null, "Valor final menor que preço de custo.\n\n" + "Custo: " + produto[i].preco_custo + "\nVenda: " + produto[i].preco_venda);

                                existe = true;
                                i = qnt+1;
                            }
                        }

                        if(!existe)//se o produto não estiver no cadastro
                            JOptionPane.showMessageDialog(null, "Produto não cadastrado.");
                    }
                    break;
                    
                case 4://Editar descrição
                    if(qnt == 0) {//se não houver nenhum produto cadastrado
                        JOptionPane.showMessageDialog(null, "Não há produtos.");
                    }
                    else {//se houver algum produto cadastrado
                        cod = JOptionPane.showInputDialog("Informe o código do produto: ");

                        existe = false;

                        for(i=0; i<qnt; i++) {//vasculha todo o cadastro
                            if(cod.equals(produto[i].codigo)) {//se chegou no produto com o código 
                                desc = JOptionPane.showInputDialog("Informe a nova descrição: ");

                                produto[i].AlterarDescricao(desc);
                                JOptionPane.showMessageDialog(null, "Sucesso.");

                                existe = true;
                                i = qnt+1;
                            }
                        }

                        if(!existe)//se o produto digitado não estiver cadastrado
                            JOptionPane.showMessageDialog(null, "Produto não cadastrado.");
                    }
                    break;
                    
                case 5://Listar
                    if(qnt == 0) {//se não houver nenhum produto cadastrado
                        JOptionPane.showMessageDialog(null, "Não há produtos.");
                    }
                    else {//se houver algum produto cadastrado
                        listar = "LISTA:\n\n";
                        ant = 0;

                        while(ant < qnt) {//enquanto não chegar no último produto cadastrado
                            for(i=0; i<5; i++) {//tenta carregar a String com informações 5 vezes
                                if(ant < qnt) {//se as iterações não superarem a quantidade de produtos cadastrados
                                    //carrega a String da lista
                                    listar = listar + produto[ant].StringImprime(ant+1);
                                    ant++;
                                }
                            }
                            //imprime a String com as informações carregadas (max = 5)
                            JOptionPane.showMessageDialog(null, listar);
                            //zera a String
                            listar = "";
                        }
                    }
                    break;
                    
                case 6://Exibir o(s) mais caro(s)
                    if(qnt == 0) {//se não houver nenhum produto cadastrado
                        JOptionPane.showMessageDialog(null, "Não há produtos.");
                    }
                    else {//se houver algum produto cadastrado
                        venda = 0;
                        count = 0;

                        for(i=0; i<qnt; i++) {//encontra o valor mais caro
                            if(produto[i].preco_venda > venda)
                                venda = produto[i].preco_venda;
                        }

                        listar = "MAIS CAROS:\n\n";

                        for(i=0; i<qnt; i++) {//vasculha todo o cadastro
                            if(produto[i].preco_venda == venda) {//se o produto da vez tem o preço mais caro encontrado
                                //carrega a String com o produto
                                listar = listar + produto[i].StringImprime(i+1);
                                count++;

                                if(count >= 5) {//se já houverem 5 produtos carregados na String
                                    //exibe a String
                                    JOptionPane.showMessageDialog(null, listar);
                                    //zera a String
                                    listar = "";
                                    count = 0;
                                }
                            }
                            
                            //se estiver na última rodada e houver algum produto carregado na String
                            if(count > 0 && i == qnt-1) {
                                JOptionPane.showMessageDialog(null, listar);
                            }
                        }
                    }
                    break;
                    
                case 7://Exibir o(s) mais barato(s)
                    if(qnt == 0) {//Se não houver nenhum produto cadastrado
                        JOptionPane.showMessageDialog(null, "Não há produtos.");
                    }
                    else {//se houver algum produto cadastrado
                        venda = produto[0].preco_venda;
                        count = 0;

                        for(i=0; i<qnt; i++) {//encontra o valor mais barato do cadastro
                            if(produto[i].preco_venda < venda)
                                venda = produto[i].preco_venda;
                        }

                        listar = "MAIS BARATOS:\n\n";

                        for(i=0; i<qnt; i++) {//vasculha todo o cadastro
                            if(produto[i].preco_venda == venda) {//se o produto da vez tiver o preço mais barato
                                //carrega a String com o produto
                                listar = listar + produto[i].StringImprime(i+1);
                                count++;

                                if(count >= 5) {//se a String estiver carregada com 5 produtos
                                    //printa a String
                                    JOptionPane.showMessageDialog(null, listar);
                                    //zera a String
                                    listar = "";
                                    count = 0;
                                }
                            }
                            
                            //se estiver na última rodada e a String estiver carregada com produtos
                            if(count > 0 && i == qnt-1) {
                                JOptionPane.showMessageDialog(null, listar);
                            }
                        }
                    }
                    break;
            }
        }while(opt != 0);
    }
}
