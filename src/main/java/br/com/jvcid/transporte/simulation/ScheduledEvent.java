package br.com.jvcid.transporte.simulation;


public class ScheduledEvent {

    private final long scheduledAtMillis;
    private final long sequence;
    private final String description;
    private final Runnable action;
    private boolean cancel = false;


    public ScheduledEvent(long scheduledAtMillis, String description, long sequence, Runnable action){

        this.scheduledAtMillis = scheduledAtMillis;
        this.sequence = sequence;
        this.description = description;
        this.action = action;

    }


    public void cancel(){
        this.cancel = true;
    }

    public boolean isCancelled(){
        return this.cancel;
    }

    public void execute(){
        if (!cancel){
            action.run();
        }
    }

    public long getScheduledAtMillis() {
        return scheduledAtMillis;
    }

    public long getSequence() {
        return sequence;
    }

    public String getDescription() {
        return description;
    }
}
