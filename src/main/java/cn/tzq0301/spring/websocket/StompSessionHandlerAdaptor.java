package cn.tzq0301.spring.websocket;

import cn.tzq0301.retry.Retry;
import io.micrometer.common.util.StringUtils;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.time.Duration;
import java.util.concurrent.ExecutionException;

import static com.google.common.base.Preconditions.checkArgument;

public interface StompSessionHandlerAdaptor extends StompSessionHandler {
    default boolean connect(final String serverAddr) throws ExecutionException, InterruptedException {
        checkArgument(StringUtils.isNotBlank(serverAddr));
        WebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        StompSession stompSession = stompClient.connectAsync(serverAddr, this).get();
        return stompSession.isConnected();
    }

    default boolean tryConnect(final String serverAddr) {
        checkArgument(StringUtils.isNotBlank(serverAddr));
        try {
            return connect(serverAddr);
        } catch (ExecutionException | InterruptedException ignored) {
            return false;
        }
    }

    default void retryConnect(final String serverAddr) {
        checkArgument(StringUtils.isNotBlank(serverAddr));
        Retry.of(epoch -> tryConnect(serverAddr), Integer.MAX_VALUE, Duration.ofSeconds(2L), true, true);
    }

    @Override
    default void afterConnected(StompSession session, StompHeaders connectedHeaders) {
    }

    @Override
    default void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
    }

    @Override
    default void handleTransportError(StompSession session, Throwable exception) {
    }

    @Override
    default Type getPayloadType(StompHeaders headers) {
        return String.class;
    }

    @Override
    default void handleFrame(StompHeaders headers, Object payload) {
    }
}
