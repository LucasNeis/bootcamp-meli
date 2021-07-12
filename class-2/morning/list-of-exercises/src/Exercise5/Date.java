package Exercise5;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int year, int month, int day) throws RuntimeException {
        if (valiDate(year, month, day)) {
            this.day = day;
            this.month = month;
            this.year = year;
            return;
        }
        throw new RuntimeException("Invalid date: " + year + "-" + month + "-" + day);
    }

    public void nextDay() throws RuntimeException {
        int lastDay = DateFormat.getInstance().monthLastDay(month);
        this.day++;
        if (this.isLeapYear(this.year) && month == 2) {
            lastDay++;
        }
        if(lastDay < this.day) {
            this.day = 1;
            this.month++;
            if(this.month > 12) {
                this.month = 1;
                this.year++;
            }
        }
        if(!this.valiDate(this.year, this.month, this.day)) {
            throw new RuntimeException("Invalid date: " + year + "-" + month + "-" + day);
        }
    }

    public boolean valiDate(int year, int month, int day) {
        if(month >= 13 || month <= 0 || year < 1970 || year > 9999)
            return false;
        if (day == 29 && month == 2 && isLeapYear(year))
            return true;
        int lastDay = DateFormat.getInstance().monthLastDay(month);
        return day > 0 && day <= lastDay;
    }

    private boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    @Override
    public String toString() {
        return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day) ;
    }
}
