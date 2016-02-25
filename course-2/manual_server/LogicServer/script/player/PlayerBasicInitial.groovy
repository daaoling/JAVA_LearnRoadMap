package org.ace.script.army;

import java.util.Map;

import org.ace.basicdata.IBasicDataInitial;
import org.ace.basicdata.model.PlayerBasicData;

public class PlayerBasicInitial implements IBasicDataInitial<PlayerBasicData> {
    private Map<Integer,PlayerBasicData>   map=new  HashMap<Integer,PlayerBasicData>();
    void init() {
		create(new PlayerBasicData(
			gdCode: 10000,
			atkBase:100,
			defBase:20,
			hpBase:200,
			mpBase:100,
			atkGrow:30,
			defGrow:5,
			hpGrow:50,
			mpGrow:30,
			skills:[1000,1001]
		));		
		create(new PlayerBasicData(
			gdCode: 10001,
			atkBase:100,
			defBase:20,
			hpBase:200,
			mpBase:100,
			atkGrow:30,
			defGrow:5,
			hpGrow:50,
			mpGrow:30,
			skills:[1002,1003]
		));
	
	
    }

    Map<Integer, PlayerBasicData> getAll() {
        return map;
    }

    void create(PlayerBasicData model){
        map.put(model.gdCode,model);
    }
}
