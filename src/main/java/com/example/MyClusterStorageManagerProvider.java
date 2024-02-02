package com.example;

import one.microstream.enterprise.cluster.nodelibrary.common.ClusterStorageManager;
import one.microstream.enterprise.cluster.nodelibrary.common.spi.ClusterStorageManagerProvider;

public class MyClusterStorageManagerProvider implements ClusterStorageManagerProvider
{
	@Override
	public ClusterStorageManager<DataRoot> provideClusterStorageManager()
	{
		return DB.get().storage();
	}
}
