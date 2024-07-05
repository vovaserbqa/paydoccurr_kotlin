package model

import entity.DriverEntity
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class MainPage(driver: WebDriver?) : DriverEntity(driver!!) {
    private val header = By.xpath("//div[text()='Платежные документы']")
    private val sectionApplications = By.xpath("//div[text()='Валютные операции']")
    private val sectionUpApplications = By.xpath("//div[text()='Валютные документы']")
    private val sectionPaydoccurr = By.xpath("//div[text()='Поручения на перевод валюты']")
    private val buttonTableSetup = By.xpath("//button[@class='css-uqtvzs']")

    @Step("wait for title")
    fun titleMainVisible(): Boolean {
        return driver.findElement(header).isDisplayed
    }

    @Step("wait for is displayed")
    fun waitForElement(element: By?): MainPage {
        driver.findElement(element).isDisplayed
        return this
    }

    @Step("go to paydoccurr section")
    fun goToPaydoccurrSection(): MainPage {
        waitForElement(sectionApplications)
        driver.findElement(sectionApplications).click()
        driver.findElement(sectionUpApplications).click()
        driver.findElement(sectionPaydoccurr).click()
        return this
    }

    @Step("go to table setup")
    fun goToTableSetupSection(): MainPage {
        driver.findElement(buttonTableSetup).click()
        return this
    }
}
