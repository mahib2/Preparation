package com.company.DataStructures.interviewbit.graph;
import java.util.ArrayList;
import java.util.Arrays;

public class SurroundedRegions {

//Modified:interview bit solution
public void solve(ArrayList<ArrayList<Character>> a) {
        int m=a.size();
        int n=a.get(0).size();

       Character[][] mat = new Character[m][n];
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(a.get(i).get(j)=='O')
                    mat[i][j]='-';
                else mat[i][j]=a.get(i).get(j);
           }
       }
       
       for(int i=0;i<m;i++)
            if(mat[i][0]=='-')
                util(mat,i,0,'-','O',m,n);
        for(int i=0;i<m;i++)
            if(mat[i][n-1]=='-')
                util(mat,i,n-1,'-','O',m,n);
        for(int i=0;i<n;i++)
            if(mat[0][i]=='-')
                util(mat,0,i,'-','O',m,n);
        for(int i=0;i<n;i++)
            if(mat[m-1][i]=='-')
                util(mat,m-1,i,'-','O',m,n);
        
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(mat[i][j]=='-')
                    a.get(i).set(j,'X');
           }
       }
	}
    public void util(Character[][] mat, int x,int y,char prev, char newv, int m, int n){
        if(x<0||x>=m||y<0||y>=n) return;
        if(mat[x][y]!=prev) return;
        mat[x][y]=newv;
        util(mat,x+1,y,prev,newv,m,n);
        util(mat,x-1,y,prev,newv,m,n);
        util(mat,x,y+1,prev,newv,m,n);
        util(mat,x,y-1,prev,newv,m,n);
    }

//Normal solution
    public static void solveRegions(ArrayList<ArrayList<Character>> a){
        Character[][] mat=new Character[a.size()][a.get(0).size()];
        int m=a.size();
        int n=a.get(0).size();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a.get(i).get(j)=='O'){
                    mat[i][j]='-';
                }else {
                    mat[i][j] = a.get(i).get(j);
                }
            }
        }
        print(mat);
        for(int i=0;i<m;i++)
            if(mat[i][0]=='-')
                    fill(mat,i,0,'-','O',m,n);
        for(int i=0;i<m;i++)
            if(mat[i][n-1]=='-')
                fill(mat,i,n-1,'-','O',m,n);
        for(int i=0;i<n;i++)
            if(mat[0][i]=='-')
                fill(mat,0,i,'-','O',m,n);
        for(int i=0;i<n;i++)
            if(mat[m-1][i]=='-')
                fill(mat,m-1,i,'-','O',m,n);


        print(mat);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]=='-') {
                    mat[i][j] = 'X';
                }
            }
        }
        print(mat);
    }
    public static void fill(Character mat[][],int x,int y, char prevV,char newV,int m, int n){
        if(x<0||x>=m||y<0||y>=n) return;
        if(mat[x][y] != prevV) return;
        mat[x][y]=newV;
        fill(mat,x+1,y,prevV,newV,m,n);
        fill(mat,x-1,y,prevV,newV,m,n);
        fill(mat,x,y+1,prevV,newV,m,n);
        fill(mat,x,y-1,prevV,newV,m,n);
    }

    public static void print(Character[][] mat){
        for(Character[] i:mat) {
           System.out.println(Arrays.toString(i));
        }
    }
    public static void main(String[] args) {
        Character[][] mat = {{'X', 'X','X'}, {'X', 'O','X'},{'O','X','O'}};
        ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>();
        for (Character[] i : mat) {
            a.add(new ArrayList<>(Arrays.asList(i)));
        }
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                System.out.print(a.get(i).get(j) + " ");
            }
            System.out.println("");
        }
        solveRegions(a);
    }


}

