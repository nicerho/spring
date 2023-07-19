package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        asd();
        return instance;
    }

    private SingletonService() {
    }
    public static void asd(){
        System.out.println("called");
    }

}
