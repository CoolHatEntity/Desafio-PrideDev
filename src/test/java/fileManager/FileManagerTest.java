package fileManager;

import com.desafio.util.fileManager.FileManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FileManagerTest extends FileManager{
    Set<Integer> defaultSet = new HashSet<>();
    File arquivo;

    @BeforeEach
    void inicia(){
        defaultSet.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        arquivo = new File("Arquivo.txt");
    }

    @AfterEach
    void finalizaTeste(){
        arquivo.delete();
    }

    @Test
    void deveRetornarValorCorretoAoTentarCriarArquivoEleExistindoOuNao(){
        if(arquivo.exists() && arquivo.isFile()){
            Assertions.assertFalse(fileCreator("Arquivo"));
            Assertions.assertTrue(fileChecker("Arquivo"));
        }else{
            Assertions.assertTrue(fileCreator("Arquivo"));
            Assertions.assertFalse(fileChecker("Arquivo"));
        }
    }

    @Test
    void deveSerCapazDeLerDeUmArquivo(){
        Set<Integer> testSet = new HashSet<Integer>();

        fileWriter("Arquivo", defaultSet);
        testSet = fileReader("Arquivo");
        Assertions.assertEquals(defaultSet, testSet);
    }
    @Test
    void deveSerCapazDeEscreverParaUmArquivo(){

        fileCreator("Arquivo");
        arquivo = new File("Arquivo.txt");

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
