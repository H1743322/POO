package proj;

import java.util.*;

public class GuardaRedes extends Jogador {
    private int elasticidade;

    public GuardaRedes(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p,
            int elast, ArrayList<String> his) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p, his);
        this.elasticidade = elast;
        super.setMedia(this.calcularMedia());

    }

    public static GuardaRedes parse(String input) {
        String[] campos = input.split(",");
        return new GuardaRedes(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]), Integer.parseInt(campos[4]), Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]), Integer.parseInt(campos[7]), Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]), new ArrayList<>());
    }

    public GuardaRedes(GuardaRedes g) {
        super(g);
        this.elasticidade = g.getElasticidade();
    }

    public int getElasticidade() {
        return this.elasticidade;
    }

    public void getElasticidade(int e) {
        this.elasticidade = e;
    }

    public double calcularMedia() {
        double media = (double) super.getVelocidade() * 0.05 + (double) super.getResistencia() * 0.05
                + (double) super.getDestreza() * 0.20 + (double) super.getImpulsao() * 0.20
                + (double) super.getCabeca() * 0.05 + (double) super.getRemate() * 0.10
                + (double) super.getPasse() * 0.10 + (double) this.getElasticidade() * 0.25;
        return media;

    }

    public GuardaRedes clone() {
        return new GuardaRedes(this);
    }

    public String getPosicao() {
        return ("GuardaRedes");
    }

    public String extraCaracteristicas() {
        return "Elasticidade:" + getElasticidade();
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        GuardaRedes d = (GuardaRedes) obj;
        return super.equals(d);

    }

}
