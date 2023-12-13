package ba.unsa.etf.rpr.test;

import ba.unsa.etf.rpr.main.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

public class TestZadatka {

    private static Imenik imenik = new Imenik();

    @BeforeAll
    public static void setup(){
        imenik.dodaj("Ramiz", new FiksniBroj(Grad.SARAJEVO, "212-802"));
        imenik.dodaj("Haso", new FiksniBroj(Grad.ZENICA, "235-812"));
        imenik.dodaj("Mujo", new MobilniBroj(62, "654-225"));
        imenik.dodaj("Edward", new MedjunarodniBroj("+34", "2164389410"));
    }

    @Test
    public void getBrojNadjen(){
        String broj = imenik.getBroj("Ramiz");
        assertEquals(broj, "033/212-802");
    }
    @Test
    public void getBrojNijeNadjen(){
        String broj = imenik.getBroj("Pero");
        assertNull(broj);
    }

    @Test
    public void addTestPositive(){
        TelefonskiBroj br = new MobilniBroj(63, "512-843");
        imenik.dodaj("Ivica", br);

        String broj = imenik.getBroj("Ivica");
        assertEquals(broj, "063/512-843");
    }

    @Test
        public void addException(){
        assertThrows(BrojIzuzetak.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new FiksniBroj(null, "321-123");
            }
        });

        assertThrows(BrojIzuzetak.class, () -> {new FiksniBroj(null, "321-123");});
    }

}