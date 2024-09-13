
import java.util.Scanner;

public class SistemaAtendimento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha historicoSolicitacoes = new Pilha();
        Fila ordemAtendimento = new Fila();

        while (true) {
            System.out.println("\nSistema de Gerenciamento de Atendimento ao Cliente");
            System.out.println("1. Adicionar solicitação ao histórico");
            System.out.println("2. Remover solicitação do histórico");
            System.out.println("3. Adicionar cliente à fila");
            System.out.println("4. Atender próximo cliente");
            System.out.println("5. Mostrar histórico de solicitações");
            System.out.println("6. Mostrar fila de atendimento");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção (digite o número correspondente): ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("ID da solicitação: ");
                        String idSolicitacao = scanner.nextLine();
                        System.out.print("Descrição da solicitação: ");
                        String descricaoSolicitacao = scanner.nextLine();
                        System.out.print("Data e hora (YYYY-MM-DD hh:mm): ");
                        String dataHoraSolicitacao = scanner.nextLine();
                        historicoSolicitacoes.push(new Elemento(idSolicitacao, descricaoSolicitacao, dataHoraSolicitacao));
                        System.out.println("Solicitação adicionada ao histórico.");
                        break;
                    case 2:
                        System.out.print("Digite o ID da solicitação a ser removida: ");
                        String idParaRemover = scanner.nextLine();
                        Elemento removido = historicoSolicitacoes.remover(idParaRemover);
                        System.out.println("Solicitação removida do histórico: " + removido);
                        break;
                    case 3:
                        System.out.print("ID do cliente: ");
                        String idCliente = scanner.nextLine();
                        System.out.print("Nome do cliente: ");
                        String nomeCliente = scanner.nextLine();
                        System.out.print("Motivo do atendimento: ");
                        String motivoAtendimento = scanner.nextLine();
                        ordemAtendimento.enqueue(new Elemento(idCliente, nomeCliente, motivoAtendimento));
                        System.out.println("Cliente adicionado à fila.");
                        break;
                    case 4:
                        Elemento atendido = ordemAtendimento.dequeue();
                        System.out.println("Cliente atendido: " + atendido);
                        break;
                    case 5:
                        System.out.println("Histórico de Solicitações:");
                        historicoSolicitacoes.imprimirPilha();
                        break;
                    case 6:
                        System.out.println("Fila de Atendimento:");
                        ordemAtendimento.imprimirFila();
                        break;
                    case 7:
                        System.out.println("Encerrando o sistema...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}