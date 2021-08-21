package fileManager;

import com.desafioItau.util.fileManager.FileManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FileManagerTest extends FileManager{
    Set<Integer> defaultSet = new HashSet<>();
    @BeforeEach
    void inicia(){
        defaultSet.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
    }
    @Test
    void deveSerCapazDeCriarArquivo(){
        File arquivo = new File("Arquivo.txt");
        if(arquivo.exists() && arquivo.isFile()){
            arquivo.delete();
        }
        Assertions.assertTrue(fileCreator("Arquivo"));
        Assertions.assertTrue(arquivo.exists());
    }
    //Teste deve ser feito apenas caso o primeiro tenha sido executado
    @Test
    void deveRetornarFalsoAoTentarArquivoExistente(){
        Assertions.assertFalse(fileCreator("Arquivo"));
        Assertions.assertTrue(fileChecker("Arquivo"));
    }
    @Test
    void deveSerCapazDeLerDeUmArquivo(){
        Set<Integer> testSet = fileReader("Teste");
        Assertions.assertEquals(defaultSet, testSet);
    }
    @Test
    void deveSerCapazDeEscreverParaUmArquivo(){
        Assertions.assertTrue(fileWriter("Arquivo", defaultSet));
        Assertions.assertEquals(defaultSet,fileReader("Arquivo"));

        Set<Integer> tempSet = new HashSet<>(defaultSet);
        tempSet.add(-63);
        tempSet.add(155);
        tempSet.add(1337);

        Assertions.assertTrue(fileWriter("Arquivo", tempSet));
        Assertions.assertEquals(defaultSet, fileReader("Arquivo"));

    }


}
