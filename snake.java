import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.applet.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.net.*;
import java.lang.*;
import java.io.*;

class snkSound1              // game music playig
{ 
	static AudioClip player;
	static URL soundToPlay;
	public void initialise(String file)
	{
		try
		{
			soundToPlay = getClass().getResource(file);
			player = Applet.newAudioClip(soundToPlay);

		} 
		catch (Exception e) {}
	}
	public void playfile( int lop)
	{
		try
		{
 
			if(lop==1)
			player.loop();
			else
			player.stop();
		} 
		catch (Exception e) {}
	}
}

class snkSound2               // click sound playing
{ 
	static AudioClip player2;
	static URL soundToPlay2;
	public void initialise2(String file)
	{
		try
		{
			soundToPlay2 = getClass().getResource(file);
			player2 = Applet.newAudioClip(soundToPlay2);

		} 
		catch (Exception e) {}
	}
	public void playfile2( int lop)
	{
		try
		{
	 
			if(lop==1)
			player2.play();
			else
			player2.stop();
		} 
		catch (Exception e) {}
	}
}

class snkSound3               // movement sound
{ 
	static AudioClip player3;
	static URL sndToPly3;
	public void initialise3(String file)
	{
		try
		{
			sndToPly3 = getClass().getResource(file);
			player3 = Applet.newAudioClip(sndToPly3);

		} 
		catch (Exception e) 
		{
		}
	}
	public void playfile3( int lop)
	{
		try
		{
 
			if(lop==1)
				player3.play();
			else
				player3.stop();
		} 
		catch (Exception e){}
	}
}
class snkSound4               // movement sound
{ 
	static AudioClip player4;
	static URL sndToPly4;
	public void initialise4(String file)
	{
		try
		{
			sndToPly4 = getClass().getResource(file);
			player4 = Applet.newAudioClip(sndToPly4);

		} 
		catch (Exception e) 
		{
		}
	}
	public void playfile4( int lop)
	{
		try
		{
 
			if(lop==1)
				player4.play();
			else
				player4.stop();
		} 
		catch (Exception e)
		{
		}
	}
}
class snkSound5               // movement sound
{ 
	static AudioClip player5;
	static URL sndToPly5;
	public void initialise5(String file)
	{
		try
		{
			sndToPly5 = getClass().getResource(file);
			player5 = Applet.newAudioClip(sndToPly5);

		} 
		catch (Exception e) 
		{
		}
	}
	public void playfile5( int lop)
	{
		try
		{
 
			if(lop==1)
				player5.play();
			else
				player5.stop();
		} 
		catch (Exception e)
		{
		}
	}
}

//JFrame
public class snake extends JFrame 
{

