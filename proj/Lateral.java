package proj;

import java.util.*;

public class Lateral extends Jogador {
    private int cruzamento;

    public Lateral(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int cruz,
            ArrayList<String> his) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p, his);
        cruzamento = cruz;
        super.setMedia(this.calcularMedia());
    }

    public static Lateral parse(String input) {
        String[] campos = input.split(",");
        return new Lateral(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]), Integer.parseInt(campos[4]), Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]), Integer.parseInt(campos[7]), Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]), new ArrayList<>());
    }

    public Lateral(Lateral l) {
        super(l);
        this.cruzamento = l.getCruzamento();
    }

    public int getCruzamento() {
        return this.cruzamento;
    }

    public void getCruzamento(int l) {
        this.cruzamento = l;
    }

    public String extraCaracteristicas() {
        return "Cruzamento:" + getCruzamento();
    }

    public double calcularMedia() {
        double media = (double) super.getVelocidade() * 0.20 + (double) super.getResistencia() * 0.15
                + (double) super.getDestreza() * 0.10 + (double) super.getImpulsao() * 0.05
                + (double) super.getCabeca() * 0.05 + (double) super.getRemate() * 0.05
                + (double) super.getPasse() * 0.15 + (double) this.getCruzamento() * 0.25;
        return media;

    }

    public String getPosicao() {
        return ("Lateral");
    }

    public Lateral clone() {
        return new Lateral(this);
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Lateral d = (Lateral) obj;
        return super.equals(d);

    }
}
