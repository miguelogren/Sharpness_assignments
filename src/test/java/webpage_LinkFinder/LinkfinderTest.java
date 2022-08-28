package webpage_LinkFinder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkfinderTest {

    @Test
    void linkfinder() {

        String link = "https://www.google.com";

        Linkfinder lf = new Linkfinder();

        int expectedLinks = 22;

        assertEquals(lf.linkfinder(link), expectedLinks);
    }
}