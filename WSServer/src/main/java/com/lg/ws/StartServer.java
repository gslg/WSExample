package com.lg.ws;

import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuguo on 2016/12/23.
 */
public class StartServer {
    public static void main(String[] args) {
        com.lg.ws.Example server = new com.lg.ws.Example();

        //发布web service到http://localhost:8080/hello地址
        Endpoint endpoint = Endpoint.publish("http://localhost:8080/hello",server);

        Binding binding = endpoint.getBinding();

        List<Handler> handlers = new ArrayList<Handler>();
        binding.setHandlerChain(handlers);

        System.out.println("服务已启动：http://localhost:8080/hello");
    }
}
