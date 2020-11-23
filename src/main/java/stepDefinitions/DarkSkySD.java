package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.DarkSkyHome;

public class DarkSkySD {

    DarkSkyHome darkSkyHome = new DarkSkyHome();

    @Given("^I am on Darksky Home Page$")
    public void i_am_on_darksky_home_page()  {

        Assert.assertEquals(SharedSD.getDriver().getTitle(),
                "Dark Sky - Sansad Marg, New Delhi, Delhi"
        ,"We are not on the dark sky home page");

    }

    @Then("^I verify current temp is equal to Temperature from Daily Timeline$")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline()
            {

               int expected =  darkSkyHome.getCurrTemp();
               int actual = darkSkyHome.getTimelineTemp();

                System.out.println("expected:"+expected);
                System.out.println("actual:"+actual);

                Assert.assertEquals(actual,expected,
                        "tempertature are equal");

            }
}
