package org.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.app.entity.Partition;

public interface PartitionMapper {

	List<Partition> queryPartition();

	List<Integer> queryPartitionID();

	Integer queryPartitionId(@Param("partition_name") String partition_name);
}
