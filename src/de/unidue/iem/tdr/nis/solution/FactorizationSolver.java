package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.numbers.PrimeGenerator;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

public class FactorizationSolver extends TaskSolver {

    public FactorizationSolver(Connection connection) {
        super(connection, TaskDefs.TASK_FACTORIZATION);
    }

    @Override
    protected String calculateSolution() {
        int input = this.task.getIntArray(0);
        final StringBuilder primeBuilder = new StringBuilder();
        final PrimeGenerator primeGenerator = new PrimeGenerator();

        for(int i = primeGenerator.getNextPrime(); i <= input; i = primeGenerator.getNextPrime()) {
            while(input % i == 0) {
                input = input / i;
                primeBuilder.append(i);
                primeBuilder.append("*");
            }
        }
        return primeBuilder.toString().substring(0, primeBuilder.length()-1); // removes last character (*)
    }
}
