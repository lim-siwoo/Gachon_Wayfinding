package com.siwoo5530.gachon_wayfinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DijkstraAlgorithm {

    final static double INFINITY = Double.MAX_VALUE;
    static double distance;
    static ArrayList<String> stops = new ArrayList<>();


    DijkstraAlgorithm(String start, String destination){

        //그래프 저장용 맵 :  HashMap
        //HashMap<출발지, HashMap<도착지, 거리>>
        HashMap<String, HashMap<String, Double>> distanceMap =
                new HashMap<String, HashMap<String, Double>>();


        //도착지, 거리 저장용 임시 맵 : tempMap
        //tempMap을 만든후 이를 다시 distanceMap에 put
        HashMap<String, Double> tempMap;


        //그래프 입력
        tempMap = new HashMap<>();
        tempMap.put("중앙도서관", 470.0);
        distanceMap.put("기숙사", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("기숙사", 470.0);
        tempMap.put("15", 160.0);
        distanceMap.put("중앙도서관", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("중앙도서관", 160.0);
        tempMap.put("교육대학원", 30.0);
        tempMap.put("25", 144.0);
        tempMap.put("27", 58.0);
        distanceMap.put("15", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("15",30.0);
        distanceMap.put("교육대학원", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("27", 80.0);
        tempMap.put("17", 86.0);
        tempMap.put("18", 154.0);
        tempMap.put("바이오나노대학", 55.0);
        distanceMap.put("16", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("가천관", 9.0);
        tempMap.put("16", 86.0);
        tempMap.put("24", 56.0);
        distanceMap.put("17", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("17",9.0);
        distanceMap.put("가천관", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("17", 56.0);
        tempMap.put("공과대학2", 134.0);
        tempMap.put("한의대", 80.0);
        tempMap.put("26", 69.0);
        distanceMap.put("24", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("24", 134.0);
        tempMap.put("한의대", 68.0);
        tempMap.put("법과대학", 84.0);
        tempMap.put("바이오나노연구원",60.0);
        distanceMap.put("공과대학2", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("24", 80.0);
        tempMap.put("공과대학2", 68.0);
        tempMap.put("바이오나노연구원", 43.0);
        distanceMap.put("한의대", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("한의대", 43.0);
        tempMap.put("23", 92.0);
        tempMap.put("공과대학2",60.0);
        tempMap.put("법과대학", 125.0);
        distanceMap.put("바이오나노연구원", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("공과대학2", 84.0);
        tempMap.put("23", 166.0);
        tempMap.put("비전타워", 154.0);
        tempMap.put("바이오나노연구원", 125.0);
        distanceMap.put("법과대학", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("법과대학", 154.0);
        tempMap.put("23", 40.0);
        distanceMap.put("비전타워", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("비전타워", 40.0);
        tempMap.put("법과대학", 166.0);
        tempMap.put("바이오나노연구원", 92.0);
        tempMap.put("26", 100.0);
        tempMap.put("22", 134.0);
        distanceMap.put("23", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("22",60.0);
        distanceMap.put("IT대학", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("21", 35.0);
        distanceMap.put("글로벌센터", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("19", 26.0);
        distanceMap.put("예술대학1", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("20", 35.0);
        distanceMap.put("공과대학1", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("19", 102.0);
        tempMap.put("글로벌센터", 35.0);
        tempMap.put("22", 28.0);
        distanceMap.put("21", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("21", 28.0);
        tempMap.put("IT대학", 60.0);
        tempMap.put("20", 69.0);
        tempMap.put("23", 134.0);
        distanceMap.put("22", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("18", 59.0);
        tempMap.put("공과대학1", 35.0);
        tempMap.put("22", 69.0);
        distanceMap.put("20", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("25", 140.0);
        tempMap.put("예술대학1", 26.0);
        tempMap.put("예술대학2", 97.0);
        tempMap.put("18", 75.0);
        tempMap.put("21", 103.0);
        distanceMap.put("19", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("19", 75.0);
        tempMap.put("바이오나노대학",103.0);
        tempMap.put("16", 154.0);
        tempMap.put("20", 59.0);
        tempMap.put("26", 110.0);
        tempMap.put("예술대학2", 130.0);
        distanceMap.put("18", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("16", 55.0);
        tempMap.put("예술대학2", 37.0);
        tempMap.put("18", 103.0);
        distanceMap.put("바이오나노대학", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("바이오나노대학", 37.0);
        tempMap.put("19", 97.0);
        tempMap.put("18", 130.0);
        distanceMap.put("예술대학2", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("19", 140.0);
        tempMap.put("15", 144.0);
        distanceMap.put("25", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("24", 69.0);
        tempMap.put("23", 100.0);
        tempMap.put("18", 110.0);
        distanceMap.put("26", tempMap);

        tempMap = new HashMap<>();
        tempMap.put("15", 58.0);
        tempMap.put("16", 80.0);
        distanceMap.put("27", tempMap);



        Result  result = dijkstra(distanceMap,start);


        distance = result.distances.get(destination);


        String curNode = destination;
        stops.add(destination);
        while(!result.preNode.get(curNode).isEmpty()){
            curNode = result.preNode.get(curNode);
            stops.add(curNode);
        }




        System.out.println(destination + "까지의 최소 이동 거리: " + distance);
        System.out.println("=====이동 경로=====");
        for(int i = stops.size()-1; i>=0; i--){
            System.out.println(stops.get(i));
        }
        System.out.println("================");



    } //DijkstraAlgorithm(String start, String destination) 괄호끝


    private static class Result{
        //노드 까지 최단 거리
        HashMap<String, Double> distances = new HashMap<>();
        //자기 이전의 노드 -> 루트 추적용
        HashMap<String, String> preNode = new HashMap<>();
    }  //result



    //input: Map<출발지, Map<도착지, 거리>>, 최초 출발지
    //output: Result object
    //do: dijkstra 알고리즘을 이용하여 출발지부터 각 노드까지 최단 거리, 루트 계산
    private static Result dijkstra(HashMap<String, HashMap<String, Double>> graph, String source){



        HashMap<String, Double> distances = new HashMap<>();
        HashMap<String, String> preNode = new HashMap<>();

        //출발지의 최단거리는 0, 이전 노드는 없음
        distances.put(source, 0.0);
        preNode.put(source, "");
        //그래프의 각 노드를 저장할 집합
        HashSet<String> Q = new HashSet<>();

        //그래프 노드를 Q에 저장
        //출발지가 아닌 경우 distance, 이전 노드 초기화
        for(String key: graph.keySet()){
            Q.add(key);
            if(!key.equals(source)){
                distances.put(key, INFINITY);
                preNode.put(key, "");
            }
        }
        //Q가 빌때 까지 반복
        while(!Q.isEmpty()){
            //현재 Q안에서 최소 distance인 node 찾은 후 꺼내기
            String minNode = "";
            double minNodeDistance = INFINITY;
            for(String node: Q){
                if(distances.get(node) < minNodeDistance){
                    minNode = node;
                    minNodeDistance = distances.get(node);
                }
            }
            Q.remove(minNode);

            //거리 최소 node의 이웃 노드까지 거리 Map 읽어 오기
            //최소 node 까지 거리 + 이웃 노드까지 거리 < 현재 이웃 노드의 최소 거리 이면 distance, preNode 갱신
            HashMap<String, Double> minNodeMap = graph.get(minNode);
            for(String key: minNodeMap.keySet()){
                double distance = minNodeDistance + minNodeMap.get(key);
                if(distance < distances.get(key)){
                    distances.put(key, distance);
                    preNode.put(key, minNode);
                }
            }

        }

        Result result = new Result();
        result.distances.putAll(distances);
        result.preNode.putAll(preNode);

        return result;


    } // private static Result dijkstra(HashMap<String, HashMap<String, Double>> graph, String source) 끝괄호

    public double getDistance()
    {
        return distance;
    }

    public ArrayList<String> getStops()
    {
        return stops;
    }

} //public class DijkstraAlgorithm 끝괄호
