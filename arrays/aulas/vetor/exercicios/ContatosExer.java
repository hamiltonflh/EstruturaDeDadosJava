package arrays.aulas.vetor.exercicios;
import arrays.aulas.vetor.Vetor;
import arrays.aulas.vetor.teste.Contato;
import java.util.Scanner;
import java.lang.Thread;

public class ContatosExer {
    public static void main(String[] args){
        Vetor<Contato> contatos = new Vetor<>(20);
        Scanner tec = new Scanner(System.in);
        int opcao = 0;
        criarContatosDinamencamente(30, contatos);

        while(opcao!=6){
            opcao = escolherOpcao(tec);

            switch(opcao){
                case 1:
                    criarContatoFinal(tec,contatos);
                    break;
                case 2:
                    removerContato(tec, contatos);
                    break;
                case 3:
                    pesquisarContato(tec, contatos);
                    break;
                case 4:
                    listarContatos(contatos);
                    break;
                case 5:
                    contatos.removeAll();
                    break;
                case 6:
                    try{
                        System.out.println("Finalizando...");
                        Thread.sleep(2000);
                        System.out.println("Volte Sempre!");
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
            }

        }
    }

    private static void criarContatoFinal(Scanner scan, Vetor<Contato> contatos){
        String nome = lerInformacao("Digite o nome: ", scan);
        String telefone = lerInformacao("Digite o telefone: ", scan);
        String email = lerInformacao("Digite o email: ", scan);

        Contato contato = new Contato(nome,telefone,email);
        contatos.adiciona(contato);
        System.out.println("Contato adicionado com Sucesso!!");
        System.out.println(contato);
    }


    private static String lerInformacao(String msg, Scanner scan){
        System.out.println(msg);
        return scan.nextLine();
    }


    private static void removerContato(Scanner scan, Vetor<Contato> contatos){
        boolean contatoRemovido = false;
        Contato aux = null;
        while(contatoRemovido == false){
            String contato = lerInformacao("Digite o nome do contato no qual você quer remover:", scan);
            for (int i=0;i<contatos.tamanho();i++){
                aux = contatos.obtem(i);
                if(aux.getNome().equals(contato)){
                    contatos.remove(aux);
                    contatoRemovido = true;
                }
            }
            if(contatoRemovido){
                System.out.println("Contato removido com Sucesso");
            } else{
                System.out.println("Contato não encontrado. Digite novamente.");
            }
        }

    }


    private static void pesquisarContato(Scanner scan, Vetor<Contato> contatos){
        boolean contatoEncontrado = false;
        Contato aux = null;
        while(contatoEncontrado == false){
            String pesquisa = lerInformacao("Digite o nome do Contato: ", scan);

            for (int i=0;i<contatos.tamanho();i++){
                aux = contatos.obtem(i);
                if(aux.getNome().equals(pesquisa)) {
                    contatoEncontrado = true;
                    break;
                }
            }
            if(contatoEncontrado){
                System.out.println("Resultado da Pesquisa: ");
                System.out.println("Nome: " + aux.getNome());
                System.out.println("Telefone: " + aux.getTelefone());
                System.out.println("Email: " + aux.getEmail());
                System.out.println("----------------------------------------------------------");
            } else{
                System.out.println("Contato não encontrado. Pesquise novamente.");
            }
        }

    }


    public static void listarContatos(Vetor<Contato> contatos){
        Contato aux;
        if(contatos.tamanho() > 0){
            System.out.println("--------------------------------------");
            for(int i=0;i<contatos.tamanho();i++){
                aux = contatos.obtem(i);
                System.out.println("Nome: "+ aux.getNome());
                System.out.println("Telefone: "+ aux.getTelefone());
                System.out.println("Email: "+ aux.getEmail());
                System.out.println(" ");
            }
            System.out.println("--------------------------------------");
        } else{
            System.out.println("A Lista está Vazia. Adicione algum contato para eu poder Listá-los");
        }


    }


    private static int escolherOpcao(Scanner tec){
        boolean entradaValida = false;
        int opcao = 0;
        String entrada;
        while(!entradaValida){
            System.out.println("Menu: Escolha uma opção abaixo:");
            System.out.println("[1] Adicionar Contato;");
            System.out.println("[2] Remover Contato;");
            System.out.println("[3] Pesquisar Contato;");
            System.out.println("[4] Listar Contatos;");
            System.out.println("[5] Excluir todos os Contatos;");
            System.out.println("[6] Finalizar Atendimento.");
            System.out.println("----------------------------------------------------");

            try{
                entrada = tec.nextLine();
                opcao = Integer.parseInt(entrada);

                if(opcao>=0 && opcao<=6){
                    entradaValida = true;
                } else{
                    throw new Exception();
                }

            } catch(Exception e){
                System.out.println("Entrada inválida, digite novamente");
            }

        }
        return opcao;
    }


    private static void criarContatosDinamencamente(int quantidade, Vetor<Contato> contatos){
        Contato contato;
        for(int i=1;i<=quantidade;i++){
            contato = new Contato();
            contato.setNome("Contato "+ i);
            contato.setTelefone("111111"+i);
            contato.setEmail("contato"+i+"@email.com");
            contatos.adiciona(contato);
        }
    }
}
