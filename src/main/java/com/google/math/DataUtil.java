
package com.google.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {
    public static final double crossinsure = 2430.0D;
    public static final double cartype_big = 110.0D;
    public static final double cartype_small = 111.0D;

    public DataUtil() {
    }

    public static BigDecimal bigDecimalUtil(Object obj) {
        String str = obj == null ? "" : obj.toString();
        str = str.replaceAll(",", "").replaceAll("￥", "");
        if (str != null && !str.equals("")) {
            BigDecimal b = new BigDecimal(str);
            return b;
        } else {
            return new BigDecimal(0);
        }
    }

    public static double doubleBigDecimalUtil(Object obj) {
        String str = String.valueOf(obj == null ? "" : obj);
        double d = 0.0D;
        if (str != null && !str.equals("")) {
            d = (new BigDecimal(doubleUtil(str))).setScale(2, 4).doubleValue();
        } else {
            d = 0.0D;
        }

        return d;
    }

    public static BigDecimal bigDecimalForDoubleUtil(Object obj) {
        String str = String.valueOf(obj == null ? "" : obj);
        BigDecimal b = BigDecimal.ZERO;
        if (str != null && !str.equals("")) {
            b = (new BigDecimal(doubleUtil(str))).setScale(2, 4);
        } else {
            b = BigDecimal.ZERO;
        }

        return b;
    }

    public static float floatUtil(String str) {
        float f = 0.0F;
        if (str != null && !str.equals("")) {
            f = Float.parseFloat(str.replaceAll(",", ""));
        } else {
            f = 0.0F;
        }

        return f;
    }

    public static float floatUtil(Object obj) {
        String str = String.valueOf(obj == null ? "" : obj);
        float f = 0.0F;
        if (str != null && !str.equals("")) {
            f = Float.parseFloat(str.replaceAll(",", ""));
        } else {
            f = 0.0F;
        }

        return f;
    }

    public static String formatBigDecimalUtil(Object bg) {
        DecimalFormat df = new DecimalFormat("##,###,##0.00");
        if (bg instanceof String) {
            return df.format(new BigDecimal(StringUtil(bg)));
        } else {
            return !(bg instanceof Float) && !(bg instanceof BigDecimal) && !(bg instanceof Double) ? "0.00" : df.format(bg);
        }
    }

    public static double doubleUtil(String str) {
        double d = 0.0D;
        if (str != null && !str.equals("") && !str.equals("null")) {
            d = Double.parseDouble(str.replaceAll(",", ""));
        } else {
            d = 0.0D;
        }

        return d;
    }

    public static double doubleUtil(Object obj) {
        String str = String.valueOf(obj == null ? "" : obj);
        double d = 0.0D;
        if (str != null && !str.equals("") && !str.equals("null")) {
            d = Double.parseDouble(str.replaceAll(",", ""));
        } else {
            d = 0.0D;
        }

        return d;
    }

    public static String StringUtil(Object obj) {
        String str = String.valueOf(obj == null ? "" : obj);
        return str;
    }

    public static int intUtil(String str) {
        int temInd;
        if (str != null && !str.equals("")) {
            temInd = Integer.parseInt(str.replaceAll(",", ""));
        } else {
            temInd = 0;
        }
        return temInd;
    }

    public static int intUtil(Object obj) {
        String str = String.valueOf(obj == null ? "" : obj);
        int temInd;
        if (str != null && !str.equals("")) {
            temInd = Integer.parseInt(str.replaceAll(",", ""));
        } else {
            temInd = 0;
        }

        return temInd;
    }

    public static long longUtil(String str) {
        long temLong = 0L;
        if (str != null && !str.equals("")) {
            temLong = Long.parseLong(str.replaceAll(",", ""));
        } else {
            temLong = 0L;
        }

        return temLong;
    }

    public static long longUtil(Object obj) {
        String str = String.valueOf(obj == null ? "" : obj);
        long temLong = 0L;
        if (str != null && !str.equals("")) {
            temLong = Long.parseLong(str.replaceAll(",", ""));
        } else {
            temLong = 0L;
        }

        return temLong;
    }

    public static String formatdigital(double value) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        String aa = df.format(value);
        return aa;
    }

    public static double found2Pot(double value) {
        DecimalFormat df = new DecimalFormat("0.00");
        String aa = df.format(value);
        double f = Double.valueOf(aa).doubleValue();
        return f;
    }

    public static Date dateUtil(Object obj, String pattern) throws ParseException {
        String source = String.valueOf(obj == null ? "" : obj);
        Date destDate = null;
        if (source != null && !source.equals("")) {
            destDate = (new SimpleDateFormat(pattern)).parse(source);
        }

        return destDate;
    }

    /**
     *	 此方法不可用
     * @param obj
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("deprecation")
    public static Date dateUtil(Object obj) throws ParseException {
        String source = String.valueOf(obj == null ? "" : obj);
        Date destDate = null;
        if (source != null && !source.equals("")) {
            destDate = new Date(source);
        }

        return destDate;
    }

    public static String formatDateStringUtil(Object obj) {
        String rs = null;

        try {
            Date destDate = dateUtil(obj);
            rs = dateToStringUtil(destDate, "yyyy-MM-dd");
        } catch (ParseException var3) {
            var3.printStackTrace();
        }

        return rs;
    }

    public static Date dateUtil(String source, String pattern) throws ParseException {
        Date destDate = null;
        if (source != null && !source.equals("")) {
            destDate = (new SimpleDateFormat(pattern)).parse(source);
        }

        return destDate;
    }

    public static Date nextMonth(Date source) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(source);
        calendar.set(2, formatMonth(calendar.getTime()).intValue());
        calendar.set(5, 1);
        return calendar.getTime();
    }

    public static Date nextYear(Date source) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(source);
        calendar.set(1, formatYear(calendar.getTime()).intValue() + 1);
        calendar.set(6, 1);
        return calendar.getTime();
    }

    public static String getOneDayOfYear(Date source) {
        int year = formatYear(source).intValue();
        return year + "-01-01";
    }

    public static Integer formatYear(Date source) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy");
        String dest = sf.format(source);
        return Integer.parseInt(dest);
    }

    public static Integer formatMonth(Date source) {
        SimpleDateFormat sf = new SimpleDateFormat("MM");
        String dest = sf.format(source);
        return Integer.parseInt(dest);
    }

    public static Integer formatDay(Date source) {
        SimpleDateFormat sf = new SimpleDateFormat("dd");
        String dest = sf.format(source);
        return Integer.parseInt(dest);
    }

    public static Date isoDateToDateUtil(Object dateStr) {
        String str = StringUtil(dateStr);
        if (!str.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}Z")) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            str = str.replaceFirst("T", " ").replaceFirst(".\\d{3}Z", "");

            try {
                Date date = sdf.parse(str);
                Calendar ca = Calendar.getInstance();
                ca.setTime(date);
                ca.add(11, 8);
                return ca.getTime();
            } catch (ParseException var5) {
                var5.printStackTrace();
                return null;
            }
        }
    }

    public static String isoDateToStringUtil(Object dateStr) {
        Date date = null;
        String str = StringUtil(dateStr);
        if (str.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return str;
        } else {
            if (str.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}Z")) {
                date = isoDateToDateUtil(dateStr);
            }

            try {
                return dateToStringUtil(date, "yyyy-MM-dd");
            } catch (ParseException var4) {
                var4.printStackTrace();
                return "";
            }
        }
    }

    public static void main(String[] args) {
        try {
            String str = "Fri Dec 10 2015 00:00:00 GMT+0800";
            System.out.println(dateUtil(str));
            //2026-03-21,new Date(String s),只能转换指定格式的字符串
            System.out.println(dateUtil("2026-03-21"));
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static String dateToStringUtil(Object obj, String pattern) throws ParseException {
        String dest = "";
        if (obj != null) {
            dest = (new SimpleDateFormat(pattern)).format((Date)obj);
        }

        return dest;
    }
}
