import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GerenciarTarefa {

    private ArrayList<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(String titulo, String descricao){
        Tarefa novaTarefa = new Tarefa(titulo, descricao);
        tarefas.add(novaTarefa);
    }

    public void listarTarefas(){
        for(int i = 0; i<tarefas.size(); i++){
            Tarefa tarefa = tarefas.get(i);
            System.out.println("ID: " + tarefa.getId() + "\nTítulo: " + tarefa.getTitulo() + "\nConcluída: " 
                                + (tarefa.isConcluida() ? "Sim" : "Não" + "\nData de criação: " + tarefa.getDataCriacao()) + "\n");
        }
    }

    public Tarefa buscarTarefaId(int id){
        for(int i = 0; i<tarefas.size(); i++){
            Tarefa tarefa = tarefas.get(i);
            if(tarefa.getId() == id){
                return tarefa;
            }
        }
        System.out.println("Tarefa não encontrada!");
        return null;
    }

    public void removerTarefa(int id){
        Tarefa tarefa = buscarTarefaId(id);

        if(tarefa != null){
            tarefas.remove(tarefa);
            System.out.println("Sua tarefa foi removida!");
        }else{
            System.out.println("Não conseguimos encontrar está tarefa!");
        }
    } 

    public static void main(String[] args) {
        GerenciarTarefa Gerenciador = new GerenciarTarefa();
        int opcao;

        do{
            String menu = """
                        1 - Criar tarefa
                        2 - Listar Tarefas
                        3 - Buscar Tarefa
                        4 - Marcar Tarefa Como Concluida
                        5 - Remover Tarefa
                        0 - Sair
                    """;

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            
            switch(opcao){
                
                case 1 :
                    String titulo = JOptionPane.showInputDialog("Como deseja chamar sua Tarefa: ");
                    String descricao = JOptionPane.showInputDialog("Descreva sua Tarefa: ");
                    Gerenciador.adicionarTarefa(titulo, descricao);
                    break;
                
                case 2:
                    Gerenciador.listarTarefas();;
                    break;

                case 3:
                    int busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da Tarefa: "));
                    
                    Tarefa tarefa = Gerenciador.buscarTarefaId(busca);
                    if(tarefa != null){
                        JOptionPane.showMessageDialog(null, "Título: " + tarefa.getTitulo()
                                                       + "\nDescrição: " + tarefa.getDescricao());
                    break;
                    }else{
                        JOptionPane.showMessageDialog(null, "Tarefa não encontrada!");
                        break;
                    }

                case 4:
                    int concluir = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da Tarefa: "));

                    Tarefa t = Gerenciador.buscarTarefaId(concluir);
                    if(t != null){
                        t.concluirTarefa();
                        JOptionPane.showMessageDialog(null, "Sua Tarefa foi removida!");
                        break;
                    }else{
                        JOptionPane.showMessageDialog(null, "Tarefa não encontrada!");
                        break;
                    }
                
                case 5:
                    int remover = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da sua Tarefa: "));
                    Gerenciador.removerTarefa(remover);
                    break;
                
                case 0:
                    JOptionPane.showMessageDialog(null, "Obrigado por utilizar o programa!");
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Digite uma opção válida!");
            }

        }while(opcao != 0);
    }

}

