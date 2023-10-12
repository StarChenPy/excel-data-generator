package xyz.starsdust.exceldatagenerator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parser {
    /**
     * 权重随机数
     * @param weight 数组中值的大小决定了数组对应位置的下标出现的几率, 比如[16, 4, 2, 7], 下标0(16)出现的频率最高
     * @return 索引值
     */
    public static int weightedRandom(List<Integer> weight){
        List<Integer> weightTmp = new ArrayList<>(weight.size() + 1);
        weightTmp.add(0);
        Integer sum = 0;
        for( Integer d : weight ){
            sum += d;
            weightTmp.add(sum);
        }
        Random random = new Random();
        int rand = random.nextInt(sum);
        int index = 0;
        for(int i = weightTmp.size()-1; i >0; i--){
            if( rand >= weightTmp.get(i)){
                index = i;
                break;
            }
        }
        return index;
    }

    public static String parseString(String s) {
        // 拆分字符串，先通过";"拆开概率分布组, 再用","拆开不同的选项
        String[] probabilitySplit = s.replaceAll(" ", "").split(";");
        String[][] strSplit = new String[probabilitySplit.length][];
        for (int i = 0; i < probabilitySplit.length; i++) {
            strSplit[i] = probabilitySplit[i].split(",");
        }

        // 计算概率分布列表, 每一级的概率都比上一级低一半
        ArrayList<Integer> weightsList = new ArrayList<>();
        for (int i = 0; i < strSplit.length; i++) {
            if (!"".equals(strSplit[i][0])) {
                weightsList.add((strSplit.length - i) * 2);
            } else {
                weightsList.add(0);
            }
        }

        // 决定好哪个概率组的后，再从当前组中随机选择
        String[] selectArray = strSplit[weightedRandom(weightsList)];
        return selectArray[new Random().nextInt(selectArray.length)];
    }
}
