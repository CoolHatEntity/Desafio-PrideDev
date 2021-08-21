import com.desafioItau.util.SorteadorDeNumeros;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SorteadorNumerosTest extends SorteadorDeNumeros {
    @Test
    void deveSerIncapazDeSortearComParametrosInvalidos(){
        Assertions.assertNull(sorteiaNumeros(3, 60, 1));
        Assertions.assertNull(sorteiaNumeros(60, 3, 0));
        Assertions.assertNull(sorteiaNumeros(20, 1, 30));
    }
    @Test
    void devePoderSortearComAQuantidadeDesejada(){
        int size = 5;
        Set<Integer> sorteados = sorteiaNumeros(60,1,size);
        Assertions.assertNotNull(sorteados);
        Assertions.assertEquals(size,sorteados.size());

        size = 10;
        sorteados = sorteiaNumeros(60,1,size);
        Assertions.assertEquals(size,sorteados.size());

        size = 33;
        sorteados = sorteiaNumeros(60,1,size);
        Assertions.assertEquals(size,sorteados.size());
    }
    @Test
    void garanteQueNenhumValorSorteadoEstaForaDaAmplitudeDesejada(){
        int size = 5;
        int upperBound = 5;
        int lowerBound = 1;
        List<Integer> entradas = new ArrayList<>(sorteiaNumeros(upperBound,lowerBound,size));
        for (Integer entrada : entradas) {
            Assertions.assertTrue(entrada >= lowerBound && entrada <= upperBound);
        }

    }
}
