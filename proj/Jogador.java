package proj;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Jogador implements Serializable {

    private String nomeJogador;
    private int numeroJogador;
    private int velocidade, resistencia, destreza, impulsao, cabeca, remate, passe;
    private double media;
    private ArrayList<String> historico;

    public Jogador() {
        nomeJogador = "";
        numeroJogador = 0;
        velocidade = 0;
        resistencia = 0;
        destreza = 0;
        impulsao = 0;
        cabeca = 0;
        remate = 0;
        passe = 0;
        media = 0;
        this.historico = new ArrayList<>();
    }

    public Jogador(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p,
            ArrayList<String> his) {
        nomeJogador = nomeJ;
        numeroJogador = numeroJ;
        velocidade = vel;
        resistencia = res;
        destreza = des;
        impulsao = imp;
        cabeca = cab;
        remate = rem;
        passe = p;
        media = this.calcularMedia();
        this.historico = his;
    }

    public Jogador(Jogador j) {
        nomeJogador = j.getNomeJogador();
        numeroJogador = j.getNumeroJogador();
        velocidade = j.getVelocidade();
        resistencia = j.getResistencia();
        destreza = j.getDestreza();
        impulsao = j.getImpulsao();
        cabeca = j.getCabeca();
        remate = j.getRemate();
        passe = j.getPasse();
        media = j.getMedia();
        historico = j.getHistorico();
    }

    public abstract double calcularMedia();

    public abstract String getPosicao();

    public abstract String extraCaracteristicas();

    public double getMedia() {
        return this.media;
    }

    public void setMedia(Double m) {
        this.media = m;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getNumeroJogador() {
        return numeroJogador;
    }

    public void setNumeroJogador(int numeroJogador) {
        this.numeroJogador = numeroJogador;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getImpulsao() {
        return impulsao;
    }

    public void setImpulsao(int impulsao) {
        this.impulsao = impulsao;
    }

    public int getCabeca() {
        return cabeca;
    }

    public void setCabeca(int cabeca) {
        this.cabeca = cabeca;
    }

    public int getRemate() {
        return remate;
    }

    public void setRemate(int remate) {
        this.remate = remate;
    }

    public int getPasse() {
        return passe;
    }

    public void setPasse(int passe) {
        this.passe = passe;
    }

    public void setHistorico(ArrayList<String> historico) {
        this.historico = historico;
    }

    public ArrayList<String> getHistorico() {
        return this.historico;
    }

    public void insereHistorico(String nome) {
        this.historico.add(nome);
    }

    public abstract Jogador clone();

    /*
     * public static Jogador parse(String input){ String[] campos =
     * input.split(","); return new Jogador(campos[0], Integer.parseInt(campos[1]),
     * campos[2], Integer.parseInt(campos[3]), Integer.parseInt(campos[4]),
     * Integer.parseInt(campos[5]), Integer.parseInt(campos[6]),
     * Integer.parseInt(campos[7]), Integer.parseInt(campos[8])); }
     */

    public String toString() {
        return nomeJogador + "\n";
    }

    public String toString2() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: ").append(this.nomeJogador).append('\n').append("Numero: ").append(this.numeroJogador)
                .append('\n').append("Velocidade: ").append(this.velocidade).append('\n').append("Resistencia: ")
                .append(this.resistencia).append('\n').append("Destreza: ").append(this.destreza).append('\n')
                .append("Impulsao: ").append(this.impulsao).append('\n').append("Cabeca: ").append(this.cabeca)
                .append('\n').append("Remate: ").append(this.remate).append('\n').append("Passe: ").append(this.passe)
                .append(this.historico.toString()).append('\n');
        return sb.toString();

    }
}
