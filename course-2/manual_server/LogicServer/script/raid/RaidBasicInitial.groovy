package org.ace.script;

import java.util.HashMap;
import java.util.Map;

import org.ace.basicdata.IBasicDataInitial;
import org.ace.basicdata.model.RaidBasicData;
import org.ace.model.MonsterModel;
import org.ace.model.Vector3;

public class RaidBasicInitial implements IBasicDataInitial<RaidBasicData> {
	private Map<Integer, RaidBasicData> map=new HashMap<Integer, RaidBasicData>();
	@Override
	public void init() {
		create(new RaidBasicData(
				gdCode:1000,
				level:1,
				num:1,
				starPostion:new Vector3(3.89f,0.6f,-37.52f),
				monsters:monsters(monster(1000,1,16.08f,0.6f,-33.87f),monster(1000,1,17.72f,0.6f,-31.83f),monster(1000,1,20.39f,0.6f,-29.71f),monster(1000,2,-2.55f,0.8f,-30.09f),monster(1000,2,1.92f,0.8f,-29.53f),monster(1000,2,5.76f,0.8f,-28.06f),monster(1001,5,9.83f,2.60f,-19.22f),monster(1001,5,4.46f,23.36f,-20.88f),monster(1001,5,2.63f,3.54f,-15.83f),monster(1001,5,6.16f,3.97f,-14.46f),monster(1001,1,-28.37f,2.92f,-34.82f),monster(1001,1,-26.15f,2.70f,-39.30f),monster(1001,1,-34.95f,5.07f,-39.31f),monster(1001,1,-37.10f,4.35f,-41.58f),monster(1001,1,-39.18f,4.08f,-39.61f),monster(1001,3,37.60f,2.20f,40.01f),monster(1001,3,45.25f,2.13f,-38.59f),monster(1001,3,36.89f,1.16f,-31.83f),monster(1001,3,39.44f,1.13f,-27.21f),monster(1001,3,45.25f,1.23f,-31.83f),monster(1001,3,45.25f,0.91f,-27.27f),monster(1002,3,-29.72f,4.40f,-39.85f),monster(1002,3,-34.95f,4.40f,-34.99f),monster(1002,3,-39.18f,3.15f,-34.99f),monster(1002,3,-39.18f,2.40f,-32.74f),monster(1002,3,-46.25f,2.17f,-30.77f),monster(1002,3,-46.93f,2.07f,-27.62f),monster(1003,5,-41.94f,0.6f,-23.00f),monster(1003,5,-38.96f,0.6f,-21.54f),monster(1003,5,-37.80f,0.6f,-24.47f),monster(1003,1,-33.54f,0.6f,-24.47f),monster(1003,1,-27.71f,0.6f,-26.82f),monster(1003,2,-25.28f,0.6f,-18.21f),monster(1003,2,-27.66f,0.6f,-11.67f),monster(1003,4,-23.88f,0.6f,-9.51f),monster(1004,2,-10.88f,2.33f,-17.80f),monster(1004,2,-11.44f,1.48f,-9.44f),monster(1004,2,-14.05f,1.06f,0.19f),monster(1004,2,-9.46f,1.69f,-0.18f),monster(1004,3,-32.80f,0.6f,-0.19f),monster(1004,3,-29.22f,0.6f,-4.76f),monster(1004,2,29.11f,0.6f,-21.06f),monster(1004,3,33.07f,0.6f,-17.45f),monster(1004,3,37.80f,0.6f,-14.23f),monster(1005,2,10.51f,3.26f,-10.62f),monster(1005,2,15.89f,2.00f,-7.59f),monster(1005,2,15.89f,2.56f,-1.58f),monster(1005,2,16.40f,1.64f,3.18f),monster(1005,5,-0.73f,2.17f,5.87f),monster(1005,5,-3.95f,0.87f,11.75f),monster(1006,5,4.07f,2.92f,3.58f),monster(1006,5,9.61f,1.50f,7.11f),monster(1006,3,47.06f,0.59f,-0.22f),monster(1006,3,44.93f,2.22f,11.54f),monster(1006,3,44.10f,1.80f,6.35f),monster(1006,3,43.16f,0.59f,3.27f),monster(1006,5,29.73f,1.46f,20.15f),monster(1006,5,33.06f,1.14f,18.21f),monster(1006,4,10.53f,0.59f,35.15f),monster(1006,4,1.60f,1.05f,35.15f),monster(1006,4,-19.57f,2.49f,30.43f),monster(1006,4,-28.63f,2.35f,24.88f),monster(1007,4,-23.77f,2.04f,28.66f),monster(1007,4,-5.56f,0.32f,27.34f),monster(1007,4,6.12f,0.42f,32.93f),monster(1007,5,29.35f,0.59f,11.54f),monster(1007,5,33.06f,0.58f,10.80f),monster(1008,1,-2.05f,0.32f,23.81f),monster(1008,1,0.99f,1.42f,9.30f))
		));
	}
	void create(RaidBasicData data){
		map.put(data.getGdCode(), data);
	}

	@Override
	public Map<Integer, RaidBasicData> getAll() {
		return map;
	}

	MonsterModel monster(int gdCode,int level,float x,float y,float z){
		return new MonsterModel(gdCode, level, x, y, z);
	}
	
	MonsterModel[] monsters(MonsterModel...models){
		return models;
	}
}
