package io.github.mackzwellz.jfa.objects.mandatory.obj_task_2;

public class Clock {

    private final int MINUTES_IN_ONE_HOUR = 60;
    private final int SECONDS_IN_ONE_MINUTE = 60;
    private final int HOURS_IN_ONE_DAY = 24;
    private int hours; //todo (range 0 - 23)
    private int minutes; //todo (range 0 - 59)
    private int seconds; //todo (range 0 - 59)

    public Clock() {
        this.hours = 12;
        this.minutes = 0;
        this.seconds = 0;
    }

    public Clock(int hours, int minutes, int seconds) {
        if (hours < 0 || minutes < 0 || seconds < 0 ||
                hours >= HOURS_IN_ONE_DAY || minutes >= MINUTES_IN_ONE_HOUR || seconds >= SECONDS_IN_ONE_MINUTE) {
            throw new IllegalArgumentException();
        } else {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }
    }

    public Clock(int secondsSinceMidnight) {
        setClock(secondsSinceMidnight);
    }

    public void setClock(int secondsSinceMidnight) {
        int hoursFromInput = Math.floorDiv(secondsSinceMidnight, (MINUTES_IN_ONE_HOUR * SECONDS_IN_ONE_MINUTE));
        int minutesFromInput = Math.floorDiv(secondsSinceMidnight, SECONDS_IN_ONE_MINUTE) - (hoursFromInput * MINUTES_IN_ONE_HOUR);
        int secondsFromInput = secondsSinceMidnight -
                (hoursFromInput * MINUTES_IN_ONE_HOUR * SECONDS_IN_ONE_MINUTE) -
                (minutesFromInput * SECONDS_IN_ONE_MINUTE);
        System.out.printf("Set Clock from %s secondsSinceMidnight: %s hours, %s min, %s s%n", secondsSinceMidnight, hoursFromInput, minutesFromInput, secondsFromInput);
        this.hours = hoursFromInput;
        this.minutes = minutesFromInput;
        this.seconds = secondsFromInput;
    }

    //todo convert to enum
    public void tick() {
        if (seconds + 1 >= SECONDS_IN_ONE_MINUTE && minutes + 1 >= MINUTES_IN_ONE_HOUR && hours + 1 >= HOURS_IN_ONE_DAY) {
            System.out.println("Started a new day!");
            hours = 0;
            minutes = 0;
            seconds = 0;
        } else if (seconds + 1 >= SECONDS_IN_ONE_MINUTE && minutes + 1 >= MINUTES_IN_ONE_HOUR) {
            hours++;
            minutes = 0;
            seconds = 0;
        } else if (seconds + 1 >= SECONDS_IN_ONE_MINUTE) {
            minutes++;
            seconds = 0;
        } else {
            seconds++;
        }
    }

    public void tickDown() {
        if (seconds - 1 < 0 && minutes - 1 < 0 && (hours - 1 < 0 || hours > 23)) {
            System.out.println("Ticked down to previous day!");
            hours = 23;
            minutes = 59;
            seconds = 59;
        } else if (seconds - 1 < 0 && minutes - 1 < 0) {
            hours--;
            minutes = 59;
            seconds = 59;
        } else if (seconds - 1 < 0) {
            minutes--;
            seconds = 59;
        } else {
            seconds--;
        }
    }

    //todo handle h-t-m and m-t-s
    public void addClock(Clock clockToAdd) {
        this.hours += clockToAdd.hours;
        this.minutes += clockToAdd.minutes;
        this.seconds += clockToAdd.seconds;
    }

    //todo handle h-t-m and m-t-s
    public Clock subtractClock(Clock clockToSubtract) {
        return new Clock(
                this.hours - clockToSubtract.hours,
                this.minutes - clockToSubtract.minutes,
                this.seconds - clockToSubtract.seconds
        );
    }

    @Override
    public String toString() {
        return String.format("(%s:%s:%s)",
                handlePrecedingZero(this.hours), handlePrecedingZero(this.minutes), handlePrecedingZero(this.seconds));
    }

    // number > 9 works too i guess
    public String handlePrecedingZero(int number) {
        return String.valueOf(number).length() > 1 ? String.valueOf(number) : "0" + number;
    }

    public void logCurrentTime() {
        System.out.println("Current time of this clock: " + this);
    }
}
