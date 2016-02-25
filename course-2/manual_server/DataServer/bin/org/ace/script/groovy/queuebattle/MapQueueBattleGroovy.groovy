package org.ace.script.groovy.queuebattle

import org.ace.model.MonsterModel

/**
 * Created by IntelliJ IDEA.
 * User: mujiya
 * Date: 13-2-26
 * Time: 下午3:15
 * To change this template use File | Settings | File Templates.
 */
class MapQueueBattleGroovy implements IMapQueueBattleGroovy{
    MonsterModel[] getMonsters(Integer mapId) {
        MonsterModel[] models;
         mapId=Math.random()*4+1;
        switch(mapId){
            case 1:
                models=new  MonsterModel[2];
                models[0]=new MonsterModel("测试怪1",2,1,2,1,200);
                models[1]=new MonsterModel("测试怪2",3,3,4,2,250);
                break;
            case 2:
                models=new  MonsterModel[1];
                models[0]=new MonsterModel("测试怪1",2,1,2,1,200);
                break;
            case 3:
            	models=new  MonsterModel[3];
                models[0]=new MonsterModel("测试怪1",2,1,2,1,200);
                models[1]=new MonsterModel("测试怪2",3,3,4,2,250);
                models[2]=new MonsterModel("测试怪3",4,4,5,3,300);
            	break;
            default:
                models=new  MonsterModel[4];
                models[0]=new MonsterModel("测试怪1",2,1,2,1,200);
                models[1]=new MonsterModel("测试怪2",3,3,4,2,250);
                models[2]=new MonsterModel("测试怪3",4,4,5,3,300);
                models[3]=new MonsterModel("测试怪4",5,7,6,4,500);
                break
        }
        return models  //To change body of implemented methods use File | Settings | File Templates.
    }

}
