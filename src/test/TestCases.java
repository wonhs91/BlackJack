package test;

import main.java.BlackJack;
import main.java.Controller.BlackJackPreparation;
import org.junit.Before;
import org.junit.Test;
import sun.misc.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TestCases {

    private BlackJack blackJack;
    private BlackJackPreparation blackJackPreparation;
    InputStream in;

    @Before
    public void setUp(){
        blackJack = new BlackJack();
        blackJackPreparation = new BlackJackPreparation();

    }

    @Test
    public void test(){
        blackJackPreparation.prepareTable();

    }

}
