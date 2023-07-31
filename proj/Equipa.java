package proj;

import java.io.*;
import java.io.Serializable;

import java.util.stream.Collectors;
import java.util.*;

public class Equipa implements Serializable {

    private String nome;
    private Map<Integer, Jogador> jogadores;
    private double media;

    public Equipa() {
        this.nome = "";
        this.jogadores = new HashMap<>();
        this.media = 0;
    }

    public Equipa(String nNome) {
        this.nome = nNome;
        jogadores = new HashMap<>();
        this.media = 0;
    }

    public Equipa(Equipa e) {
        this.nome = e.getNome();
        this.jogadores = e.getJogadores();
        this.media = e.getMedia();
    }

    public Map<Integer, Jogador> getJogadores() {
        return this.jogadores.values().stream().collect(Collectors.toMap(e -> e.getNumeroJogador(), e -> e.clone()));
        // return
        // this.jogadores.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
        // Map.Entry::getValue));

    }

    public void setJogadores(Map<Integer, Jogador> nJogadores) {
        this.jogadores = nJogadores.values().stream()
                .collect(Collectors.toMap(e -> e.getNumeroJogador(), e -> e.clone()));
    }

    public String getNome() {
        return nome;
    }

    public Double getMedia() {
        return media;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void insereJogador(Jogador j) {
        this.jogadores.put(j.getNumeroJogador(), j.clone());
        j.insereHistorico(this.getNome());

    }

    public void setJogador(Jogador j) throws JogadorNaoExisteException {
        if (this.jogadores.containsKey(j.getNumeroJogador()))
            throw new JogadorNaoExisteException("Jogador com esse numero existe");
        else
            this.jogadores.put(j.getNumeroJogador(), j.clone());
    }

    public void removeJogador(Jogador j) throws JogadorNaoExisteException {
        int n = j.getNumeroJogador();
        if (!this.jogadores.containsKey(n))
            throw new JogadorNaoExisteException("Jogador nao existe");
        else {

            this.jogadores.remove(n);
        }
    }

    public void removeJogadorNumero(int n) throws JogadorNaoExisteException {

        if (!this.jogadores.containsKey(n))
            throw new JogadorNaoExisteException("Jogador nao existe");
        else {

            this.jogadores.remove(n);
        }
    }

    public void transferenciaJogador(Jogador j) { // exeption
        int n = j.getNumeroJogador();

        while (this.jogadores.containsKey(n)) {
            n++;
        }
        j.setNumeroJogador(n);
        j.insereHistorico(this.getNome());
        this.jogadores.put(n, j.clone());

    }

    public double calcularMediaEquipa() {
        double r = 0;
        int i = 0;
        for (Jogador j : jogadores.values()) {
            r += j.calcularMedia();
            i += 1;
        }
        r = r / i;
        this.media = r;
        return r;
    }

    public Jogador procuraJogadorNumero(int n) throws JogadorNaoExisteException {
        if (this.jogadores.containsKey(n))
            return this.jogadores.get(n).clone();
        else
            throw new JogadorNaoExisteException("Jogador nao existe");
    }

    public Jogador procuraJogadorNome(String nome) throws JogadorNaoExisteException {

        Jogador ola = null;
        for (Jogador j : jogadores.values()) {
            if (j.getNomeJogador().equals(nome))
                ola = j.clone();
        }

        // if (ola == null)
        // throw new JogadorNaoExisteException("Jogador nao existe");
        // else
        return ola;

    }

    public String toString() {
        String r = "Equipa:" + nome + "\n";
        // String r = "\n";
        for (Jogador j : jogadores.values()) {
            r += j.toString();
        }
        return r;
    }

    public String toString2() {
        String r = "\n";
        for (Jogador j : jogadores.values()) {
            r += j.toString();
        }
        return r;
    }

    public Equipa clone() {
        return new Equipa(this);
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Equipa e = (Equipa) obj;
        return e.getNome().equals(this.nome) && e.getJogadores() == (this.jogadores) && e.getMedia() == (this.media);

    }

    public static Equipa parse(String input) {
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    public void save() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("EquipaSave.obj"));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public void load() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("EquipaSave.obj"));
        Equipa e = (Equipa) ois.readObject();
        ois.close();
        this.nome = e.nome;
        this.jogadores = e.jogadores;
        this.media = e.media;

    }

}
