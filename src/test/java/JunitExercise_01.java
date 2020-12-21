import org.junit.*;

public class JunitExercise_01 {

    // basit deneme, setup ve teardown nasıl çalışır, çıktılar nasıl gösterilir vs.

    @BeforeClass
    public static void setUp() {
        System.out.println("Setup is running");
    }
    @Before
    public void initialize() {
        System.out.println("Initialize is running");
    }
    @Test
    public void testB() {
        System.out.println("TestB is running");
    }
    @Test
    public void testA() {
        System.out.println("TestA is running");
    }
    @After
    public void finalise() {
        System.out.println("Finalize is running");
    }
    @AfterClass
    public static void tearDown() {
        System.out.println("Teardown is running");
    }

}
