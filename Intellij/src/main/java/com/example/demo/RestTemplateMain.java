package com.example.demo;

import com.example.demo.domain.Money;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;

public class RestTemplateMain {
    /**
     * 	用一个普通方法，直接完成对REST服务的请求
     * @param args
     */
    public static void main(String[] args) {
        RestTemplate tpl = new RestTemplate();
        List<Integer> aList = new ArrayList();
        aList.add(12);
        aList.add(11);
        aList.add(15);
        aList.add(19);
        System.out.println(aList.toString());
        Collections.sort(aList);

        System.out.println(aList.toString());

        List<Money> moneyList = new ArrayList<Money>();
        //随机生成10个点
        for (int i = 0; i < 10; i++) {
            int moneyNum = (int) (Math.random() * 200) + 1;
            Money m = new Money();
            m.setBigDecimal(BigDecimal.valueOf(moneyNum));
            m.setGetter("hh"+moneyNum);
            moneyList.add(m);
        }

        System.out.println(moneyList.toString());

        coll(moneyList);
        System.out.println(moneyList.toString());

        //get List
        ResponseEntity<List> responseEntity = tpl.getForEntity("http://localhost:8080/hello/Moneys", List.class);
        HttpHeaders headers = responseEntity.getHeaders();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int code = statusCode.value();

        List<HashMap<String,Object>> list = (ArrayList)responseEntity.getBody();

        System.out.println(list.toString());
        //sort rest webservice response
        Collections.sort(list, new Comparator<HashMap<String,Object>>() {

            @Override
            //当 o1 < o2 时返回正数
            public int compare(HashMap<String,Object> o1, HashMap<String,Object> o2) {
                int distance1 = ((Double)o1.get("bigDecimal")).intValue();
                int distance2 = ((Double)o2.get("bigDecimal")).intValue();

                return (distance1 > distance2) ? 1 : ((distance1 == distance2) ? 0 : -1);
            }

        });
        System.out.println(list.toString());

        //sort hashMap
        Map map = new HashMap();
        map.put("11",11);
        map.put("22",22);
        map.put("44",44);
        map.put("55",55);
        map.put("33",33);
        System.out.println(map.toString());
        Set<Map.Entry<String,Integer>> mapSet = map.entrySet();

        List<Map.Entry<String,Integer>> mapList = new ArrayList<>(mapSet);
        Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int distance1 = o1.getValue();
                int distance2 = o2.getValue();

                return Integer.compare(distance1, distance2);
            }
        });
        Map<String,Integer> mapResult = new HashMap<>();

        for(Map.Entry<String, Integer> o1 : mapList){
            mapResult.put(o1.getKey(),o1.getValue());
        }

        System.out.println(mapResult.toString());

/*
        //get one object
        HashMap<String, Integer> map = new HashMap<>();
        map.put("id",2);
        ResponseEntity<Money> responseEntity1 = tpl.getForEntity("http://localhost:8080/hello/getById/{id}", Money.class, map);
        Money userEntity = responseEntity1.getBody();
        System.out.println(userEntity.toString());

        //POST SAVE
        Money m = new Money();
        m.setBigDecimal(BigDecimal.valueOf(400));
        String a = String.valueOf(400);
        String b = 400+"";
        m.setDescription("aaaaa");
        m.setGetter("m");
        m.setGiver("n");
        ResponseEntity<Money> responseEntity3 = tpl.postForEntity("http://localhost:8080/hello/createMoney", m,Money.class);
        HttpHeaders headers3 = responseEntity.getHeaders();
        HttpStatus statusCode3 = responseEntity.getStatusCode();
        int code3 = statusCode.value();
        Money list3 = responseEntity3.getBody();
        System.out.println(list3.toString());



        String p = tpl.getForObject("http://localhost:8080/hello/String1", String.class);

        System.out.println(p+"----------------");*/
    }

    public static void coll(List<Money> list) {
        Collections.sort(list, new Comparator<Money>() {

            @Override
            //当 o1 < o2 时返回正数
            public int compare(Money o1, Money o2) {
                int distance1 = o1.getBigDecimal().intValue();
                int distance2 = o2.getBigDecimal().intValue();

                return (distance1 < distance2) ? 1 : ((distance1 == distance2) ? 0 : -1);
            }

        });
    }

}
