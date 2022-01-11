package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join 框架---将一个大任务拆分成多个小任务，将最终的结果汇总到大任务的框架（其中利用到工作窃取算法---【工作窃取算法：将大任务拆分出来的小任务后，线程会维护一个双端队列，这些小任务会分给一个个线程来执行，线程执行的有
 * 快的有慢的，快的执行完以后会帮助慢的，慢的线程在双端队列的头部取数据，帮助的线程从尾部取数据】）。
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 4;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCalculate = (end - start) >= THRESHOLD;
        // 判断阈值，如果任务任务拆分的符合要求，就直接计算
        if (canCalculate) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 否则继续拆分
            //int middle = (start + end ) / 2;
            int middle = start - (start - end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 左边的结果
            Integer leftResult = leftTask.join();
            // 右边的结果
            Integer rightResult = rightTask.join();
            sum = leftResult+ rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1,100);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(countTask);
        try {
            System.out.println(submit.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
