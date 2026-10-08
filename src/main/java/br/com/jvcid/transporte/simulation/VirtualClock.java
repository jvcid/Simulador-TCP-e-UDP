package br.com.jvcid.transporte.simulation;

public final class VirtualClock {

    private long nowMillis = 0;

    public long nowMillis() {
        return nowMillis;
    }

    void advanceTo(long targetMillis) {
        if (targetMillis < nowMillis) {
            throw new IllegalArgumentException(
                    "O relógio virtual não pode voltar no tempo."
            );
        }

        nowMillis = targetMillis;
    }

    void reset() {
        nowMillis = 0;
    }
}