/**
 * This class represents a Date object
 *
 * @author Elad Sopher
 * @version 05/12/22
 */
public class Date
{
    private static final int MAX_ONE_DIGIT_NUMBER = 9;
    private static final int DEFAULT_DAY = 1;
    private static final int DEFAULT_MONTH = 1;
    private static final int DEFAULT_YEAR = 2000;
    private static final int MIN_YEAR = 1000;
    private static final int MAX_YEAR = 9999;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;
    private static final int FEB_REGULAR_MAX = 28;
    private static final int FEB_LEAP_YEAR_MAX = 29;

    private int _day;
    private int _month;
    private int _year;

    /**
     * Empty constructor
     * sets the attributes to default
     */
    public Date()
    {
        _day = DEFAULT_DAY;
        _month = DEFAULT_MONTH;
        _year = DEFAULT_YEAR;
    }

    /**
     * creates a new Date object
     * If the given date is valid - creates a new Date object, otherwise creates the date 01/01/2000
     * @param day the day in the month(1-31)
     * @param month the month in the year(1-12)
     * @param year the year (4 digits)
     */
    public Date(int day, int month, int year)
    {
        this();
        if(isValidDate(day,month,year))
        {
            _day = day;
            _month= month;
            _year = year;
        }
    }

    /**
     * Copy Constructor
     * @param other the date to be copied
     */
    public Date(Date other)
    {
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }

    /**
     * checks if the date given by the user is a valid date
     * @param leapYear return true if the given year is a leap year,otherwise return false
     * @returns true is the date is valid,otherwise return false
     */
    private boolean isValidDate(int day,int month,int year)
    {
        if(year < MIN_YEAR || year > MAX_YEAR || month < MIN_MONTH || month > MAX_MONTH || day < MIN_DAY || day > MAX_DAY)
        {
            return false;
        }
        boolean leapYear = leapYear(year);
        switch(month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return true;
            case 4:
            case 6:
            case 9:
            case 11:
                if(day >= MAX_DAY)
                    return false;
                else
                    return true;
            case 2:
                if((leapYear && day > FEB_LEAP_YEAR_MAX) || (!leapYear && day > FEB_REGULAR_MAX))
                    return false;
                else
                    return true;
            default:
                break;
        }
        return true;
    }

    /**
     * gets the day
     * @returns the day
     */
    public int getDay()
    {
        return _day;
    }

    /**
     * gets the month
     * @returns the month
     */
    public int getMonth()
    {
        return _month;
    }

    /**
     * gets the year
     * @returns the year
     */
    public int getYear()
    {
        return _year;
    }

    /**
     * sets the day
     * @param dayToSet the value to be set if valid
     */
    public void setDay(int dayToSet)
    {
        if(isValidDate(dayToSet,_month,_year))
        {
            _day = dayToSet;
        }
    }

    /**
     * sets the month
     * @param monthToSet the value to be set if valid
     */
    public void setMonth(int monthToSet)
    {
        if(isValidDate(_day,monthToSet,_year))
        {
            _month = monthToSet;
        }
    }

    /**
     * sets the year
     * @param yearToSet the value to be set if valid
     */
    public void setYear(int yearToSet)
    {
        if(isValidDate(_day,_month,yearToSet))
        {
            _year = yearToSet;
        }
    }

    /**
     * checks if 2 dates are the same
     * @param other the date to compare this date to
     * @return true if the dates are the same
     */
    public boolean equals(Date other)
    {
        return (_day == other.getDay() && _month == other.getMonth() && _year == other.getYear());
    }

    /**
     * checks which date comes first
     * @param other the date to compare to this date
     * @return true if this date comes before other date
     * @return false if this date comes after other date
     */
    public boolean before(Date other)
    {
        return (_year < other.getYear() || _year == other.getYear() && _month < other.getMonth() || _year == other.getYear() && _month == other.getMonth() && _day < other.getDay());
    }

    /**
     * Check if this date is after other date
     * @param other the date to compare this date to
     * @return true if this date is after other date,otherwise false
     */
    public boolean after(Date other)
    {
        return other.before(this);
    }

    /**
     * computes the day number since the beginning of the Christian counting of years
     */
    private int calculateDate ( int day, int month, int year)
    {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }

    /**
     * Calculates the difference in days between two dates
     * @param other the date to calculate the difference between
     */
    public int difference(Date other)
    {
        return Math.abs(calculateDate(_day,_month,_year) - calculateDate(other._day,other._month,other._year));
    }

    /**
     * check if this year is a leap year
     * @param leapYear represents if this year is a leap year or not
     * @return true if this year is a leap year, otherwise false
     */
    private boolean leapYear(int year)
    {
        boolean leapYear = false;
        boolean dividableByFour = (year % 4 == 0) ? true : false;
        boolean dividableByHundred = (year % 100 == 0) ? true : false;
        boolean dividableByFourHundred = (year % 400 == 0) ? true : false;
        if((dividableByFour && !dividableByHundred) || (dividableByFour && dividableByHundred && dividableByFourHundred))
        {
            leapYear = true;
        }
        return leapYear;
    }

    /**
     * Calculate the date of tomorrow
     * @return the date of tomorrow
     */
    public Date tomorrow()
    {
        Date tomorrow = new Date(this);
        //not using set method because the date wont change using that method
        int day = _day;
        int month = _month;
        int year = _year;
        day += 1;
        if(isValidDate(day,month,year))
        {
            return new Date(day,month,year);
        }
        day = 1;
        month += 1;
        if(isValidDate(day,month,year))
        {
            return new Date(day,month,year);
        }
        month = 1;
        year += 1;
        return new Date(day,month,year);
    }

    /**
     * returns a String that represents this date
     * @return String that represents this date
     * in the following format: DD/MM/YYYY
     */
    public String toString()
    {
        String day = (_day <= MAX_ONE_DIGIT_NUMBER) ? "0" + _day : _day + "";
        String month = (_month <= MAX_ONE_DIGIT_NUMBER) ? "0" + _month : _month + "";
        return day + "/" + month + "/" + _year;
    }
}//end of Class Date
