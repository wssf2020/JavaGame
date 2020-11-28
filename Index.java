//BluefishV-bilibili

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/*总文件数:1  总行数:1100
 * 
 * 		  史蒂夫大战僵尸
 * 		Steve VS Zombie
 * 
 * 			游戏玩法
 * 使用A/D行走，按住空格(space)或w跳跃
 * 使用K键攻击前方的僵尸，使用J键发射飞镖(左右摇摆可使飞镖向左右飞)
 * 更多提示请在游戏内按键"T"。
 */
public class Index extends JFrame {
	public boolean jump = false;
	private JLabel tf;
	public Index() throws InterruptedException {
		// 初始化图片
		Demo map = new Demo();
		Demo grass = new Demo();
		Demo me = new Demo();
		Demo zombie = new Demo();
		Demo healthDemo = new Demo();
		Demo xp = new Demo();
		Demo xp_pic = new Demo();
		Demo die = new Demo();
		Demo arrow_pic = new Demo();
		Demo arrow = new Demo();
		Demo redHeat = new Demo();
		Demo zombieHealth = new Demo();
		Demo win = new Demo();
		Demo ci = new Demo();
		Demo anvilDemo = new Demo();
		Demo tip = new Demo(); 
		tip.setX(1000);tip.setY(1000);tip.setWidth(150);tip.setHeight(50);tip.setImage(new ImageIcon("src/game_zh/tip.png").getImage());
		anvilDemo.setX(490);anvilDemo.setY(50);anvilDemo.setWidth(60);anvilDemo.setHeight(80);anvilDemo.setImage(new ImageIcon().getImage());
		ci.setX(290);ci.setY(260);ci.setWidth(40);ci.setHeight(40);ci.setImage(new ImageIcon("src/game_zh/DiCi.jpg").getImage());
		zombieHealth.setX(1000);arrow.setY(1000);zombieHealth.setWidth(80);zombieHealth.setHeight(20);zombieHealth.setImage(new ImageIcon("src/game_zh/h5.png").getImage());
		arrow.setX(1000);arrow.setY(1000);arrow.setWidth(50);arrow.setHeight(50);arrow.setImage(new ImageIcon("src/game_zh/arrowFlying.gif").getImage());
		redHeat.setX(340);redHeat.setY(555);redHeat.setWidth(180);redHeat.setHeight(25);redHeat.setImage(new ImageIcon("src/game_zh/redHeat.gif").getImage());
		arrow_pic.setX(250);arrow_pic.setY(530);arrow_pic.setWidth(80);arrow_pic.setHeight(80);arrow_pic.setImage(new ImageIcon("src/game_zh/arrow.jpg").getImage());
		win.setX(1000);win.setY(1000);win.setWidth(700);win.setHeight(550);win.setImage(new ImageIcon("src/game_zh/you_win.jpg").getImage());
		die.setX(1000);die.setY(1000);die.setWidth(700);die.setHeight(550);die.setImage(new ImageIcon("src/game_zh/you_died.jpg").getImage());
		xp_pic.setX(200);xp_pic.setY(545);xp_pic.setHeight(45);xp_pic.setWidth(45);xp_pic.setImage(new ImageIcon("src/game_zh/exp.gif").getImage());
		xp.setX(1000);xp.setY(1000);xp.setHeight(30);xp.setWidth(30);xp.setImage(new ImageIcon("src/game_zh/exp.gif").getImage());
		JLabel jLabel = new JLabel();
		me.setHeat(100);
		healthDemo.setX(5);healthDemo.setY(545);healthDemo.setWidth(160);healthDemo.setHeight(45);healthDemo.setImage(new ImageIcon("src/game_zh/5.jpg").getImage());
		zombie.setHeat(50);
		zombie.setImage(new ImageIcon("src/game_zh/zombie_right.jpg").getImage());
		zombie.setX(1000);zombie.setY(1000);zombie.setWidth(45);zombie.setHeight(80);
		Demo stone0 = new Demo();Demo stone1 = new Demo();Demo stone2 = new Demo();Demo stone4 = new Demo();
		stone4.setX(425); stone4.setY(129);stone4.setWidth(202);stone4.setHeight(33);stone4.setImage(new ImageIcon().getImage());
		//stone3.setX(0); stone3.setY(129);stone3.setWidth(342);stone3.setHeight(33);stone3.setImage(new ImageIcon().getImage());
		stone2.setX(618); stone2.setY(302);stone2.setWidth(65);stone2.setHeight(33);stone2.setImage(new ImageIcon().getImage());
		stone1.setX(287); stone1.setY(302);stone1.setWidth(135);stone1.setHeight(33);stone1.setImage(new ImageIcon().getImage());
		stone0.setX(0); stone0.setY(302);stone0.setWidth(205);stone0.setHeight(33);stone0.setImage(new ImageIcon().getImage());
		grass.setX(0); grass.setY(492); grass.setHeight(60); grass.setWidth(685); grass.setImage(new ImageIcon().getImage());
		map.setImage(new ImageIcon("src/game_zh/map.jpg").getImage());
		map.setHeight(550); map.setWidth(685);
		me.setX(100); me.setY(410); me.setHeight(80); me.setWidth(45);me.setImage(new ImageIcon("src/game_zh/steve_right.jpg").getImage());
		
		
		DemoPanel panel = new DemoPanel(map, grass, stone0, stone1, stone2, stone4, zombie,healthDemo ,anvilDemo,xp ,xp_pic ,zombieHealth ,arrow_pic ,arrow,tip,me ,ci ,redHeat ,die ,win );

		// 配置
		this.add(jLabel);
		Container contentPane = this.getContentPane();
		//contentPane.add(new JLabel("按T打开菜单") , BorderLayout.NORTH);
		tf = new JLabel();
		contentPane.add(tf, BorderLayout.SOUTH);
		
		//tf.setText("哈哈");
		//contentPane.add(tf, BorderLayout.SOUTH);
		//tf.setText("123");
		this.setTitle("Steve-VS-Zombie");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 640);
		this.add(panel);
		this.setVisible(true);
		
