package ink.lucien.iamlucien.util;

/**
 * Created by Lucien on 2019/9/23.
 */
public class Util {
    public static String getLineNumber() {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return String.format("[%s#%s:%d]", ste.getClassName(), ste.getMethodName(), ste.getLineNumber());
    }
}
