package model

import entity.DriverEntity
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class LoginPage(driver: WebDriver?) : DriverEntity(driver!!) {
    private val inputLogin = By.xpath("//input[@name='login']")
    private val inputPassword = By.xpath("//input[@name='password']")
    private val buttonLogin = By.xpath("//button[@class='css-d34lyg']")
    private val title = By.xpath("//div[@class='css-l6zity']")

    @Step("log in")
    fun login(login: String?, password: String?) {
        driver.findElement(inputLogin).sendKeys(login)
        driver.findElement(inputPassword).sendKeys(password)
        driver.findElement(buttonLogin).click()
        for (i in 0..5) {
            driver.findElement(By.xpath("//input[@data-name='digit-$i']")).sendKeys("1")
        }
    }
}
