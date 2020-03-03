package com.codechef.wicp2002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class chsoc {

	static List<String> input;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String tmp="";
		input = new ArrayList<String>();
		try {
			while((tmp=br.readLine()) != null) {
				if(tmp.trim().length() > 0) {
					input.add(tmp);
				}
				else 
					break;
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		int[] nTh = new int[2];
		for(int i=1;i<input.size();i++) {
			String[] tkns = input.get(i).split(" ");			
			if(tkns.length == 2) {
				nTh[0] = Integer.parseInt(tkns[0]);
				nTh[1] = Integer.parseInt(tkns[1]);
			} else {
				int[] array = new int[nTh[0]];
				for(int j=0;j<tkns.length;j++) {
					array[j] = Integer.parseInt(tkns[j]);
				}
				getMS(array,nTh[1]);
			}
			
		}
	}
	
	static void getMS(int[] array,int th) {
		int M=0,S=0;
		for(int k=0;k<array.length;k++) {
			int sum = 0;		
			for(int l=0;l<array.length;l++) {
				sum += Math.max(array[l]-array[k], 0);
			}
			if(sum >= th) {
				S=sum;
				M=array[k];
			}
			else {
				break;
			}
		}
		System.out.print("\r"+M+" "+S);
	}
}
