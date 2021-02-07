package com.example.service;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@ServerEndpoint(value = "/imserver/{userId}")
@Component
public class WebSocketServer {
    /**
     * 记录当前在线连接数
     */
    private static final AtomicInteger onlineCount = new AtomicInteger(0);
    private static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        Session userSession = sessionMap.get(userId);
        if (userSession == null) {
            onlineCount.incrementAndGet(); // 在线数加1
        }
        sessionMap.put(userId, session);
        log.info("有新用户加入，userId={}, 当前在线人数为：{}", userId, onlineCount.get());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session, @PathParam("userId") String userId) {
        onlineCount.decrementAndGet(); // 在线数减1
        sessionMap.remove(userId);
        log.info("有一连接关闭，移除userId={}的用户session, 当前在线人数为：{}", userId, onlineCount.get());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("userId") String userId) {
        log.info("服务端收到用户userId={}的消息:{}", userId, message);
        JSONObject obj = JSONUtil.parseObj(message);
        String toUserId = obj.getStr("toUserId");
        String text = obj.getStr("text");
        Session toSession = sessionMap.get(toUserId);
        if (toSession != null) {
            String jsonStr = "{\"fromUserId: " + userId + "\", \"text\": " + text + "}";
            this.sendMessage(jsonStr, toSession);
            log.info("发送给用户id={}，消息：{}", toUserId, jsonStr);
        } else {
            log.info("发送失败，未找到用户id={}的session", toUserId);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 服务端发送消息给客户端
     */
    private void sendMessage(String message, Session toSession) {
        try {
            log.info("服务端给客户端[{}]发送消息{}", toSession.getId(), message);
            toSession.getBasicRemote().sendText(message);
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败", e);
        }
    }
}
