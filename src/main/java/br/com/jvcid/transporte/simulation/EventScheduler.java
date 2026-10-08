package br.com.jvcid.transporte.simulation;

import java.util.PriorityQueue;
import java.util.Comparator;

public class EventScheduler {

    private final VirtualClock clock = new VirtualClock();
    private long nextSequence;

    private final Comparator<ScheduledEvent> order =
            Comparator.comparingLong(ScheduledEvent::getScheduledAtMillis)
                    .thenComparingLong(ScheduledEvent::getSequence);


    private final PriorityQueue<ScheduledEvent> events =
            new PriorityQueue<>(order);

    public void schedule(
            long delayMillis,
            String description,
            Runnable action) {

        long scheduledAtMillis = clock.nowMillis() + delayMillis;

        // Próximos passos: criar o evento, adicioná-lo à fila e retorná-lo.
    }

}
