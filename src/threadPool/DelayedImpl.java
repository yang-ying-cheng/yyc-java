package threadPool;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedImpl implements Delayed {
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(2L*1000*1000,TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
