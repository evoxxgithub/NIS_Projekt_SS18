package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.numbers.HexMultiplier;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

public class AesGf8Solver extends TaskSolver {
    public AesGf8Solver(Connection connection) {
        super(connection, TaskDefs.TASK_AES_GF8);
    }

    @Override
    protected String calculateSolution() {
        final String hex1 = task.getStringArray(0);
        final String hex2 = task.getStringArray(1);
        System.out.println("aes-hex1: " + hex1);
        System.out.println("aes-hex1: " + hex2);
        final String result = new HexMultiplier().multiply(hex1, hex2);
        System.out.println("aes-result: " + result);
        return result;
    }
}
