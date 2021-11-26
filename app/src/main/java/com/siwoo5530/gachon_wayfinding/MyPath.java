package com.siwoo5530.gachon_wayfinding;

import android.graphics.PointF;

import  java.util.ArrayList;

public class MyPath
{
    ArrayList <Integer> xArray = new ArrayList<Integer>();
    ArrayList <Integer> yArray = new ArrayList<Integer>();

    public ArrayList<PointF> getPointFS() {
        return pointFS;
    }

    ArrayList <PointF> pointFS = new ArrayList<PointF>();




    public MyPath(ArrayList<String> stops) {
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();


        name.add("기숙사");		x.add(129); y.add(142);
        name.add("중앙도서관");	x.add(425); y.add(168);
        name.add("15"); 		x.add(410); y.add(228);
        name.add("교육대학원"); 	x.add(430); y.add(230);
        name.add("16");		x.add(396); y.add(375);
        name.add("17");		x.add(418); y.add(392);
        name.add("가천관");  	x.add(433); y.add(386);
        name.add("24");		x.add(442); y.add(411);
        name.add("한의대");	 	x.add(425); y.add(433);
        name.add("공과대학2"); 		x.add(457); y.add(462);
        name.add("바이오나노연구원");	x.add(382); y.add(491);
        name.add("법과대학"); 		x.add(398); y.add(512);
        name.add("비전타워");		x.add(332); y.add(515);
        name.add("23"); 		x.add(320); y.add(479);
        name.add("22"); 		x.add(195); y.add(443);
        name.add("IT대학");		x.add(210); y.add(460);
        name.add("21");		x.add(155); y.add(425);
        name.add("글로벌센터");	x.add(135); y.add(418);
        name.add("20"); 		x.add(253); y.add(414);
        name.add("공과대학1"); 	x.add(222); y.add(400);
        name.add("19");		x.add(195); y.add(340);
        name.add("예술대학1"); 	x.add(159); y.add(325);
        name.add("예술대학2"); 	x.add(311); y.add(304);
        name.add("바이오나노대학");	x.add(357); y.add(365);
        name.add("18"); 		x.add(300); y.add(400);
        name.add("25");		x.add(265); y.add(230);
        name.add("26");		x.add(368); y.add(445);
        name.add("27");		x.add(446); y.add(290);


        pointFS.clear();

        for(int i=0; i<stops.size();i++)
        {
            for(int j=0; j<name.size();j++)
            {
                if(name.get(j).equals(stops.get(i)))
                {
                    PointF temp = new PointF(x.get(j)*1.4f-20,y.get(j)*1.5f);
                    pointFS.add(i,temp);
                }
            }
        }

    }


}
