package proj;

import java.util.*;
import java.io.IOException;

public class Controller {

    public static void run() throws IOException, ClassNotFoundException {

        Liga l = new Liga();
        Equipa criacao = new Equipa("Criacao");
        Jogo jogo = new Jogo();
        String[] s = { "Criacao", "Pesquisa", "Editar", "Carregar Ficheiro", "Save", "Load" };
        Menu menu = new Menu(s);
        // Scanner sc = new Scanner(System.in);
        int op = -1;
        while (op != 0) {
            menu.executa();
            op = menu.getOpcao();
            System.out.println(op);
            switch (op) {
                case 1:

                    menuCriar(l, criacao);

                    break;
                case 2:
                    menuVer(l);
                    break;
                case 3:
                    menuEditar(l);
                    break;
                case 4:
                    menuFicheiro(l);
                    break;
                case 5:
                    save(l, criacao, jogo);
                    break;
                case 6:
                    load(l, criacao, jogo);
                    break;
                case 0:
                    break;
            }

        }

    }

    public static void save(Liga l, Equipa cria, Jogo jogo) throws IOException {

        View view = new View();
        l.save();
        cria.save();
        jogo.save();
        view.msg("-------------Saved------------");

    }

    public static void load(Liga l, Equipa cria, Jogo jogo) throws IOException, ClassNotFoundException {
        View view = new View();
        l.load();
        cria.load();
        jogo.load();
        view.msg("-------------Loaded------------");

    }

