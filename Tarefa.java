public class Tarefa {

    private static int contadorId = 0;
    private int id;
    private String titulo;
    private String descricao;
    private boolean concluida;
    private java.time.LocalDate dataCriacao;
    
    public Tarefa(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false;
        this.dataCriacao = java.time.LocalDate.now();
        this.id = ++contadorId;
    }


    // Métodos
    public void concluirTarefa(){
        this.concluida = true;
    }

    public void alterarStatus(){
        this.concluida = !this.concluida;
    }

    
    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public java.time.LocalDate getDataCriacao() {
        return dataCriacao;
    }


}
