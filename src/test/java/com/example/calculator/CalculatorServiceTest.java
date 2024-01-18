package com.example.calculator;

import mockit.Expectations;
import mockit.Verifications;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CalculatorServiceTest {
    // 1. khởi tạo đối tượng mock
    @Injectable
    private MathOperation mathOperation; 

    // 2. khởi tạo đối tượng test
    @Tested
    private CalculatorService calculatorService; 

    @Test
    public void testPerformAddition() {
        int A = 2;
        int B = 3;

        int RESULT = 6;


        new Expectations() {{  
            // 3. kịch bản cho phương thức add()  
            mathOperation.add(A, B);
            result = RESULT;
        }};

        // 4. thực thi đối tượng test
        int mockResult = calculatorService.performAddition(A, B);

        
        // 5. khởi tạo đối tượng mới không thông qua mock
        MathOperation mathOperationReal = new MathOperation();
        CalculatorService calculatorService = new CalculatorService(mathOperationReal);
        int result = calculatorService.performAddition(A, B);

        System.out.println("Mock Result: " + mockResult);
        System.out.println("Real Result: " + result);

        // 6. so sánh kết quả giữa mock và real
        assertEquals(result, mockResult);

        // 7. kiểm tra số lần gọi hàm 
        new Verifications() {{
            mathOperation.add(A, B);
            times = 1;
        }};
    }
}