    public static void menuCriar(Liga l, Equipa cria) {
        String[] s = { "Criar Jogador", "Ver Jogadores Criados", "Criar Equipa",
                "Adicionar Jogador Criado a Uma Equipa" };
        Menu menuCriar = new Menu(s);
        int op = -1;
        Scanner sc = new Scanner(System.in);
        View view = new View();
        String line;
        Jogador j = null;
        Equipa aux = null;

        while (op != 0) {
            menuCriar.executa();
            op = menuCriar.getOpcao();
            System.out.println(op);
            switch (op) {
                case 1:

                    view.msg("Use este formato");
                    view.msg(
                            "Nome Posicao Numero Velocidade Resistencia Destreza Impulsao cabeca Remate Passe Parametro_da_posicao");
                    line = sc.nextLine();
                    String[] all = line.split(" ");

                    switch (all[1].toLowerCase()) {
                        case "defesa":

                            j = new Defesa(all[0], Integer.parseInt(all[2]), Integer.parseInt(all[3]),
                                    Integer.parseInt(all[4]), Integer.parseInt(all[5]), Integer.parseInt(all[6]),
                                    Integer.parseInt(all[7]), Integer.parseInt(all[8]), Integer.parseInt(all[9]),
                                    Integer.parseInt(all[10]), new ArrayList<>());

                            try {
                                cria.setJogador(j);
                                view.printJogador(j.getNomeJogador(), j.getPosicao(), j.getNumeroJogador(),
                                        j.getVelocidade(), j.getResistencia(), j.getDestreza(), j.getImpulsao(),
                                        j.getCabeca(), j.getRemate(), j.getPasse(), j.extraCaracteristicas(),
                                        j.getMedia(), j.getHistorico().toString());
                            } catch (Exception e) {
                                view.msg(e.getMessage());
                            }

                            break;
                        case "medio":
                            j = new Medio(all[0], Integer.parseInt(all[2]), Integer.parseInt(all[3]),
                                    Integer.parseInt(all[4]), Integer.parseInt(all[5]), Integer.parseInt(all[6]),
                                    Integer.parseInt(all[7]), Integer.parseInt(all[8]), Integer.parseInt(all[9]),
                                    Integer.parseInt(all[10]), new ArrayList<>());

                            try {
                                cria.setJogador(j);
                                view.printJogador(j.getNomeJogador(), j.getPosicao(), j.getNumeroJogador(),
                                        j.getVelocidade(), j.getResistencia(), j.getDestreza(), j.getImpulsao(),
                                        j.getCabeca(), j.getRemate(), j.getPasse(), j.extraCaracteristicas(),
                                        j.getMedia(), j.getHistorico().toString());
                            } catch (Exception e) {
                                view.msg(e.getMessage());
                            }
                            break;
                        case "avancado":
                            j = new Avancado(all[0], Integer.parseInt(all[2]), Integer.parseInt(all[3]),
                                    Integer.parseInt(all[4]), Integer.parseInt(all[5]), Integer.parseInt(all[6]),
                                    Integer.parseInt(all[7]), Integer.parseInt(all[8]), Integer.parseInt(all[9]),
                                    Integer.parseInt(all[10]), new ArrayList<>());

                            try {
                                cria.setJogador(j);
                                view.printJogador(j.getNomeJogador(), j.getPosicao(), j.getNumeroJogador(),
                                        j.getVelocidade(), j.getResistencia(), j.getDestreza(), j.getImpulsao(),
                                        j.getCabeca(), j.getRemate(), j.getPasse(), j.extraCaracteristicas(),
                                        j.getMedia(), j.getHistorico().toString());
                            } catch (Exception e) {
                                view.msg(e.getMessage());
                            }
                            break;
                        case "lateral":
                            j = new Lateral(all[0], Integer.parseInt(all[2]), Integer.parseInt(all[3]),
                                    Integer.parseInt(all[4]), Integer.parseInt(all[5]), Integer.parseInt(all[6]),
                                    Integer.parseInt(all[7]), Integer.parseInt(all[8]), Integer.parseInt(all[9]),
                                    Integer.parseInt(all[10]), new ArrayList<>());

                            try {
                                cria.setJogador(j);
                                view.printJogador(j.getNomeJogador(), j.getPosicao(), j.getNumeroJogador(),
                                        j.getVelocidade(), j.getResistencia(), j.getDestreza(), j.getImpulsao(),
                                        j.getCabeca(), j.getRemate(), j.getPasse(), j.extraCaracteristicas(),
                                        j.getMedia(), j.getHistorico().toString());
                            } catch (Exception e) {
                                view.msg(e.getMessage());
                            }
                            break;
                        case "guardaredes":
                            j = new GuardaRedes(all[0], Integer.parseInt(all[2]), Integer.parseInt(all[3]),
                                    Integer.parseInt(all[4]), Integer.parseInt(all[5]), Integer.parseInt(all[6]),
                                    Integer.parseInt(all[7]), Integer.parseInt(all[8]), Integer.parseInt(all[9]),
                                    Integer.parseInt(all[10]), new ArrayList<>());

                            try {
                                cria.setJogador(j);
                                view.printJogador(j.getNomeJogador(), j.getPosicao(), j.getNumeroJogador(),
                                        j.getVelocidade(), j.getResistencia(), j.getDestreza(), j.getImpulsao(),
                                        j.getCabeca(), j.getRemate(), j.getPasse(), j.extraCaracteristicas(),
                                        j.getMedia(), j.getHistorico().toString());
                            } catch (Exception e) {
                                view.msg(e.getMessage());
                            }
                            break;

                    }

                    break;
                case 2:

                    view.printEquipa(cria.getNome(), cria.getMedia(), cria.toString2());

                    break;
                case 3:
                    view.msg("Nome da equipa?");
                    line = sc.nextLine();
                    aux = new Equipa(line);
                    try {
                        l.insereEquipa(aux);
                        view.printCriacaoEquipa(aux.getNome());
                    } catch (EquipaNaoExisteException e) {
                        view.msg(e.getMessage());
                    }
                    break;
                case 4:
                    view.msg("Nome do Jogador?");
                    line = sc.nextLine();
                    Jogador f = null;
                    try {
                        f = cria.procuraJogadorNome(line);

                    } catch (JogadorNaoExisteException e) {
                        view.msg(e.getMessage());
                    }
                    view.msg("Nome da Equipa destino?");
                    line = sc.nextLine();

                    try {
                        int n1 = f.getNumeroJogador();
                        l.insereJogadorNaEquipa(line, f);
                        int n2 = f.getNumeroJogador();
                        cria.removeJogador(f);
                        view.printTransferencia(f.getNomeJogador(), "Criacao ", line, n1, n2);

                    } catch (EquipaNaoExisteException | JogadorNaoExisteException e) {
                        view.msg(e.getMessage());
                    }

                    break;

            }
        }
    }

