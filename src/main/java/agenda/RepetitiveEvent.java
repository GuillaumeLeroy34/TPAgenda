package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {

    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    private ChronoUnit frequency;
    private ArrayList<LocalDate> exceptions = new ArrayList<LocalDate>();

    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;

    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        this.exceptions.add(date);
    }

    public ArrayList<LocalDate> getExceptions() {
        return exceptions;
    }

    /**
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        // TODO : implémenter cette méthode
        return this.frequency;
    }

    public boolean isInDay(LocalDate aDay) {
        if (this.getExceptions().contains(aDay)) { // n'est pas un jour ou l'évènement récurrent se déroule
            return (false);
        } else {
            int différenceJour = aDay.getDayOfYear() - this.getStart().getDayOfYear();
            if (différenceJour < 0) {
                return false;}
                if (this.frequency.equals("DAYS")) {
                    return (true); // si l'évènement se déroule tous les jours ET la journée testée n'est pas dans les exceptions, il se déroule forcément
                }
                if (this.frequency.equals("WEEKS")) {

                } else {
                    int nombreSemaines = différenceJour / 7;
                    Event test = new Event("test", this.getStart().plus(nombreSemaines, ChronoUnit.WEEKS), this.getDuration());
                    test.isInDay(aDay);
                }
                
            }
        
        return false;
    }
}
