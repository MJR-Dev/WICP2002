package com.codechef.wicp2002;

import java.util.Scanner;

public class encoms {

	static String[] alphabetPair = {"az","by","cx","dw","ev","fu","gt","hs","ir","jq","kp","lo","mn","nm","ol","pk","qj","ri","sh","tg","uf","ve","wd","xc","yb","za"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int numOfCases = 0,strLngth = 0;
		if(sc.hasNextInt())
		    numOfCases = sc.nextInt();
		String[] opStr = new String[numOfCases];
		for(int i =0;i<numOfCases;i++) {
		    if(sc.hasNextInt())
		        strLngth = sc.nextInt();
			String ipStr = "";
			if(sc.hasNext())
			    ipStr = sc.nextLine();
			opStr[i] = encodeCond1(ipStr);
		}
		sc.close();
		for(String op:opStr)
			System.out.println(op);
	}
	
	static String encodeCond1(String ip) {
		int lngth = 0;
		StringBuffer tmp = new StringBuffer();
		if(ip.length()%2 == 0)
			lngth = ip.length();
		else
			lngth = ip.length()-1;
		for(int i=0;i<lngth;) {
			tmp.append(ip.charAt(i+1));
			tmp.append(ip.charAt(i));
			i = i+2;
		}
		if(ip.length()%2 > 0)
			tmp.append(ip.charAt(ip.length()-1));
		
		return encodeCond2(tmp.toString());
	}
	
	static String encodeCond2(String ip) {
		StringBuffer tmp = new StringBuffer();
		for(int k=0;k<ip.length();k++) {
			char ch = ip.charAt(k);
			for(int j=0;j<alphabetPair.length;j++) {
				if(alphabetPair[j].charAt(0) == ch) {
					tmp.append(alphabetPair[j].charAt(1));
				}
			}
		}
		return tmp.toString();
	}

}
