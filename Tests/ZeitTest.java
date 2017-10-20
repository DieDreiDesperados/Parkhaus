
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ZeitTest {

    ZeitSnapshot z01;

    @Before
    public void setUp() {
        z01   = new ZeitSnapshot();
    }


    @Test
    public void test_ausgabe() {
        System.out.println(z01.toString());
    }





}
