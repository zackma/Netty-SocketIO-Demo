package server;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import entity.ChatEntity;

/**
 * Created by Administrator on 2017/12/25 0025.
 */
public class SocketServer {

    static SocketIOServer server;
    public void startServer() throws InterruptedException {
        Configuration config = new Configuration();

        config.setHostname("localhost");
        config.setPort(9092);
        config.setOrigin(null);         //设置为null时允许的跨域为“*”（官方坑）

        server = new SocketIOServer(config);

        //服务添加目标监听然后向目标操作
        server.addEventListener("chatevent", ChatEntity.class, new DataListener<ChatEntity>() {
            public void onData(SocketIOClient socketIOClient, ChatEntity chatEntity, AckRequest ackRequest) throws Exception {
                socketIOClient.sendEvent("chatevent",chatEntity);
            }
        });

        server.start();
//        Thread.sleep(Integer.MAX_VALUE);
//        server.stop();
    }
}
