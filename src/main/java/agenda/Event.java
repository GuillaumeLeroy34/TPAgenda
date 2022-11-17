package agenda;

import java.time.*;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;

    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The durarion of the event
     */
    private Duration myDuration;

    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public static boolean estAprès(LocalDateTime a, LocalDateTime reference) {
        if (a.getYear() >= reference.getYear()) {
            if (a.getMonthValue() >= reference.getMonthValue()) {
                if (a.getDayOfYear() >= reference.getDayOfYear()) {
                    return(true);
                }
            }
        }
        return(false);
    }
    
        public static boolean estAvant(LocalDateTime a, LocalDateTime reference) {
        if (a.getYear() <= reference.getYear()) {
            if (a.getMonthValue() <= reference.getMonthValue()) {
                if (a.getDayOfYear() <= reference.getDayOfYear()) {
                    return(true);
                }
            }
        }
        return(false);
    }

    public boolean isInDay(LocalDate aDay) {
        // TODO : implémenter cette méthode
        LocalDateTime dateDebut = this.getStart();
 
        LocalDateTime dateFin = dateDebut ; // .plus(this.getDuration());
        if (estAprès(aDay.atStartOfDay(),dateDebut) && estAvant(aDay.atStartOfDay(),dateFin)) {
            return (true);
        } else {
            return (false);
        }

    }

    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }

    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

    @Override
    public String toString() {
        return("titre="+this.getTitle());
    }
}
    

    


