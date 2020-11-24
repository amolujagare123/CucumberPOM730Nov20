package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.DarkSkyHome;

import java.util.ArrayList;
import java.util.Collections;

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


    @Then("^I verify timeline is displayed with two hours incremented$")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented()
             {

               ArrayList<Integer> timeList = darkSkyHome.getTimelist();
               System.out.println(timeList);

                 ArrayList<Integer> timeDiffList = new ArrayList<>();

                 for(int i=0;i<timeList.size()-1;i++)
                 {
                     int time1 = timeList.get(i);
                     int time2 = timeList.get(i+1);
                     int timeDiff =0;

                     if(time2>time1)
                      timeDiff = time2-time1;

                     else if(time1>time2)
                         timeDiff = (time2+12) - time1;

                     timeDiffList.add(timeDiff);

                 }
                 System.out.println(timeDiffList);
                 int occurance = Collections.frequency(timeDiffList,2);
                 int size = timeDiffList.size();
                 boolean result = occurance==size; // true / false
                 Assert.assertTrue(result,"all time differences are not 2");

    }


    @Then("^I verify today's lowest and highest temp is displayed correctly$")
    public void i_verify_todays_lowest_and_highest_temp_is_displayed_correctly()
             {

                 darkSkyHome.clickTodaysExpander();

                 System.out.println("Bar:"+darkSkyHome.getBarTempList());
                 System.out.println("TimeLine:"+darkSkyHome.getTimelineTempList());

                 Assert.assertEquals(darkSkyHome.getBarTempList(),
                         darkSkyHome.getTimelineTempList(),
                         "temp. is not correct on todays timeline");

    }

}
