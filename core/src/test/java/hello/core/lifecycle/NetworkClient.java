package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient { //implements InitializingBean, DisposableBean
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);


    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + "meessage = " + message);

    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init() {
        //의존관게 주입이 끝나면 호출
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지 ");
    }

    @PreDestroy
    public void close() {
        //bean이 죽기전에 호출
        System.out.println("NetworkClient.close");
        disconnect();
    }
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        //의존관게 주입이 끝나면 호출
//        connect();
//        call("초기화 연결 메세지 ");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        //bean이 죽기전에 호출
//        disconnect();
//    }
}
