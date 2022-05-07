package proj;

import java.util.*;

public class Defesa extends Jogador {
    private int cortes = 70;

    public Defesa(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int c,
            ArrayList<String> his) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p, his);
        this.cortes = c;
        super.setMedia(this.calcularMedia());
    }

    public static Defesa parse(String input) {
        String[] campos = input.split(",");
        return new Defesa(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]), Integer.parseInt(campos[4]), Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]), Integer.parseInt(campos[7]), Integer.parseInt(campos[8]), 70,
                new ArrayList<>());
    }

    public Defesa(Defesa d) {
        super(d);
        this.cortes = d.getCortes();

    }

    public int getCortes() {
        return this.cortes;
    }

    public void getCortes(int c) {
        this.cortes = c;
    }

    public String extraCaracteristicas() {
        return "Cortes:" + getCortes();
    }

    public double calcularMedia() {
        double media = (double) super.getVelocidade() * 0.05 + (double) super.getResistencia() * 0.10
                + (double) super.getDestreza() * 0.10 + (double) super.getImpulsao() * 0.10
                + (double) super.getCabeca() * 0.20 + (double) super.getRemate() * 0.05
                + (double) super.getPasse() * 0.20 + (double) this.getCortes() * 0.20;
        return media;

    }

    public String getPosicao() {
        return ("Defesa");
    }

    public Defesa clone() {
        return new Defesa(this);
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Defesa d = (Defesa) obj;
        return super.equals(d);

    }
}
