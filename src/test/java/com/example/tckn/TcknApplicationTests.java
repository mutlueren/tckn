package com.example.tckn;

import com.example.tckn.service.TcknValidationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TcknApplicationTests {

    @InjectMocks
    TcknValidationService tcknValidationService;

    @Test
    void is_tckn_valid(){
        boolean isValid = tcknValidationService.isTcknValid("13811111111");
        assertNotNull(isValid);
        assertFalse(isValid);
    }

}
