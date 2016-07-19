package com.zl.test;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import com.zl.pool.NioSelectorRunnablePool;
import com.zl.strap.ServerBootstrap;
/**
 * 启动函数
 * @author 周力
 *
 */
public class Start {

	public static void main(String[] args) {
		
		//初始化boss 与 worker线程池，并开启selector
		NioSelectorRunnablePool nioSelectorRunnablePool = new NioSelectorRunnablePool(Executors.newCachedThreadPool(), Executors.newCachedThreadPool());
		
		//获取服务类
		ServerBootstrap bootstrap = new ServerBootstrap(nioSelectorRunnablePool);
		
		//绑定端口
		bootstrap.bind(new InetSocketAddress(10101));
		
		System.out.println("start");
	}

}
