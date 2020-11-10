package com.exercise.autotesting;

import com.exercise.autotesting.property.BaseAppProperty;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutotestingApplicationTests {

    public static Logger logger = LoggerFactory.getLogger(AutotestingApplicationTests.class);

    private static ChromeDriverService service;
    private WebDriver driver;

    @Autowired
    private BaseAppProperty baseConstant;

    @Test
    public void part1Test() {
        try {
            driver.manage().window().maximize();
            logger.info("1. open url:{}",baseConstant.getSearchURL());
            driver.get(baseConstant.getSearchURL());
            logger.info("2. click 'Images' button");
            driver.findElement(By.linkText(baseConstant.getSelectImageLink())).click();
            logger.info("3. click 'Search by image' icon");
            driver.findElement(By.cssSelector(baseConstant.getSelectSearchByImg())).click();
            logger.info("4. click 'Upload an image' link");
            driver.findElement(By.cssSelector(baseConstant.getSelectUploadBut())).click();
            logger.info("5. select a file...");
            driver.findElement(By.cssSelector(baseConstant.getSelectUploadFromLocal())).click();
            logger.info("6. upload...");
            this.uploadFile();
            logger.info("7. image matching...");
            String sizeMsg = driver.findElement(By.cssSelector(baseConstant.getSelectSizeMsg())).getText();
            if (!StringUtils.isEmpty(sizeMsg) && sizeMsg.contains(baseConstant.getFoundWord())) {
                logger.info("Success to match.....");
                WebElement resultEle = driver.findElement(By.cssSelector(baseConstant.getVisitResult()));
                if (StringUtils.isEmpty(resultEle.getText())) {
                    logger.info("can not visit the result by id: {}", baseConstant.getVisitResultId());
                } else {
                    logger.info("Success to visit...");
                    resultEle.click();
                }
            } else {
                logger.info("fail to match.....");
            }
            logger.info("take a screenshot...");
            this.takeSnapShot();
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        } finally {
            logger.info("8. close...");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.close();
        }
    }

    private void uploadFile() {
        String basedImagePath = new File(baseConstant.getBasedImagePath()).getAbsolutePath();
        driver.findElement(By.cssSelector(baseConstant.getSelectUploadKeys())).sendKeys(basedImagePath);
    }

    private void takeSnapShot() throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(baseConstant.getFileOutPutPath());
        FileUtils.copyFile(SrcFile, DestFile);
    }

    @Before
    public void createDriver() throws IOException{
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(baseConstant.getWebDriverPath()))
                .usingAnyFreePort()
                .build();
        service.start();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-lang=en");
        driver = new RemoteWebDriver(service.getUrl(), options);
    }

    @After
    public void quitDriver() {
        driver.quit();
        service.stop();
    }
}
