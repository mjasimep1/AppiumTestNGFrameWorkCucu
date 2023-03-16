package com.qa.runners;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.*;

public class RunnerBase {
    private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();

    public static TestNGCucumberRunner getRunner(){
        return testNGCucumberRunner.get();
    }

    private static void setRunner(TestNGCucumberRunner testNGCucumberRunner1){
        testNGCucumberRunner.set(testNGCucumberRunner1);
    }

    @Parameters({"platformName", "udid", "deviceName","systemPort","chromeDriverPort"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(String platformName, String udid, String deviceName, String systemPort, String chromeDriverPort) throws Exception {

        ThreadContext.put("ROUTINGKEY", platformName + "_" + deviceName);

        GlobalParams params = new GlobalParams();
        params.setPlatformName(platformName);
        params.setUdid(udid);
        params.setDeviceName(deviceName);
        params.setSystemPort(systemPort);
        params.setChromeDriverPort(chromeDriverPort);
        params.setAvd(deviceName);

        new ServerManager().startServer();
        //-------------------------------------
       /* CommandLine cmd = new CommandLine("C:\\\\Program Files\\\\nodejs\\\\node.exe");
        cmd.addArgument("C:\\\\Users\\\\artdsktp44user\\\\AppData\\\\Roaming\\\\npm\\\\node_modules\\\\appium\\\\build\\\\lib\\\\main.js");
        cmd.addArgument("--address");
        cmd.addArgument("127.0.0.1");
        cmd.addArgument("--port");
        cmd.addArgument("4723");
        DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        try {
            executor.execute(cmd, handler);
            Thread.sleep(10000);
            System.out.println("Server starting");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }*/
        //-------------------------------------
        new DriverManager().initializeDriver();

        setRunner(new TestNGCucumberRunner(this.getClass()));
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
        getRunner().runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return getRunner().provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        DriverManager driverManager = new DriverManager();
        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        ServerManager serverManager = new ServerManager();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }
        if(testNGCucumberRunner != null){
            getRunner().finish();
        }
    }
}