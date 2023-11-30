
/**
* Name: Itzayana Aguilar (aguilar)
* Course: CSCI 241 - Computer Science I
* Section: 002 <-- choose your section
* Assignment: 9
*
* Project/Class Description:
* Keep track of informatuon for a clock time for a 12 and a 24 hour clock.
*
* Known bugs:
* None
*/
public class ClockTime {

    //Instance variables to store the hour, minute, and second
    private int hour;
    private int minute;
    private int second;

    // Default constructor initializing time 
    public ClockTime() {
        hour = 0;
        minute = 0;
        second = 0;
    }

    // Constructor with input validation and adjustments to hour, second and time
    public ClockTime(int hour, int minute, int second) {

        //If greater than 59,update minutes and reset seconds
        if (second > 59) {
            minute += second / 60;
            second %= 60;
        } else if (second < 0) {
            second = 0;
        }

        //if greater than 59, update hours and reset minutes
        if (minute > 59) {
            hour += minute / 60;
            minute %= 60;
        } else if (minute < 0) {
            minute = 0;
        }

        //if greater than 24, by taking the modulos and reset
        if (hour > 24) {
            hour %= 24;
        } else if (hour < 0) {
            hour = 0;
        }

        // Set instance variables
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Getter methods for hour, minute, and second
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    // Setter methods  for hour, minute, and second within range
    public void setHour(int hour) {
        if (hour >= 0 && hour <= 24) {
            this.hour = hour;
        }
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        }
    }

    public void setSecond(int second) {
        if (second >= 0 && second <= 59) {
            this.second = second;
        }
    }

    // String representation of the time in 24-hour format
    public String toString() {
        //Set String
        String zeroHour = "";
        String zeroMinute = "";
        String zeroSecond = "";

        // Set leading zeros for hour if  less than 10 
        if (hour < 10) {
            zeroHour = "0" + hour;
        } else {
            zeroHour = "" + hour;
        }

        // Set leading zeros for minute if it's less than 10
        if (minute < 10) {
            zeroMinute = "0" + minute;
        } else {
            zeroMinute = "" + minute;
        }

        // Set leading zeros for second if it's less than 10
        if (second < 10) {
            zeroSecond = "0" + second;
        } else {
            zeroSecond = "" + second;
        }

        // Concatenate the time Stringd and return the result
        return zeroHour + ":" + zeroMinute + ":" + zeroSecond;

    }

    // String representation of the time in 12-hour format
    public String toString12() {
        String time;
        // Variable to store the adjusted hour for 12-hour format
        int checkHour = 0;

        // Determine if it's AM or PM based on the hour and set it to String time
        if (hour < 12) {
            time = "A.M.";
            // If midnight, set checkHour to 12
            if (hour == 0) {
                checkHour = 12;
            } else {
                checkHour = hour;
            }
        } else {
            time = "P.M.";
            // If noon, set checkHour to 12, else subtract 12 from the current hour
            if (hour == 12) {
                checkHour = 12;
            } else {
                checkHour = hour - 12;
            }
        }

        String zeroHour = "";
        String zeroMinute = "";
        String zeroSecond = "";

        // Set leading zeros for hour if  less than 10 or checkHour is less than 10
        if (hour < 10 || checkHour < 10) {
            zeroHour = "0" + checkHour;
        } else {
            zeroHour = "" + checkHour;
        }

        // Set leading zeros for minute if it's less than 10
        if (minute < 10) {
            zeroMinute = "0" + minute;
        } else {
            zeroMinute = "" + minute;
        }

        // Set leading zeros for second if it's less than 10
        if (second < 10) {
            zeroSecond = "0" + second;
        } else {
            zeroSecond = "" + second;
        }

        // Concatenate the time Stringd and return the result
        return zeroHour + ":" + zeroMinute + ":" + zeroSecond + " " + time;
    }

    // advance time by given number of seconds 
    public void advance(int seconds) {
        // Loop over the number of seconds given
        for (int i = 0; i < seconds; i++) {
            // Increment second
            second++;
            // If the second is 60, reset to 0 and add the minute by 1
            if (second == 60) {
                second = 0;
                minute++;

                // If the minute is 60, reset to 0 and add the hour by 1
                if (minute == 60) {
                    minute = 0;
                    hour++;

                    // If the hour is 24, reset to 0 (midnight)
                    if (hour == 24) {
                        hour = 0;
                    }
                }
            }
        }
    }

    // Method to check if two objects in ClockTime is the same
    public boolean equals(ClockTime otherClock) {
        return (this.hour == otherClock.hour && this.minute == otherClock.minute && this.second == otherClock.second);
    }

}
