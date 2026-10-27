package filmnow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilmeTest {

    private Filme filmeBase;

    @BeforeEach
    void setUp() {
        filmeBase = new Filme("Avatar", "2009", "Disney+");
    }

    @Test
    void testToString() {
        String esperado = "Avatar, 2009\nDisney+";
        assertEquals(esperado, filmeBase.toString());
    }

    @Test
    void testEqualsFilmesIguais() {
        // Nome em maiúsculas para testar o equalsIgnoreCase e mesmo ano
        Filme outroFilme = new Filme("AVATAR", "2009", "Netflix");
        assertEquals(filmeBase, outroFilme);
    }

    @Test
    void testEqualsFilmesDiferentes() {
        Filme filmeDiferente = new Filme("Avatar", "2023", "Cinema");
        assertNotEquals(filmeBase, filmeDiferente);
    }
}
