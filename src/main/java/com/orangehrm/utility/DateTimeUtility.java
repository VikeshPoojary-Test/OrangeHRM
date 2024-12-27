package com.orangehrm.utility;

import com.orangehrm.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class DateTimeUtility extends BasePage {

        public void selectDate(String targetDate, String dateFormat, By presentDateWebElement,
                               By previousButton_Calender, By nextButton_Calender, By selectCalenderDate){
            Date formattedTargetDate;
            Calendar calendar = Calendar.getInstance();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

            try {
                simpleDateFormat.setLenient(false);
                formattedTargetDate = simpleDateFormat.parse(targetDate);
                System.out.println(formattedTargetDate);

                calendar.setTime(formattedTargetDate);

                int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
                int targetMonth = calendar.get(Calendar.MONTH);
                int targetYear = calendar.get(Calendar.YEAR);

                String presentDate = getValue(presentDateWebElement).replace("\n", " ");
                calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(presentDate));

                int presentMonth = calendar.get(Calendar.MONTH);
                int presentYear = calendar.get(Calendar.YEAR);

                while (targetMonth < presentMonth || targetYear < presentYear) {
                    click(previousButton_Calender);

                    presentDate = getValue(presentDateWebElement).replace("\n", " ");
                    calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(presentDate));

                    presentMonth = calendar.get(Calendar.MONTH);
                    presentYear = calendar.get(Calendar.YEAR);
                }

                while (targetMonth > presentMonth || targetYear > presentYear) {
                    click(nextButton_Calender);

                    presentDate = getValue(presentDateWebElement).replace("\n", " ");
                    calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(presentDate));

                    presentMonth = calendar.get(Calendar.MONTH);
                    presentYear = calendar.get(Calendar.YEAR);
                }

                List<WebElement> listofDate = waitAndGetAllElements(selectCalenderDate);
                IntStream.range(0, Math.min(listofDate.size(), listofDate.size()))
                        .filter(i -> listofDate.get(i).getText().equalsIgnoreCase(String.valueOf(targetDay)))
                        .findFirst()
                        .ifPresent(i -> listofDate.get(i).click());

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

}

