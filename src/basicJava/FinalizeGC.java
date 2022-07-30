package basicJava;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/6/26 18:08
 */

public class FinalizeGC {
    public static FinalizeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("我居然还活着！");
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("这是finalize");
        FinalizeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeGC();
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法很低，暂停0.5秒，等待它
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("啊，我死了！");
        }

        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法很低，暂停0.5秒，等待它
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("啊，我死了！");
        }
    }
}
