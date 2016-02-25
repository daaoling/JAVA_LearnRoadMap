package org.ace.script.army;

import java.util.Map;

import org.ace.basicdata.IBasicDataInitial;
import org.ace.basicdata.model.MonsterBasicData;

public class PlayerBasicInitial implements IBasicDataInitial<MonsterBasicData> {
    private Map<Integer,MonsterBasicData>   map=new  HashMap<Integer,MonsterBasicData>();
    void init() {
		create(new MonsterBasicData(
			gdCode: 1000,
			atkBase:122,
			defBase:115,
			hpBase:421,
			mpBase:0,
			atkGrow:5,
			defGrow:5,
			hpGrow:10,
			mpGrow:0,
			exp:10
		));

	create(new MonsterBasicData(
			gdCode: 1001,
			atkBase:128,
			defBase:120,
			hpBase:450,
			mpBase:0,
			atkGrow:8,
			defGrow:8,
			hpGrow:15,
			mpGrow:0,
			exp:15
		));

	create(new MonsterBasicData(
			gdCode: 1002,
			atkBase:135,
			defBase:125,
			hpBase:460,
			mpBase:0,
			atkGrow:10,
			defGrow:8,
			hpGrow:15,
			mpGrow:0,
			exp:20
		));

	create(new MonsterBasicData(
			gdCode: 1003,
			atkBase:138,
			defBase:130,
			hpBase:500,
			mpBase:0,
			atkGrow:10,
			defGrow:8,
			hpGrow:20,
			mpGrow:0,
			exp:35
		));

	create(new MonsterBasicData(
			gdCode: 1004,
			atkBase:145,
			defBase:136,
			hpBase:520,
			mpBase:0,
			atkGrow:12,
			defGrow:10,
			hpGrow:25,
			mpGrow:0,
			exp:40
		));

	create(new MonsterBasicData(
			gdCode: 1005,
			atkBase:150,
			defBase:145,
			hpBase:530,
			mpBase:0,
			atkGrow:15,
			defGrow:10,
			hpGrow:28,
			mpGrow:0,
			exp:45
		));

	create(new MonsterBasicData(
			gdCode: 1006,
			atkBase:160,
			defBase:110,
			hpBase:420,
			mpBase:0,
			atkGrow:20,
			defGrow:8,
			hpGrow:10,
			mpGrow:0,
			exp:40
		));

	create(new MonsterBasicData(
			gdCode: 1007,
			atkBase:160,
			defBase:130,
			hpBase:440,
			mpBase:0,
			atkGrow:15,
			defGrow:10,
			hpGrow:20,
			mpGrow:0,
			exp:60
		));

	create(new MonsterBasicData(
			gdCode: 1008,
			atkBase:400,
			defBase:400,
			hpBase:999999,
			mpBase:0,
			atkGrow:0,
			defGrow:0,
			hpGrow:0,
			mpGrow:0,
			exp:1000
		));

	
	
    }

    Map<Integer, MonsterBasicData> getAll() {
        return map;
    }

    void create(MonsterBasicData model){
        map.put(model.gdCode,model);
    }
}
