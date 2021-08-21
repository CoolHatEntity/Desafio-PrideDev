import com.desafioItau.util.SorteadorDeEntradas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SorteadorDeEntradasTest extends SorteadorDeEntradas {
    Set<Integer> defaultSet = new HashSet<>();
    Set<Integer> reducedSet = new HashSet<>();
    @BeforeEach
    void inicia(){
        defaultSet.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        reducedSet.addAll(Arrays.asList(1, 2, 3, 4, 5));
    }
    @Test
    void deveSerPossivelSortearComUmaEntradaMaiorDoQueAQuantidadeDesejada(){
        Set<Integer> entrada = new HashSet<>(defaultSet);
        Set<Integer> sorteado = new HashSet<>(sortearEntradas(entrada, 10));

        Assertions.assertNotEquals(null, sorteado);
        Assertions.assertTrue(entrada.containsAll(sorteado));
        Assertions.assertEquals(10,sorteado.size());

        entrada = new HashSet<>(reducedSet);
        entrada.add(65);
        sorteado = new HashSet<>(sortearEntradas(entrada, 6));
        Assertions.assertFalse(sorteado.contains(65));
    }
    @Test
    void deveSerPossivelSortearComMenosValoresDoQueSolicitado(){
        Set<Integer> entrada = new HashSet<>(reducedSet);
        Set<Integer> sorteado = new HashSet<>(sortearEntradas(entrada, 10));

        Assertions.assertNotEquals(null, sorteado);
        Assertions.assertTrue(sorteado.containsAll(entrada));
        Assertions.assertEquals(10,sorteado.size());
    }
}
