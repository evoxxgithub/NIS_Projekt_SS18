package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.encryption.AES;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

public class AESMixColumnsSolver extends TaskSolver {

    public AESMixColumnsSolver(Connection connection) {
        super(connection, TaskDefs.TASK_AES_MIXCOLUMNS);
    }

    @Override
    protected String calculateSolution() {
        //String input = this.task.getStringArray(0);
        String input = "01010101c6c6c6c6d4d4d4d510101010";
        System.out.println(input);
        input = input.substring(0, 2) + input.substring(8, 10) + input.substring(16, 18) + input.substring(24, 26)
                + input.substring(2, 4) + input.substring(10, 12) + input.substring(18, 20) + input.substring(26, 28)
                + input.substring(4, 6) + input.substring(12, 14) + input.substring(20, 22) + input.substring(28, 30)
                + input.substring(6, 8) + input.substring(14, 16) + input.substring(22, 24) + input.substring(30, 32);
        System.out.println(input);
        String result = AES.mixColumns(input);
        System.out.println(result);
        return input;
    }
}
