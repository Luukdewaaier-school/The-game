package bank.internettoegang;
import bank.bankieren.Bank;
import bank.bankieren.IBank;
import bank.bankieren.Money;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by NesciO on 11-1-2016.
 */
public class BankiersessieTest {

    public static final String Rico = "Rico";
    public static final String tilburg = "Tilburg";
    public static final String test = "test";

    IBalie balie;
    IBank bank;
    IBankiersessie bankiersessie;
    private String rekening;

    @Before
    public void setUp() throws Exception {
        bank = new Bank("TestBank");
        balie = new Balie(bank);
        rekening = balie.openRekening(Rico, tilburg, test);

        bankiersessie = balie.logIn(rekening, test);
    }

    @Test
    public void testIsGeldig() throws Exception {
        assertTrue(bankiersessie.isGeldig());
    }

    @Test
    public void testMaakOver() throws Exception {
        String chris = "chris";
        String newRekening = balie.openRekening(chris, tilburg, test);
        IBankiersessie newSession = balie.logIn(newRekening, test);

        assertTrue(bankiersessie.maakOver(newSession.getRekening().getNr(), new Money(1, Money.EURO)));
    }

    @Test
    public void testGetRekening() throws Exception {
        assertNotNull(bankiersessie.getRekening());
    }

    @Test
    public void testLogUit() throws Exception {
        assertTrue(bankiersessie.isGeldig());

        bankiersessie.logUit();

//        assertFalse(bankiersessie.isGeldig());
    }
}