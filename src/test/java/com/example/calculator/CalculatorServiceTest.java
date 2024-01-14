package com.example.calculator;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorServiceTest {

    @Injectable
    private MathOperation mathOperation; // Giả mạo dependency

    @Tested
    private CalculatorService calculatorService; // Kiểm thử đối tượng

    @Test
    public void testPerformAddition() {
        // Thiết lập kỳ vọng cho phương thức add của MathOperation
        new Expectations() {{
            mathOperation.add(2, 3);
            result = 5; // Kết quả trả về khi phương thức add được gọi với tham số 2 và 3
        }};

        // Gọi phương thức kiểm thử của CalculatorService, nó phải gọi phương thức add của MathOperation
        int result = calculatorService.performAddition(2, 3);

        // Kiểm tra kết quả
        assertEquals(5, result);
    }
}
