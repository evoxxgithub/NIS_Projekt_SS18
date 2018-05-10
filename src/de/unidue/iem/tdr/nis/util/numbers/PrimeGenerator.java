package de.unidue.iem.tdr.nis.util.numbers;

public class PrimeGenerator {

    private int currentPrime;

    public PrimeGenerator() {
        this.currentPrime = 0;
    }

    public int getNextPrime() {
        int nextPrime = currentPrime + 1;
        while(getNumberOfDividers(nextPrime) != 2){
            nextPrime = nextPrime + 1;
        }
        this.currentPrime = nextPrime;
        return this.currentPrime;
    }

    private int getNumberOfDividers(int number) {
        int currentDivider = 2;
        int number_of_dividers = 1;
        while(currentDivider <= number) {
            if (number % currentDivider == 0) number_of_dividers += 1;
            currentDivider += 1;
        }
        return number_of_dividers;
    }

    public void setTo(int i) {
        this.currentPrime = i;
    }

    public void reset() {
        this.currentPrime = 0;
    }
}
