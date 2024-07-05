import entity.Entity
import io.github.bonigarcia.wdm.WebDriverManager
import model.LoginPage
import model.MainPage
import model.ScrollerPaydoccurrPage
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit


open class Base : Entity() {
    var loginPage: LoginPage? = null
    var mainPage: MainPage? = null
    var scrollerPaydoccurrPage: ScrollerPaydoccurrPage? = null
    var driver: WebDriver? = null


    @Before
    fun setDriver() {
        WebDriverManager.chromedriver().setup()

        driver = ChromeDriver()
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVERPATH)
        loginPage = LoginPage(driver)
        mainPage = MainPage(driver)
        scrollerPaydoccurrPage = ScrollerPaydoccurrPage(driver)
        driver!!.manage().window().maximize()
        driver!!.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS)
        driver!!.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        driver!!.get(URL)
        loginPage!!.login(LOGIN, PASSWORD)
        Assert.assertTrue("Wait for title main is displayed", mainPage!!.titleMainVisible())
    }

    @After
    open fun tearDown() {
        driver?.quit()
    }
}
