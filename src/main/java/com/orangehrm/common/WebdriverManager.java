package com.orangehrm.common;

import com.orangehrm.utility.PropertyReader;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebdriverManager {
    static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public synchronized static WebDriver getDriver(){
        if(threadLocal.get() == null){
            threadLocal.set(createWebdriver());
        }
        return threadLocal.get();
    }

    public static WebDriver createWebdriver(){
        WebDriver driver = null;
        String key = PropertyReader.getConfigProperty("browser");
       if(key.equalsIgnoreCase("safari")){
           driver = new SafariDriver();
       } else if (key.equalsIgnoreCase("edge")) {
           driver = new EdgeDriver();
       } else {
           driver = new ChromeDriver();
       }
       threadLocal.set(driver);
       return driver;
    }

    public static String getURL(){
        return PropertyReader.getConfigProperty("url");

    }

//    public static String reportPath = null;
//    static HashMap< String, WebDriver> driverMap = new HashMap < String, WebDriver > ();
//    static HashMap < String, WebDriver > newDriverMap = new HashMap < String, WebDriver > ();
//    static HashMap < String, WebDriver > oldDriverMap = new HashMap < String, WebDriver > ();
//    static HashMap < String, ExtentTest> testMap = new HashMap < String, ExtentTest > ();
//    static HashMap < String, ExtentTest > testFailMap = new HashMap < String, ExtentTest > () ;
//    static List< String > failScreenshots = new ArrayList<>();
//
//    public static WebDriver getDriver1() {
//        return driverMap.get (Thread.currentThread().getName() + Thread.currentThread().getId());
//    }
//
//    private static ExtentTest getTest() {
//        return testMap.get(Thread.currentThread().getName() + Thread.currentThread().getId());
//    }
//
//    //write to the report given status and if the sereenshot is needed it also captured to the repOrt
//    public static void logReport (Status status, String message, boolean takeScreenshot ) {
//        if (takeScreenshot) {
//            getTest().log(status, message, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(getDriver())).build());
//        } else {
//            getTest().log(status, message);
//            message = message.replace("<span onclick=\"$(this).next().toggle();\">Show/Hide Stacktrace</span><p>style=" +
//                    "\"displays: none;\">", "");
//            System.out.println(getCurrentDateTime() + message);
//        }
//    }
//
//    //return the current date and time
//    public static String getCurrentDateTime() {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/ dd HH:mm: ss");
//        LocalDateTime now = LocalDateTime.now ();
//
//        return "[" + (dtf.format (now) ) + "] ";
//    }
//
//    //capture the screenshot and save the screenshot inside the report folder and return the screenshot name
//    private static String takeScreenshot (WebDriver driver) {
//        String screenShotName = getCurrentDateTime ().replace("/", "_").replace(":","_")
//                .replace(" [","").replace("] ", "")
//                .replace(" ", "_") + UUID.randomUUID().toString();
//
//        String path = reportPath + "/screenshots/" + screenShotName + ".jpeg";
//        String retPath = "./screenshots/" + screenShotName + ".jpeg";
//        try {
//            File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType. FILE) ;
//            FileHandler.copy(f, new File(path));
//            failScreenshots.add(screenShotName + ".jpeg");
//        } catch (Exception e) {
//            testLog(Status.SKIP,"Can not take screenshot: " + e);
//        }
//        return retPath;
//    }
//
//    private static void testLog(Status status, String Message) {
//        getTest().log(status, Message);
//        getTestFail().log(status, Message);
//    }
//
//    private static ExtentTest getTestFail () {
//        return testFailMap.get(Thread.currentThread ().getName() + Thread.currentThread().getId ());
//    }
//
//    public void M_Setup() throws MalformedURLException {
//
//        String P_Browser = PropertyReader.getConfigProperty("browser") ;
//        //URL from the property file
//        String B_URL = PropertyReader.getConfigProperty("url");
//
//        System. out.println ("Environment is : "+ B_URL);
//
//        // Select and open the broWser
//        if (P_Browser.equalsIgnoreCase ("Firefox")){
//            System.out.println ("Browser is: " + P_Browser) ;
//            System.setProperty ("webdriver. gecko. driver", ".\\esources\\drivers\\geckodriver. exe");
//
//            driverMap.put (Thread.currentThread().getName() + Thread.currentThread ().getId (), new FirefoxDriver());
//
//            getDriver().get(B_URL);
//            getDriver().manage().window().maximize ();
//            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
//
//        } else if(P_Browser.equalsIgnoreCase("Chrome")){
//            System.out.println("Browser is: "+P_Browser);
//
//            String downloadFilepath = reportPath + "\\downloads";
//
//            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//
//            chromePrefs .put ("download, default directory", downloadFilepath) ;
//
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--incognito");
//            options.setExperimentalOption("prefs", chromePrefs);
//            options.setPageLoadStrategy (PageLoadStrategy.NORMAL) ;
//            options.setAcceptInsecureCerts(true);
//
//            DesiredCapabilities cap = new DesiredCapabilities();
//            cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//            cap.setCapability(ChromeOptions.CAPABILITY, options);
//
//            driverMap.put(Thread.currentThread().getName() + Thread.currentThread().getId(), new ChromeDriver(options));
//
//        }else if (P_Browser.equalsIgnoreCase ("edge")) {
//            // set the driver path
//            String downloadFilepath = reportPath + "\\downloads";
//
//            HashMap<String, Object> edgePrefs = new HashMap<String, Object>();
//
//            edgePrefs.put("download. default directory", downloadFilepath) ;
//            edgePrefs.put("download. prompt for download", false);
//
//            EdgeOptions options = new EdgeOptions();
//            options.setExperimentalOption("prefs", edgePrefs) ;
//            options.setAcceptInsecureCerts(true);
//            options.addArguments ("inprivate");
//
//            // start Edge Session
//            oldDriverMap.put(Thread.currentThread().getName() + Thread.currentThread().getId(), getDriver());
//
//            newDriverMap.put(Thread.currentThread().getName() + Thread. currentThread().getId(), new EdgeDriver(options));
//
//            driverMap.put(Thread.currentThread().getName() + Thread.currentThread().getId(),
//                    newDriverMap.get(Thread.currentThread().getName() + Thread.currentThread().getId()));
//
//            getDriver1().manage().window().maximize();
//            getDriver1().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//
//            getDriver1().get(B_URL) ;
//
//        } else {
//            logReport(Status.FAIL, "Unsupported browser", true);
//            getDriver1().close () ;
//        }
//    }
}
