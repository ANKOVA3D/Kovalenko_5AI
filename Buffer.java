import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Buffer {
    private final BlockingQueue<Integer> queue;

    public Buffer(int size) {
        queue = new LinkedBlockingQueue<>(size);
    }

    public void put(int value) throws InterruptedException {
        queue.put(value);
    }

    public int take() throws InterruptedException {
        return queue.take();
    }
}
