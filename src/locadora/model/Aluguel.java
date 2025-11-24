package locadora.model;



import java.time.Duration;
import java.time.LocalDateTime;

public class Aluguel extends Filme {

    public double calcularValor(){

        Duration duracao = Duration.between(dataHoraAluguel, dataHoraDevolucao);
        long horas = duracao.toHours();
        if (duracao.toMinutesPart() > 0) {
            horas += 1;
        }
        return horas * filme.getValorPorHora();





    }



    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public LocalDateTime getDataHoraAluguel() {
        return dataHoraAluguel;
    }

    public void setDataHoraAluguel(LocalDateTime dataHoraAluguel) {
        this.dataHoraAluguel = dataHoraAluguel;
    }

    public LocalDateTime getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

    public void setDataHoraDevolucao(LocalDateTime dataHoraDevolucao) {
        this.dataHoraDevolucao = dataHoraDevolucao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }



    private long id;
    private Cliente cliente;
    private  Filme filme;
    private LocalDateTime dataHoraAluguel;
    private LocalDateTime dataHoraDevolucao = null;
    private double valorTotal;


}
