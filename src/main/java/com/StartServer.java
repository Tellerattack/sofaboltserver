package com;


import com.alipay.remoting.ConnectionEventType;

/**
 * @Author:wjy
 * @Date: 2018/11/6.
 */
public class StartServer {
	BoltServer                server;
	int                       port                      = 8999;

	SimpleServerUserProcessor serverUserProcessor       = new SimpleServerUserProcessor();
	CONNECTEventProcessor     serverConnectProcessor    = new CONNECTEventProcessor();
	DISCONNECTEventProcessor  serverDisConnectProcessor = new DISCONNECTEventProcessor();


	public StartServer(){
		// 1. create a Rpc server with port assigned
		server = new BoltServer(port);
		// 2. add processor for connect and close event if you need
		server.addConnectionEventProcessor(ConnectionEventType.CONNECT, serverConnectProcessor);
		server.addConnectionEventProcessor(ConnectionEventType.CLOSE, serverDisConnectProcessor);
		// 3. register user processor for client request
		server.registerUserProcessor(serverUserProcessor);
		// 4. server start
		if (server.start()) {
			System.out.println("server start ok!");
		} else {
			System.out.println("server start failed!");
		}
		// server.getRpcServer().stop();
	}

	public static void main(String[] args) {
		new StartServer();
	}
}
