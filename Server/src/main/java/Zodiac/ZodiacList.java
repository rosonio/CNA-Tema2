package Zodiac;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ZodiacList {

    private ArrayList<ZodiacSign> zodiacArrayList = new ArrayList<ZodiacSign>();

    public ZodiacList() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "src/main/resources/Zodiacs.txt"));
            String line = reader.readLine();

            while (line != null) {
                line = reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] sign = line.split(" ");

                    ZodiacSign zodiac = new ZodiacSign(sign[0], sign[1], sign[2]);
                    zodiacArrayList.add(zodiac);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean DateVerification(String date) {
        if (date != "") {
            if (date.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")) {
                String[] dateSplit = date.split("/");
                int month = Integer.parseInt(dateSplit[0]);
                int day = Integer.parseInt(dateSplit[1]);
                int year = Integer.parseInt(dateSplit[2]);

                if (month == 2 && year % 4 == 0 && year % 100 != 0 && year % 400 == 0 && day > 28) {
                    return false;
                } else {
                    if ((month == 4 || month == 6) || month == 9 || month == 11 && day > 30) {
                        return false;
                    }
                }
                return true;

            }
        }
        return false;
    }

    public String ReturnSign(String date) {
        try {
            String[] dateSplit = date.split("/");
            int month = Integer.parseInt(dateSplit[0]);
            int day = Integer.parseInt(dateSplit[1]);

            for (ZodiacSign zodiacSign : zodiacArrayList) {
                String[] startDate = zodiacSign.startingDate.split("/");
                String[] endDate = zodiacSign.endDate.split("/");

                if (DateVerification(date) && (month == Integer.parseInt(startDate[0]) && day >= Integer.parseInt(startDate[1])) || (month == Integer.parseInt(endDate[0]) && day <= Integer.parseInt(endDate[1]))) {
                    return zodiacSign.zodiacSign;
                }
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }
}
