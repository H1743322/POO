package proj;

import java.util.ArrayList;

public class Medio extends Jogador {
    private int recuperacao;

    public Medio(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int rec,
            ArrayList<String> his) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p, his);
        recuperacao = rec;
        super.setMedia(this.calcularMedia());

    }

    public static Medio parse(String input) {
        String[] campos = input.split(",");
        return new Medio(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]), Integer.parseInt(campos[4]), Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]), Integer.parseInt(campos[7]), Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]), new ArrayList<>());
    }

    public Medio(Medio l) {
        super(l);
        this.recuperacao = l.getRecuperacao();
    }

    public int getRecuperacao() {
        return this.recuperacao;
    }

    public void getRecuperacao(int l) {
        this.recuperacao = l;
    }

    public String extraCaracteristicas() {
        return "Recuperacao:" + getRecuperacao();
    }

    public double calcularMedia() {
        double media = (double) super.getVelocidade() * 0.10 + (double) super.getResistencia() * 0.10
                + (double) super.getDestreza() * 0.15 + (double) super.getImpulsao() * 0.05
                + (double) super.getCabeca() * 0.05 + (double) super.getRemate() * 0.10
                + (double) super.getPasse() * 0.20 + (double) this.getRecuperacao() * 0.25;
        return media;

    }

    public Medio clone() {
        return new Medio(this);
    }

    public String getPosicao() {
        return ("Medio");
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Medio d = (Medio) obj;
        return super.equals(d);

    }

}
