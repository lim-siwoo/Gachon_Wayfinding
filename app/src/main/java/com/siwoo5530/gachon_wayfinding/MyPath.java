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


        name.add("기숙사");	x.add(161);	y.add(213);
        name.add("중앙도서관");	x.add(575);	y.add(252);
        name.add("15");	x.add(554);	y.add(342);
        name.add("교육대학원");	x.add(582);	y.add(345);
        name.add("16");	x.add(534);	y.add(563);
        name.add("17");	x.add(565);	y.add(588);
        name.add("가천관");	x.add(586);	y.add(579);
        name.add("24");	x.add(599);	y.add(617);
        name.add("한의대");	x.add(575);	y.add(650);
        name.add("공과대학2");	x.add(620);	y.add(693);
        name.add("바이오나노연구원");	x.add(515);	y.add(737);
        name.add("법과대학");	x.add(537);	y.add(768);
        name.add("비전타워");	x.add(445);	y.add(773);
        name.add("23");	x.add(428);	y.add(719);
        name.add("22");	x.add(253);	y.add(665);
        name.add("IT대학");	x.add(274);	y.add(690);
        name.add("21");	x.add(197);	y.add(638);
        name.add("글로벌센터");	x.add(169);	y.add(627);
        name.add("20");	x.add(334);	y.add(621);
        name.add("공과대학1");	x.add(291);	y.add(600);
        name.add("19");	x.add(253);	y.add(510);
        name.add("예술대학1");	x.add(203);	y.add(488);
        name.add("예술대학2");	x.add(415);	y.add(456);
        name.add("바이오나노대학");	x.add(480);	y.add(548);
        name.add("18");	x.add(400);	y.add(600);
        name.add("25");	x.add(351);	y.add(345);
        name.add("26");	x.add(495);	y.add(668);
        name.add("27");	x.add(604);	y.add(435);



        pointFS.clear();

        for(int i=0; i<stops.size();i++)
        {
            for(int j=0; j<name.size();j++)
            {
                if(name.get(j).equals(stops.get(i)))
                {
                    PointF temp = new PointF(x.get(j),y.get(j));
                    pointFS.add(i,temp);
                }
            }
        }

    }


}
