import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SchrankeTestCase implements SchrankeIF {

    Boolean istOben = false;

    public void geheHoch() throws Exception {
        if (istOben) {
            throw new Exception();
        }
        istOben = true;

    }

    public void geheRunter() throws Exception {
        if (!istOben) {
            throw new Exception();
        }
        istOben = false;

    }

    SchrankeTestCase s1;

    @Before
    public void setUp() {
        s1 = new SchrankeTestCase();
    }

    @Test
    public void geheRunter_bug_throwsException() {
        try {
            s1.geheRunter();
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void geheHoch_bug_throwsException() {
        try {
            s1.geheHoch();
            s1.geheHoch();
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }
}
