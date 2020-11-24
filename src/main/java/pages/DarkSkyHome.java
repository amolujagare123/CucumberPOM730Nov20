package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import stepDefinitions.SharedSD;

import java.util.ArrayList;

public class DarkSkyHome extends  BasePage{

    By currTempTxt = By.xpath("//span[@class='summary swap']");
    By timelineTempTxt = By.xpath("//span[@class='first']//span");
    By timeTextList = By.xpath("//span[@class='hour']/span");
    By expander = By.xpath("//a[@data-day='0']//span[@class='toggle']");
    By barMinTemp = By.xpath("//a[@class='day revealed']//span[@class='minTemp']");
    By barMaxTemp = By.xpath("//a[@class='day revealed']//span[@class='maxTemp']");
    By timelineMinTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']");
    By timelineMaxTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[@class='temp']");



    public ArrayList<String> getBarTempList()
    {
        String maxTemp =  getTextFromElement(barMinTemp).split("˚")[0]; // 77˚
        String minTemp =  getTextFromElement(barMaxTemp).split("˚")[0]; // 77˚

        ArrayList<String> tempList = new ArrayList<>();

        tempList.add(maxTemp);
        tempList.add(minTemp);

        return tempList;
    }

    public ArrayList<String> getTimelineTempList()
    {
        String maxTemp =  getTextFromElement(timelineMinTemp).split("˚")[0]; // 53˚
        String minTemp =  getTextFromElement(timelineMaxTemp).split("˚")[0]; // 53˚

        ArrayList<String> tempList = new ArrayList<>();

        tempList.add(maxTemp);
        tempList.add(minTemp);

        return tempList;
    }






    public void clickTodaysExpander()
    {

        JavascriptExecutor jse = (JavascriptExecutor) SharedSD.getDriver();
        jse.executeScript("window.scrollBy(0,800);");

        clickOn(expander);
    }



  public ArrayList<Integer> getTimelist()
  {
        ArrayList<String> timetxtList = getElementTextList(timeTextList);
        System.out.println(timetxtList);
        ArrayList<Integer> timeList = new ArrayList<>();

        for(int i=0;i<timetxtList.size();i++)
        {
            String str = timetxtList.get(i);//"11pm";

            int l = str.length();

            String timeStr =  str.substring(0,l-2); // "11"

            int time = Integer.parseInt(timeStr);

            timeList.add(time);

        }



        return  timeList;
  }


    public int getCurrTemp()
    {
        String tempTxt = getTextFromElement(currTempTxt); // 64˚ Clear.

        String tempStr = tempTxt.split("˚")[0];

       return Integer.parseInt(tempStr);
    }

    public int getTimelineTemp()
    {
        String tempTxt = getTextFromElement(timelineTempTxt); //67°

        String tempStr = tempTxt.split("°")[0];

        return Integer.parseInt(tempStr);
    }

}
