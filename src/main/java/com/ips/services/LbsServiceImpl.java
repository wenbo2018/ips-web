package com.ips.services;

import com.ips.dao.RadioSignalStrengthDao;
import com.ips.dto.RadioSignalStrength;
import com.ips.knn.KNNNode;
import com.ips.services.api.LbsService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by shenwenbo on 2016/12/23.
 */
@Service
public class LbsServiceImpl implements LbsService,ApplicationListener<ContextRefreshedEvent> {



    @Override
    public int lbsLocation(RadioSignalStrength ra,int k) {
        ArrayList<Integer> r=new ArrayList<Integer>();
        r= new ArrayList<Integer>();
        r.add(ra.getAP1());
        r.add(ra.getAP2());
        r.add(ra.getAP3());
        r.add(ra.getAP4());
        r.add(ra.getAP5());
        r.add(ra.getAP6());
        r.add(ra.getAP7());
        r.add(ra.getAP8());
        r.add(ra.getAP9());
        r.add(ra.getAP10());
        r.add(ra.getAP11());
        r.add(ra.getAP12());
        r.add(ra.getAP13());
        r.add(ra.getAP14());
        r.add(ra.getAP15());
        return   knn(r, k);
    }

    @Override
    public void addCache(RadioSignalStrength ra) {
        ArrayList<Integer> r=null;
            r= new ArrayList<Integer>();
        r.add(ra.getAP1());
        r.add(ra.getAP2());
        r.add(ra.getAP3());
        r.add(ra.getAP4());
        r.add(ra.getAP5());
        r.add(ra.getAP6());
        r.add(ra.getAP7());
        r.add(ra.getAP8());
        r.add(ra.getAP9());
        r.add(ra.getAP10());
        r.add(ra.getAP11());
        r.add(ra.getAP12());
        r.add(ra.getAP13());
        r.add(ra.getAP14());
        r.add(ra.getAP15());
        r.add(ra.getCin());
            datas.add(r);
    }


    List<List<Integer>> datas = new ArrayList<List<Integer>>();

    @Resource
    RadioSignalStrengthDao radioSignalStrengthDao;

    //初始化后将训练数据加载到内存中去
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
        ArrayList<Integer> r=null;
            List<RadioSignalStrength> radioSignalStrengths=radioSignalStrengthDao.list();
            for (RadioSignalStrength ra:radioSignalStrengths) {
                r= new ArrayList<Integer>();
                r.add(ra.getAP1());
                r.add(ra.getAP2());
                r.add(ra.getAP3());
                r.add(ra.getAP4());
                r.add(ra.getAP5());
                r.add(ra.getAP6());
                r.add(ra.getAP7());
                r.add(ra.getAP8());
                r.add(ra.getAP9());
                r.add(ra.getAP10());
                r.add(ra.getAP11());
                r.add(ra.getAP12());
                r.add(ra.getAP13());
                r.add(ra.getAP14());
                r.add(ra.getAP15());
                r.add(ra.getCin());
                datas.add(r);
            }
    }

    /**
     * 设置优先级队列的比较函数，距离越大，优先级越高
     */
    private Comparator<KNNNode> comparator = new Comparator<KNNNode>() {
        public int compare(KNNNode o1, KNNNode o2) {
            if (o1.getDistance() >= o2.getDistance()) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    /**
     * 获取K个不同的随机数
     *
     * @param k   随机数的个数
     * @param max 随机数最大的范围
     * @return 生成的随机数数组
     */
    public List<Integer> getRandKNum(int k, int max) {
        List<Integer> rand = new ArrayList<Integer>(k);
        for (int i = 0; i < k; i++) {
            int temp = (int) (Math.random() * max);
            if (!rand.contains(temp)) {
                rand.add(temp);
            } else {
                i--;
            }
        }
        return rand;
    }

    /**
     * 计算测试元组与训练元组之前的距离
     *
     * @param d1 测试元组
     * @param d2 训练元组
     * @return 距离值
     */
    public double calDistance(List<Integer> d1, List<Integer> d2) {
        double distance = 0.00;
        for (int i = 0; i < d1.size(); i++) {
            distance += (d1.get(i) - d2.get(i)) * (d1.get(i) - d2.get(i));
        }
        return Math.sqrt(distance);
    }

    /**
     * 执行KNN算法，获取测试元组的类别
     * @param testData 测试元组
     * @param k        设定的K值
     * @return 测试元组的类别
     */
    public int knn(List<Integer> testData, int k) {
        ArrayList<KNNNode> alKN = new ArrayList<KNNNode>();
        for (int i = 0; i < k; i++) {
            List<Integer> currData = datas.get(i);
            int c = currData.get(currData.size() - 1);
            KNNNode node = new KNNNode(i, calDistance(testData, currData), c);
            alKN.add(node);
        }
        for (int i = k; i < datas.size(); i++) {
            List<Integer> t = datas.get(i);
            double distance = calDistance(testData, t);
            for (int j = 0; j < alKN.size(); j++) {
                if ((alKN.get(j).getDistance()) >= distance) {
                    alKN.remove(j);
                    alKN.add(new KNNNode(i, distance, t.get(t.size() - 1)));
                    break;
                }
            }

        }
        return getMostClass(alKN);
    }

    /**
     * 获取所得到的k个最近邻元组的多数类
     *
     * @return 多数类的名称
     */
    private int getMostClass(ArrayList<KNNNode> alKN) {
        Map<Integer, Integer> classCount = new HashMap<Integer, Integer>();
        for (int i = 0; i < alKN.size(); i++) {
            KNNNode node = alKN.remove(i);
            int c = node.getC();
            if (classCount.containsKey(c)) {
                classCount.put(c, classCount.get(c) + 1);
            } else {
                classCount.put(c, 1);
            }
        }
        int maxIndex = -1;
        int maxCount = 0;
        Object[] classes = classCount.keySet().toArray();
        for (int i = 0; i < classes.length; i++) {
            if (classCount.get(classes[i]) > maxCount) {
                maxIndex = i;
                maxCount = classCount.get(classes[i]);
            }
        }
        return (int) classes[maxIndex];
    }

}
