
package filmnow;

public class Filme {
    private String nome;
    private String anoLancamento;
    private String local;


    public Filme(String nome, String anoLancamento, String local){
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.local = local;

    }
    public String getNome() {
        return nome;
    }
    public String getAnoLancamento() {
        return anoLancamento;
    }
    public String getLocal() {
        return local;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if ( o == null || getClass() != o.getClass()) return false;

        Filme filme = (Filme) o;

        return this.anoLancamento == filme.anoLancamento && this.nome.equalsIgnoreCase(filme.nome);
    }
    @Override
    public String toString() {
        return nome + "," + anoLancamento + "\n" + local;
    }
    @Override
    public int hashCode() {
        return this.nome.hashCode();
    }
}
