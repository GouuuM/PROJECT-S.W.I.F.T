import panels.SystemManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("        Welcome Wild Cats       ");
        System.out.println("================================");
        // Create an instance of the SystemManager class.
        SystemManager systemManager = new SystemManager();
        // Start the school management system by calling the run() method.
        systemManager.run();
    }
}