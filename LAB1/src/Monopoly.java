/*
 * Monopoly.java
 * 
 * Última modificação: 05/05
 */

import Jogador.Dominio.Jogador;
import Métodos.LerEstacao;
import Métodos.LerJogador;
import Métodos.LerServico;
import Métodos.LerTerreno;
//import CartaSorte.Dominio.CartaSorte;
import Estacao.Dominio.Estacao;
//import Peca.Dominio.Peca;
//import Propriedade.Dominio.Propriedade;
import ServicoPublico.Dominio.ServicoPublico;
import Tabuleiro.Dominio.Tabuleiro;
import Terreno.Dominio.Terreno;
import Peca.Dominio.Peca;
import java.util.Scanner;
import java.util.Random;


//Esta classe contém a estrutura de implementação de um jogo Monopoly
public class Monopoly {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem vindo ao Monopoly!!");
        
        int opcao;
        do {
            System.out.println("O que você gostaria de fazer?");
            System.out.println("1 - Adicionar Jogador");
            System.out.println("2 - Remover Jogador");
            System.out.println("3 - Comprar Serviço Público");
            System.out.println("4 - Comprar Terreno");
            System.out.println("5 - Comprar Estação");
            System.out.println("6 - Ver informações de jogador");
            System.out.println("7 - Sair");
            System.out.println("8 - Mover um jogador");
            
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    Jogador jogador = LerJogador.le_jogador();
                    Tabuleiro.jogadores.add(jogador);
                    break;

                case 2:
                    System.out.println("Digite o id do jogador que você gostaria de remover");
                    int remocao = entrada.nextInt();
                    Tabuleiro.jogadores.remove(remocao);
                    break;
                case 3:
                    System.out.println("Primeiro crie o Serviço Público");
                    ServicoPublico serv = LerServico.le_servico();
                    entrada.nextLine();
                    Tabuleiro.propriedades.add(serv);
                    System.out.println("Digite o id do jogador que está comprando: ");
                    int id = entrada.nextInt();
                    boolean comprou_serv = serv.comprar_servico(Tabuleiro.jogadores.get(id).getDinheiro());
                    serv.setDono(Tabuleiro.jogadores.get(id));
                    Jogador.cartas.add(serv);
        
                    if (comprou_serv) {
                        System.out.println("Serviço comprado!");
                    }
                    else{
                        System.out.println("Você não tem dinheiro suficiente para comprar este Serviço Público");
                    }
                    break;
                case 4:
                    System.out.println("Primeiro crie o Terreno");
                    Terreno terr =  LerTerreno.le_terreno();
                    Tabuleiro.propriedades.add(terr);
                    System.out.println("Digite o id do jogador que está comprando: ");
                    int id2 = entrada.nextInt();
                    boolean comprou_terr = terr.comprar_terreno(Tabuleiro.jogadores.get(id2).getDinheiro());
                    terr.setDono(Tabuleiro.jogadores.get(id2));
                    Jogador.cartas.add(terr);
                    
            
                    if (comprou_terr) {
                        System.out.println("Terreno comprada!");
                    }
                    else{
                        System.out.println("Você não tem dinheiro suficiente para comprar este Terreno");
                    }
                    break;
                case 5:
                    System.out.println("Primeiro crie a Estação");
                    Estacao est = LerEstacao.le_estacao();
                    Tabuleiro.propriedades.add(est);
                    System.out.println("Digite o id do jogador que está comprando: ");
                    int id3 = entrada.nextInt();
                    boolean comprou_est = est.comprar_estacao(Tabuleiro.jogadores.get(id3).getDinheiro());
                    est.setDono(Tabuleiro.jogadores.get(id3));
                    Jogador.cartas.add(est);
            
                    if (comprou_est) {
                        System.out.println("Estação comprada!");
                    }
                    else{
                        System.out.println("Você não tem dinheiro suficiente para comprar esta Estação");
                    }
                    break;
                case 6:
                    System.out.println("Digite o id do jogador que você gostaria de ver informações");
                    int id4 = entrada.nextInt();
                    Peca peca = new Peca();
                    peca = Tabuleiro.jogadores.get(id4).getPeca();
                    System.out.println(Tabuleiro.jogadores.get(id4).toString()); // impressão do jogador
                    System.out.println("Posição do jogador: " + peca.getPos());
                    break;
                
                case 7:
                    System.out.println("Finalizando ...");
                    break;
                case 8:
                    System.out.println("Escolha o Id do jogador que irá se mover");
                    int id5 = entrada.nextInt();
                    Random dado = new Random();
                    int resultado_dado = dado.nextInt(6) + 1;
                    Peca peca2 = new Peca();
                    peca2 = Tabuleiro.jogadores.get(id5).getPeca();
                    peca2.setPos(resultado_dado);
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        } while (opcao != 7);
    }
}
