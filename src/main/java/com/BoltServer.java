package com;

import com.alipay.remoting.ConnectionEventProcessor;
import com.alipay.remoting.ConnectionEventType;
import com.alipay.remoting.rpc.RpcServer;
import com.alipay.remoting.rpc.protocol.UserProcessor;

/**
 * @Author:wjy
 * @Date: 2018/11/6.
 */
public class BoltServer {

	/** port */
	private int       port;

	/** rpc server */
	private RpcServer server;

	// ~~~ constructors
	public BoltServer(int port) {
		this.port = port;
		this.server = new RpcServer(this.port);
	}

	public BoltServer(int port, boolean manageFeatureEnabled) {
		this.port = port;
		this.server = new RpcServer(this.port, manageFeatureEnabled);
	}

	public BoltServer(int port, boolean manageFeatureEnabled, boolean syncStop) {
		this.port = port;
		this.server = new RpcServer(this.port, manageFeatureEnabled, syncStop);
	}

	public boolean start() {
		this.server.start();
		return true;
	}

	public void stop() {
		this.server.stop();
	}

	public RpcServer getRpcServer() {
		return this.server;
	}

	public void registerUserProcessor(UserProcessor<?> processor) {
		this.server.registerUserProcessor(processor);
	}

	public void addConnectionEventProcessor(ConnectionEventType type,
											ConnectionEventProcessor processor) {
		this.server.addConnectionEventProcessor(type, processor);
	}
}
