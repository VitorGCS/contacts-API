package com.webApp.demo.webApp.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.webApp.demo.webApp.service.CustomerServiceImpl.formatFullName;

public class CustomerServiceTest {

    private void assertFullName(String theRealCustomer, String expected) {
        assertEquals(expected, formatFullName(theRealCustomer));
    }

    @Test
    public void givenNull_returnsAnonymous() {
        assertFullName(null, "Anonymous");
    }

    @Test
    public void givenEmptyString_returnAnonymous() {
        assertFullName("", "Anonymous");
    }

    @Test
    public void givenSimpleName_returnSimpleName() {
        assertFullName("Vitor", "Vitor Anonymous");
    }

    @Test
    public void givenSimpleNameWithSpaces_returnSimpleNameWithoutSpaces() {
        assertFullName("Vitor  ", "Vitor Anonymous");
    }

    @Test
    public void givenFullName_returnFullName() {
        assertFullName("Vitor Silva", "Vitor Silva");
    }

    @Test
    public void givenFullNameWithExtraSpaces_returnFullName() {
        assertFullName("   Vitor   Silva  ", "Vitor Silva");
    }

    @Test
    public void ignoreHonorific() {
        assertFullName( "Mr. Vitor Silva", "Vitor Silva");
        assertFullName( "Mrs. First Last", "First Last");
    }

    @Test void postNominals_stayAtEnd() {
        assertFullName("First Last Sr.", "First Last");
        assertFullName("First Last Sr. Phd.", "First Last");
    }

    @Test
    public void integration() {
        assertFullName("  Mr.   Vitor    Silva  Sr. ", "Vitor Silva");
    }
}
