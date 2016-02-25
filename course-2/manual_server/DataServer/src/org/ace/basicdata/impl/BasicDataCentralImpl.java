package org.ace.basicdata.impl;

import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.ace.basicdata.IBasicDataCentral;
import org.ace.basicdata.IBasicDataInitial;

public class BasicDataCentralImpl<T> implements IBasicDataCentral<T> {
	private Map<Integer, T> map;

	private IBasicDataInitial<T> basicDataInitial;
	
	@PostConstruct
	@Override
	public void init() {
		map=basicDataInitial.getAll();
		
	}

	@Override
	public Collection<T> getAll() {
		
		return map.values();
	}

	@Override
	public T get(Integer code) {
		return map.get(code);
	}

	public void setBasicDataInitial(IBasicDataInitial<T> basicDataInitial) {
		this.basicDataInitial = basicDataInitial;
	}

	@Override
	public boolean has(Integer code) {
		return map.containsKey(code);
	}
	
	

}
