package io.github.mackzwellz.jfa.objects.mandatory.obj_task_2;

public class Clock {

    private final int MINUTES_IN_ONE_HOUR = 60;
    private final int SECONDS_IN_ONE_MINUTE = 60;
    private final int HOURS_IN_ONE_DAY = 24;
    private int hours;
    private int minutes;
    private int seconds;

    public Clock() {
        this.hours = 12;
        this.minutes = 0;
        this.seconds = 0;
    }

    public Clock(int hours, int minutes, int seconds) {
        clockInputValidator(hours, minutes, seconds);
        setClock(convertClockToSeconds(hours, minutes, seconds));
    }

    public Clock(int secondsSinceMidnight) {
        setClock(secondsSinceMidnight);
    }

    public void setClock(int secondsSinceMidnight) {
        int initialHoursFromInput = Math.floorDiv(secondsSinceMidnight, (MINUTES_IN_ONE_HOUR * SECONDS_IN_ONE_MINUTE));
        int actualHoursFromInput = initialHoursFromInput;

        if (initialHoursFromInput >= HOURS_IN_ONE_DAY) {
            int wholeDays = Math.floorDiv(initialHoursFromInput, HOURS_IN_ONE_DAY);
            System.out.printf("Subtracting %s whole days from clock%n", wholeDays);
            actualHoursFromInput = initialHoursFromInput - (wholeDays * HOURS_IN_ONE_DAY);
        }

        int minutesFromInput = Math.floorDiv(secondsSinceMidnight, SECONDS_IN_ONE_MINUTE) - (initialHoursFromInput * MINUTES_IN_ONE_HOUR);
        int secondsFromInput = secondsSinceMidnight -
                (initialHoursFromInput * MINUTES_IN_ONE_HOUR * SECONDS_IN_ONE_MINUTE) -
                (minutesFromInput * SECONDS_IN_ONE_MINUTE);
        System.out.printf("Set Clock from %s secondsSinceMidnight: %s hours, %s min, %s s%n",
                secondsSinceMidnight, actualHoursFromInput, minutesFromInput, secondsFromInput);

        clockInputValidator(actualHoursFromInput, minutesFromInput, secondsFromInput);

        this.hours = actualHoursFromInput;
        this.minutes = minutesFromInput;
        this.seconds = secondsFromInput;
    }

    private void clockInputValidator(int hours, int minutes, int seconds) {
        if (hours < 0 || hours >= HOURS_IN_ONE_DAY) {
            throw new IllegalArgumentException("Clock hours are out of expected bounds");
        }
        if (minutes < 0 || minutes >= MINUTES_IN_ONE_HOUR) {
            throw new IllegalArgumentException("Clock minutes are out of expected bounds");
        }
        if (seconds < 0 || seconds >= SECONDS_IN_ONE_MINUTE) {
            throw new IllegalArgumentException("Clock seconds are out of expected bounds");
        }
    }

    private int convertClockToSeconds(int hours, int minutes, int seconds) {
        int hoursSinceMidnight = Math.multiplyExact(hours, (MINUTES_IN_ONE_HOUR * SECONDS_IN_ONE_MINUTE));
        int minutesSinceMidnight = Math.multiplyExact(minutes, SECONDS_IN_ONE_MINUTE);
        int secondsSinceMidnight = seconds + minutesSinceMidnight + hoursSinceMidnight;
        System.out.printf("Derived %s secondsSinceMidnight from Clock: %s hours, %s min, %s s%n",
                secondsSinceMidnight, hours, minutes, seconds);
        return secondsSinceMidnight;
    }

    private int convertClockToSeconds(Clock clock) {
        return convertClockToSeconds(clock.hours, clock.minutes, clock.seconds);
    }

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
        if (seconds - 1 < 0 && minutes - 1 < 0 && (hours - 1 < 0 || hours >= MINUTES_IN_ONE_HOUR)) {
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

    public void addClock(Clock clockToAdd) {
        int thisClock = convertClockToSeconds(this);
        int thatClock = convertClockToSeconds(clockToAdd);
        setClock(Math.abs(thisClock + thatClock));
    }

    public Clock subtractClock(Clock clockToSubtract) {
        int thisClock = convertClockToSeconds(this);
        int thatClock = convertClockToSeconds(clockToSubtract);
        return new Clock(Math.abs(thisClock - thatClock));
    }

    @Override
    public String toString() {
        return String.format("(%s:%s:%s)",
                handlePrecedingZero(this.hours), handlePrecedingZero(this.minutes), handlePrecedingZero(this.seconds));
    }

    public String handlePrecedingZero(int number) {
        return number > 9 ? String.valueOf(number) : "0" + number;
    }

    public void logCurrentTime() {
        System.out.println("Current time of this clock: " + this);
    }
}
