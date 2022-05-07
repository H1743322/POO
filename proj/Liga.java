package proj;

import java.io.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Liga implements Serializable {

    private List<Jogo> jogos;
    private Map<String, Equipa> equipas;

    public Liga() {
        this.jogos = new ArrayList<>();
        this.equipas = new HashMap<>();
    }

    public Liga(Map<String, Equipa> Nequipas, List<Jogo> Njogos) {
        this.equipas = Nequipas.values().stream().collect(Collectors.toMap(e -> e.getNome(), e -> e.clone()));

        // this.equipas =
        // Nequipas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
        // Map.Entry::getValue));

        this.jogos = Njogos.stream().collect(Collectors.toList());
    }

    public Equipa getEquipa(String nome) throws EquipaNaoExisteException {
        Equipa equipa = this.equipas.get(nome);
        if (equipa == null)
            throw new EquipaNaoExisteException("Equipa nao existe");
        else
            return equipa.clone();
    }

    public Map<String, Equipa> getEquipas() {
        return this.equipas.values().stream().collect(Collectors.toMap(e -> e.getNome(), e -> e.clone()));
    }

    public void insereEquipa(Equipa equipa) throws EquipaNaoExisteException {
        if (this.equipas.containsKey(equipa.getNome()))
            throw new EquipaNaoExisteException("Equipa ja existe");
        else
            this.equipas.put(equipa.getNome(), equipa.clone());
    }

    public void setEquipas(Map<String, Equipa> nequipas) {
        this.equipas = nequipas.values().stream().collect(Collectors.toMap(e -> e.getNome(), e -> e.clone()));
    }

    public void insereJogadorNaEquipa(String nEquipa, Jogador j)
            throws JogadorNaoExisteException, EquipaNaoExisteException {

        if (this.equipas.containsKey(nEquipa)) {
            this.equipas.get(nEquipa).transferenciaJogador(j);

        } else
            throw new EquipaNaoExisteException("Equipa nao existe");
        ;// exemption
    }

    public void removeJogadorDaEquipa(String nEquipa, Jogador j)
            throws JogadorNaoExisteException, EquipaNaoExisteException {
        if (this.equipas.containsKey(nEquipa)) {
            this.equipas.get(nEquipa).removeJogador(j);

        } else
            throw new EquipaNaoExisteException("Equipa nao existe");// exemption
    }

    public void removeJogadorDaEquipaNumero(String nEquipa, int numero)
            throws JogadorNaoExisteException, EquipaNaoExisteException {
        if (this.equipas.containsKey(nEquipa)) {
            this.equipas.get(nEquipa).removeJogadorNumero(numero);

        } else {
            throw new EquipaNaoExisteException("Equipa nao existe");
        }
    }

    public void removeEquipa(Equipa equipa) throws EquipaNaoExisteException {
        if (this.equipas.containsKey(equipa.getNome())) {
            this.equipas.remove(equipa.getNome());

        } else
            throw new EquipaNaoExisteException("Equipa nao existe"); // exemption
    }

    // vai a cada equipa procurar um jogador com o nome "nome"
    public Jogador procuraJogadorNome(String nome) throws JogadorNaoExisteException {
        boolean flag = false;
        Jogador j = null;
        Iterator<Map.Entry<String, Equipa>> it = this.equipas.entrySet().iterator();
        while (it.hasNext() && !flag) {

            j = it.next().getValue().procuraJogadorNome(nome);
            if (j != null) {
                flag = true;
            }
        }
        if (j == null)
            throw new JogadorNaoExisteException("Jogador nao existe");
        else
            return j.clone();

    }

    // vai a cada equipa procurar um jogador J ( pelo o numero do jogador)
    public Jogador procuraJogador(Jogador j) throws JogadorNaoExisteException {
        boolean flag = false;
        Jogador aux = null;
        Iterator<Map.Entry<String, Equipa>> it = this.equipas.entrySet().iterator();
        while (it.hasNext() && !flag) {
            Map.Entry<String, Equipa> entry = it.next();
            aux = entry.getValue().procuraJogadorNumero(j.getNumeroJogador());
            if (aux != null)
                flag = true;
        }
        if (flag == false)
            throw new JogadorNaoExisteException("Jogador nao existe");
        return aux.clone();
    }

    public void transferenciaDeJogador(Jogador j, Equipa origem, Equipa destino)
            throws JogadorNaoExisteException, EquipaNaoExisteException {
        this.removeJogadorDaEquipa(origem.getNome(), j);
        this.insereJogadorNaEquipa(destino.getNome(), j);
    }

    public String toString() {
        String r = "\n";
        for (Equipa e : equipas.values()) {
            r += e.toString();
        }
        return r;
    }

    public String toString2() {
        String r = "\n";
        for (Equipa e : equipas.values()) {
            r += e.getNome() + "\n";
        }
        return r;
    }

    public void save() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("LigaSave.obj"));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public void load() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("LigaSave.obj"));
        Liga l = (Liga) ois.readObject();
        ois.close();
        this.equipas = l.equipas;
        this.jogos = l.jogos;
    }

}
