import io.qameta.allure.Epic
import io.qameta.allure.Issue
import io.qameta.allure.Owner
import io.qameta.allure.junit4.DisplayName
import jdk.jfr.Description
import org.junit.Assert
import org.junit.Test

@Owner("v.serbin")
@Epic("Tests for scroller currency transfer")
class ScrollerTest : Base() {
    @Test
    @DisplayName("goToPaydoccurrPageTest")
    @Description("Checking the header on the Currency Transfer Orders page")
    @Issue("GBO-88241")
    fun goToPaydoccurrPageTest() {
        mainPage!!.goToPaydoccurrSection()
        Assert.assertTrue("Wait for title onb is displayed", scrollerPaydoccurrPage!!.titlePaydoccurrVisible())
    }

    @Test
    @DisplayName("check table setup")
    @Description("Checking the header on the table settings drover")
    @Issue("GBO-88245")
    fun checkTableSetupTest() {
        mainPage!!.goToPaydoccurrSection()
        mainPage!!.goToTableSetupSection()
        Assert.assertTrue("Wait for title table setup is displayed", scrollerPaydoccurrPage!!.titleTableSetupVisible())
    }
}