	// global variables initialise
	static int allow=0,mx=0,my=0,imgx=1,imgy=1,imgx1=1350,imgy1=740,cntrl=-1,preCntrl=0;
	static int maxPlayersS=2,maxPlayers =2,ad=1,single=0,cmpBxo=0,term=0,sCreated=0,alt4=0;
	 int sound=1, music=1,tempSound=sound,tempMusic=music,repeat=0,musicCl=1,sndCl=0;
	static int pmix=630,pmiy=400,pi1=1,pi2=1,pi3=1,pi4=1,pi5=1,tx,ty,bxo=0,pd=0,tpd=0;
	static int ric=0,rollN=0,rCntrl=0,user=0,join=0,cRoll=0,cSend=0,sSend=0;
	static int ms1=0,rndN=0,plr[][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}},tplr[][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
	static long rCtr=0,scf=0;
	static int sndP=0,stat=0,diceR=0;
	int i,j,k,l,m,rnk=0,tmp1,tmp2,tmp3,tmp4,alt=0,nfc=0,pfc=0;
	int snkAry[][]={{24,1},{99,6},{55,13},{71,29},{88,67}};
	int ladAry[][]={{8,31},{15,97},{27,48},{42,81},{66,87}};
	static int brdAry[][][] = new int[5][10][10];
	Image img,img1,img2,p1,p2,p3,p4,p5,tp,box,r0,r1,r2,r4,tr,r21,r22,r23,r24,r25;
	static snkSound1 sn1;
	static snkSound2 sn2;
	static snkSound3 sn3;
	static snkSound4 sn4;
	static snkSound5 sn5;
	static TextField nameField,passField;
	static Random rnd;
	static String tmpStr="",pName="PLAYER",passWord="",originalPass="password",askNm="",pList[]={"","","","","",""};
	static Thread ss,sr,cs,cr;
	static MulticastSocket ports = null,portr=null;
	//static int port1=1234,port2=2234;
	
	static InetAddress group  = null;
	
	static byte buf[] = null;
	static DatagramPacket data =null , data1=null;
	
	static LinkedList<String> receiveString;
	static LinkedList<String> sendString;
	
	
	
	public  static void main(String args[]) throws IOException  // main function
	{
		snake mou = new snake();
		
		group = InetAddress.getByName("234.5.6.7");
		buf = new byte[1024];
		sendString = new LinkedList<String>();
		receiveString = new LinkedList<String>();
		mou.setSize(1360,740);
		mou.setTitle("Snake and Ladder");
		mou.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//mou.setUndecorated(true);
		
		mou.setVisible(true);
		mou.initial("sound/abc.wav","sound/abc1.wav","sound/move.wav" ,"sound/lad.wav","sound/snk.wav");
		nameField.setBounds(650,490,200,22);
		passField.setBounds(650,490,200,22);	
		
	}
	
	public class Receiving implements Runnable
	{
		public void run() 
		{
			String TreceiveString ="";
			while(true)
			{
			System.out.println("ports hosted");
			//TreceiveString = "";
			try
			{
				while(true)
				{
				
					if(rCtr>100 && cSend==1)
					{
						if(scf==1)
						receiveString.add("0,");
						rCtr=0;
					}
					if(sSend==1 || cSend==1)
					{
						rCtr++;
						if(sSend==1 && join==0)
							portr = new MulticastSocket(2234);
						else
							portr = new MulticastSocket(1234);
						portr.joinGroup(group);
						buf = new byte[1024];
						data = new DatagramPacket(buf, buf.length);
						portr.receive(data);
						TreceiveString = new String(data.getData()).trim();
						portr.leaveGroup(group);
						if(TreceiveString != "" || TreceiveString != null)// && receiveString.search(TreceiveString) ==-1)
						{
						
							rCtr=0;
							receiveString.add(TreceiveString);
							System.out.println(TreceiveString);
						}
						TreceiveString="";
					
					}
				}
				
			}
			catch (Exception e) {System.out.println("ports receive error "+e);}
			System.out.println("ports closed");
			}
		}
	}
	class Sending implements Runnable
	{
		public void run()  
		{
			//Enumeration sing = sendString.elements();
			while(true)
			{
				String msg1  = "";
				
				try
				{
					while(true)
					{
						while(sendString.peekFirst() != null)
						{
							//msg1= sendString.getFirst();
							
							msg1= sendString.removeFirst();
							
							if(sSend==1 || cSend==1)
							{
							
								if(msg1!= "" || msg1!= null)
								
								{
									if(sSend==1 && join==0)
									{
										ports = new MulticastSocket(2234);
										System.out.println("server sending --->>>> "+ msg1);
									}
									else
									{
										ports = new MulticastSocket(1234);
										System.out.println("client sending --->>>> "+ msg1);
									}
									//allowSend--;
									buf = new byte[1024];
									buf = msg1.getBytes();
									if(sSend==1 && join==0)
										data1 = new DatagramPacket(buf,buf.length,group,1234);
									else
										data1 = new DatagramPacket(buf,buf.length,group,2234);
									
									ports.send(data1);
									Thread.sleep(50);
								}
							}
					
						
						 
						}
						
					}
					
				}
				catch (Exception e)
				{
				System.out.println("ports send error "+e);
				}
			}
		}
	}
	
	
	
	public void initial(String filnm1, String filnm2 , String filnm3,String filnm4 ,String filnm5)   // function to initialise objects
	{int i,j,k,l=1;
	sn1= new snkSound1();
	sn1.initialise(filnm1);
	if(music==1)
	sn1.playfile(1);
		sn2= new snkSound2();
		sn2.initialise2(filnm2);
		sn3= new snkSound3();
		sn3.initialise3(filnm3);
		sn4= new snkSound4();
		sn4.initialise4(filnm4);
		sn5= new snkSound5();
		sn5.initialise5(filnm5);
		nameField = new TextField("PLAYER   (Maximum 7 character)",8);
		passField = new TextField("password",8);
		rnd = new Random();
		for(i=0;i<5;i++)
		{for(j=0;j<10;j++)
		{
		for(k=0;k<=9;k++)
		{if(i==0)
		{
		if(j%2==0)
		brdAry[i][j][k]= l++;
		else
		brdAry[i][j][9-k]=l++;
		}
		else
		brdAry[i][j][k]=0;
		}
		}
		}
		try
			{
			group = InetAddress.getByName("234.5.6.7");
			
			}
			catch (IOException e) {}
		Sending Send = new Sending();
		 ss = new Thread(Send);
		Receiving Receive = new Receiving();
		 sr = new Thread(Receive);
		
		ss.start(); sr.start();
		
	}
	public static void playMusic( int lop)
	{
	
		sn1.playfile(lop);
	
	}
	public static void playSound(int lop)
	{
	
	sn2.playfile2(lop);
	}
	public static void playMoveSound(int lop)
	{
	
		sn3.playfile3(lop);
	}
	public static void playLadderSound(int lop)
	{
	
		sn4.playfile4(lop);
	}
	public static void playSnakeSound(int lop)
	{
	
		sn5.playfile5(lop);
	}
	public snake() 
	{	
		addMouseListener(new mouseWork(this));
		
	}
	public static void make()
	{
		int i,j;
		String TsendString="10,",TTsendString="";
		//if(sSend==1) plrCnt++;
			for(i=0;i<4;i++)
			{
				for(j=0;j<3;j++)
				{
					TsendString = TsendString+ String.valueOf(plr[i][j])+",";
				}
			}
		
			
			//System.out.println("made as "+ TsendString);
			adS(TsendString);
			
	}
	
	public  void scan(Graphics gg)
	{
		int l=0,i=0,n=0,tempo=0,tMaxPlayers=maxPlayers,j=0,tmpn=0;
		String tStr="",tStr1="",t121="";
		StringTokenizer st ;
		//Enumerator ring = receiveString.elements();
		char a;
		try
		{
		
		if(sSend==1)
			{
			adS("21,");
			
			make();
			if(pi1==0)
			adS("30,"+pList[1]+",");
			if(pi2==0)
			adS("40,"+pList[2]+",");
			if(pi3==0)
			adS("50,"+pList[3]+",");
			if(pi4==0)
			adS("60,"+pList[4]+",");
			if(pi5==0)
			adS("70,"+pList[5]+",");
		
			for(i=0;i<4;i++)
			{
			if(plr[i][0] ==0) break;
			}
			//System.out.println("maximum players === "+i);
			//if(i >3) i=3;
			tMaxPlayers  = tMaxPlayers -i;
			
			if(tMaxPlayers <0) tMaxPlayers =0;
			i=0;
			maxPlayersS= tMaxPlayers;
			//System.out.println("maximum players === "+tMaxPlayers);
			tStr ="9"+ tMaxPlayers +",";
			
			adS(tStr);
			tStr="";
			tStr="8,"+originalPass+",";
			adS(tStr);
			tStr="";
			}
		
		while(receiveString.peekFirst() != null)
		{
		tStr1="";l=0;i=0;
		//tStr = receiveString.getFirst();
		
		tStr= receiveString.removeFirst();
		st = new StringTokenizer(tStr,",");
		if(st.hasMoreTokens())
		tStr1= st.nextToken();
		else
		continue;
		n= Integer.parseInt(tStr1);
		
		
		if(n==0)
		{
			cSend=0;sSend=0;
			//System.exit(0);
			System.out.println( n+" checked");
			cntrl=-1; //receiveString="";
			return ;
		}
		else if(n==1)
		{
			tStr1= st.nextToken();
			 n=Integer.parseInt(tStr1);
			 if(sSend==1 && n!=bxo)
			 {
				if(n==1)
				{pi1=1;pList[1]="";}
				else if(n==2)
				{pi2=1;pList[2]="";}
				else if(n==3)
				{pi3=1;pList[3]="";}
				else if(n==4)
				{pi4=1;pList[4]="";}
				else if(n==5)
				{pi5=1;pList[5]="";}
				n=exist(n);
				if( n !=-1)
				{
					for(i=n;i<3;i++)
					{
					plr[n][0]=plr[n+1][0];plr[n][1]=plr[n+1][1];plr[n][2]=plr[n+1][3];
					}
					plr[3][0]=plr[3][1]=plr[3][2]=0;
				}
			 }
		}
		else if( n==8)
		{
		originalPass = st.nextToken();
		// update latter
		}
		
		else if( n==20)
		{
			sCreated=0;
		}
		
		else if( n==21)
		{
			sCreated=1;
			//System.out.println(n+" checked");
		}
		else if(cntrl==4 && n==30 && pi1!=0)
		{
			pi1=0;alt4=1;pList[1]=st.nextToken();
		}
		else if(cntrl==4&& n==40 && pi2!=0)
		{
			pi2=0;alt4=1;pList[2]=st.nextToken();
		}
		else if(cntrl==4&& n==50 && pi3!=0)
		{
			pi3=0;alt4=1;pList[3]=st.nextToken();
		}
		else if(cntrl==4&& n==60 && pi4!=0)
		{
			pi4=0;alt4=1;pList[4]=st.nextToken();
		}
		else if(cntrl==4&& n==70 && pi5!=0)
		{
			pi5=0;alt4=1;pList[5]=st.nextToken();
		}
		else if( n==30)
		{
			pi1=0;pList[1]=st.nextToken();
			if(stat==1 && exist(1) ==-1)
			{
				for(i=0;i<4;i++)
				{
				 if(plr[i][0] ==0)
				 break;
				}
				plr[i][0]=1;plr[i][1]=1;
				appear(1,1);
				fresh(gg);
				
			}
		}
		else if(n==40)
		{
			pi2=0;pList[2]=st.nextToken();
			if(stat==1 && exist(2) ==-1)
			{
				for(i=0;i<4;i++)
				{
				 if(plr[i][0] ==0)
				 break;
				}
				plr[i][0]=2;plr[i][1]=1;
				appear(2,1);
				fresh(gg);
				
			}
		}
		else if( n==50 )
		{
			pi3=0;pList[3]=st.nextToken();
			if(stat==1 && exist(3) ==-1)
			{
				for(i=0;i<4;i++)
				{
				 if(plr[i][0] ==0)
				 break;
				}
				plr[i][0]=3;plr[i][1]=1;
				appear(3,1);
				fresh(gg);
				
			}
		}
		else if( n==60 )
		{
			pi4=0;pList[4]=st.nextToken();
			if(stat==1 && exist(4) ==-1)
			{
				for(i=0;i<4;i++)
				{
				 if(plr[i][0] ==0)
				 break;
				}
				plr[i][0]=4;plr[i][1]=1;
				appear(4,1);
				fresh(gg);
				
			}
		}
		else if(n==70)
		{
			pi5=0;pList[5]=st.nextToken();
			if(stat==1 && exist(5) ==-1)
			{
				for(i=0;i<4;i++)
				{
				 if(plr[i][0] ==0)
				 break;
				}
				plr[i][0]=5;plr[i][1]=1;
				appear(5,1);
				fresh(gg);
				
			}
		}
		else if( n==31)
		{
			if(sSend==1 && bxo != 1 || cSend==1 && bxo != 1) 
			{pi1=1;pList[1]="";
			while(search(1)==1)
			{disappear(1);
			}
			if(exist(1) !=-1)
		{
		n= exist(1);
		//tmp1=plr[n][0]; tmp2=plr[n][1]; tmp3=plr[0][2];
		for(i=n;i<3;i++)
		{
		plr[i][0]=plr[i+1][0];
		plr[i][1]=plr[i+1][1];
		plr[i][2]=plr[i+1][2];
		
		}
		plr[i][0]=0;
		plr[i][1]=0;
		plr[i][2]=0;
		}
			if(stat==1) 
			{fresh(gg);
			panelFresh(gg);
			}
			}
		
			
		}
		else if(n==41)
		{
			if(sSend==1 && bxo != 2 || cSend==1 && bxo != 2)
			{pi1=2;pList[2]="";
			while(search(2)==1)
			{disappear(2);
			}
			if(exist(2) !=-1)
		{
		n= exist(2);
		//tmp1=plr[n][0]; tmp2=plr[n][1]; tmp3=plr[0][2];
		for(i=n;i<3;i++)
		{
		plr[i][0]=plr[i+1][0];
		plr[i][1]=plr[i+1][1];
		plr[i][2]=plr[i+1][2];
		
		}
		plr[i][0]=0;
		plr[i][1]=0;
		plr[i][2]=0;
		}
			if(stat==1)
			{fresh(gg);
			panelFresh(gg);
			}
			}
			
		}
		else if( n==51 )
		{
			if(sSend==1 && bxo != 3 || cSend==1 && bxo != 3)
			{pi1=3;pList[3]="";
			while(search(3)==1)
			{disappear(3);
			}
			if(exist(3) !=-1)
		{
		n= exist(3);
		//tmp1=plr[n][0]; tmp2=plr[n][1]; tmp3=plr[0][2];
		for(i=n;i<3;i++)
		{
		plr[i][0]=plr[i+1][0];
		plr[i][1]=plr[i+1][1];
		plr[i][2]=plr[i+1][2];
		
		}
		plr[i][0]=0;
		plr[i][1]=0;
		plr[i][2]=0;
		}
			if(stat==1) 
			{fresh(gg);
			panelFresh(gg);
			}
			}
			
		}
		else if( n==61 )
		{
			if(sSend==1 && bxo != 4 || cSend==1 && bxo != 4)
			{pi1=4;pList[4]="";
			while(search(4)==1)
			{disappear(4);
			}
			if(exist(4) !=-1)
		{
		n= exist(4);
		//tmp1=plr[n][0]; tmp2=plr[n][1]; tmp3=plr[0][2];
		for(i=n;i<3;i++)
		{
		plr[i][0]=plr[i+1][0];
		plr[i][1]=plr[i+1][1];
		plr[i][2]=plr[i+1][2];
		
		}
		plr[i][0]=0;
		plr[i][1]=0;
		plr[i][2]=0;
		}
			if(stat==1)
			{fresh(gg);
			panelFresh(gg);
			}
			}
			
		}
		else if(n==71)
		{
			if(sSend==1 && bxo != 5 || cSend==1 && bxo != 5)
			{pi1=5;pList[5]="";
			while(search(5)==1)
			{disappear(5);
			}
		if(exist(5) !=-1)
		{
		n= exist(5);
		//tmp1=plr[n][0]; tmp2=plr[n][1]; tmp3=plr[0][2];
		for(i=n;i<3;i++)
		{
		plr[i][0]=plr[i+1][0];
		plr[i][1]=plr[i+1][1];
		plr[i][2]=plr[i+1][2];
		
		}
		plr[i][0]=0;
		plr[i][1]=0;
		plr[i][2]=0;
		}
			if(stat==1) 
			{fresh(gg);
			panelFresh(gg);
			}
			}
			
		}
		else if(n==90)
		{
			maxPlayers=0;
		}
		else if(n==91)
		{
			maxPlayers=1;
		}
		else if(n==92)
		{
			maxPlayers=2;
		}
		else if(n==93)
		{
			maxPlayers=3;
		}
		else if(n==120)
		{
			 if(cntrl==5 || cntrl==11 || stat==0)
			 {
			 tStr1= st.nextToken();
			  tStr1= st.nextToken();
			 n=Integer.parseInt(tStr1);
			 plr[0][2]=n;
			 plr[0][1]+= plr[0][2];
				if(plr[0][1] >100) 
					plr[0][1]-= plr[0][2];
				for(i=0;i<5;i++)
				{if(plr[0][1]== snkAry[i][0])
		
					plr[0][1]= snkAry[i][1];
				}
				for(i=0;i<5;i++)
					{if(plr[0][1]== ladAry[i][0])
						
					plr[0][1]= ladAry[i][1];
					}
			 			tmp1=plr[0][0]; tmp2=plr[0][1]; tmp3=plr[0][2];
		for(i=0;i<3;i++)
		{if(plr[i+1][0]==0)
		break;
		plr[i][0]=plr[i+1][0];
		plr[i][1]=plr[i+1][1];
		plr[i][2]=plr[i+1][2];
		
		}
		if( i <=3)
		{
		plr[i][0]=tmp1;
		plr[i][1]=tmp2;
		plr[i][2]=tmp3;
		}
		for(i=0;i<3;i++)
		{
			while(plr[i][0] !=0 && search(plr[i][0]) == 1)
			{
				disappear( plr[i][0]);
			}
			appear(plr[i][0],plr[i][1]);
		}
		//alt++;
			 }
			 else
			 {
			tStr1= st.nextToken();
			 n=Integer.parseInt(tStr1);
			 sndP=n;
			 if(n !=bxo)
			 {
			  tStr1= st.nextToken();
			 n=Integer.parseInt(tStr1);
			 rndN=n;
			 rCntrl=1;rollN=0;
			 }
			 }
			// System.exit(0);
		}
		else if(n==121)
		{
		t121="";
		 tStr1= st.nextToken();
		
			 n=Integer.parseInt(tStr1);
			 tmpn=n;
			 sndP=n;
			 if(n !=bxo)
			 {
			 if( cntrl==9||cntrl==5 || cntrl==11 || stat==0)
			 {
			
			 plr[0][2]=n;
			  tStr1= st.nextToken();
			  
			 n=Integer.parseInt(tStr1);
			 			 tStr="";
			 tStr="120,"+plr[0][2]+","+n+",";
			 if(sSend==1)
			 adS(tStr);
			 plr[0][1]+= plr[0][2];
				if(plr[0][1] >100) 
					plr[0][1]-= plr[0][2];
				for(i=0;i<5;i++)
				{if(plr[0][1]== snkAry[i][0])
		
					plr[0][1]= snkAry[i][1];
				}
				for(i=0;i<5;i++)
					{if(plr[0][1]== ladAry[i][0])
						
					plr[0][1]= ladAry[i][1];
					}
					tmp1=plr[0][0]; tmp2=plr[0][1]; tmp3=plr[0][2];
		for(i=0;i<3;i++)
		{if(plr[i+1][0]==0)
		break;
		plr[i][0]=plr[i+1][0];
		plr[i][1]=plr[i+1][1];
		plr[i][2]=plr[i+1][2];
		
		}
		if(i<=3)
		{
		plr[i][0]=tmp1;
		plr[i][1]=tmp2;
		plr[i][2]=tmp3;
		}
		for(i=0;i<3;i++)
		{
			while(plr[i][0] !=0 && search(plr[i][0]) == 1)
			{
				disappear( plr[i][0]);
			}
			appear(plr[i][0],plr[i][1]);
		}
		
		//alt++;
			 }
			 else
			 {
			  tStr1= st.nextToken();
			 n=Integer.parseInt(tStr1);
			 rndN=n;
			 rCntrl=1;rollN=0;
			 tStr="";
			 tStr="120,"+tmpn+","+n+",";
			 if(sSend==1)
			 adS(tStr);
			 }
			// System.exit(0);
			 }
		}
		else if(n==10)
		{
		i=0; j=0;
		
		while(st.hasMoreTokens())
			{
			 tStr1= st.nextToken();
			 n=Integer.parseInt(tStr1);
			 tplr[i][j++]=n;
			 if(j>2)
			{j=0;i++;}
			if(i>3) break;
			 
			}
			doChanges(gg);
		}
		
	}
	}
	catch(Exception e) {System.out.println(e);}
	}
	public void doChanges(Graphics gg) // do chages on board
	{
		int i,j,k,l;
		if(cntrl==10)
		{
	
		}
		if(cSend==1 && stat==0)
		{
			
				for(i=0;i<4;i++)
				{
					for(j=0;j<3;j++)
					{
						plr[i][j] = tplr[i][j];
					}
				}
			
			//plrCnt=plrCntR;
		}
		else if(sSend==1)
		{
			for(i=0;i<4;i++)
			{
				for(j=0;j<3;j++)
				{
					plr[i][j] = tplr[i][j];
				}
			}
			make();
			
		}
	}
	public static int exist( int player)
	{
		int n=-1,i;
		for(i=0;i<4;i++)
		{if(plr[i][0]== player)
			n=i;
		}
		return n;
	}
	public static int existT( int player)
	{
		int n=-1,i;
		for(i=0;i<4;i++)
		{if(tplr[i][0]== player)
			n=i;
		}
		return n;
	}
	public static int search(int player)
	{
		int i,j,k;
		for(j=0;j<10;j++)
		{
			for(k=0;k<10;k++)
			{
				
				for(i=1;i<5;i++)
				{
					if(brdAry[i][j][k]== player)
					{
						return 1;
					}
				}
				
			}
		}
		return 0;
	}
	
	public static void disappear(int player) //delete recent ie. top player from brdArray[][]
	{	
		int i,j,k,l;
		for(j=0;j<10;j++)
		{
			for(k=0;k<10;k++)
			{
				
				for(i=1;i<5;i++)
				{
					if(brdAry[i][j][k]==player)
					{
						for (l=i;l<4;l++)
							brdAry[l][j][k] = brdAry[l+1][j][k];
						brdAry[4][j][k]=0;
					}
				}
				
			}
		}
	}
	
	public static void appear( int player, int possition) // search for top ie. recent player's pos in board and put it in the board
	{	
		int i,j,k;
		for(j=0;j<10;j++)
		{
			for(k=0;k<10;k++)
			{
				if(brdAry[0][j][k] == possition)
				{
					for(i=1;i<5;i++)
					{
						if(brdAry[i][j][k]== 0)
						{
							brdAry[i][j][k] = player;
							break;
						}
					}
					break;
				}
				
			}
		}
	}
	
	public void movement(Graphics gg,int player,int start,int stop)
	{
		int i;
		for(i=start; i<=stop;i++)
		{
			while(player!=0 && search(player) == 1)
			{
				disappear( player);
			}
			appear(player,i);
			fresh(gg);
			playMoveSound(0);
			if(tempSound ==1)
				playMoveSound(1);
			try
			{
				Thread.sleep(200);
			}
			catch (Exception e) 
			{	
			}
		}
		
	}
	
	public void ascend(Graphics gg,int player,int pos1, int pos2)
	{
		int i,ii,j,k,l,tmpx,tmpy;
		int x1=0,x2=0,y1=0,y2=0;
		Image imgg=p1;
		Toolkit tt = Toolkit.getDefaultToolkit();
		for(j=0;j<10;j++)
			{
				for(k=0;k<10;k++)
				{
						if(brdAry[0][j][k]== pos1)
							{
								x1= 10+(k*110);
								y1 = 680 - (j*70);
							}
						if(brdAry[0][j][k]== pos2)
							{
								x2= 10+(k*110);
								y2 = 680 - (j*70);
							}
				}
		
			}
		
		if(player ==1)
			imgg = p1;
			else if(player==2)
			imgg=p2;
			else if(player==3)
			imgg=p3;
			else if(player==4)
			imgg=p4;
			else if(player==5)
			imgg=p5;
			
		
		while(!prepareImage(imgg,this))
				{
				}
		ii=20;
		for(i=ii;i>=0;i--)
		{
			tmpx = (((ii-i)*x2)+(i*x1))/ii;
			tmpy = (((ii-i)*y2)+(i*y1))/ii;
			gg.drawImage(imgg,tmpx,tmpy,this);
			try
			{
				Thread.sleep(30);
			}
			catch (Exception e) 
			{	
			}
			fresh (gg);
		}
		
	}
	
	public void over(Graphics gg,int player)
	{
		Toolkit tt = Toolkit.getDefaultToolkit();
		 imgx =300; imgy=200; 
		 if(player==bxo)
			img = tt.getImage("images/winner.jpg");
		
		
		 else
		 img = tt.getImage("images/clear.jpg");
		
		 
		 while(!prepareImage(img,this))
				{
				}
			gg.drawImage(img,imgx,imgy,this);
			if(player ==1)
			img = p1;
			else if(player==2)
			img=p2;
			else if(player==3)
			img=p3;
			else if(player==4)
			img=p4;
			else if(player==5)
			img=p5;
			while(!prepareImage(img,this))
				{
				}
			setFont(new Font("Arial",Font.BOLD,30));	
			Color c1 = new Color(200,0,0);
			gg.setColor(c1);
			if(player==bxo)
			{
			imgx =335;imgy=275;
			gg.drawString(pList[player],430,320);
			}
			else
			{
			imgx=320;imgy=230;
			gg.drawString(pList[player]+" cleared the game",375,260);
			}
				
			gg.drawImage(img,imgx,imgy,this);
			try
			{
				Thread.sleep(10000);
			}
			catch (Exception e) 
			{	
			}
			fresh (gg);
			
	}
	public void panelFresh(Graphics g)
	{
		int i,j=0;
		j=0;
		Toolkit t = Toolkit.getDefaultToolkit();
		Color c2 = new Color(250,250,250);
		Color c1 = new Color(0,200,0);
		Color c0 = new Color(0,0,0);
		g.setColor(c2);
		g.fillRect(1115,375,195,220);
		if(bxo != plr[0][0])
		img = t.getImage("images/wait.JPG");
		else
		img = t.getImage("images/wait2.png");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,1110,225,this);
		
		for(i=50; i<300;i+=50)
		{g.setColor(c0);
		if( j <=3 && plr[j][0] ==1) 
		{g.drawImage(p1,1120,340+i,this);
		
		g.fillRect(1170,350+i,100,10);
		g.setColor(c1);
		g.fillRect(1170,350+i,plr[j][1],10);
		g.drawString(plr[j][2]+" ",1280,360+i);
		j++;
		}
		else if(j <=3 && plr[j][0] ==2) 
		{g.drawImage(p2,1120,340+i,this);
		g.fillRect(1170,350+i,100,10);
		g.setColor(c1);
		g.fillRect(1170,350+i,plr[j][1],10);
		g.drawString(plr[j][2]+" ",1280,360+i);
		j++;
		}
		
		else if(j <=3 && plr[j][0] ==3) 
		{g.drawImage(p3,1120,340+i,this);
		g.fillRect(1170,350+i,100,10);
		g.setColor(c1);
		g.fillRect(1170,350+i,plr[j][1],10);
		g.drawString(plr[j][2]+" ",1280,360+i);
		j++;
		}
		else if(j <=3 && plr[j][0] ==4) 
		{g.drawImage(p4,1120,340+i,this);
		g.fillRect(1170,350+i,100,10);
		g.setColor(c1);
		g.fillRect(1170,350+i,plr[j][1],10);
		g.drawString(plr[j][2]+" ",1280,360+i);
		j++;
		}
		else if(j <=3 && plr[j][0] ==5) 
		{g.drawImage(p5,1120,340+i,this);
		g.fillRect(1170,350+i,100,10);
		g.setColor(c1);
		g.fillRect(1170,350+i,plr[j][1],10);
		g.drawString(plr[j][2]+" ",1280,360+i);
		j++;
		}
		else if(j <=3 && plr[j][0]==0)
		break;
		
		
		}
		imgx=1275; imgy=50;imgx1=0; img=tp;
	}
	public void fresh(Graphics gg)
	{
		Toolkit tt = Toolkit.getDefaultToolkit();
		 imgx =1; imgy=30; imgx1=1100;imgy1=700;
			img = tt.getImage("images/board.jpg");
			while(!prepareImage(img,this))
				{
				}
			gg.drawImage(img,imgx,imgy,imgx1,imgy1,this);
			for(j=0;j<10;j++)
			{
				for(k=0;k<10;k++)
				{
					for(l=1;l<5;l++)
					{
							if(brdAry[l][j][k]==1)
								img =p1;
							else if(brdAry[l][j][k]==2)
								img =p2;
							else if(brdAry[l][j][k]==3)
								img =p3;
							else if(brdAry[l][j][k]==4)
								img =p4;
							else if(brdAry[l][j][k]==5)
								img =p5;
							else if(brdAry[l][j][k]==0)
								break;
							while(!prepareImage(img,this))
							{
							}
							tmp1= 10+(k*110)+(l-1)*20;
							tmp2 = 680 - (j*70);
							gg.drawImage(img,tmp1,tmp2,this);
				}
		
			}
		}
		imgx=1275; imgy=50;imgx1=0; img=tp;
	
	}
	public void reset()
	{
		int i,j;
		String tst="";
		for(i=0;i<4;i++)
		{
			plr[i][0]=plr[i][1]=plr[i][2]=0;
		}
		sCreated=0;bxo=0;rnk=0;sSend=0;cSend=0;alt=0;alt4=0;single=0;//plrCnt=1;plrCntR=0;
		join=0;pi1=pi2=pi3=pi4=pi5=1;preCntrl=0;passWord="";originalPass="password";
		maxPlayers=4;scf=0;maxPlayersS=4;sndP=0;stat=0;diceR=0;
		//data.flush();
		//data1.flush();
		
		while(sendString.peekFirst() != null)
		{//tst = sendString.irstElement();
		sendString.removeFirst();
		}
		sendString.add("1234,");
		while(receiveString.peekFirst() != null)
		{//tst = receiveString.firstElement();
		receiveString.removeFirst();
		}
		//sendString.removeAllElements();
		//receiveString.removeAllElements();
		for(i=0;i<10;i++)
		{
			for(j=0;j<10;j++)
			{
				brdAry[1][i][j]= brdAry[2][i][j]= brdAry[3][i][j]=brdAry[4][i][j]=0;
			}
		}
		if(nfc==1) remove(nameField);
		if(pfc==1) remove(passField);
		nfc=0;pfc=0;
	}
	public static void adS(String as)
	{
		if(sSend==1 || cSend==1)
		{
			if(sendString.contains(as) == false)
			sendString.add(as);
		}
	}
	
	public void paint(Graphics g) 
	{
		if(single==0) 
		scan(g);
		//if(cntrl ==-1) reset();
		if(musicCl==1)                 // play music if selected
		{
			if(tempMusic ==1)
			playMusic(1);
			else
			playMusic(0);
			musicCl=0;
		}
		if(sndCl==1)                  // play click sound if selected
		{
			playSound(0);
			if(tempSound ==1)
			playSound(1);
			sndCl=0;
		}
		setFont(new Font("Arial",Font.BOLD,30));
		Color c2 = new Color(250,250,250);
		Color c1 = new Color(0,200,0);
		Color c0 = new Color(0,0,0);
		Toolkit t = Toolkit.getDefaultToolkit();
		p1 = t.getImage("images/p1.gif");
		p2 = t.getImage("images/p2.gif");
		p3 = t.getImage("images/p3.gif");
		p4 = t.getImage("images/p4.gif");
		p5 = t.getImage("images/p5.gif");
		box = t.getImage("images/box.gif");
		r1 = t.getImage("images/ror1.gif");
		r2 = t.getImage("images/ror2.gif");
		r21 = t.getImage("images/rol21.gif");
		r22 = t.getImage("images/rol22.gif");
		r23 = t.getImage("images/rol23.gif");
		r24 = t.getImage("images/rol24.gif");
		r25 = t.getImage("images/rol25.gif");
		r4 = t.getImage("images/ror4.gif");
		r0 = t.getImage("images/ror.gif");
		
		if(sCreated==1 && cntrl==9 && maxPlayers==0 || sCreated==1 && cntrl==9 && maxPlayersS==0)
		{
		img = t.getImage("images/gogogo.png");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,620,430,this);
		}
		
		
		if(bxo==0 && plr[0][0] !=0)
		bxo=plr[0][0];
		
		if(bxo ==0)
		{
		if(pi1==1)                    // initialise temporary select for first time
		{tp=p1;bxo=1;}
		else if(pi2==1)
		{tp=p2;bxo=2;}
		else if(pi3==1)
		{tp=p3;bxo=3;}
		else if(pi4==1)
		{tp=p4;bxo=4;}
		else if(pi5==1)
		{tp=p5;bxo=5;}
		
		}
		
		while(!prepareImage(r1,this)||!prepareImage(p1,this)|| !prepareImage(p2,this)|| !prepareImage(p3,this)|| !prepareImage(p4,this)|| !prepareImage(p5,this)|| !prepareImage(box,this))
		{
		}
		while(!prepareImage(r4,this)||!prepareImage(r0,this)||!prepareImage(r2,this)||!prepareImage(r21,this)||!prepareImage(r22,this)||!prepareImage(r23,this)||!prepareImage(r24,this)||!prepareImage(r25,this))
		{
		}
		if( ++ms1 >100 && rollN >=1)
		{ms1 =0;
		rndN= rnd.nextInt(6);
		rndN++;
		if(rndN >=7) rndN=6;
		
		if(cntrl!=10 && rCntrl==0)
		{g.drawImage(r4,810,510,this);
		
		g.setColor(c1);
		
		if(ad==1)
		rndN=6;  		                         // needed to b removed
		g.drawString(rndN+" ",833,547);
		
		if(ric==1)
		{ric= 2;
		tr = r1;
		rollN--;
		
		}
		else
		{ric = 1;
		tr=r2;
		rollN--;
		}
		}
		else
		{rCntrl=1;
		g.setColor(c2);
		g.fillRect(1279,271,35,35);
		g.setColor(c1);
		g.drawString(rndN+" ",1285,300);
		if(ric==1)
		{ric= 2;
		tr = r22;
		rollN--;
		}
		else if(ric==2)
		{ric= 3;
		tr = r23;
		rollN--;
		
		}
		else if(ric==3)
		{ric= 4;
		tr = r24;
		rollN--;
		
		}
		else if(ric==4)
		{ric= 1;
		tr = r25;
		rollN--;
		
		}
		img =tr; imgx=1220;imgy=275;imgx1=0;
		g.drawImage(tr,1220,275,this);
		}
		}
		if(rCntrl==1&& rollN==0 )
		{ rCntrl=0;alt=1;
			if(sndP ==bxo)
			{
			tmpStr="";
			tmpStr="121,"+bxo+","+rndN+",";
			adS(tmpStr);
			}
			sndP=0;
		plr[0][2]=rndN;
		
		if(cRoll==0)
		cRoll=1;
		else
		cRoll=0;
		
		while(plr[0][0] !=0 && search(plr[0][0])==1)
		{
			disappear(plr[0][0]);
		}
		plr[0][1]+= plr[0][2];
		if(plr[0][1] >100) 
		plr[0][1]-= plr[0][2];
		else
		{
			movement(g,plr[0][0],plr[0][1]-plr[0][2]+1,plr[0][1]);
			if(plr[0][1]==100)
			{
				over(g,plr[0][0]);
				if(single==1)
				{term=1;
				cntrl=-1;
				}
				if(plr[0][0]==bxo)
				user=plr[0][1];
				else
				{plr[0][0]=0;plr[0][1]=0;plr[0][2]=0;
				}
			
			}
		}
		
		for(i=0;i<5;i++)
		{if(plr[0][1]== snkAry[i][0])
		{
		disappear(plr[0][0]);
		plr[0][1]= snkAry[i][1];
					playLadderSound(0);
			if(tempSound ==1)
				playSnakeSound(1);
				try
			{
				Thread.sleep(500);
			}
			catch (Exception e) 
			{	
			}
		}
		}
		for(i=0;i<5;i++)
		{if(plr[0][1]== ladAry[i][0])
		{
		disappear(plr[0][0]);
		playLadderSound(0);
		if(tempSound ==1)
				playLadderSound(1);
		ascend(g,plr[0][0],ladAry[i][0],ladAry[i][1]);
		plr[0][1]= ladAry[i][1];
					
			
		}
		
		}
		//plr[0][2]= rndN;
		
		g.drawImage(r21,1220,275,this);
		img = t.getImage("images/board.jpg");
		imgx =1; imgy=30; imgx1=1100;imgy1=700;allow=0;
		if(cntrl==5)
		{cntrl=5;imgx=600;imgy=300;imgx1=0;allow=0;repeat=2;preCntrl=10;
		img = t.getImage("images/set3.gif");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,imgx,imgy,this);
		
		}
		if(cntrl==11)
		{
          cntrl=11;imgx=600;imgy=300;imgx1=0;allow=0;repeat=2;preCntrl=10;
		img = t.getImage("images/exit.gif");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,imgx,imgy,this);
		}
		}
		if( ric==0 ||rollN ==0 ) tr=r0;
		if(cntrl==9 && ric!=0 && rollN==0 && rndN ==6)
		{
		cntrl =10;stat=1;
		imgx =1; imgy=30; imgx1=1100;imgy1=700;allow=0;sndCl=1;
		img = t.getImage("images/board.jpg");
		img1 = t.getImage("images/panel.gif");
		if(bxo==1)
		tp=p1;
		else if(bxo==2)
		tp=p2;
		else if(bxo==3)
		tp=p3;
		else if(bxo==4)
		tp=p4;
		else if(bxo==5)
		tp=p5;
		for(i=0;i<4;i++)
		{if(plr[i][0] == bxo)
		break;
		if(plr[i][0]==0)
		{plr[i][0]=bxo;
		plr[i][1]=1;
		brdAry[1][0][0]=bxo;
		break;
		}
		}
		for(j=0;j<10;j++)
		{for(k=0;k<10;k++)
		{
		for(i=0;i<4;i++)
		{
		if(plr[i][1]== brdAry[0][j][k])
		{for(l=1;l<5;l++)
		{if(brdAry[l][j][k]==plr[i][0])
		brdAry[l][j][k]= 0;
		}
		for(l=1;l<5;l++)
		{if(brdAry[l][j][k]==0)
		{brdAry[l][j][k]= plr[i][0];
		break;
		}
		}
		}
		}
		}
		}
		
		while(!prepareImage(tp,this)||!prepareImage(img,this)||!prepareImage(img1,this))
		{
		}
		g.drawImage(img,imgx,imgy,imgx1,imgy1,this);
		g.drawImage(img1,1101,30,230,697,this);
		g.drawImage(tp,1275,50,this);
		if(plr[0][0] !=bxo)
		{
		img = t.getImage("images/wait.JPG");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,1110,225,this);
		img=tp;
		}
		fresh(g);
		imgx=1275; imgy=50;imgx1=0; img=tp;
		
		
		
		g.setColor(c1);
		j= pName.length();
		if(j>7) j=7;
		if(j==0) 
		{
		pName="PLAYER";
		j=6;
		}
		
		pName= pName.substring(0,j);
		g.drawString(pName+" ",1115,70);
		for(j=0;j<4;j++)
		{if(plr[j][0]==bxo)
		break;
		}
		i=(int)(plr[j][1]*1.45);
		//plr[j][2]=6;
		g.fillRect(1108,196,i,20);
		g.drawString(plr[j][1]+" ",1262,220);
		rnk=1;
		for(i=0;i<4;i++)
		{if(plr[i][1] > plr[j][1])
		rnk++;
		}
		
		g.drawString(rnk+" ",1270,165);
		//g.setColor(c2);
		//for(i=0; i<60;i+=20)
		//g.fillOval(1222+i,285,13,13);
		j=0;
		for(i=50; i<300;i+=50)
		{g.setColor(c0);
		if( j <=3 && plr[j][0] ==1) 
		{g.drawImage(p1,1120,340+i,this);
		
		g.fillRect(1170,350+i,100,10);
		g.setColor(c1);
		g.fillRect(1170,350+i,plr[j][1],10);
		g.drawString(plr[j][2]+" ",1280,360+i);
		j++;
		}
		else if(j <=3 && plr[j][0] ==2) 
		{g.drawImage(p2,1120,340+i,this);
		g.fillRect(1170,350+i,100,10);
		g.setColor(c1);
		g.fillRect(1170,350+i,plr[j][1],10);
		g.drawString(plr[j][2]+" ",1280,360+i);
		j++;
		}
		
		else if(j <=3 && plr[j][0] ==3) 
		{g.drawImage(p3,1120,340+i,this);
		g.fillRect(1170,350+i,100,10);
		g.setColor(c1);
		g.fillRect(1170,350+i,plr[j][1],10);
		g.drawString(plr[j][2]+" ",1280,360+i);
		j++;
		}
		else if(j <=3 && plr[j][0] ==4) 
		{g.drawImage(p4,1120,340+i,this);
		g.fillRect(1170,350+i,100,10);
		g.setColor(c1);
		g.fillRect(1170,350+i,plr[j][1],10);
		g.drawString(plr[j][2]+" ",1280,360+i);
		j++;
		}
		else if(j <=3 && plr[j][0] ==5) 
		{g.drawImage(p5,1120,340+i,this);
		g.fillRect(1170,350+i,100,10);
		g.setColor(c1);
		g.fillRect(1170,350+i,plr[j][1],10);
		g.drawString(plr[j][2]+" ",1280,360+i);
		j++;
		}
		else if(j <=3 && plr[j][0]==0)
		break;
		
		
		}
		
		}
		if(cntrl==9)
		{img=tr;
		while(!prepareImage(img,this))
		{
		}
		}
		if(term==1 && single==1)
		{
		cntrl=-1;join=0;term=0;alt=0;user=0;
		allow=0;sndCl=1; preCntrl=0;rollN=0;rndN=0;ric=0;
		single=0;
		if(search(bxo)==1)
		{disappear(bxo);
		}
		if(search(cmpBxo)==1)
		{disappear(cmpBxo);
		}
		for(j=0;j<4;j++)
		{if(plr[j][0]==bxo)
		break;
		}
		for(i=0;i<4;i++)
		{
		if(plr[i][0]!=0 && search(plr[i][0])==1)
		{disappear(plr[i][0]);
		}
		}
		//plr[j][0]=0;plr[j][1]=0; plr[j][2]=0;bxo=0;
		
		if(j==4) j=3;
		for(i=j;i<3;i++)
		{
		
		plr[i][0]=plr[i+1][0];
		plr[i][1]=plr[i+1][1];
		plr[i][2]=plr[i+1][2];
		}
		plr[i][0]=0;plr[i][1]=0; plr[i][2]=0;bxo=1;cmpBxo=2;
		for(i=0;i<4;i++)
		{
		plr[i][0]=plr[i][1]=plr[i][2]=0;
		}
		}
		if(cntrl==-1)       // main screen image display
		{img = t.getImage("images/1.jpg");
		while(!prepareImage(img,this))
		{
		}
		reset();
		cntrl=0;imgx=1;imgy=1;imgx1=1350;imgy1=740;term=0;allow=0;cRoll=0;
		}
		//else if(alt==0&&allow==1&& rCntrl==0 && cntrl==10&& plr[0][0]==bxo&& user>=100)
		//{
		//alt=1;
		//}
		else if(allow==1&& cntrl==11 && mx>=635 && mx <=760 && my>=455 && my<=485)
		{cntrl=-1;join=0;
		allow=0;sndCl=1; preCntrl=0;rollN=0;rndN=0;ric=0;
		single=0;
		if(sSend==1) adS("0,");
		if(cSend==1)
			{
			//adS( ("1,"+bxo+","));
			sSend=0;
			if(bxo==1)
		{pi1=1;adS("31,");}
		else if (bxo==2)
		{pi2=1; adS("41,");}
		else if (bxo==3)
		{pi3=1; adS("51,");}
		else if (bxo==4)
		{pi4=1; adS("61,");}
		else if (bxo==5)
		{pi5=1; adS("71,");}
		if(cSend==1 || sSend==1)
		{
		for(tmp1=0;tmp1 <4;tmp1++)
		{if(plr[tmp1][0]==bxo)
		break;
		}
		for(tmp2=tmp1;tmp2<3;tmp2++)
		{plr[tmp2][0]=plr[tmp2+1][0];
		plr[tmp2][1]=plr[tmp2+1][1];
		}
		plr[3][0]=plr[3][1]=0;
		bxo=0;
		make();
		}
			}
		//allowSend=1;
		while(sendString.peekFirst() != null)
		{
		try
		{
		Thread.sleep(500);
		}
		catch(Exception e){}
		}
		 sSend=0;
		 cSend=0;
		 sCreated=0;
		//sendString="";
		if(search(bxo)==1)
		{disappear(bxo);
		}
		for(j=0;j<4;j++)
		{if(plr[j][0]==bxo)
		break;
		}
		for(i=0;i<4;i++)
		{
		if(plr[i][0]!=0 && search(plr[i][0])==1)
		{disappear(plr[i][0]);
		}
		}
		//plr[j][0]=0;plr[j][1]=0; plr[j][2]=0;bxo=0;
		
		if(j==4) j=3;
		for(i=j;i<3;i++)
		{
		
		plr[i][0]=plr[i+1][0];
		plr[i][1]=plr[i+1][1];
		plr[i][2]=plr[i+1][2];
		}
		plr[i][0]=0;plr[i][1]=0; plr[i][2]=0;bxo=plr[0][0];
		reset();
		}
		
		else if(single==1&&cntrl !=-1 &&rollN==0&& cRoll==1&& rCntrl==0)
		{
		cntrl=10;allow=0;sndCl=1;
		rollN = rnd.nextInt(30);
		rollN++;
		ric=1;
		//cRoll=0;
		fresh(g);
		try
			{
				Thread.sleep(300);
			}
			catch (Exception e) 
			{	
			}
		}
		else if(allow==1&& rCntrl==0 && cntrl==10 && mx>=1110 && mx <=1220 && my>=270 && my<=310 && plr[0][0]==bxo || ad==1 && allow==1&& rCntrl==0 && cntrl==10 && mx>=1110 && mx <=1220 && my>=270 && my<=310)
		{
		cntrl=10;allow=0;sndCl=1;
		rollN = rnd.nextInt(30);
		rollN++;
		ric=1;
		sndP=bxo;
		//cRoll=1;
		img = t.getImage("images/wait.JPG");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,1110,225,this);
		img=tp;
		}
		else if(alt>=1 || allow==1&& rCntrl==0 && cntrl==10 && mx>=880 && mx <=990 && my>=30 && my<=100&& ad==1)
		{alt--;
		cntrl=10;allow=0;sndCl=1;
		//rollN = rnd.nextInt(30);
		//rollN++;
		//ric=1;
		tmp4=0;
		do
		{
		tmp1=plr[0][0]; tmp2=plr[0][1]; tmp3=plr[0][2];tmp4++;
		for(i=0;i<3;i++)
		{if(plr[i+1][0]==0)
		break;
		plr[i][0]=plr[i+1][0];
		plr[i][1]=plr[i+1][1];
		plr[i][2]=plr[i+1][2];
		
		}
		plr[i][0]=tmp1;
		plr[i][1]=tmp2;
		plr[i][2]=tmp3;
		}while(plr[0][1] ==100&&tmp4<6);
		//make();
		cntrl=9 ;ric=1 ; rollN=0 ; rndN =6;
		}
		else if(allow==1&& cntrl==0 && mx>=620 && mx <=930 && my>=480 && my<=540)
		{img = t.getImage("images/MENU.JPG");
		while(!prepareImage(img,this))
		{
		}
		imgx =600; imgy=100; imgx1=0;cntrl=1;allow=0;sndCl=1;
		}
		else if(allow==1&& cntrl==0 && mx>=620 && mx <=930 && my>=560 && my<=620)
		{
		System.exit(0);
		}
		else if(allow==1&& cntrl==0 && mx>=700 && mx <=840 && my>=630 && my<=700)
		{img = t.getImage("images/rules.png");
		while(!prepareImage(img,this))
		{
		}
		imgx =300; imgy=100; imgx1=0;cntrl=2;allow=0;sndCl=1;
		}
		else if(allow==1&& cntrl==2 && mx >=830 && mx <=930 && my >=520 && my <=570)
		{cntrl=-1;
		imgx=1;imgy=1;imgx1=1350;imgy1=740;allow=0;sndCl=1;
		}
		else if(allow==1&& cntrl==1 && mx >=720 && mx <=820 && my >=530 && my <=570)
		{cntrl=-1;
		imgx=1;imgy=1;imgx1=1350;imgy1=740;allow=0;sndCl=1;
		}
		else if(allow==1&& cntrl==1 && mx>=615 && mx<=920 && my>=225 && my<=275)
		{cntrl=3;imgx=600;imgy=300;imgx1=0;allow=0;repeat=2;sndCl=1;
		//port1=1234;port2=2234;
		/*if(single==0) 
		sSend=1;
		cSend=0;*/
		//sCreated=1;
		img = t.getImage("images/server.jpg");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,imgx,imgy,this);
		
		}
		else if(allow==1&& cntrl==1 && mx>=615 && mx<=920 && my>=445 && my<=505)
		{cntrl=7;imgx=610;imgy=220;imgx1=0;allow=0;sndCl=1;
		
		img = t.getImage("images/thanks.png");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,imgx,imgy,this);
		
		}
		else if(allow==1&& cntrl==7 && mx>=710 && mx<=830 && my>=420 && my<=450)
		{cntrl=1;imgx=600;imgy=100;imgx1=0;allow=0;sndCl=1;
		
		img = t.getImage("images/MENU.JPG");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,imgx,imgy,this);
		
		}
		
		else if(allow==1&& cntrl==1 && mx>=615 && mx<=920 && my>=380 && my<=435)
		{cntrl=5;imgx=600;imgy=300;imgx1=0;allow=0;repeat=2;sndCl=1;
		img = t.getImage("images/set3.gif");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,imgx,imgy,this);
		tempSound=sound;tempMusic=music;
		}
		else if(allow==1&& cntrl==10 && mx>=1145 && mx<=1270 && my>=620 && my<=670)
		{cntrl=5;imgx=600;imgy=300;imgx1=0;allow=0;repeat=2;sndCl=1;preCntrl=10;
		img = t.getImage("images/set3.gif");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,imgx,imgy,this);
		
		}
		else if(allow==1&& cntrl==10 && mx>=1145 && mx<=1270 && my>=680 && my<=715)
		{cntrl=11;imgx=600;imgy=300;imgx1=0;allow=0;repeat=2;sndCl=1;preCntrl=10;
		img = t.getImage("images/exit.gif");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,imgx,imgy,this);
		
		}
		else if(allow==1&& cntrl==5 && mx>=630 && mx<=760 && my>=530 && my<=560)
		{cntrl=1;imgx=600;imgy=100;imgx1=0;allow=0;sndCl=1;musicCl=1;
		if(music==1 && tempMusic==1) musicCl=0;
		img = t.getImage("images/MENU.JPG");
		while(!prepareImage(img,this))
		{
		}
		
		if(preCntrl==10)
		{
		preCntrl=0;cntrl=10;imgx =1; imgy=30; imgx1=1100;imgy1=700;allow=0;sndCl=1;
		fresh(g);
		panelFresh(g);
		imgx=1275; imgy=50;imgx1=0; img=tp;
		
		}
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,imgx,imgy,this);
		sound=tempSound; music=tempMusic;
		}
		else if(allow==1&& cntrl==11 && mx>=785 && mx<=900 && my>=450 && my<=480)
		{
		preCntrl=0;cntrl=10;imgx =1; imgy=30; imgx1=1100;imgy1=700;allow=0;sndCl=1;
		fresh(g);
		panelFresh(g);
		imgx=1275; imgy=50;imgx1=0; img=tp;
		
		}
		else if(allow==1&& cntrl==5 && mx>=840 && mx<=910 && my>=370 && my<=420)
		{cntrl=5;imgx=850;imgy=375;imgx1=0;allow=0;sndCl=1;
		img1 = t.getImage("images/TICK.gif");
		img2 = t.getImage("images/CROSS.gif");
		while(!prepareImage(img1,this)||!prepareImage(img2,this))
		{
		}
		
		if(tempSound==0)
		{
		tempSound=1;
		img = img1;
		}
		else
		{
		tempSound=0;
		img=img2;
		}
		}
		else if(allow==1&& cntrl==5 && mx>=840 && mx<=910 && my>=450 && my<=500)
		{cntrl=5;imgx=850;imgy=455;imgx1=0;allow=0;musicCl=1;sndCl=1;
		img1 = t.getImage("images/TICK.gif");
		img2 = t.getImage("images/CROSS.gif");
		while(!prepareImage(img1,this)||!prepareImage(img2,this))
		{
		}
		
		if(tempMusic==0)
		{
		tempMusic=1;
		img = img1;
		}
		else
		{
		tempMusic=0;
		img=img2;
		}
		}
		
		else if(allow==1&& cntrl==5 && mx>=790 && mx<=920 && my>=530 && my<=560)
		{cntrl=1;imgx=600;imgy=100;imgx1=0;allow=0;sndCl=1;musicCl=1;
	    if(music==1)
		 musicCl=0;
		if(sound==0)
		sndCl=0;
		img = t.getImage("images/MENU.JPG");
		if(preCntrl==10)
		{
		preCntrl=0;cntrl=10;imgx =1; imgy=30; imgx1=1100;imgy1=700;allow=0;sndCl=1;
		fresh(g);
		panelFresh(g);
		imgx=1275; imgy=50;imgx1=0; img=tp;
		}
		g.drawImage(img,imgx,imgy,this);
		
		tempSound=sound;tempMusic=music;
		}
		else if(allow==1&& cntrl==3 && mx>=750 && mx<=890 && my>=570 && my<=620)
		{cntrl=1; imgx = 600;imgy=100;imgx1=0;allow=0;sndCl=1;
		sSend=0;cSend=0;sCreated=0;
		img = t.getImage("images/MENU.JPG");
		while(!prepareImage(img,this))
		{
		}
		}
		else if(allow==1&& cntrl==1 && mx>=615 && mx<=920 && my>=300 && my<=355)
		{cntrl=4;join=1; imgx = 600;imgy=300;imgx1=0;allow=0;sndCl=1;repeat=2;preCntrl=1;
		//port1=2234; port2=1234;
		sCreated=0;
		img = t.getImage("images/player1.jpg");
		while(!prepareImage(img,this))
		{
		}
		if(single==0)
		cSend=1;
		sSend=0;
		
		}
		else if(cntrl==4&& alt4==1 && sCreated ==1 && join==1)
		{cntrl=4;join=1; imgx = 600;imgy=300;imgx1=0;allow=0;sndCl=1;repeat=2;preCntrl=1;
		//port1=2234; port2=1234;
		alt4=0;
		img = t.getImage("images/player1.jpg");
		while(!prepareImage(img,this))
		{
		}
		if(single==0)
		cSend=1;
		sSend=0;
		}
		else if(allow==1&& cntrl==1 && mx>=615 && mx<=920 && my>=150 && my<=200)
		{cntrl=3;single=1; imgx = 600;imgy=300;imgx1=0;allow=0;sndCl=1;repeat=2;preCntrl=1;
		pi1=1;pi2=1;pi3=1;pi4=1;pi5=1;
		for(i=0;i<4;i++)
		{
			plr[i][0]=plr[i][1]=plr[i][2]=0;
			
		}
		img = t.getImage("images/player1.jpg");
		while(!prepareImage(img,this))
		{
		}
		}
		else if(allow==1&& cntrl==3 && mx>=610 && mx<=860 && my>=370 && my<=400)
		{cntrl=3; imgx = 625;imgy=380;imgx1=0;allow=0;sndCl=1;
		img = t.getImage("images/server.jpg");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,600,300,this);
		img = t.getImage("images/dot.gif");
		while(!prepareImage(img,this))
		{
		}
		maxPlayers=2;
		}
		else if(allow==1&& cntrl==3 && mx>=610 && mx<=860 && my>=435 && my<=465)
		{cntrl=3; imgx = 625;imgy=440;imgx1=0;allow=0;sndCl=1;
		img = t.getImage("images/server.jpg");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,600,300,this);
		img = t.getImage("images/dot.gif");
		while(!prepareImage(img,this))
		{
		}
		maxPlayers=3;
		}
		else if(allow==1&& cntrl==3 && mx>=610 && mx<=860 && my>=500 && my<=530)
		{cntrl=3; imgx = 625;imgy=510;imgx1=0;allow=0;sndCl=1;
		img = t.getImage("images/server.jpg");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,600,300,this);
		img = t.getImage("images/dot.gif");
		while(!prepareImage(img,this))
		{
		}
		maxPlayers=4;
		}
		else if(allow==1&& cntrl==3 && mx>=610 && mx<=730 && my>=570 && my<=620)
		{cntrl=4;join=0;imgx=600;imgy=300;imgx1=0;allow=0;repeat=2;sndCl=1;preCntrl=3;
		img = t.getImage("images/player1.jpg");
		while(!prepareImage(img,this))
		{
		}
		l=1;
		for(i=0;i<4;i++)
		{
		plr[i][0]=plr[i][2]=0;
		plr[i][1]=0;
		}
		
		
		}
		
		else if(allow==1&& cntrl==13 && mx>=580 && mx<=720 && my>=580 && my<=610)
		{cntrl=9; imgx = 685;imgy=505;imgx1=0;allow=0;sndCl=1;
		//port1=2234;port2=1234;
		sSend=0;
		if(single !=1)
		cSend=1; // playing as client
		passWord= passField.getText();
		try
		{
		Thread.sleep(300);
		}
		catch (Exception e){}
		tmp1=0;
		if(join==0 && sCreated==1)
		tmp1=1;
		
		else if(join==0 && sCreated==0) // playing as server
		{
		originalPass = passField.getText();
		//port1=1234;port2=2234;
		if(single==0)
		{sSend=1;
		cSend=0;
		sCreated=1;
		}
		}
		if(passWord.equals(originalPass) && tmp1==0)
		cntrl=9;
		else 
		cntrl=-1;
		if(join==1 && sCreated==0)
		{ 
		cntrl=-1;cSend=0;
		}
		
		remove(passField);
		pfc=0;
		img = t.getImage("images/1.jpg");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,1,1,1350,740,this);
		img = t.getImage("images/roll.gif");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,630,470,this);
		if(bxo==0)
		img=tp;
		else
		{if(bxo==1)
		img=p1;
		else if(bxo==2)
		img=p2;
		else if(bxo==3)
		img=p3;
		else if(bxo==4)
		img=p4;
		else if(bxo==5)
		img=p5;
		}
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,640,480,this);
		img = t.getImage("images/others.png");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,620,430,this);
		img=r0;
		while(!prepareImage(img,this))
		{
		}
		}
		else if(rollN==0&& allow==1&& cntrl==9 && mx>=650 && mx<=750 && my>=590 && my<=620)
		{
			if(sCreated==0 || sCreated==1 && maxPlayers==0 || sCreated==1 && maxPlayersS==0)
			{
			cntrl=9; imgx=685;imgy=505;imgx1=0;allow=0;sndCl=1;rollN=50;ric=1;
			rollN = rnd.nextInt(50);
			rollN++;
			img = r1;
			while(!prepareImage(img,this))
			{
			}
			}
			else
			{
			cntrl=9;
			}
		
		}
		else if(allow==1&& cntrl==9 && mx>=770 && mx<=870 && my>=590 && my<=620)
		{cntrl=-1;join=0; imgx=1;imgy=1;imgx1=1350;imgy1=740;allow=0;sndCl=1;ric=0;

		if(cSend==1)
			{
			//adS( ("1,"+bxo+","));
			sSend=0;
			if(bxo==1)
		{pi1=1;adS("31,");}
		else if (bxo==2)
		{pi2=1; adS("41,");}
		else if (bxo==3)
		{pi3=1; adS("51,");}
		else if (bxo==4)
		{pi4=1; adS("61,");}
		else if (bxo==5)
		{pi5=1; adS("71,");}
		if(cSend==1 || sSend==1)
		{
		for(tmp1=0;tmp1 <4;tmp1++)
		{if(plr[tmp1][0]==bxo)
		break;
		}
		for(tmp2=tmp1;tmp2<3;tmp2++)
		{plr[tmp2][0]=plr[tmp2+1][0];
		plr[tmp2][1]=plr[tmp2+1][1];
		}
		plr[3][0]=plr[3][1]=0;
		bxo=0;
		make();
		}
			}
		if(sSend==1) adS( "0,");
		//allowSend=1;
		while(sendString.peekFirst() != null)
		{
		try
		{
		Thread.sleep(500);
		}
		catch(Exception e){}
		}
		sSend=0;cSend=0;
		sCreated=0;
		//sendString="";
	
		
		img = t.getImage("images/1.jpg");
		while(!prepareImage(img,this))
		{
		}
		reset();
		}
		else if(allow==1&& cntrl==8 && mx>=750 && mx<=900 && my>=580 && my<=610)
		{cntrl=4;imgx=600;imgy=300;imgx1=0;allow=0;sndCl=1;repeat=2;join=0;
		remove(nameField);
		nfc=0;
		
		//reset();
		if(bxo==1)
		{pi1=1;
		if(cSend==1)
		adS("31,");}
		else if (bxo==2)
		{pi2=1; 
		if(cSend==1)
		adS("41,");}
		else if (bxo==3)
		{pi3=1;
		if(cSend==1)
		adS("51,");}
		else if (bxo==4)
		{pi4=1; 
		if(cSend==1)
		adS("61,");}
		else if (bxo==5)
		{pi5=1;
		if(cSend==1)
		adS("71,");}
		if(cSend==1 || sSend==1)
		{
		for(tmp1=0;tmp1 <4;tmp1++)
		{if(plr[tmp1][0]==bxo)
		break;
		}
		for(tmp2=tmp1;tmp2<3;tmp2++)
		{plr[tmp2][0]=plr[tmp2+1][0];
		plr[tmp2][1]=plr[tmp2+1][1];
		}
		plr[3][0]=plr[3][1]=0;
		}
		//bxo=0;
		if (cSend==1) 
		make();
		if(sSend==1) preCntrl=3;
		
		img = t.getImage("images/1.jpg");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,1,1,1350,740,this);
		img = t.getImage("images/MENU.JPG");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,600,100,this);
		img = t.getImage("images/server.jpg");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,600,300,this);
		img = t.getImage("images/player1.jpg");
		while(!prepareImage(img,this))
		{
		}
		}
		else if(allow==1&& cntrl==8 && mx>=580 && mx<=720 && my>=580 && my<=610)
		{if (single==0)
		{
		cntrl=13;imgx=550;imgy=450;imgx1=0;allow=0;sndCl=1;
		img = t.getImage("images/pass.gif");
		while(!prepareImage(img,this))
		{
		}
		pName= nameField.getText();
		
		if(pName.length()==0)
		pName="PLAYER";
		else
		{j= pName.length();
		if(j>7) j=7;
		if(j==0) 
		{
		pName="PLAYER";
		j=6;
		}
		
		pName= pName.substring(0,j);
		}
		pList[bxo]=pName;
		remove(nameField);
		nfc=0;
		add(passField); 
		pfc=1;
		g.drawImage(img,imgx,imgy,this);
		}
		else
		{
		cntrl=9; imgx = 685;imgy=505;imgx1=0;allow=0;sndCl=1;
		pName= nameField.getText();
		
		remove(nameField);
		nfc=0;
		img = t.getImage("images/1.jpg");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,1,1,1350,740,this);
		img = t.getImage("images/roll.gif");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,630,470,this);
		if(bxo==0)
		img=tp;
		else
		{if(bxo==1)
		img=p1;
		else if(bxo==2)
		img=p2;
		else if(bxo==3)
		img=p3;
		else if(bxo==4)
		img=p4;
		else if(bxo==5)
		img=p5;
		}
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,640,480,this);
		img=r0;
		while(!prepareImage(img,this))
		{
		}
		
		}
		if(bxo==1)
		{pi1=0;adS(("30,"+pName+","));}
		else if(bxo==2)
		{pi2=0;adS("40,"+pName+",");}
		else if(bxo==3)
		{pi3=0;adS("50,"+pName+",");}
		else if(bxo==4)
		{pi4=0;adS("60,"+pName+",");}
		else if(bxo==5)
		{pi5=0;adS("70,"+pName+",");}
		}
		else if(allow==1&& cntrl==13 && mx>=750 && mx<=900 && my>=580 && my<=610)
		{cntrl=8;imgx=870;imgy=510;imgx1=0;allow=0;sndCl=1;
		
		img = t.getImage("images/name.gif");
		while(!prepareImage(img,this))
		{
		}
		add(nameField); 
		nfc=1;
		remove(passField);
		pfc=0;
		g.drawImage(img,550,450,this);
		if(bxo==0)
		img=tp;
		else
		{if(bxo==1)
		img=p1;
		else if(bxo==2)
		img=p2;
		else if(bxo==3)
		img=p3;
		else if(bxo==4)
		img=p4;
		else if(bxo==5)
		img=p5;
		}
		while(!prepareImage(img,this))
		{
		}
		 if(preCntrl==3)
		 {preCntrl=0;
		 for(i=0;i<5;i++)
		{for(j=0;j<10;j++)
		{
		for(k=0;k<=9;k++)
		{if(i==0)
		{
		if(j%2==0)
		brdAry[i][j][k]= l++;
		else
		brdAry[i][j][9-k]=l++;
		}
		else
		brdAry[i][j][k]=0;
		}
		}
		}
		
		if(bxo==0)
		{
		if(pi1==1)                    // initialise temporary select for first time
		{tp=p1;bxo=1;}
		else if(pi2==1)
		{tp=p2;bxo=2;}
		else if(pi3==1)
		{tp=p3;bxo=3;}
		else if(pi4==1)
		{tp=p4;bxo=4;}
		else if(pi5==1)
		{tp=p5;bxo=5;}
		//brdAry[0][0][0]=bxo;
		//plr[0][0] = bxo;
		}
		tmp1=0;
		while(plr[tmp1][0]!=0)
		{
		tmp1++;
		}
		if(tmp1 <4)
		{plr[tmp1][0]=bxo;
		plr[tmp1][1]=1;
		//plr[0][0]=bxo;
		//plr[0][1]=1;
		make();
		}
		
		 }
		 
		}
		else if(allow==1&& cntrl==4 && mx>=610 && mx<=740 && my>=590 && my<=620)
		{cntrl=8;imgx=870;imgy=510;imgx1=0;allow=0;sndCl=1;
		
			img = t.getImage("images/name.gif");
			while(!prepareImage(img,this))
			{
			}
			add(nameField); 
			nfc=1;
			g.drawImage(img,550,450,this);
			if(single==1)
			{
				cmpBxo=bxo+1;
				if(cmpBxo>5)
				cmpBxo=1;
				plr[1][0]=cmpBxo;
				plr[1][1]=plr[1][2]=1;
			}
			if(bxo==0)
				img=tp;
			else
			{
				if(bxo==1)
				img=p1;
				else if(bxo==2)
				img=p2;
				else if(bxo==3)
				img=p3;
				else if(bxo==4)
				img=p4;
				else if(bxo==5)
				img=p5;
			}
		while(!prepareImage(img,this))
		{
		}
		if(preCntrl==3)
		{preCntrl=0;
		 for(i=0;i<5;i++)
		{
			for(j=0;j<10;j++)
			{
				for(k=0;k<=9;k++)
				{
					if(i==0)
					{
					if(j%2==0)
					brdAry[i][j][k]= l++;
					else
					brdAry[i][j][9-k]=l++;
					}
				else
				brdAry[i][j][k]=0;
				}
			}
		}
		
		if(bxo==0)
		{
		if(pi1==1)                    // initialise temporary select for first time
		{tp=p1;bxo=1;pi1=0;}
		else if(pi2==1)
		{tp=p2;bxo=2;pi2=0;}
		else if(pi3==1)
		{tp=p3;bxo=3;pi3=0;}
		else if(pi4==1)
		{tp=p4;bxo=4;pi4=0;}
		else if(pi5==1)
		{tp=p5;bxo=5;pi5=0;}
		//brdAry[0][0][0]=bxo;
		//plr[0][0] = bxo;
		}
		else if(bxo==1)
		{pi1=0;}
		else if(bxo==2)
		{pi2=0;}
		else if(bxo==3)
		{pi3=0;}
		else if(bxo==4)
		{pi4=0;}
		else if(bxo==5)
		{pi5=0;}
		tmp1=0;
		while(plr[tmp1][0]!=0)
		{
		tmp1++;
		}
		//System.out.println(tmp1);
		if(tmp1 <=3)
		{
		while(exist(bxo)!=-1)
		{
		bxo++;
		if (bxo >5)
		bxo=1;
		}
		if(bxo==1)
		{pi1=0;}
		else if(bxo==2)
		{pi2=0;}
		else if(bxo==3)
		{pi3=0;}
		else if(bxo==4)
		{pi4=0;}
		else if(bxo==5)
		{pi5=0;}
		plr[tmp1][0]=bxo;
		plr[tmp1][1]=1;
		if(sSend==1)
		make();
		//System.out.println("ffffffffffffffffffffff");
		}
		//plr[0][0]=bxo;
		//plr[0][1]=1;
		}
		else if(preCntrl==1 && maxPlayers !=0 && sCreated !=0)
		{
		if(bxo==0)
		{
		if(pi1==1)                    // initialise temporary select for first time
		{tp=p1;bxo=1;pi1=0;adS("30,"+pName+",");}
		else if(pi2==1)
		{tp=p2;bxo=2;pi2=0;adS("40,"+pName+",");}
		else if(pi3==1)
		{tp=p3;bxo=3;pi3=0;adS("50,"+pName+",");}
		else if(pi4==1)
		{tp=p4;bxo=4;pi4=0;adS("60,"+pName+",");}
		else if(pi5==1)
		{tp=p5;bxo=5;pi5=0;adS("70,"+pName+",");}
		//brdAry[0][0][0]=bxo;
		//plr[0][0] = bxo;
		}
		else if(bxo==1)
		{pi1=0;adS(("30,"+pName+","));}
		else if(bxo==2)
		{pi2=0;adS("40,"+pName+",");}
		else if(bxo==3)
		{pi3=0;adS("50,"+pName+",");}
		else if(bxo==4)
		{pi4=0;adS("60,"+pName+",");}
		else if(bxo==5)
		{pi5=0;adS("70,"+pName+",");}
		tmp1=0;
		while(plr[tmp1][0]!=0)
		{
		tmp1++;
		}
		//System.out.println(tmp1);
		if(tmp1 <=3)
		{
		while(exist(bxo)!=-1)
		{
		bxo++;
		if (bxo >5)
		bxo=1;
		}
		if(bxo==1)
		{pi1=0;adS(("30,"+pName+","));}
		else if(bxo==2)
		{pi2=0;adS("40,"+pName+",");}
		else if(bxo==3)
		{pi3=0;adS("50,"+pName+",");}
		else if(bxo==4)
		{pi4=0;adS("60,"+pName+",");}
		else if(bxo==5)
		{pi5=0;adS("70,"+pName+",");}
		plr[tmp1][0]=bxo;
		plr[tmp1][1]=1;
		make();	
		
		}
		}
		 
		 if(maxPlayers==0 || sCreated==0 && preCntrl==1&& single!=1) 
		 {cntrl=-1;cSend=0;sSend=0;}
		}
		else if(allow==1&& cntrl==4 && mx>=630 && mx<=670 && my>=400 && my<=440)
		{cntrl=4;imgx=600;imgy=300;imgx1=0;allow=0;repeat=2;sndCl=1;tpd=0;
		
		img = t.getImage("images/player1.jpg");
		while(!prepareImage(img,this))
		{
		}
		if(pi1==1 && tpd<1)
		{tpd++;
		bxo=1;
		}
		if(pi2==1&& tpd<1)
		{tpd++;
		bxo=2;
		}
		if(pi3==1&& tpd<1)
		{tpd++;
		bxo=3;
		}
		if(pi4==1&& tpd<1)
		{tpd++;
		bxo=4;
		}
		if(pi5==1&& tpd<1)
		{tpd++;
		bxo=5;
		}
		}
		else if(allow==1&& cntrl==4 && mx>=730 && mx<=770 && my>=400 && my<=440)
		{cntrl=4;imgx=600;imgy=300;imgx1=0;allow=0;repeat=2;sndCl=1;tpd=0;
		img = t.getImage("images/player1.jpg");
		while(!prepareImage(img,this))
		{
		}
		if(pi1==1 && tpd<2)
		{tpd++;
		bxo=1;
		}
		if(pi2==1&& tpd<2)
		{tpd++;
		bxo=2;
		}
		if(pi3==1&& tpd<2)
		{tpd++;
		bxo=3;
		}
		if(pi4==1&& tpd<2)
		{tpd++;
		bxo=4;
		}
		if(pi5==1&& tpd<2)
		{tpd++;
		bxo=5;
		}
		
		}
		else if(pd >=3 && allow==1&& cntrl==4 && mx>=830 && mx<=870 && my>=400 && my<=440)
		{cntrl=4;imgx=600;imgy=300;imgx1=0;allow=0;repeat=2;sndCl=1;tpd=0;
		img = t.getImage("images/player1.jpg");
		while(!prepareImage(img,this))
		{
		}
		if(pi1==1 && tpd<3)
		{tpd++;
		bxo=1;
		}
		if(pi2==1&& tpd<3)
		{tpd++;
		bxo=2;
		}
		if(pi3==1&& tpd<3)
		{tpd++;
		bxo=3;
		}
		if(pi4==1&& tpd<3)
		{tpd++;
		bxo=4;
		}
		if(pi5==1&& tpd<3)
		{tpd++;
		bxo=5;
		}
		}
		else if(pd >=4 && allow==1&& cntrl==4 && mx>=630 && mx<=670 && my>=500 && my<=540)
		{cntrl=4;imgx=600;imgy=300;imgx1=0;allow=0;repeat=2;sndCl=1;tpd=0;
		img = t.getImage("images/player1.jpg");
		while(!prepareImage(img,this))
		{
		}
		if(pi1==1 && tpd<4)
		{tpd++;
		bxo=1;
		}
		if(pi2==1&& tpd<4)
		{tpd++;
		bxo=2;
		}
		if(pi3==1&& tpd<4)
		{tpd++;
		bxo=3;
		}
		if(pi4==1&& tpd<4)
		{tpd++;
		bxo=4;
		}
		if(pi5==1&& tpd<4)
		{tpd++;
		bxo=5;
		}
		}
		else if(pd >=5 && allow==1&& cntrl==4 && mx>=730 && mx<=770 && my>=500 && my<=540)
		{cntrl=4;imgx=600;imgy=300;imgx1=0;allow=0;repeat=2;sndCl=1;tpd=0;
		img = t.getImage("images/player1.jpg");
		while(!prepareImage(img,this))
		{
		}
		if(pi1==1 && tpd<5)
		{tpd++;
		bxo=1;
		}
		if(pi2==1&& tpd<5)
		{tpd++;
		bxo=2;
		}
		if(pi3==1&& tpd<5)
		{tpd++;
		bxo=3;
		}
		if(pi4==1&& tpd<5)
		{tpd++;
		bxo=4;
		}
		if(pi5==1&& tpd<5)
		{tpd++;
		bxo=5;
		}
		}
		else if(allow==1&& preCntrl==1 && cntrl==4 && mx>=760 && mx<=900 && my>=590 && my<=620)
		{cntrl=1;join=0;single=0;imgx=600;imgy=100;imgx1=0;allow=0;sndCl=1;preCntrl=0;
		//adS(("1,"+bxo+","));
		if(bxo==1)
		{pi1=1;adS("31,");}
		else if (bxo==2)
		{pi2=1; adS("41,");}
		else if (bxo==3)
		{pi3=1; adS("51,");}
		else if (bxo==4)
		{pi4=1; adS("61,");}
		else if (bxo==5)
		{pi5=1; adS("71,");}
		if(cSend==1 || sSend==1)
		{
		for(tmp1=0;tmp1 <4;tmp1++)
		{if(plr[tmp1][0]==bxo)
		break;
		}
		for(tmp2=tmp1;tmp2<3;tmp2++)
		{plr[tmp2][0]=plr[tmp2+1][0];
		plr[tmp2][1]=plr[tmp2+1][1];
		}
		plr[3][0]=plr[3][1]=0;
		bxo=0;
		//make();
		}
		//allowSend=1;
		while(sendString.peekFirst() != null)
		{
		try
		{
		Thread.sleep(100);
		}
		catch(Exception e){}
		}
		//sendString ="";
		cSend=0;
		sSend=0;
		
		img = t.getImage("images/MENU.JPG");
		while(!prepareImage(img,this))
		{
		}
		reset();
		}
		
		else if(allow==1&& cntrl==4 && mx>=760 && mx<=900 && my>=590 && my<=620)
		{cntrl=3;imgx=625;imgy=300;imgx1=0;allow=0;sndCl=1;
		if(bxo==1)
		{pi1=1;}
		else if (bxo==2)
		{pi2=1;}
		else if (bxo==3)
		{pi3=1;}
		else if (bxo==4)
		{pi4=1;}
		else if (bxo==5)
		{pi5=1;}
		if(cSend==1 || sSend==1)
		{
		for(tmp1=0;tmp1 <4;tmp1++)
		{if(plr[tmp1][0]==bxo)
		break;
		}
		for(tmp2=tmp1;tmp2<3;tmp2++)
		{plr[tmp2][0]=plr[tmp2+1][0];
		plr[tmp2][1]=plr[tmp2+1][1];
		}
		plr[3][0]=plr[3][1]=0;
		bxo=0;
		}
		//make();
		
		
		 sSend=0; cSend=0;
		img = t.getImage("images/MENU.JPG");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,600,100,this);
		img = t.getImage("images/server.jpg");
		while(!prepareImage(img,this))
		{
		}
		g.drawImage(img,600,300,this);
		img = t.getImage("images/dot.gif");
		while(!prepareImage(img,this))
		{
		}
		if(maxPlayers==2)
		imgy=380;
		else if(maxPlayers==3)
		imgy=440;
		else
		imgy=510;
		//img = t.getImage("images/player1.jpg");
		}
		
		
		g.setColor(c0);
		if(imgx1==0)
		g.drawImage(img,imgx,imgy,this);
		else
		g.drawImage(img,imgx,imgy,imgx1,imgy1,this);
		if (ad==1)
		{g.fillRect(1,1,250,100);
		g.setColor(c1);
		g.drawString(mx+" "+my+" "+cntrl+"  "+allow,30,55);
		
		}
		//pName= nameField.getText();
		if(pName.equals("54321")) 
		{ad=1;
		pName="PLAYER";
		}
		if(pName.equals("12345")) ad=0;
		//g.drawString(pName.substring(0,6)+" ",30,90);
		if(cntrl ==3 && repeat>=1)
		{repeat--;
		img1 = t.getImage("images/dot.gif");
		while(!prepareImage(img1,this))
		{
		}
		
		if(maxPlayers==2)
		g.drawImage(img1,625,380,this);
		else if(maxPlayers==3)
		g.drawImage(img1,625,440,this);
		else
		g.drawImage(img1,625,510,this);
		if (repeat==1)
		{imgx=625;
		img=img1;
		if(maxPlayers==2)
		imgy=380;
		else if(maxPlayers==3)
		imgy=440;
		else
		imgy=510;
		}
		}
		if(cntrl==4 && repeat >=1)
		{
		repeat --;
		pmix =630; pmiy =400;pd=0;
		if(pi1==1)
		{
		tx=pmix;ty=pmiy;tp=p1;pd++;
		if(bxo==1)
		g.drawImage(box,pmix-10,pmiy-10,this);
		g.drawImage(p1,pmix,pmiy,this);
		if(pmix <=800)
		pmix = pmix+100;
		else
		{pmix=630;
		pmiy=500;
		}
		
		}
		if(pi2==1)
		{
		tx=pmix;ty=pmiy;tp=p2;pd++;
		if(bxo==2)
		g.drawImage(box,pmix-10,pmiy-10,this);
		g.drawImage(p2,pmix,pmiy,this);
		if(pmix <=800)
		pmix = pmix+100;
		else
		{pmix=630;
		pmiy=500;
		}
		}
		if(pi3==1)
		{
		tx=pmix;ty=pmiy;tp=p3;pd++;
		if(bxo==3)
		g.drawImage(box,pmix-10,pmiy-10,this);
		g.drawImage(p3,pmix,pmiy,this);
		if(pmix <=800)
		pmix = pmix+100;
		else
		{pmix=630;
		pmiy=500;
		}
		}
		if(pi4==1)
		{
		tx=pmix;ty=pmiy;tp=p4;pd++;
		if(bxo==4)
		g.drawImage(box,pmix-10,pmiy-10,this);
		g.drawImage(p4,pmix,pmiy,this);
		if(pmix <=800)
		pmix = pmix+100;
		else
		{pmix=630;
		pmiy=500;
		}
		}
		if(pi5==1)
		{
		tx=pmix;ty=pmiy;tp=p5;pd++;
		if(bxo==5)
		g.drawImage(box,pmix-10,pmiy-10,this);
		g.drawImage(p5,pmix,pmiy,this);
		//pmix = 650;pmiy = 370;
		}
		if(repeat==1)
		{
		img=tp;
		imgx=tx;imgy=ty;
		}
		}
		if(cntrl==5 && repeat >=1)
		{repeat--;
		
		img1 = t.getImage("images/TICK.gif");
		img2 = t.getImage("images/CROSS.gif");
		while(!prepareImage(img1,this)||!prepareImage(img2,this))
		{
		}
		
		if(tempSound==1)
		g.drawImage(img1,850,375,this);
		else
		g.drawImage(img2,850,375,this);
		if(tempMusic==1)
		g.drawImage(img1,850,455,this);
		else
		g.drawImage(img2,850,455,this);
		if(repeat==1)
		{
		imgx=850; imgy=455;
		if(tempMusic==1)
	    img=img1;
		else
        img=img2;
		}
		}
		
	}
	
}

	

class mouseWork extends MouseAdapter
{
	snake mous;
	public mouseWork ( snake mous)
	{
		this.mous = mous;
	}
	public void mousePressed(MouseEvent me) 
	{
	   mous.mx = me.getX();
	   mous.my = me.getY();
	   mous.allow=1;
	   //mous.repaint(0,0,1,1);
	}
	
	
}

