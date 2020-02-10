package i18n;

import org.junit.Test;

import java.util.Locale;

public class I18NTest {

    @Test
    public void test(){
        Locale china = new Locale("zn","CN");
        System.out.println(china);
    }
}