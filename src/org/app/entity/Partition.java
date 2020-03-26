package org.app.entity;

public class Partition {

	private Integer partition_id;
	private String partition_name;
	private String partition_info;

	public Partition(Integer partition_id, String partition_name, String partition_info) {
		super();
		this.partition_id = partition_id;
		this.partition_name = partition_name;
		this.partition_info = partition_info;
	}

	public Integer getPartition_id() {
		return partition_id;
	}

	public void setPartition_id(Integer partition_id) {
		this.partition_id = partition_id;
	}

	public String getPartition_name() {
		return partition_name;
	}

	public void setPartition_name(String partition_name) {
		this.partition_name = partition_name;
	}

	public String getPartition_info() {
		return partition_info;
	}

	public void setPartition_info(String partition_info) {
		this.partition_info = partition_info;
	}

	public Partition(Integer partition_id, String partition_name) {
		super();
		this.partition_id = partition_id;
		this.partition_name = partition_name;
	}

	public Partition(Integer partition_id) {
		super();
		this.partition_id = partition_id;
	}

	public Partition() {
		super();
	}

	@Override
	public String toString() {
		return "Partition [partition_id=" + partition_id + ", partition_name=" + partition_name + ", partition_info="
				+ partition_info + "]";
	}

}
