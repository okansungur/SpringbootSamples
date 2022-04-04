package com.example.tmp.monopro.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;

 public class Utility {
    static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Utility.class.getName());

    private static int sequence = 0;


    public static String encodeData(String data) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(data);
    }




    public static XMLGregorianCalendar getCurrentXMLGregorianCalendar(){
        try{
            Calendar c = Calendar.getInstance();
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(c.getTime());
            XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
            return xgc;
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "XMLGregorianCalendar {0}.", e.getMessage());
            return null;
        }
    }


    public static XMLGregorianCalendar CalendarToXMLGregorianCalendar(Calendar cal){
        try{
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(cal.getTime());
            XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
            return xgc;
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "CalendarToXMLGregorianCalendar {0}.", e.getMessage());
            return null;
        }
    }


    public static Calendar XMLGregorianCalendarToCalendar(XMLGregorianCalendar xcal){
        try{
            Calendar cal = Calendar.getInstance();
            cal.setTime(xcal.toGregorianCalendar().getTime());
            return cal;
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "XMLGregorianCalendarToCalendar {0}.", e.getMessage());
            return null;
        }
    }


    public static String calendarToXMLDateTimeString(Calendar cal){
        if(cal == null){ return ""; }
        String dateTimeString = "" + cal.get(Calendar.YEAR);
        dateTimeString += "-" +String.format("%02d", (cal.get(Calendar.MONTH) + 1));
        dateTimeString += "-" +String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH)));
        dateTimeString += "T";
        dateTimeString += String.format("%02d", cal.get(Calendar.HOUR_OF_DAY));
        dateTimeString += ":" + String.format("%02d", cal.get(Calendar.MINUTE));
        dateTimeString += ":" + String.format("%02d", cal.get(Calendar.SECOND));
        dateTimeString += ".000Z";
        return dateTimeString;
    }


    public static int getCurrentDayTimeInSeconds(){
        int totalSeconds = 0;
        Calendar now = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        totalSeconds = now.get(Calendar.HOUR_OF_DAY) * 60 * 60 + now.get(Calendar.MINUTE) * 60 + now.get(Calendar.SECOND);
        return totalSeconds;
    }


    public static String generateMessageID(String messageid){
        Calendar calendar = Calendar.getInstance();
        String messageId =messageid ;
        messageId += calendar.get(Calendar.YEAR);
        messageId += String.format("%02d", (calendar.get(Calendar.MONTH) + 1));
        messageId += String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));
        messageId += String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY));
        messageId += String.format("%02d", calendar.get(Calendar.MINUTE));
        messageId += String.format("%02d", calendar.get(Calendar.SECOND));
        messageId += String.format("%05d", (sequence++)%100000);
        return messageId;
    }




}
