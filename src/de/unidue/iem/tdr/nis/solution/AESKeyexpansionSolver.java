package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.encryption.AES;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

import java.util.Arrays;

public class AESKeyexpansionSolver extends TaskSolver {

    public AESKeyexpansionSolver(Connection connection) {
        super(connection, TaskDefs.TASK_AES_KEYEXPANSION);
    }

    @Override
    protected String calculateSolution() {
        final String key = this.task.getStringArray(0);
        System.out.println(key);
        final String[] words = AES.keyexpandsion(key);
        System.out.println(Arrays.toString(words));
        final String solution = words[0] + words[1] + words[2] + words[3] + "_" +
                words[4] + words[5] + words[6] + words[7] + "_" +
                words[8] + words[9] + words[10] + words[11];
        System.out.println(solution);
        return solution;
    }
}
