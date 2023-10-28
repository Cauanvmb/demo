import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class Main {

    @Test
    public void testAdicionar() {
        String input = "1\n1\nConsole1\nMarca1\nModelo1\n500\nCor1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

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
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Estoque estoque = new Estoque();
        Console console1 = new Console("Console1", new Especificacao("Marca1", "Modelo1", 500, "Cor1", 1));
        Console console2 = new Console("Console2", new Especificacao("Marca2", "Modelo2", 1000, "Cor2", 2));
        estoque.estoqueConsoles.add(console1);
        estoque.estoqueConsoles.add(console2);
        estoque.removerPorId();
        assertEquals(1, estoque.estoqueConsoles.size());
    }

}
