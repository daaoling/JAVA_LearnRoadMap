package org.ace.script.skill

import org.ace.basicdata.IBasicDataInitial
import org.ace.basicdata.model.ArmyBasicData
import org.ace.basicdata.model.MonsterBasicData
import org.ace.basicdata.model.SkillBasicData
import static org.ace.constans.SkillConstans.*

class SkillBasicInitial implements IBasicDataInitial<SkillBasicData>{
    private Map<Integer,SkillBasicData>   map=new  HashMap<Integer,SkillBasicData>();
    void init() {
        create(new SkillBasicData(
                gdCode: 1,
                type: TYPE_ATT,
                attType:ATT_ATK,
                value1Type:CONSTANT,
                value1: 1000,
                value2Type:PERCENT,
                value2: 10,
                buffType: NONE,
                buffTime: 3,
                buff1: 10,
                buff2: 10,
                buff3: 10

        ));
		
    }

    Map<Integer, SkillBasicData> getAll() {
        return map;
    }

    void create(SkillBasicData model){
        map.put(model.gdCode,model);
    }
}