    public static void menuVer(Liga l) {
        String[] s = { "Ver Todas Equipas", "Ver Equipa", "Ver Jogador ", "Media da equipa ", "Media do jogador" };
        Menu menuVer = new Menu(s);
        int op = -1;
        Scanner sc = new Scanner(System.in);
        View view = new View();
        String line;
        while (op != 0) {
            menuVer.executa();
            op = menuVer.getOpcao();
            System.out.println(op);
            switch (op) {
                case 1:

                    view.printEquipas(l.toString2());

                    break;
                case 2:
                    view.msg("Nome da equipa?");
                    line = sc.nextLine();
                    try {
                        Equipa eq = l.getEquipa(line);
                        view.printEquipa(eq.getNome(), eq.getMedia(), eq.toString2());
                    } catch (EquipaNaoExisteException e) {
                        view.msg(e.getMessage());
                    }

                    break;
                case 3:

                    view.msg("Nome do jogador?");
                    line = sc.nextLine();
                    try {
                        Jogador j;
                        j = l.procuraJogadorNome(line);
                        view.printJogador(j.getNomeJogador(), j.getPosicao(), j.getNumeroJogador(), j.getVelocidade(),
                                j.getResistencia(), j.getDestreza(), j.getImpulsao(), j.getCabeca(), j.getRemate(),
                                j.getPasse(), j.extraCaracteristicas(), j.getMedia(), j.getHistorico().toString());

                    } catch (JogadorNaoExisteException e) {
                        view.msg(e.getMessage());

                    }
                    break;
                case 4:
                    view.msg("Nome da equipa?");
                    line = sc.nextLine();
                    try {
                        Equipa eq = l.getEquipa(line);
                        eq.calcularMediaEquipa();
                        view.printMedia(eq.getMedia());
                    } catch (EquipaNaoExisteException e) {
                        view.msg(e.getMessage());
                    }
                    break;
                case 5:
                    view.msg("Nome do jogador?");
                    line = sc.nextLine();
                    try {
                        Jogador j;
                        j = l.procuraJogadorNome(line);
                        j.calcularMedia();
                        view.printMedia(j.getMedia());

                    } catch (JogadorNaoExisteException e) {
                        view.msg(e.getMessage());

                    }
                    break;
                case 0:
                    break;
            }

        }

    }

    public static void menuFicheiro(Liga l) {
        Parser p = new Parser();
        View view = new View();
        try {
            p.parse();
            l.setEquipas(p.getEquipas());
        } catch (LinhaIncorretaException e) {
            view.msg(e.getMessage());
        }

    }

    public static void menuEditar(Liga l) {
        String[] s = { "Transferir Jogador", "Remover Jogador", "Remover Equipa" };
        Menu menuEditar = new Menu(s);
        int op = -1;
        Scanner sc = new Scanner(System.in);
        View view = new View();
        String line;
        while (op != 0) {
            menuEditar.executa();
            op = menuEditar.getOpcao();
            System.out.println(op);
            switch (op) {
                case 1:
                    String e1;
                    String e2;
                    view.msg("Nome do Jogador?");
                    line = sc.nextLine();
                    view.msg("Nome da Equipa origem?");
                    e1 = sc.nextLine();
                    view.msg("Nome da Equipa destino?");
                    e2 = sc.nextLine();

                    try {
                        Jogador j = l.procuraJogadorNome(line);
                        int n1 = j.getNumeroJogador();
                        Equipa eq1 = l.getEquipa(e1);
                        Equipa eq2 = l.getEquipa(e2);
                        l.transferenciaDeJogador(j, eq1, eq2);
                        int n2 = j.getNumeroJogador();
                        view.printTransferencia(j.getNomeJogador(), eq1.getNome(), eq2.getNome(), n1, n2);

                    } catch (JogadorNaoExisteException | EquipaNaoExisteException e) {
                        view.msg(e.getMessage());
                    }

                    break;
                case 2:

                    view.msg("Nome do Jogador?");
                    line = sc.nextLine();
                    Jogador j = null;
                    try {
                        j = l.procuraJogadorNome(line);
                    } catch (JogadorNaoExisteException e) {
                        view.msg(e.getMessage());
                        break;
                    }
                    view.msg("Nome da Equipa?");
                    line = sc.nextLine();

                    try {
                        l.removeJogadorDaEquipa(line, j);
                        view.printRemocaoJogador(j.getNomeJogador(), line);
                    } catch (EquipaNaoExisteException | JogadorNaoExisteException e) {
                        view.msg(e.getMessage());
                    }

                    break;
                case 3:
                    view.msg("Nome da Equipa?");
                    line = sc.nextLine();

                    try {
                        l.removeEquipa(l.getEquipa(line));
                        view.printRemocaoEquipa(line);

                    } catch (EquipaNaoExisteException e) {
                        view.msg(e.getMessage());
                    }

                    break;

            }
        }
    }

}
