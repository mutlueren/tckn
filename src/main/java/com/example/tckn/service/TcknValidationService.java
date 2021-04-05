package com.example.tckn.service;

import org.springframework.stereotype.Service;

@Service
public class TcknValidationService {

    public boolean isTcknValid(String tckn) {
        if (tckn == null || tckn.equals("") || tckn.isEmpty() || !tckn.matches("^([1-9]{1}[0-9]{10})$")) {
            return false;
        }
        int oddNumberTotal = 0;
        int evenNumberTotal = 0;
        int total = 0;
        int tenthNumber = 0;
        int eleventhNumber = 0;
        for (int i = 0; i < tckn.length(); i++) {
            int charNumber = Character.getNumericValue(tckn.toCharArray()[i]);
            if (i == 0 || i == 2 || i == 4 || i == 6 || i == 8) {
                oddNumberTotal = oddNumberTotal + charNumber;
                total = total + charNumber;
            } else if (i == 1 || i == 3 || i == 5 || i == 7) {
                evenNumberTotal = evenNumberTotal + charNumber;
                total = total + charNumber;
            } else if (i == 9) {
                tenthNumber = charNumber;
                total = total + charNumber;
            } else if (i == 10) {
                eleventhNumber = charNumber;
            }
        }
        return ((((oddNumberTotal * 7) - evenNumberTotal) % 10) == tenthNumber) && ((total % 10) == eleventhNumber) && (eleventhNumber % 2 == 0);
    }
}
