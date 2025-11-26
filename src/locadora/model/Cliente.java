package locadora.model;

public class Cliente {

    private String nome;
    private long CPF;
    private long id;
    private String email;
    private long telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente" +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nCPF: " + CPF +
                "\nE-mail: " + email +
                "\nTelefone: " + telefone +
                "\n";
    }

}
