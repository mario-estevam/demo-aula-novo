package com.example.borala.demoaula;

import com.example.borala.demoaula.controllers.Alimento;
import com.example.borala.demoaula.controllers.AlimentoDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoAulaApplicationTests {

    @Test
    void contextLoads() {
        AlimentoDao control = new AlimentoDao();
        Alimento a = control.readforID("1");
        System.out.println(a.getNome());
    }

}