		//线程
		cmd Cmd = new cmd();
		Cmd.setDemo(me);
		Cmd.setZombieDeme(zombie);
		Cmd.start();
		arrow arr = new arrow();
		arr.setZombieHealthDemo(zombieHealth);
		arr.setArrow(arrow);
		arr.setMyself(me);
		arr.setZombie(zombie);
		arr.start();
		EatExp eatExp = new EatExp();
		eatExp.setDemo(me);
		eatExp.setExp(xp);
		eatExp.start();
		Text text = new Text();
		text.setDemo(me);
		text.setDie(die);
		text.setHealthDemo(healthDemo);
		text.setZombie(zombie);
		text.setExp(xp);
		text.setZombieHealthDemo(zombieHealth);
		
		text.start();
		ZombieAndMe zombieAndMe = new ZombieAndMe();
		zombieAndMe.setZombieDemo(zombie);
		zombieAndMe.setTipDemo(tip);
		zombieAndMe.setMeDemo(me);
		zombieAndMe.start();
		Drop drop = new Drop();
		drop.setDemo(me);
		drop.start();
		ZombieDrop zombieDrop = new ZombieDrop();
		zombieDrop.setDemo(zombie);
		zombieDrop.start();
		OutOfMap outOfMap = new OutOfMap();
		outOfMap.setDemo(me);
		outOfMap.start();
		OutOfMap ZombieOutOfMap = new OutOfMap();
		ZombieOutOfMap.setDemo(zombie);
		ZombieOutOfMap.start();
		Summon summon = new Summon();
		summon.setDemo(zombie);
		summon.setTime(1000*8);
		summon.start();
		ZombieRun zombieRun = new ZombieRun();
		zombieRun.setDemo(zombie);
		zombieRun.start();
		// 键盘监听
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (KeyEvent.VK_W == e.getKeyCode()) {
					me.setY(me.getY() - 20);
				} else if (KeyEvent.VK_S == e.getKeyCode()) {
					me.setY(me.getY() + 10);
				} else if (KeyEvent.VK_A == e.getKeyCode()) {
					me.setImage(new ImageIcon("src/game_zh/steve_left.jpg").getImage());
					me.setDirection(false);
					me.setX(me.getX() - 10);
				} else if (KeyEvent.VK_D == e.getKeyCode()) {
					me.setImage(new ImageIcon("src/game_zh/steve_right.jpg").getImage());
					me.setDirection(true);
					me.setX(me.getX() + 10);
				}else if (KeyEvent.VK_SPACE==e.getKeyCode()) {
					boolean dropping = drop.getDropping();
					if(dropping == false) {//判断是否正在下落，如果否则可以跳跃
					for(int i = 0;i<20;i++) {
						jump = true;
						MyThread th = new MyThread();
						th.setDemo(me);
						th.start();
					}
					jump = false;}
				}else if(KeyEvent.VK_K == e.getKeyCode()) {
					boolean direction = me.getDirection();
						PicChange pc = new PicChange();
						pc.setDirection(me.getDirection());
						pc.setDemo(me);
						pc.start();
						
				}else if(KeyEvent.VK_J == e.getKeyCode()) {
					if(me.getArrow()<=0) {}else {
					me.setArrow(me.getArrow()-1);
					boolean direction = me.getDirection();
					arrow.setX(me.getX());
					arrow.setY(me.getY());
					ArrowChange arrowChange = new ArrowChange();
					arrowChange.setDirection(direction);
					arrowChange.setDemo(me);
					arrowChange.start();
				}
				}else if(KeyEvent.VK_T == e.getKeyCode()) {
					JFrame help = new JFrame();
					JPanel helpPanel = new JPanel();
					JTextArea helpTextArea = new JTextArea("----------------帮助页面----------------使用A/D行走，按住空格(space)或w跳跃      使用K键攻击前方的僵尸，使用J键发射飞镖(左右摇摆可使飞镖向左右飞)\n踩到地刺会受到8点的伤害\n【僵尸被击败数秒后会在木门处复活】\n当您的血量小于0时游戏结束！",20,40);
					helpTextArea.setLineWrap(true);
					helpTextArea.setForeground(Color.black);
					helpTextArea.setFont(new Font("楷体",Font.BOLD,16));
					helpTextArea.setBackground(Color.white);
					JScrollPane jScrollPane = new JScrollPane(helpTextArea);
					Dimension size = helpTextArea.getPreferredSize();
					helpTextArea.setBounds(600,600,size.width,size.height);
					helpPanel.add(jScrollPane);
					help.add(helpPanel);
					help.setBackground(Color.LIGHT_GRAY);
					help.setSize(400, 430);
					help.setTitle("help-menu");
					help.setVisible(true);
					//help.setDefaultCloseOperation(help.EXIT_ON_CLOSE);
				}else if(KeyEvent.VK_E == e.getKeyCode()) {
					JFrame frame = new JFrame("物品修复和命名");
					  //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					  frame.setLayout(new FlowLayout());
					  JButton button = new JButton("血量上限+8(经验x2)");
					  JButton buttonB = new JButton("攻击+1(经验x1)");
					  JButton buttonC = new JButton("通关游戏(经验x200)");
					  buttonC.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if(me.getExp()>199) {
								me.setExp(me.getExp()-200);
								System.out.println("恭喜通关！");
								win.setX(0);
								win.setY(0);
							}else {
								System.out.println("经验不足");
							}
							
						}
					});
					  button.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(me.getExp()>1) {
								me.setExp(me.getExp()-2);
								me.setMaxHeat(me.getMaxHeat()+8);
								System.out.println("已购买血量上限");
							}else {
								System.out.println("经验不足");
							}
							
						}
					});
					  buttonB.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(me.getExp()>0) {
								me.setExp(me.getExp()-1);
								me.setAtt(me.getAtt()+1);
								System.out.println("已购买攻击*1");
							}else {
								System.out.println("经验不足");
							}

						}
					});
					  Dimension preferredSize = new Dimension(300,70);//设置尺寸
					  button.setPreferredSize(preferredSize );
					  buttonB.setPreferredSize(preferredSize );
					  buttonC.setPreferredSize(preferredSize );
					  frame.add(button);
					  frame.add(buttonB);
					  frame.add(buttonC);
					  frame.setBounds(0,0, 400, 300);
					  frame.setVisible(true);
					/*JFrame anvil = new JFrame("Anvil");
					JButton buttonA = new JButton("血量");
					JButton buttonB = new JButton("攻击");
					JButton buttonC = new JButton("通关");
					anvil.add(buttonA);
					anvil.add(buttonB);
					anvil.add(buttonC);
					anvil.setSize(400,300);
					anvil.setVisible(true);*/
				}
				/*调试*/else if(KeyEvent.VK_G == e.getKeyCode()) {
					System.out.println("僵尸坐标：X:"+zombie.getX()+"Y："+zombie.getY());
				}else if(KeyEvent.VK_E == e.getKeyCode()) {
					System.out.println(xp.getX()+"<-- X == Y-->"+xp.getY());
					//xp.setX(100);
					//xp.setY(300);
				}
			}
		});

		// 循环刷新
		while (true) {
			
			tf.setText("   生命值: "+me.getHeat()+" (MAX:"+me.getMaxHeat()+")                     经验: "+me.getExp()+"  		        飞镖: "+me.getArrow()+"         僵尸:"+zombie.getHeat()*2+"% (MAX:50)   攻击: "+me.getAtt()+"  消息: "+text.getLastMsg());
			//me.setY(me.getY()-5);
			Thread.sleep(5);
			Rectangle anvilRectangle = new Rectangle(anvilDemo.getX(),anvilDemo.getY(),anvilDemo.getWidth(),anvilDemo.getHeight());
			Rectangle ciRectangle = new Rectangle(ci.getX(),ci.getY(),ci.getWidth(),ci.getHeight());
			Rectangle xpRectangle = new Rectangle(xp.getX(),xp.getY(),xp.getWidth(),xp.getHeight());
			Rectangle arrowRectangle = new Rectangle(arrow.getX(),arrow.getY(),arrow.getWidth(),arrow.getHeight());
			Rectangle grassRectangle = new Rectangle(grass.getX(),grass.getY(),grass.getWidth(),grass.getHeight());
			Rectangle stone4Rectangle = new Rectangle(stone4.getX(),stone4.getY(),stone4.getWidth(),stone4.getHeight());
			Rectangle stone2Rectangle = new Rectangle(stone2.getX(),stone2.getY(),stone2.getWidth(),stone2.getHeight());
			Rectangle stone1Rectangle = new Rectangle(stone1.getX(),stone1.getY(),stone1.getWidth(),stone1.getHeight());
			Rectangle stone0Rectangle = new Rectangle(stone0.getX(),stone0.getY(),stone0.getWidth(),stone0.getHeight());
			Rectangle steveRectangle = new Rectangle(me.getX(),me.getY(),me.getWidth(),me.getHeight());
			Rectangle zombieRectangle = new Rectangle(zombie.getX(),zombie.getY(),zombie.getWidth(),zombie.getHeight());
			eatExp.setMe(steveRectangle);
			eatExp.setXp(xpRectangle);
			arr.setArrowRectangle(arrowRectangle);
			arr.setZombieRectangle(zombieRectangle);
			zombieDrop.setR(zombieRectangle);
			zombieDrop.setR1(grassRectangle);
			zombieDrop.setR2(stone0Rectangle);
			zombieDrop.setR3(stone1Rectangle);
			zombieAndMe.setMe(steveRectangle);
			zombieAndMe.setAnvil(anvilRectangle);
			zombieAndMe.setCiRectangle(ciRectangle);
			zombieAndMe.setZombie(zombieRectangle);
			drop.setR6(stone4Rectangle);drop.setR4(stone2Rectangle);
			drop.setR3(stone1Rectangle);drop.setR2(stone0Rectangle);drop.setR(steveRectangle);drop.setR1(grassRectangle);
			drop.setJump(jump);
			panel.repaint();
		}

	}

	// main方法
	public static void main(String[] args) throws InterruptedException {
		new Index();
	}
}






