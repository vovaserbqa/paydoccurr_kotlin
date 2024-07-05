package model

import entity.DriverEntity
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class ScrollerPaydoccurrPage(driver: WebDriver?) : DriverEntity(driver!!) {
    private val title = By.xpath("//div[text()='Поручения на перевод валюты']")
    private val titleTableSetup = By.xpath("//div[text()='Вид таблицы']")

    @Step("wait for title")
    fun titlePaydoccurrVisible(): Boolean {
        return driver.findElement(title).isDisplayed
    }

    @Step("wait for table setup")
    fun titleTableSetupVisible(): Boolean {
        return driver.findElement(titleTableSetup).isDisplayed
    }
}
