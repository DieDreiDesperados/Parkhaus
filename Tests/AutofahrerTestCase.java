import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AutofahrerTestCase implements AutofahrerIF {

    Boolean istGeparkt = false;

    public void parke() {
        istGeparkt = true;
    }
    public void verlasse() {
        istGeparkt = false;
    }

    AutofahrerTestCase auto1;

    @Before
    public void setUp() {
        auto1 = new AutofahrerTestCase();
    }

    @Test
    public void parke_IstGeparkt_True() {
        auto1.parke();
        Assert.assertTrue(auto1.istGeparkt);
    }

    @Test
    public void parke_IstGeparkt_Falsee() {
        auto1.parke();
        auto1.verlasse();
        Assert.assertFalse(auto1.istGeparkt);
    }
}
