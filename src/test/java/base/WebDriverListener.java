package base;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;


public class WebDriverListener implements IInvokedMethodListener {
    private DriverFactory driverFactory;
    public WebDriverListener() {

    }

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            String browserName = (String)iInvokedMethod.getTestMethod().getXmlTest().getLocalParameters().get("browser");
            String platform = (String)iInvokedMethod.getTestMethod().getXmlTest().getLocalParameters().get("platform");
            DriverFactory.createInstance(browserName,platform);
        }
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            DriverManager.removeDriver();
            System.out.println("After Invoke Method");
        }
    }
}
