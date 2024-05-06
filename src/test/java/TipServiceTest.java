import static org.junit.jupiter.api.Assertions.assertEquals;

import academy.kata.TipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class TipServiceTest {

    @Spy
    private TipService tipService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @MethodSource("argsProviderFactoryForFivePerCent")
    public void shouldBeFivePerCent(BigDecimal amount) {
        assertEquals(amount.multiply(BigDecimal.valueOf(1.05)), tipService.roundTips(amount));
    }

    @ParameterizedTest
    @MethodSource("argsProviderFactoryForTenPerCent")
    public void shouldBeTenPerCent(BigDecimal amount) {
        assertEquals(amount.multiply(BigDecimal.valueOf(1.1)), tipService.roundTips(amount));
    }


    static Stream<BigDecimal> argsProviderFactoryForFivePerCent() {
        return Stream.of(BigDecimal.valueOf(1000), BigDecimal.valueOf(3000));
    }

    static Stream<BigDecimal> argsProviderFactoryForTenPerCent() {
        return Stream.of(BigDecimal.valueOf(0), BigDecimal.valueOf(500), BigDecimal.valueOf(999));
    }
}
