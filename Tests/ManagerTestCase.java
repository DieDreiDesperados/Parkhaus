import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ManagerTestCase implements ManagerIF {

    double money;

    @Override
    public double checkMoney() {
        return money;
    }


    public void getMoney(double newMoney) {
        money += newMoney;
    }


    ManagerTestCase man;

    @Before
    public void setUp() {
        man = new ManagerTestCase();
    }

    @Test
    public void getMoney_NullInput_returnZero() {

        Assert.assertEquals(0,man.checkMoney(),0);

    }
    @Test
    public void getMoney_SomeMoney_returnSameAmount() {
        man.getMoney(2.32);
        Assert.assertEquals(2.32,man.checkMoney(),0);

    }
}
