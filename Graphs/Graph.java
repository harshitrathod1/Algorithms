package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    ArrayList<ArrayList<Integer>> adjList;
    ArrayList<ArrayList<Node>> adjlist;
    ArrayList<ArrayList<Edge>> adj;

    int vertices;
    private boolean weighted = false;

    Graph(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList<>();
        allocateSpace();
    }

    Graph(int _vertices,boolean _weighted){
        weighted = _weighted;
        vertices = _vertices;
        adj = new ArrayList<>();
        //adjlist = new ArrayList<>();
        //allocate();
        allocateWeightedSpace();
    }

    private void allocate(){
        for (int i = 0; i < vertices;i++){
            adjlist.add(new ArrayList<>());
        }
    }
    private void allocateSpace(){
        for(int i = 0; i < vertices;i++){
            adjList.add(new ArrayList<>());
        }
    }

    private void allocateWeightedSpace(){
        for(int i = 0;i < vertices;i++){
            adj.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{
          1,2,3,0,0,0
        };
        int[] nums2 = new int[]{
                2,5,6
        };

        merge(nums1,3,nums2,3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sortedList = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;

        while(j < n){
            if(nums1[i] == 0){
                sortedList[k] = nums2[j];
                j += 1;
            }else if(nums1[i] <= nums2[j]){
                sortedList[k] = (nums1[i]);
                i += 1;
            }else if(nums1[i] > nums2[j]){
                sortedList[k] = (nums2[j]);
                j += 1;
            }
            k += 1;
//            System.out.println(i +  " " + j);
            System.out.println(Arrays.toString(sortedList));
        }

        nums1 = sortedList;

        System.out.println(Arrays.toString(sortedList));
    }
}
