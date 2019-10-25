package codes.walid4444.lavaloon.toggl;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import codes.walid4444.lavaloon.toggl.Remote.Models.TimeEntryModel;

public class SortingUtility {

    public static List<TimeEntryModel> sortTimeEntries(List<TimeEntryModel> timeEntries){
        Collections.sort(timeEntries);
        return timeEntries;
    }

    public static List<String> getTimesEntriesDates(List<TimeEntryModel> timeEntries){
        List<String> stringList = new ArrayList<>();
        for (TimeEntryModel t:timeEntries) {
            stringList.add(t.getAt());
        }
        return stringList;
    }

    public static Map<String,List<TimeEntryModel>> groupTimeEntriesDates(List<TimeEntryModel> timeEntries) {
        Map<String, List<TimeEntryModel>> map = new HashMap<String, List<TimeEntryModel>>();


        for (TimeEntryModel date : timeEntries) {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
            Date k = null;
            try {
                 k = f.parse(date.getAt());
            }catch (Exception e){
                Log.e("Grouping",e.getMessage());
            }


            String key = new SimpleDateFormat("yyyy-MM-dd").format(k);
            try {
                key = formatToYesterdayOrToday(key);
            }catch (Exception e){
                Log.e("GROUPING",e.getMessage());
            }
            if (map.containsKey(key)) {
                List<TimeEntryModel> list = map.get(key);
                list.add(date);

            } else {
                List<TimeEntryModel> list = new ArrayList<TimeEntryModel>();
                list.add(date);
                map.put(key, list);
            }

        }
        return map;
    }

    public static String formatToYesterdayOrToday(String date) throws ParseException {
        Date dateTime = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        Calendar today = Calendar.getInstance();
        Calendar yesterday = Calendar.getInstance();
        Calendar last_weak = Calendar.getInstance();

        yesterday.add(Calendar.DATE, -1);
        last_weak.add(Calendar.DATE, -7);

        DateFormat timeFormatter = new SimpleDateFormat("hh:mma");

        if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)) {
            return "Today ";
        } else if (calendar.get(Calendar.YEAR) == yesterday.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == yesterday.get(Calendar.DAY_OF_YEAR)) {
            return "Yesterday " ;
        } else if (calendar.get(Calendar.YEAR) == yesterday.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == last_weak.get(Calendar.DAY_OF_YEAR)) {
            return "Last Weak" ;
        }else {
            return date;
        }
    }


    public static String ConverttoSimpleDate(String date){
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        String key= null;
        try {
             key = new SimpleDateFormat("HH:mm MM-dd").format(f.parse(date));
        }catch (Exception e){

        }
        return key;

    }
}