class cmd extends Thread{
	private Demo demo,zombieDemo;
	public void setDemo(Demo demo) {
		this.demo = demo;
	}
	public void setZombieDeme(Demo demo) {
		this.zombieDemo = demo;
	}
	@Override
	public void run() {
		while(true) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String[] array = str.split("%");
		//System.out.println(Arrays.toString(array));
		if("/xp".equals(array[0])) {
			try {
				int exp = Integer.valueOf(array[2]).intValue();
			   
				if("add".equals(array[1])) {
					demo.setExp(demo.getExp()+exp);
					System.out.println("已为 Steve 添加"+exp+"经验值");
				}else if("remove".equals(array[1])){
					 demo.setExp(demo.getExp()-exp);
					 System.out.println("已为 Steve 移除"+exp+"经验值");
				}
			    
			} catch (NumberFormatException e) {

			    e.printStackTrace();

			}
		}else if("/health".equals(array[0])) {
			try {
				
			    int health = Integer.valueOf(array[1]).intValue();
			    demo.setHeat(health);
			    System.out.println("已将 Steve 的生命值设置为"+health);
			} catch (NumberFormatException e) {

			    e.printStackTrace();

			}
		}else if("/att".equals(array[0])) {
			try {

			    int att = Integer.valueOf(array[1]).intValue();
			    demo.setAtt(att);
			    System.out.println("已将 Steve 的攻击力设置为"+att);
			} catch (NumberFormatException e) {

			    e.printStackTrace();

			}
		}else if("/kill".equals(array[0])) {
			if("Steve".equals(array[1])) {
				demo.setHeat(-1);
				System.out.println("已清除 Steve");
			}else if("Zombie".equals(array[1])) {
				zombieDemo.setHeat(-1);
				System.out.println("已清除 Zombie");
			}else {
				System.out.println("找不到实体: "+array[1]);
			}
		}else if("/MAX".equals(array[0])) {
			try {

			    int mh = Integer.valueOf(array[1]).intValue();
			    demo.setMaxHeat(mh);
			    System.out.println("已将 Steve 的最大生命值设置为"+mh);
			} catch (NumberFormatException e) {

			    e.printStackTrace();

			}
		}
		}
	}
}
class ArrowChange extends Thread{
	private Demo demo;
	private boolean direction = false;
	public void setDemo(Demo demo) {
		this.demo = demo;
	}
	public void setDirection(boolean direction) {
		this.direction = direction;
	}
	@Override
	public void run() {
		if(direction == false) {
		try {
			//System.out.println("k");
			demo.setWidth(100);
			demo.setImage(new ImageIcon("src/game_zh/steve_left_hj2.jpg").getImage());
			Thread.sleep(300);
			demo.setWidth(45);
			demo.setImage(new ImageIcon("src/game_zh/steve_left.jpg").getImage());
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		}else {
			try {
				demo.setWidth(100);
				demo.setImage(new ImageIcon("src/game_zh/steve_right_hj2.jpg").getImage());
				Thread.sleep(300);
				
				demo.setWidth(45);
				demo.setImage(new ImageIcon("src/game_zh/steve_right.jpg").getImage());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}
class arrow extends Thread{
	private Demo zombie ,arrow,myself,zombieHealthDemo;
	private Rectangle zombieRectangle,arrowRectangle;
	//private boolean direction1 = true;
	//public void setDirection1(boolean direction1) {
	//	this.direction1 = direction1;
		//System.out.println("abc"+this.direction1);
	//}
	public void setZombieHealthDemo(Demo health) {
		this.zombieHealthDemo = health;
	}
	public void setMyself(Demo myself) {
		this.myself = myself;
	}
	public void setZombieRectangle(Rectangle z) {
		this.zombieRectangle = z;
	}
	public void setArrowRectangle(Rectangle a) {
		this.arrowRectangle = a;
	}
	public void setZombie(Demo zombie) {
		this.zombie = zombie;
	}
	public void setArrow(Demo arrow) {
		this.arrow = arrow;
	}
	private int x,y;
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(true) {
			try {
				Thread.sleep(7);
				zombieHealthDemo.setX(zombie.getX()-20);
				zombieHealthDemo.setY(zombie.getY()-30);
				x = arrow.getX();
				y = arrow.getY();
				if(zombieRectangle.intersects(arrowRectangle)) {
					zombie.setHeat(zombie.getHeat()-7);
					arrow.setX(1000);
					arrow.setY(1000);
				}
				if(x<-50) {
					arrow.setX(1000);
				}
				if(x>800) {
					arrow.setX(1000);
				}
				if(x<=900&&y<=900) {
					if(myself.getDirection()==false&&myself.getArrow()>=0) {
						arrow.setX(x-7);
					}else if(myself.getDirection()==true&&myself.getArrow()>=0) {
						
						arrow.setX(x+7);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
class EatExp extends Thread{
	private Demo demo;
	private Demo exp;
	private Rectangle me , xp;
	public void setMe(Rectangle me) {
		this.me = me;
	}
	public void setXp(Rectangle xp) {
		this.xp = xp;
	}
	public void setDemo(Demo demo) {
		this.demo = demo;
	}
	public void setExp(Demo exp) {
		this.exp = exp;
	}
	Text text = new Text();
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(500);
				if(me.intersects(xp)) {
					demo.setExp(demo.getExp()+1);
					demo.setHeat(demo.getHeat()+5);
					text.setString("经验+1 !(可以在铁砧处升级属性)");
					exp.setX(1000);
					exp.setY(1000);
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Text extends Thread{
	private Demo demo,healthDemo,zombieDemo,exp,die,zombieHealthDemo;
	private String lastMsg = "按T打开帮助菜单";
	public String getLastMsg() {
		return lastMsg;
	}
	public void setZombieHealthDemo(Demo health) {
		this.zombieHealthDemo = health;
	}
	public void setDie(Demo die) {
		this.die = die;
	}
	public void setExp(Demo exp) {
		this.exp = exp;
	}
	public void setString(String lastMsg) {
		this.lastMsg = lastMsg;
	}
	public void setHealthDemo(Demo healthDemo) {
		this.healthDemo = healthDemo;
	}
	public void setZombie(Demo zombieDemo) {
		this.zombieDemo = zombieDemo;
	}
	public void setDemo(Demo demo) {
		this.demo = demo;
	}
	int health;
	int zombieHealth;
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		healthDemo.setImage(new ImageIcon("src/game_zh/5.jpg").getImage());
		while(true) {
			try {
				Thread.sleep(1000);
				
				zombieHealth = zombieDemo.getHeat();
				health = demo.getHeat();
				if(zombieHealth<0) {
					lastMsg = "僵尸 被击败了. 箭+5";
					demo.setArrow(demo.getArrow()+5);
					exp.setX(zombieDemo.getX());
					exp.setY(zombieDemo.getY()+40);
					zombieDemo.setHeat(0);
					zombieDemo.setX(1000);
					zombieDemo.setY(1000);
				}
				if(health<=0) {
					demo.setHeat(0);
					lastMsg = "你失败了！";
					die.setX(0);
					die.setY(0);
				}
				if(health<demo.getMaxHeat()) {
					demo.setHeat(demo.getHeat()+1);
				}
				if(zombieHealth>=50) {
					//System.out.println(50);
					zombieHealthDemo.setImage(new ImageIcon("src/game_zh/h5.png").getImage());
				}else if(zombieHealth>40&&zombieHealth<50) {
					zombieHealthDemo.setImage(new ImageIcon("src/game_zh/h4.png").getImage());
				}else if(zombieHealth>30&&zombieHealth<=40) {
					zombieHealthDemo.setImage(new ImageIcon("src/game_zh/h3.png").getImage());
				}else if(zombieHealth>20&&zombieHealth<=30) {
					zombieHealthDemo.setImage(new ImageIcon("src/game_zh/h2.png").getImage());
				}else if(zombieHealth>10&&zombieHealth<=20) {
					zombieHealthDemo.setImage(new ImageIcon("src/game_zh/h1.png").getImage());
				}else if(zombieHealth<=5){
					zombieHealthDemo.setImage(new ImageIcon("src/game_zh/h0.png").getImage());
				}else {}
				if(health>=demo.getMaxHeat()) {
					healthDemo.setImage(new ImageIcon("src/game_zh/5.jpg").getImage());
				}else if(health > demo.getMaxHeat()*0.8 && health < demo.getMaxHeat()) {
					healthDemo.setImage(new ImageIcon("src/game_zh/4.jpg").getImage());
				}else if(health>demo.getMaxHeat()*0.6 && health <=demo.getMaxHeat()*0.8) {
					healthDemo.setImage(new ImageIcon("src/game_zh/3.jpg").getImage());
				}else if(health>demo.getMaxHeat()*0.4 && health <=demo.getMaxHeat()*0.6) {
					healthDemo.setImage(new ImageIcon("src/game_zh/2.jpg").getImage());
				}else if(health>demo.getMaxHeat()*0.2 && health <= demo.getMaxHeat()*0.4) {
					healthDemo.setImage(new ImageIcon("src/game_zh/1.jpg").getImage());
				}else{
					healthDemo.setImage(new ImageIcon("src/game_zh/0.jpg").getImage());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class ZombieAndMe extends Thread{
	private Demo meDemo,zombieDemo,tipDemo;
	public void setMeDemo(Demo meDemo) {
		this.meDemo = meDemo;
	}
	public void setTipDemo(Demo tip) {
		this.tipDemo = tip;
	}
	public void setZombieDemo(Demo zombieDemo) {
		this.zombieDemo = zombieDemo;
	}
	private Rectangle me, zombie,ciRectangle,anvilRectangle;
	public void setAnvil(Rectangle anvil) {
		this.anvilRectangle = anvil;
	}
	public void setCiRectangle(Rectangle ci) {
		this.ciRectangle = ci;
	}
	public void setMe(Rectangle me) {
		this.me = me;
	}
	public void setZombie(Rectangle zombie) {
		this.zombie = zombie;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(true) {
			try {
				Thread.sleep(700);
				if(me.intersects(anvilRectangle)) {
					//System.out.println("重合:ling 707");
					tipDemo.setX(450);
					tipDemo.setY(10);
				}else {
					tipDemo.setX(1000);
					tipDemo.setY(1000);
				}
				if(me.intersects(ciRectangle)) {
					meDemo.setHeat(meDemo.getHeat()-8);
				}
				if(me.intersects(zombie)) {
					if(meDemo.getHit()==true) {
						zombieDemo.setHeat(zombieDemo.getHeat()-meDemo.getAtt());
						//System.out.println("我打僵尸");
					}else if (meDemo.getHit()==false) {
						meDemo.setHeat(meDemo.getHeat()-6);
						//System.out.println("僵尸打我");
					}
					//System.out.println("碰撞");
					
				}
			} catch (InterruptedException e) {e.printStackTrace();}
		
		}
	}
}
class ZombieDrop extends Thread{
	private Demo demo;
	private Rectangle r,r1,r2,r3;
	public void setR1(Rectangle r1) {
		this.r1 = r1;
	}
	public void setR2(Rectangle r2) {
		this.r2 = r2;
	}
	public void setR3(Rectangle r3) {
		this.r3 = r3;
	}
	public void setDemo(Demo demo) {
		this.demo = demo;
	}
	public void setR(Rectangle r) {
		this.r = r;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(true) {
			try {
				Thread.sleep(13);
				if(r.intersects(r1)||r.intersects(r2)||r.intersects(r3)) {
				}else if(demo.getX()>=800||demo.getY()>=800){
					
				}else{
					demo.setY(demo.getY()+3);
				}
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}
class ZombieRun extends Thread{
	private Demo demo;
	public void setDemo(Demo demo) {
		this.demo = demo;
	}
	@Override
	public void run() {
		while(true) {
		try {
			Thread.sleep(50);
			if(demo.getX()>=800||demo.getY()>=800) {
				
			}else {
			demo.setX(demo.getX()+3);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
		
	}
}
class Summon extends Thread{
	private int time;
	private Demo demo;
	public void setDemo(Demo demo) {
		this.demo = demo;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(time);
				if(demo.getY()<=800&&demo.getX()<=800) {
					
				}else {
					demo.setHeat(50);
					demo.setX(50);
					demo.setY(200);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class PicChange extends Thread{
	private Demo demo;
	private boolean direction;
	public void setDirection(boolean direction) {
		this.direction = direction;
	}
	public void setDemo(Demo demo) {
		this.demo = demo;
	}
	@Override
	public void run() {
		if(direction == false) {
			demo.setHit(true);
		try {
			//System.out.println("k");
			demo.setWidth(120);
			demo.setImage(new ImageIcon("src/game_zh/steve_left_hj0.jpg").getImage());
			Thread.sleep(300);
			demo.setImage(new ImageIcon("src/game_zh/steve_left_hj1.jpg").getImage());
			Thread.sleep(300);
			demo.setWidth(45);
			demo.setImage(new ImageIcon("src/game_zh/steve_left.jpg").getImage());
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		demo.setHit(false);
		}else {
			demo.setHit(true);
			try {
				//System.out.println("k");
				demo.setWidth(120);
				demo.setImage(new ImageIcon("src/game_zh/steve_right_hj0.jpg").getImage());
				Thread.sleep(300);
				demo.setImage(new ImageIcon("src/game_zh/steve_right_hj1.jpg").getImage());
				Thread.sleep(300);
				demo.setWidth(45);
				demo.setImage(new ImageIcon("src/game_zh/steve_right.jpg").getImage());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			demo.setHit(false);
		}
	}
}
class OutOfMap extends Thread{
	private Demo demo;
	public void setDemo(Demo demo){
		this.demo = demo;
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
				if(demo.getX()>700) {
					demo.setX(0);
					demo.setY(demo.getY()-80);
				}else if (demo.getX()<0) {
					demo.setX(700);
					demo.setY(demo.getY()-80);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Drop extends Thread{
	private Demo demo;
	private boolean dropping = false , jump;
	private Rectangle r, r1, r2, r3, r4, r5, r6;
	public boolean getDropping() {
		return dropping;
	}
	public void setJump(boolean jump) {
		this.jump = jump;
	}
	public void setR1(Rectangle r1) {
		this.r1 = r1;
	}
	public void setR2(Rectangle r2) {
		this.r2 = r2;
	}
	public void setR3(Rectangle r3) {
		this.r3 = r3;
	}
	public void setR4(Rectangle r4) {
		this.r4 = r4;
	}
	public void setR6(Rectangle r6) {
		this.r6 = r6;
	}
	public void setR(Rectangle r) {
		this.r = r;
	}
	public void setDemo(Demo demo) {
		this.demo = demo;
	}
	@Override
	public void run() {
		double i = 1;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(true) {
			try {
				Thread.sleep(13);
				if(r.intersects(r1)||r.intersects(r2)||r.intersects(r3)||r.intersects(r4)||r.intersects(r6)) {
					i = 1.0;
					dropping = false;
				}else if(jump==true){
					dropping = false;
				}else {
					//重力系统
					i = i+0.05;//使下落的时间越长下落的速度越快，每次循环i增加0.05
					int ii = (int) i;
					demo.setY(demo.getY()+ii);
					dropping = true;//使dropping设置为正在下落以暂时禁止跳跃
				}
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}
class MyThread extends Thread{
	private Demo demo;
	public void setDemo(Demo demo) {
		this.demo = demo;
	}
	@Override
	public void run() {
		for (int i = 0; i < 9; i++) {
			if(i<3) {
			demo.setY(demo.getY()-3);
			}else {
			demo.setY(demo.getY()-1);
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//背景图片,没卵用
/*class BackgroundPanel extends JPanel {
	Image im;

	public BackgroundPanel(Image im) {
		this.im = im;
		this.setOpaque(true);
	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);

	}
}
*/
class DemoPanel extends JPanel {
	private Demo[] demos;

	public DemoPanel(Demo... demo) {
		this.demos = demo;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Demo demo : demos) {
			g.drawImage(demo.getImage(), demo.getX(), demo.getY(), demo.getWidth(), demo.getHeight(), null);
		}

	}
}

class Demo {
	private int x, y, width, height, heat, exp = 0,arrow = 50,att = 7,maxHeat = 100;
	private boolean direction = true, hit = false;
	private Image image;
	
	public Demo() {
		this.image = new ImageIcon("src/game_zh/steve.jpg").getImage();
		this.width = 100;
		this.height = 100;
	}
	public void setMaxHeat(int h) {
		this.maxHeat = h;
	}
	public int getMaxHeat() {
		return maxHeat;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getAtt() {
		return att;
	}
	public int getArrow() {
		return arrow;
	}
	public void setArrow(int arrow) {
		this.arrow = arrow;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public boolean getHit() {
		return hit;
	}
	public void setHit(boolean hit) {
		this.hit = hit;
	}
	public boolean getDirection() {
		return direction;
	}
	public void setDirection(boolean direction) {
		this.direction = direction;
	}
	public int getX() {
		return x;
	}
	public int getHeat() {
		return heat;
	}
	public void setHeat(int heat) {
		this.heat = heat;
	}
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}

/*
   *   备用代码
 * 
 * me.setImage(new ImageIcon("src/game_zh/steve.jpg").getImage());
 * BackgroundPanel bgp=new BackgroundPanel((new
 * ImageIcon("src/game_zh/map.jpg")).getImage());
 * bgp.setBounds(0,0,400,300);bgp.setLayout(null);this.getContentPane();this.setLayout(null);this.add(bgp);
 *
 */