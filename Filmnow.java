package Lab3;

public class FilmNow {
    private Filme[] filmes;
    private Filme[] hotList;

    public FilmNow() {
        this.filmes = new Filme[100];
        this.hotList = new Filme[10];
    }

    public boolean adicionarFilme(String nome, int anoDeLancamento, String local, int posicaoLista) {
        if (posicaoLista < 1 || posicaoLista > 100) {
            return false;
        }

        if (nome == null || local == null || nome.equals("") || local.equals("")) {
            return false;
        }

        for (int i = 0; i < this.filmes.length; i++) {
            if (this.filmes[i] != null) {
                if (this.filmes[i].getNome().equals(nome) && this.filmes[i].getAnoLancamento() == anoDeLancamento) {
                    return false;
                }
            }
        }

        this.filmes[posicaoLista - 1] = new Filme(nome, anoDeLancamento, local);
        return true;
    }

    public String detalharFilme(int Posicao) {
        if (Posicao < 1 || Posicao > 100) {
            return "POSIÇÃO INVÁLIDA";
        }

        int indice = Posicao - 1;

        if (this.filmes[indice] == null) {
            return "POSIÇÃO INVÁLIDA";
        }

        String detalhes = this.filmes[indice].toString();

        // Se o filme estiver na HotList, adiciona o emoji 🔥
        if (estaNaHotList(this.filmes[indice])) {
            detalhes = "🔥 " + detalhes;
        }

        return detalhes;
    }

    public boolean adicionarHot(int posicao, int posicaoHot) {
        if (posicao < 1 || posicao > 100 || posicaoHot < 1 || posicaoHot > 10) {
            return false;
        }
        int indiceLista = posicao - 1;
        int indiceHot = posicaoHot - 1;

        if (this.filmes[indiceLista] == null) {
            return false;
        }

        this.hotList[indiceHot] = this.filmes[indiceLista];
        return true;
    }

    public String[] exibirHot() {
        String[] resultado = new String[this.hotList.length];

        for (int i = 0; i < hotList.length; i++) {
            if (hotList[i] != null) {
                int novaPosicao = i + 1;
                resultado[i] = novaPosicao + " - " + hotList[i];
            } else {
                resultado[i] = null;
            }
        }
        return resultado;
    }

    public boolean removerHot(int posicaoParaRemover) {
        if (posicaoParaRemover < 1 || posicaoParaRemover > 10) {
            return false;
        }
        int posicaoRemovida = posicaoParaRemover - 1;

        this.hotList[posicaoRemovida] = null;
        return true;
    }

    private boolean estaNaHotList(Filme filme) {
        for (int i = 0; i < this.hotList.length; i++) {
            if (this.hotList[i] != null && this.hotList[i].equals(filme)) {
                return true;
            }
        }
        return false;
    }
}
