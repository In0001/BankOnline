import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BankOnlineTest {
    BankOnline bankOnline = new BankOnline();
    int test;

    @Test
    void isBlocked1() throws IOException {
        test = bankOnline.isBlocked("1111111111111111");
        assertEquals(0, test);
    }

    @Test
    void isBlocked2() throws IOException {
        test = bankOnline.isBlocked("1211111111111111");
        assertEquals(3, test);
    }

    @Test
    void isBlocked3() throws IOException {
        test = bankOnline.isBlocked("2222222222222222");
        assertEquals(0, test);
    }

    @Test
    void isBlocked4() throws IOException {
        test = bankOnline.isBlocked("1111222222222222");
        assertEquals(3, test);
    }
}