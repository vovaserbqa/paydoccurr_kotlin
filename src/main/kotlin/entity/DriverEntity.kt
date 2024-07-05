package entity

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

open class DriverEntity(driver: WebDriver) {
    var driver: WebDriver

    init {
        this.driver = driver
    }

    fun waitForElementVisibility(element: By?) {
        WebDriverWait(driver, Duration.ofSeconds(3))
            .until(ExpectedConditions.visibilityOf(driver.findElement(element)))
    }
}
