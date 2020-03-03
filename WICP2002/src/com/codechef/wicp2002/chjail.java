package com.codechef.wicp2002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class chjail {
	
	static ArrayList<String> mtrLst,endResult;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfCases = 0;	
		endResult = new ArrayList<String>();
		try {
		numOfCases = Integer.parseInt(br.readLine());
		mtrLst = new ArrayList<String>();
		String tmp ="";
		
			while((tmp=br.readLine()) != null) {
				if(tmp.trim().length() > 0) {
					mtrLst.add(tmp);
				}	else 
					break;
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}		
		for(int i=0;i<mtrLst.size();i++) {
			List<String> lst = new ArrayList<String>();
			int[] mnxy = new int[4];
			String[] mnxyStr = mtrLst.get(i).split(" ");
			for(int j=0;j<4;j++)
				mnxy[j] = Integer.parseInt(mnxyStr[j]);
			
			for(int k=i;k<i+mnxy[0];k++) {
				lst.add(mtrLst.get(k+1));
			}
			getMatrix(mnxy[0],mnxy[1],lst,mnxy[2]-1,mnxy[3]-1);
			if((mnxy[0]+1) < mtrLst.size()) 
					i = i+mnxy[0];
			else 
				break;
		}		
		for(String str:endResult)
			System.out.println(str);
		
	}	
	//If a person standing in room (i,j) then he can walk to room (i,j+1),(i+1,j) and (i+1,j+1).
	static void getMatrix(int rows,int cols,List<String> matrix,int draini, int drainj) {
		boolean flag = false;
		int[][] mtr = new int[4][4];
		for(int i=0;i<4;i++) {
			String[] elements = matrix.get(i).split(" ");
			for(int j=0;j<4;j++) {
				mtr[i][j] = Integer.parseInt(elements[j]);
			}
		}
		int chefPwr = mtr[0][0];		
		int posi=0,posj=0,i=0,j=0;
		int result = 0;		
		while(i<rows && j<cols) {
				if(mtr[i][j+1] >= 1 && mtr[i+1][j] >= 1 && mtr[i+1][j+1] >= 1) {
					int min = mtr[i][j+1];
					posi = i;
					posj = j+1;
					if(mtr[i+1][j] < min) { 
						min = mtr[i+1][j];
						posi = i+1;
						posj = j;
					}
					if(mtr[i+1][j+1] < min){ 
						min = mtr[i+1][j+1];
						posi = i+1;
						posj = j+1;
					}
					result += min;
					if(result <= chefPwr && posi == draini && posj == drainj) {
						flag=true;
						break;
					}
					else {
						i=posi;
						j=posj;
					}
					
				}
			}		
		if(flag)
			endResult.add("Escape");
		else
			endResult.add("Died");
		
	}
	
	
	
}
