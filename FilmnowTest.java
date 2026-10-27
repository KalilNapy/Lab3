package filmnow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilmNowTest {

    private FilmNow filmNow;

    @BeforeEach
    void setUp() {
        filmNow = new FilmNow();
    }

    @Test
    void testCadastraFilmeComSucesso() {
        boolean resultado = filmNow.cadastraFilme(1, "Avatar", "2009", "Disney+");
        assertTrue(resultado);
    }

    @Test
    void testCadastraFilmePosicaoInvalida() {
        // Posição abaixo de 1 e acima de 100
        assertFalse(filmNow.cadastraFilme(0, "Avatar", "2009", "Disney+"));
        assertFalse(filmNow.cadastraFilme(101, "Avatar", "2009", "Disney+"));
    }

    @Test
    void testCadastraFilmeDuplicado() {
        filmNow.cadastraFilme(1, "Avatar", "2009", "Disney+");

        // Tentar cadastrar o mesmo filme (mesmo nome e ano) noutra posição deve falhar
        boolean resultadoDuplicado = filmNow.cadastraFilme(3, "AVATAR", "2009", "Netflix");
        assertFalse(resultadoDuplicado);
    }

    @Test
    void testGetFilmeInexistente() {
        String detalhes = filmNow.getFilme(1);
        assertEquals("POSIÇÃO INVÁLIDA", detalhes);
    }

    @Test
    void testAdicionarEExibirHotList() {
        filmNow.cadastraFilme(1, "Avatar", "2009", "Disney+");

        // Adiciona à HotList na posição 1
        boolean adicionou = filmNow.adicionarHot(1, 1);
        assertTrue(adicionou);

        // Verifica se o filme aparece na HotList com o emoji de destaque
        String detalhes = filmNow.getFilme(1);
        assertTrue(detalhes.startsWith("🔥"));
    }
}
