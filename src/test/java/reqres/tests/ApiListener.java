package reqres.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import rozetka.tests.BaseUITest;
import rozetka.tests.UIListener;

import java.util.Arrays;

public class ApiListener implements ITestListener {

    private static Logger LOG = LogManager.getLogger(ApiListener.class.getName());

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("test {} starts with params: {}",
                result.getName(), Arrays.toString(result.getParameters()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("test {} finished.", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("test {} failed.", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.info("test {} skipped.", result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
