package locadora.model;

import java.time.LocalDate;

public class Filme {


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public LocalDate getDatalancamento() {
            return datalancamento;
        }

        public void setDatalancamento(LocalDate datalancamento) {
            this.datalancamento = datalancamento;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public double getValorPorHora() {
            return valorPorHora;
        }

        public void setValorPorHora(double valorPorHora) {
            this.valorPorHora = valorPorHora;
        }

        public boolean isDisponivel() {
            return disponivel;
        }

        public void setDisponivel(boolean disponivel) {
            this.disponivel = disponivel;
        }

        private long id;
        private String nome;
        private String categoria;
        private LocalDate datalancamento;
        private double valorPorHora;
        private boolean disponivel = true;

        @Override
        public String toString() {
            return "FilmeRepository{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", categoria='" + categoria + '\'' +
                    ", datalancamento=" + datalancamento +
                    ", valorPorHora=" + valorPorHora +
                    ", disponivel=" + disponivel +
                    '}';
        }
    }


