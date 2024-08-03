package com.zlq.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/15 16:54
 */
public class ProxyTest {

	public static void main(String[] args) {
		ChairmanXi xi = new ChairmanXi();
		SlaverCaiQi slaverCaiQi = new SlaverCaiQi(xi);
		GovernCountry instance = ChairmanProxy.getInstance(slaverCaiQi);
		instance.ironFist();
		instance.thrownCoins();
	}

}

interface GovernCountry {

	void ironFist();

	void thrownCoins();
}


class ChairmanXi implements GovernCountry {

	@Override
	public void ironFist() {
		System.out.println("砸了个铁拳");
	}

	@Override
	public void thrownCoins() {
		System.out.println("向非洲兄弟大撒币");
	}
}

class PrimeMisterLiQiang implements GovernCountry {

	private ChairmanXi xi;

	public PrimeMisterLiQiang(ChairmanXi xi) {
		this.xi = xi;
	}

	@Override
	public void ironFist() {
		System.out.println("李强");
		xi.ironFist();
	}

	@Override
	public void thrownCoins() {
		System.out.println("李强");
		xi.thrownCoins();
	}
}

class SlaverCaiQi implements GovernCountry {

	private ChairmanXi xi;

	public SlaverCaiQi(ChairmanXi xi) {
		this.xi = xi;
	}

	@Override
	public void ironFist() {
		System.out.println("蔡奇");
		xi.ironFist();
	}

	@Override
	public void thrownCoins() {
		System.out.println("蔡奇");
		xi.thrownCoins();
	}
}

class ChairmanProxy<T> implements InvocationHandler {

	private T t;

	public ChairmanProxy(T t) {
		this.t = t;
	}

	public static <T> T getInstance(T t) {
		Object o = Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(),
				new ChairmanProxy<T>(t));
		return (T) o;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(t, args);
	}
}