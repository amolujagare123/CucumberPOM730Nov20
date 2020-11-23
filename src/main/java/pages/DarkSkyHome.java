package pages;

import org.openqa.selenium.By;

public class DarkSkyHome extends  BasePage{

    By currTempTxt = By.xpath("//span[@class='summary swap']");
    By timelineTempTxt = By.xpath("//span[@class='first']//span");


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
