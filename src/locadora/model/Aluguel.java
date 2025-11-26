package locadora.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Aluguel {

    private long id;
    private Cliente cliente;
    private Filme filme;
    private LocalDateTime dataHoraAluguel;
    private LocalDateTime dataHoraDevolucao = null;
    private double valorTotal;

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String aluguelStr = dataHoraAluguel != null ? dataHoraAluguel.format(formatter) : "não registrado";
        String devolucaoStr = dataHoraDevolucao != null ? dataHoraDevolucao.format(formatter) : "não devolvido";
        String clienteStr = cliente != null ? cliente.getNome() + " (ID: " + cliente.getId() + ")" : "não informado";
        String filmeStr = filme != null ? filme.getNome() + " (ID: " + filme.getId() + ")" : "não informado";

        return "Aluguel" +
                "\n  ID: " + id +
                "\n  Cliente: " + clienteStr +
                "\n  Filme: " + filmeStr +
                "\n  Data do Aluguel: " + aluguelStr +
                "\n  Data da Devolução: " + devolucaoStr +
                "\n  Valor Total: R$ " + String.format("%.2f", getValorTotal()) +
                "\n";
    }

    public double calcularValor() {
        if (dataHoraAluguel == null || dataHoraDevolucao == null || filme == null) {
            return 0.0;
        }
        Duration duracao = Duration.between(dataHoraAluguel, dataHoraDevolucao);
        long horas = duracao.toHours();
        if (duracao.toMinutesPart() > 0) {
            horas++;
        }
        if (horas <= 0) {
            horas = 1;
        }
        return horas * filme.getValorPorHora();
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Filme getFilme() { return filme; }
    public void setFilme(Filme filme) { this.filme = filme; }

    public LocalDateTime getDataHoraAluguel() { return dataHoraAluguel; }
    public void setDataHoraAluguel(LocalDateTime dataHoraAluguel) { this.dataHoraAluguel = dataHoraAluguel; }

    public LocalDateTime getDataHoraDevolucao() { return dataHoraDevolucao; }
    public void setDataHoraDevolucao(LocalDateTime dataHoraDevolucao) {
        this.dataHoraDevolucao = dataHoraDevolucao;
        this.valorTotal = calcularValor();
    }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }
}
