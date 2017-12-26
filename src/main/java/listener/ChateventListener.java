package listener;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import entity.ChatEntity;

/**
 * Created by Administrator on 2017/12/25 0025.
 */
public class ChateventListener implements DataListener<ChatEntity> {
    SocketIOServer server;

    public void setServer(SocketIOServer server) {
        this.server = server;
    }

    public void onData(SocketIOClient client, ChatEntity data,AckRequest ackSender) throws Exception{
        this.server.getBroadcastOperations().sendEvent("chatevent", data);
    }
}
