package lk.ijse.dep10.sms.smsApp.business.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessExceptionTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testBusinessException() {
        assertThrows(BusinessException.class,()->{
            BusinessException businessException = new BusinessException(BusinessExceptionType.RECORD_NOT_FOUND);
            businessException.printStackTrace();
            throw businessException;
        });

    }
}