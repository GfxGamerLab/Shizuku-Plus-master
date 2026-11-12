package rikka.shizuku.server;

public class ServerConstants {

    public static final int MANAGER_APP_NOT_FOUND = 50;

    public static final String PERMISSION = "moe.shizuku.manager.permission.API_V23";
    public static final String PERMISSION_CUSTOM = "com.gfxgamerlab.shizukuplus.permission.API_V23";
    public static final String PERMISSION_MANAGER = "moe.shizuku.manager.permission.MANAGER";
    public static final String PERMISSION_MANAGER_CUSTOM = "com.gfxgamerlab.shizukuplus.permission.MANAGER";

    public static final String OFFICIAL_MANAGER_ID = "moe.shizuku.privileged.api";
    public static final String CUSTOM_MANAGER_ID = "com.gfxgamerlab.shizukuplus";

    public static boolean isManagerPackage(String packageName) {
        return OFFICIAL_MANAGER_ID.equals(packageName) || CUSTOM_MANAGER_ID.equals(packageName);
    }

    public static String getManagerApplicationId() {
        return CUSTOM_MANAGER_ID;
    }

    /**
     * The action the manager's permission prompt answers, as [managerPackage] is installed.
     *
     * This used to be built from the package the manager was *built* with, which is the same
     * string only while the app runs under its original name. Stealth mode renames the package,
     * and the manifest rewrite covers the activity's action along with everything else - so a
     * hidden copy declares its own name + ".intent.action.REQUEST_PERMISSION" while the server
     * went on asking for the original spelling. The intent named a package that is installed and
     * an action nothing there answers, which is a request that reaches nobody: the app asking for
     * permission is left waiting with no prompt to answer it.
     *
     * The server knows the manager's package as it is now - it reads it off the APK it was started
     * from, see [ShizukuService.MANAGER_APPLICATION_ID] - so the request is built from that rather
     * than from moe.shizuku.server.BuildConfig.MANAGER_APPLICATION_ID.
     */
    public static String requestPermissionAction(String managerPackage) {
        return managerPackage + ".intent.action.REQUEST_PERMISSION";
    }

    public static final int BINDER_TRANSACTION_getApplications = 10001;
}
