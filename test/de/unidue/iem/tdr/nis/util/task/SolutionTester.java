package de.unidue.iem.tdr.nis.util.task;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskDefs;
import de.unidue.iem.tdr.nis.util.apicon.ServerConnector;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SolutionTester {

    private static ProjectSolver solver;
    private static Connection connection;

    @BeforeClass
    public static void setUp()  {
        ServerConnector connector = new ServerConnector();
        try {
            connector.connectToServer();
        } catch (Exception e) {
            e.printStackTrace();
            solver = new ProjectSolver(null, null);
            return;
        }
        connection = connector.getConnection();
        TaskSolver[] solvers = new TaskSolver[] {
                new DummySolver(), // solver number 0 - first to be called is number 1. (see TaskDefs)
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
                new DummySolver(),
        };
        solver = new ProjectSolver(solvers, connection);
    }

    @Test
    public void CONNECTION_TEST() {
        Assert.assertNotNull(connection);
        Assert.assertEquals(true, connection.isReady());
    }

    @Test
    public void TASK_01_CLEARTEXT() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_02_XOR() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }


    @Test
    public void TASK_03_MODULO() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_04_FACTORIZATION() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_05_VIGENERE() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_06_DES_KEYSCHEDULE() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_07_DES_RBLOCK() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_08_DES_FEISTEL() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_09_DES_ROUND() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_10_AES_GF8() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_11_AES_KEYEXPANSION() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_12_AES_MIXCOLUMNS() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_13_AES_TRANSFORMATION() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_14_AES_3ROUNDS() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_15_RC4_LOOP() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_16_RC4_KEYSCHEDULE() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_17_RC4_ENCRYPTION() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_18_DIFFIEHELLMAN() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_19_RSA_ENCRYPTION() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_20_RSA_DECRYPTION() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_21_ELGAMAL_ENCRYPTION() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }

    @Test
    public void TASK_22_ELGAMAL_DECRYPTION() {
        boolean solved = solver.getSolverOf(TaskDefs.TASK_CLEARTEXT).solve();
        Assert.assertEquals(true, solved);
    }


    @AfterClass
    public static void tearDown() {
        solver.closeConnection();
    }
}
