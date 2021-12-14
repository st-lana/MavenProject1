import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndBonusUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);


    }

    @Test
    void shouldCalculateRegisteredAndBonusOverLimit() {
        BonusService service = new BonusService();

        long amount = 1000_000_60;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateUnregisteredAndBonusUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateUnregisteredAndBonusOverLimit() {
        BonusService service = new BonusService();

        long amount = 100_000_60;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateRegisteredAndBonusEqualLimit() {
        BonusService service = new BonusService();

        long amount = 16_666_67;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateUnregisteredAndBonusEqualLimit() {
        BonusService service = new BonusService();

        long amount = 5_000_000;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }
}