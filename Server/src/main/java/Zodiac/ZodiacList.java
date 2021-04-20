package Zodiac;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ZodiacList {

    private ArrayList<ZodiacSign> zodiacList = new ArrayList<ZodiacSign>();

    public ZodiacList()
    {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "src/main/resources/Zodiacs.txt"));
            String line = reader.readLine();

            while (line != null) {
                line = reader.readLine();
            }

            while ((line = reader.readLine()) != null)
            {
                String[] sign = line.split(" ");

                ZodiacSign zodiac = new ZodiacSign(sign[0], sign[1], sign[2]);
                zodiacList.add(zodiac);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String ReturnSign(String date)
    {
        String[] dateSplit = date.split("/");
        int month = Integer.parseInt(dateSplit[0]);
        int day = Integer.parseInt(dateSplit[1]);

        for(ZodiacSign zodie : zodiacList)
        {
            String[] startingDate = zodie.startingDate.split("/");
            String[] endingDate = zodie.endDate.split("/");

            if ((month == Integer.parseInt(startingDate[0]) && day >= Integer.parseInt(startingDate[1])) || (month == Integer.parseInt(endingDate[0]) && day <= Integer.parseInt(endingDate[1])))
            {
                return zodie.zodiacSign;
            }
        }
        return " ";
    }
}
