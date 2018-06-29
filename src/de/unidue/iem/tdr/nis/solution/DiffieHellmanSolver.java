package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.numbers.Functions;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

import java.util.Random;

public class DiffieHellmanSolver extends TaskSolver {

    private int p;
    private int g;
    private int a;
    private int A;
    private double B;
    private int K;


    public DiffieHellmanSolver(Connection connection) {
        super(connection, TaskDefs.TASK_DIFFIEHELLMAN);
    }

    @Override
    protected String calculateSolution() {
        this.p = this.task.getIntArray(0);
        this.g = this.task.getIntArray(1);
        this.B  = this.task.getDoubleArray(0);
        this.a = generateRandomA(p);
        this.A = calculateAFromParams();
        this.K = calculateKey();
        return String.valueOf(this.A);
    }

    private int calculateKey() {
        int result = (int) B;
        for (int i = 0; i < a; i++) {
            result = (result * result) % p;
        }
        return result;
    }

    private int generateRandomA(int p) {
        final int topBorder = p - 2;
        return new Random().nextInt(topBorder);
    }

    private int calculateAFromParams() {
        int result = this.g;
        for (int i = 1; i < a; i++) {
            result = (result * result) % p;
        }
        return result;
    }

    private String decryptChiffreText(String input) {
        return Functions.binaryXor(input, String.valueOf(this.K));
    }
}
