package put.io.testing.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FailureOrErrorTest {
    @Test
    public void  test1(){
        assertEquals(10, 1);

    }
    @Test
    public void  test2() throws Exception {
        throw new Exception("test2");
    }

    @Test
    public void test3(){
        try {
            assertEquals(4,1);
        } catch (Throwable e){
            e.printStackTrace();
        }

    }
}
