package program.multithread.singleton;

/**
 * http://www.blogjava.net/kenzhh/archive/2013/03/15/357824.html
 */

public class SingletionByDCL {

    private static volatile SingletionByDCL instance;

    private SingletionByDCL() {
    }

    public static SingletionByDCL getInstance() {
        if (instance == null) {
            synchronized (SingletionByDCL.class) {
                if (instance == null) {
                    instance = new SingletionByDCL();
                }
            }
        }
        return instance;
    }
}
