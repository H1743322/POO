package proj;

import java.io.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jogo implements Serializable {
    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;
    Map<Integer, Integer> substituicoesCasa = new HashMap<>();
    Map<Integer, Integer> substitucoesFora = new HashMap<>();

    public Jogo(String ec, String ef, int gc, int gf, LocalDate d, List<Integer> jc, Map<Integer, Integer> sc,
            List<Integer> jf, Map<Integer, Integer> sf) {
        equipaCasa = ec;
        equipaFora = ef;
        golosCasa = gc;
        golosFora = gf;
        date = d;
        jogadoresCasa = new ArrayList<>(jc);
        jogadoresFora = new ArrayList<>(jf);
        substituicoesCasa = new HashMap<>(sc);
        substitucoesFora = new HashMap<>(sf);
    }

    public Jogo() {
        equipaCasa = "";
        equipaFora = "";
        golosCasa = 0;
        golosFora = 0;
        date = null;
        jogadoresCasa = new ArrayList<>();
        jogadoresFora = new ArrayList<>();
        substituicoesCasa = new HashMap<>();
        substitucoesFora = new HashMap<>();

    }

    public static Jogo parse(String input) {
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++) {
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++) {
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++) {
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++) {
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])), jc,
                subsC, jf, subsF);
    }

    public String toString() {
        return "Jogo:" + equipaCasa + " - " + equipaFora;
        // + " -> " + substituicoesCasa.toString()
        // + " -> " + substitucoesFora.toString();
    }

    public void save() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("JogoSave.obj"));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public void load() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("JogoSave.obj"));
        Jogo j = (Jogo) ois.readObject();
        ois.close();
        this.equipaCasa = j.equipaCasa;
        this.equipaFora = j.equipaFora;
        this.golosCasa = j.golosCasa;
        this.golosFora = j.golosFora;
        this.date = j.date;
        this.jogadoresCasa = j.jogadoresCasa;
        this.jogadoresFora = j.jogadoresFora;
        this.substituicoesCasa = j.substituicoesCasa;
        this.substitucoesFora = j.substitucoesFora;

    }

}
