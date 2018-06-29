package de.unidue.iem.tdr.nis.solution;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.task.TaskSolver;

public class RC4KeyGenSolver extends TaskSolver {

    public RC4KeyGenSolver(Connection connection) {
        super(connection, TaskDefs.TASK_RC4_KEYSCHEDULE);
    }

    @Override
    protected String calculateSolution() {
        int[] State_Table = createStateTableFromInput(this.task.getStringArray(0));
        return "";
    }

    private int[] createStateTableFromInput(String stringArray) {
        return new int[]{0};
    }

    private int gen_loop(int[] s) {
        int i=0;
        int j=0;
        i=i+1 % 256;
        j=j+s[i] % 256;
        int tmp = s[j];
        s[j] = s[i];
        s[i] = tmp;
        return s[s[i]+s[j] % s.length];
    }
}
