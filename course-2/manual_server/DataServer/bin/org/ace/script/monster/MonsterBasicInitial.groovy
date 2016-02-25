package org.ace.script.monster

import org.ace.basicdata.IBasicDataInitial
import org.ace.basicdata.model.ArmyBasicData
import org.ace.basicdata.model.MonsterBasicData

class MonsterBasicInitial implements IBasicDataInitial<MonsterBasicData>{
    private Map<Integer,ArmyBasicData>   map=new  HashMap<Integer,MonsterBasicData>();
    void init() {
        create(new MonsterBasicData(
                    gdCode: 30000,
                    hp: 1000,
                    def: 2,
                    mdef: 1,
                    spd: 2
        ));

	create(new MonsterBasicData(
                    gdCode: 30001,
                    hp: 2000,
                    def: 4,
                    mdef: 2,
                    spd: 2
        ));

	create(new MonsterBasicData(
                    gdCode: 30002,
                    hp: 3000,
                    def: 6,
                    mdef: 3,
                    spd: 2
        ));

	create(new MonsterBasicData(
                    gdCode: 30003,
                    hp: 4000,
                    def: 8,
                    mdef: 4,
                    spd: 2
        ));

	create(new MonsterBasicData(
                    gdCode: 30004,
                    hp: 5000,
                    def: 10,
                    mdef: 5,
                    spd: 2
        ));

	create(new MonsterBasicData(
                    gdCode: 30005,
                    hp: 6000,
                    def: 12,
                    mdef: 6,
                    spd: 2
        ));

		
    }

    Map<Integer, MonsterBasicData> getAll() {
        return map;
    }

    void create(MonsterBasicData model){
        map.put(model.gdCode,model);
    }
}
