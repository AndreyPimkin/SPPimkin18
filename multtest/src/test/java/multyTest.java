import static org.junit.Assert.*;

public class multyTest {

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void main() {
    }

    @org.junit.Test
    public void mul() {
        multy Multy = new multy();
        int actual = (int) Multy.Mul(4,3);
        System.out.println(actual);
    }
}