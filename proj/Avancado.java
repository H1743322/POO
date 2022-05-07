package proj;

import java.util.*;

public class Avancado extends Jogador {

    private int finalizacao = 70;

    public Avancado(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int fin,
            ArrayList<String> his) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p, his);
        this.finalizacao = fin;
        super.setMedia(this.calcularMedia());
    }

    public static Avancado parse(String input) {
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]), Integer.parseInt(campos[4]), Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]), Integer.parseInt(campos[7]), Integer.parseInt(campos[8]), 70,
                new ArrayList<>());
    }

    public Avancado(Avancado a) {
        super(a);
        this.finalizacao = a.getFinalizacao();

    }

    public int getFinalizacao() {
        return this.finalizacao;
    }

    public void getFinalizacao(int fin) {
        this.finalizacao = fin;
    }

    public double calcularMedia() {
        double media = (double) super.getVelocidade() * 0.10 + (double) super.getResistencia() * 0.05
                + (double) super.getDestreza() * 0.10 + (double) super.getImpulsao() * 0.10
                + (double) super.getCabeca() * 0.15 + (double) super.getRemate() * 0.20
                + (double) super.getPasse() * 0.05 + (double) this.getFinalizacao() * 0.25;
        return media;

    }

    public String getPosicao() {
        return ("Avancado");
    }

    public String extraCaracteristicas() {
        return "Finalizacao:" + getFinalizacao();
    }

    public Avancado clone() {
        return new Avancado(this);
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Avancado a = (Avancado) obj;
        return super.equals(a);

    }
}
