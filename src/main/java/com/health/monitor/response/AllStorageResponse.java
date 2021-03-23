package com.health.monitor.response;

import java.util.List;
import java.util.ArrayList;

public class AllStorageResponse {
	private int size;
	private List<StorageResponse> list;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<StorageResponse> getList() {
		return list;
	}
	public void setList(List<StorageResponse> list) {
		this.list = list;
	}
	public AllStorageResponse(List<StorageResponse> list)
	{
		this.list = list;
		this.size = list.size();
	}
}
