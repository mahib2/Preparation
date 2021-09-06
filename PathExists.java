package com.company.DataStructures.interviewbit.graph;
import java.util.ArrayList;

public class PathExists {

    /*    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
            java.util.Map<Integer, ArrayList<Integer>> graph=new java.util.HashMap();
            for(int i=0;i<B.size();i++){
                if(graph.get(B.get(i).get(0))==null){
                    ArrayList<Integer> temp= new ArrayList();
                    temp.add(B.get(i).get(1));
                    graph.put(B.get(i).get(0),temp);
                }
                else{
                    ArrayList<Integer> temp=graph.get(B.get(i).get(0));
                    temp.add(B.get(i).get(1));
                    graph.put(B.get(i).get(0),temp);
                }
            }
            java.util.Queue<Integer> q=new java.util.LinkedList<Integer>();
            boolean[] visited = new boolean[graph.keySet().size()+1];
            q.offer(1);
            visited[1]=true;
            while(!q.isEmpty()){
                int x = q.poll();
                ArrayList<Integer> temp = graph.get(x);
                java.util.Iterator itr = temp.iterator();
                while(itr.hasNext()){
                    int temp1= (int) itr.next();
                    if(temp1 == A) return 1;
                    if(!visited[temp1]){
                        q.offer(temp1);
                        visited[temp1]=true;
                    }
                }

            }
            return 0;
        }*/
    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        java.util.Map<Integer, ArrayList<Integer>> graph=new java.util.HashMap();
        for(int i=0;i<B.size();i++){
            if(graph.get(B.get(i).get(0))==null){
                ArrayList<Integer> temp= new ArrayList();
                temp.add(B.get(i).get(1));
                graph.put(B.get(i).get(0),temp);
            }
            else{
                ArrayList<Integer> temp=graph.get(B.get(i).get(0));
                temp.add(B.get(i).get(1));
                graph.put(B.get(i).get(0),temp);
            }
        }
        java.util.Queue<Integer> q=new java.util.LinkedList<Integer>();
        boolean[] visited = new boolean[graph.keySet().size()+1];
        q.offer(1);
        visited[1]=true;
        while(!q.isEmpty()){
            int x = q.poll();
            ArrayList<Integer> temp = graph.get(x);
            java.util.Iterator itr = temp.iterator();
            while(itr.hasNext()){
                int temp1= (int) itr.next();
                if(temp1 == A) return 1;
                if(!visited[temp1]){
                    q.offer(temp1);
                    visited[temp1]=true;
                }
            }

        }
        return 0;
    }
        public static void main(String[] args){
           // int [][] b={{1,2},{4,1},{2,4},{3,4},{5,2},{1,3}};
            int [][] b={{3,2},{1,2},{2,3},{4,3}};
            ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<b.length;i++){
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(b[i][0]);temp.add(b[i][1]);
                a.add(temp);
            }
            System.out.println(solve(3,a));
        }
}
