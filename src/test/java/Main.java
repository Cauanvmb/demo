import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Main {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private final PrintStream originalSystemErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
        System.setErr(originalSystemErr);
    }

    @Test
    public void testAdicionar() {
        String input = "1\n1\nConsole1\nMarca1\nModelo1\n500\nCor1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Estoque estoque = new Estoque();
        estoque.adicionar();
        assertEquals(1, estoque.estoqueConsoles.size());
    }

    @Test
    public void testVerLista() {
        Estoque estoque = new Estoque();
        Console console1 = new Console("Console1", new Especificacao("Marca1", "Modelo1", 500, "Cor1", 1));
        Console console2 = new Console("Console2", new Especificacao("Marca2", "Modelo2", 1000, "Cor2", 2));
        estoque.estoqueConsoles.add(console1);
        estoque.estoqueConsoles.add(console2);
        assertEquals(2, estoque.estoqueConsoles.size());
    }

    @Test
    public void testRemoverPorId() {
        String input = "1\n1\nConsole1\nMarca1\nModelo1\n500\nCor1\n2\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Estoque estoque = new Estoque();
        Console console1 = new Console("Console1", new Especificacao("Marca1", "Modelo1", 500, "Cor1", 1));
        Console console2 = new Console("Console2", new Especificacao("Marca2", "Modelo2", 1000, "Cor2", 2));
        estoque.estoqueConsoles.add(console1);
        estoque.estoqueConsoles.add(console2);
        estoque.removerPorId(1);
        assertEquals(1, estoque.estoqueConsoles.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverConsoleInexistente() {
        Estoque estoque = new Estoque();
        Console console1 = new Console("Console1", new Especificacao("Marca1", "Modelo1", 500, "Cor1", 1));
        estoque.estoqueConsoles.add(console1);

        estoque.removerPorId(8);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testInserirFuncaoInvalidaNoEstoqueEmUso(){
        String input = "7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Estoque estoque = new Estoque();
        estoque.estoqueEmUso();

    }
}
