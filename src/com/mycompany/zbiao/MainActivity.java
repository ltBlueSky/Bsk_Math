package com.mycompany.zbiao;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;


public class MainActivity extends Activity
{
	private Paint paint,Textpaint,spaint,drawpaint;
	private Bitmap baseBitmap;
	private Canvas canvas;
	private ImageView iw;
	private EditText EditTexta,EditTextb,EditTextc;
	private Button drawpicture,reset,setcolor;
	private float geta,getb,getc;
	private int width,height;
	private float aa,bb,cc;
	private TextView tx,size;
	private SeekBar setsize;
	private float sizesize;
	private int color;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		
		//初始化一个画笔，笔触宽度为5，颜色为红色	
		paint = new Paint();
		paint.setStrokeWidth(1);
		paint.setColor(Color.RED);
		paint.setAntiAlias(true);
		
		//线条颜色
		spaint = new Paint();
		spaint.setStrokeWidth(1);
		spaint.setColor(Color.BLACK);
		spaint.setAntiAlias(true);

		sizesize = 5;
		
		//draw颜色
		drawpaint = new Paint();
		drawpaint.setStrokeWidth(sizesize);
		drawpaint.setColor(Color.BLACK);
		drawpaint.setAntiAlias(true);
		
		//初始化一个写文字的画笔
		Textpaint = new Paint();
		Textpaint.setTextSize(40);
		Textpaint.setColor(Color.BLUE);
				
		iw = (ImageView)findViewById(R.id.mainImageView);	
		EditTexta = (EditText)findViewById(R.id.EditTexta);
		EditTextb = (EditText)findViewById(R.id.EditTextb);
		EditTextc = (EditText)findViewById(R.id.EditTextc);
		drawpicture = (Button)findViewById(R.id.DrawPicture);
		reset = (Button)findViewById(R.id.reset);
		setcolor = (Button)findViewById(R.id.setcolor);
		tx = (TextView)findViewById(R.id.textcolor);
		size = (TextView)findViewById(R.id.size);
		setsize = (SeekBar)findViewById(R.id.setsize);
		
		
		
		
		
		
		
		setcolor.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					showListDialog();
					// TODO: Implement this method
				}
				private void showListDialog() {
					
					final String[] items = { "黑色","蓝色","青色","灰色","绿色","红色","黄色"};
					AlertDialog.Builder listDialog = 
						new AlertDialog.Builder(MainActivity.this);
					listDialog.setTitle("选择颜色");
					
					listDialog.setItems(items, new DialogInterface.OnClickListener() {
						
						
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// which 下标从0开始
								// ...To-do
										
								switch(which)
								{
									case 0:
										//线条颜色
										drawpaint = new Paint();
										drawpaint.setStrokeWidth(sizesize);
										drawpaint.setColor(Color.BLACK);
										drawpaint.setAntiAlias(true);
										tx.setTextColor(Color.BLACK);
										setcolor.setText(items[which]);
										color = 0;
										break;
		
									case 1:
										//线条颜色
										drawpaint = new Paint();
										drawpaint.setStrokeWidth(sizesize);
										drawpaint.setColor(Color.BLUE);
										drawpaint.setAntiAlias(true);
										tx.setTextColor(Color.BLUE);
										setcolor.setText(items[which]);		
										color = 1;
										break;
									case 2:
										//线条颜色
										drawpaint = new Paint();
										drawpaint.setStrokeWidth(sizesize);
										drawpaint.setColor(Color.CYAN);
										drawpaint.setAntiAlias(true);
										tx.setTextColor(Color.CYAN);
										setcolor.setText(items[which]);		
										color = 2;
										break;
									case 3:
										//线条颜色
										drawpaint = new Paint();
										drawpaint.setStrokeWidth(sizesize);
										drawpaint.setColor(Color.GRAY);
										drawpaint.setAntiAlias(true);
										tx.setTextColor(Color.GRAY);
										setcolor.setText(items[which]);		
										color = 3;
										break;
									case 4:
										//线条颜色
										drawpaint = new Paint();
										drawpaint.setStrokeWidth(sizesize);
										drawpaint.setColor(Color.GREEN);
										drawpaint.setAntiAlias(true);
										tx.setTextColor(Color.GREEN);
										setcolor.setText(items[which]);		
										color = 4;
										break;
									case 5:
										//线条颜色
										drawpaint = new Paint();
										drawpaint.setStrokeWidth(sizesize);
										drawpaint.setColor(Color.RED);
										drawpaint.setAntiAlias(true);
										tx.setTextColor(Color.RED);
										setcolor.setText(items[which]);		
										color = 5;
										break;
									case 6:
										//线条颜色
										drawpaint = new Paint();
										drawpaint.setStrokeWidth(sizesize);
										drawpaint.setColor(Color.YELLOW);
										drawpaint.setAntiAlias(true);
										tx.setTextColor(Color.YELLOW);
										setcolor.setText(items[which]);		
										color = 6;
									break;
								}
								
							}		
							
						});
					listDialog.show();
				}
				
			});
			
		setsize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
					// 当拖动条的滑块位置发生改变时触发该方法,在这里直接使用参数progress，即当前滑块代表的进度值
					size.setText("大小:" + Integer.toString(progress));
					sizesize = progress/10;

					switch(color)
					{
						case 0:
							//线条颜色
							drawpaint = new Paint();
							drawpaint.setStrokeWidth(sizesize);
							drawpaint.setColor(Color.BLACK);
							drawpaint.setAntiAlias(true);
							break;

						case 1:
							//线条颜色
							drawpaint = new Paint();
							drawpaint.setStrokeWidth(sizesize);
							drawpaint.setColor(Color.BLUE);
							drawpaint.setAntiAlias(true);
							break;
						case 2:
							//线条颜色
							drawpaint = new Paint();
							drawpaint.setStrokeWidth(sizesize);
							drawpaint.setColor(Color.CYAN);
							drawpaint.setAntiAlias(true);
							break;
						case 3:
							//线条颜色
							drawpaint = new Paint();
							drawpaint.setStrokeWidth(sizesize);
							drawpaint.setColor(Color.GRAY);
							drawpaint.setAntiAlias(true);
							break;
						case 4:
							//线条颜色
							drawpaint = new Paint();
							drawpaint.setStrokeWidth(sizesize);
							drawpaint.setColor(Color.GREEN);
							drawpaint.setAntiAlias(true);
							break;
						case 5:
							//线条颜色
							drawpaint = new Paint();
							drawpaint.setStrokeWidth(sizesize);
							drawpaint.setColor(Color.RED);
							drawpaint.setAntiAlias(true);
							break;
						case 6:
							//线条颜色
							drawpaint = new Paint();
							drawpaint.setStrokeWidth(sizesize);
							drawpaint.setColor(Color.YELLOW);
							drawpaint.setAntiAlias(true);
							break;
					}

					
				

}
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					Log.e("------------", "开始滑动！");
				}

				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					Log.e("------------", "停止滑动！");
				}
			});

		
				//调用画图函数。初始化图像
				draww();

				//把图片展示到ImageView中				
			iw.setImageBitmap(baseBitmap);	
			
			
		reset.setOnClickListener(new OnClickListener()
			{

				@Override
				public void onClick(View p1)
				{
					baseBitmap = Bitmap.createBitmap(1000,													 
													 1000, Bitmap.Config.ARGB_8888);					

					width = baseBitmap.getWidth();
					height = baseBitmap.getHeight();


					canvas = new Canvas(baseBitmap);
					canvas.drawColor(Color.WHITE);													

					//画十字
					canvas.drawLine(0,width/2,width,width/2,paint);
					canvas.drawLine(width/2,0,width/2,width,paint);

					//画y箭头
					canvas.drawLine(width/2,0,width/2-width/50,width/(width/20),paint);
					canvas.drawLine(width/2,0,width/2+width/50,width/(width/20),paint);
					canvas.drawText("y",width/2+(width/50),width/20,Textpaint);

					//画x箭头
					canvas.drawLine(width,width/2,width-width/(width/20),width/2-(width/50),paint);
					canvas.drawLine(width,width/2,width-width/(width/20),width/2+(width/50),paint);
					canvas.drawText("x",width-(width/40),width/2+width/20,Textpaint);


					//画x坐标轴
					//正轴
					canvas.drawLine(width/5*4+width/10,width/2,width/5*4+width/10,width/2-width/50,spaint);
					canvas.drawText("4",width/5*4+width/10,width/2+width/20,Textpaint);				
					canvas.drawLine(width/5*4,width/2,width/5*4,width/2-width/50,spaint);
					canvas.drawText("3",width/5*4,width/2+width/20,Textpaint);			
					canvas.drawLine(width/5*4-width/10,width/2,width/5*4-width/10,width/2-width/50,spaint);
					canvas.drawText("2",width/5*4-width/10,width/2+width/20,Textpaint);	
					canvas.drawLine(width/5*4-width/5,width/2,width/5*4-width/5,width/2-width/50,spaint);
					canvas.drawText("1",width/5*4-width/5,width/2+width/20,Textpaint);
					//负轴
					canvas.drawLine(width/2/5*4,width/2,width/2/5*4,width/2-width/50,spaint);
					canvas.drawText("-1",width/2/5*4,width/2+width/20,Textpaint);			
					canvas.drawLine(width/2/5*4-width/10,width/2,width/2/5*4-width/10,width/2-width/50,spaint);
					canvas.drawText("-2",width/2/5*4-width/10,width/2+width/20,Textpaint);				
					canvas.drawLine(width/2/5*4-width/5,width/2,width/2/5*4-width/5,width/2-width/50,spaint);
					canvas.drawText("-3",width/2/5*4-width/5,width/2+width/20,Textpaint);
					canvas.drawLine(width/2/5*4-width/10*3,width/2,width/2/5*4-width/10*3,width/2-width/50,spaint);
					canvas.drawText("-4",width/2/5*4-width/10*3,width/2+width/20,Textpaint);

					//原点
					canvas.drawText("0",width/2+width/50,width/2+width/20,Textpaint);

					//画y坐标轴
					canvas.drawLine(width/2,width/2/5*4,width/2+width/50,width/2/5*4,spaint);
					canvas.drawText("1",width/2-width/20,width/2/5*4,Textpaint);
					canvas.drawLine(width/2,width/2/5*4-width/10,width/2+width/50,width/2/5*4-width/10,spaint);
					canvas.drawText("2",width/2-width/20,width/2/5*4-width/10,Textpaint);
					canvas.drawLine(width/2,width/2/5*4-width/5,width/2+width/50,width/2/5*4-width/5,spaint);
					canvas.drawText("3",width/2-width/20,width/2/5*4-width/5,Textpaint);
					canvas.drawLine(width/2,width/2/5*4-width/10*3,width/2+width/50,width/2/5*4-width/10*3,spaint);
					canvas.drawText("4",width/2-width/20,width/2/5*4-width/10*3,Textpaint);	
					//负轴
					canvas.drawLine(width/2,width/5*4,width/2+width/50,width/5*4,spaint);
					canvas.drawText("-1",width/2-width/20,width/5*4-width/5,Textpaint);
					canvas.drawLine(width/2,width/5*4-width/10,width/2+width/50,width/5*4-width/10,spaint);
					canvas.drawText("-2",width/2-width/20,width/5*4-width/10,Textpaint);	
					canvas.drawLine(width/2,width/5*4-width/5,width/2+width/50,width/5*4-width/5,spaint);
					canvas.drawText("-3",width/2-width/20,width/5*4,Textpaint);
					canvas.drawLine(width/2,width/2/5*4+width/2,width/2+width/50,width/2/5*4+width/2,spaint);
					canvas.drawText("-4",width/2-width/20,width/2/5*4+width/2,Textpaint);
					iw.setImageBitmap(baseBitmap);	
					// TODO: Implement this method
					Toast.makeText(MainActivity.this,"已还原",Toast.LENGTH_SHORT).show();
				}
			});
			
		drawpicture.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{		
					//获取字符串
					String aaa  = EditTexta.getText().toString();
					String bbb  = EditTextb.getText().toString();
					String ccc  = EditTextc.getText().toString();
					
					//判断字符串中是否含有"。若含有，这调用函数，把他们计算出来
					if(aaa.contains("\"")==true)
						aa = js.answer(aaa);				
					else
						aa = Float.valueOf(aaa);
						
					if(bbb.contains("\"")==true)
					bb = js.answer(bbb);
					else
						bb = Float.valueOf(bbb);
					
					if(ccc.contains("\"")==true)
						cc = js.answer(ccc);
					else
						cc = Float.valueOf(ccc);				
						
					//转成float型
					geta = Float.valueOf(aa)/100;
					getb = Float.valueOf(bb);
					getc = Float.valueOf(cc)*100;
						
					//计算并画图
					zjs();
					//把图片展示到ImageView中				
					iw.setImageBitmap(baseBitmap);	
				}

				private void zjs()
				{
					//首先刷新再画
					draww();					
					//计算函数并画出来			
					for (int x=-1000 ; x<=1000 ; x++)
					{
						float xa =(x+1);
						float y=(geta*x*x+getb*x+getc);
						float ya=(geta*xa*xa+getb*xa+getc);					
						canvas.drawLine(x+width/2,-y+width/2,xa+width/2,-ya+width/2,drawpaint);					
					}													
				}														
			});//结束点击事件
		
}


		public void draww()
		{
			if
			(baseBitmap == null) 
			{			
				baseBitmap = Bitmap.createBitmap(1000,													 
												 1000, Bitmap.Config.ARGB_8888);					

				width = baseBitmap.getWidth();
				height = baseBitmap.getHeight();


				canvas = new Canvas(baseBitmap);
				canvas.drawColor(Color.WHITE);													
				
			//画十字
			canvas.drawLine(0,width/2,width,width/2,paint);
			canvas.drawLine(width/2,0,width/2,width,paint);

			//画y箭头
			canvas.drawLine(width/2,0,width/2-width/50,width/(width/20),paint);
			canvas.drawLine(width/2,0,width/2+width/50,width/(width/20),paint);
			canvas.drawText("y",width/2+(width/50),width/20,Textpaint);

			//画x箭头
			canvas.drawLine(width,width/2,width-width/(width/20),width/2-(width/50),paint);
			canvas.drawLine(width,width/2,width-width/(width/20),width/2+(width/50),paint);
			canvas.drawText("x",width-(width/40),width/2+width/20,Textpaint);


			//画x坐标轴
			//正轴
			canvas.drawLine(width/5*4+width/10,width/2,width/5*4+width/10,width/2-width/50,spaint);
			canvas.drawText("4",width/5*4+width/10,width/2+width/20,Textpaint);				
			canvas.drawLine(width/5*4,width/2,width/5*4,width/2-width/50,spaint);
			canvas.drawText("3",width/5*4,width/2+width/20,Textpaint);			
			canvas.drawLine(width/5*4-width/10,width/2,width/5*4-width/10,width/2-width/50,spaint);
			canvas.drawText("2",width/5*4-width/10,width/2+width/20,Textpaint);	
			canvas.drawLine(width/5*4-width/5,width/2,width/5*4-width/5,width/2-width/50,spaint);
			canvas.drawText("1",width/5*4-width/5,width/2+width/20,Textpaint);
			//负轴
			canvas.drawLine(width/2/5*4,width/2,width/2/5*4,width/2-width/50,spaint);
			canvas.drawText("-1",width/2/5*4,width/2+width/20,Textpaint);			
			canvas.drawLine(width/2/5*4-width/10,width/2,width/2/5*4-width/10,width/2-width/50,spaint);
			canvas.drawText("-2",width/2/5*4-width/10,width/2+width/20,Textpaint);				
			canvas.drawLine(width/2/5*4-width/5,width/2,width/2/5*4-width/5,width/2-width/50,spaint);
			canvas.drawText("-3",width/2/5*4-width/5,width/2+width/20,Textpaint);
			canvas.drawLine(width/2/5*4-width/10*3,width/2,width/2/5*4-width/10*3,width/2-width/50,spaint);
			canvas.drawText("-4",width/2/5*4-width/10*3,width/2+width/20,Textpaint);
				
			//原点
			canvas.drawText("0",width/2+width/50,width/2+width/20,Textpaint);

			//画y坐标轴
			canvas.drawLine(width/2,width/2/5*4,width/2+width/50,width/2/5*4,spaint);
			canvas.drawText("1",width/2-width/20,width/2/5*4,Textpaint);
			canvas.drawLine(width/2,width/2/5*4-width/10,width/2+width/50,width/2/5*4-width/10,spaint);
			canvas.drawText("2",width/2-width/20,width/2/5*4-width/10,Textpaint);
			canvas.drawLine(width/2,width/2/5*4-width/5,width/2+width/50,width/2/5*4-width/5,spaint);
			canvas.drawText("3",width/2-width/20,width/2/5*4-width/5,Textpaint);
			canvas.drawLine(width/2,width/2/5*4-width/10*3,width/2+width/50,width/2/5*4-width/10*3,spaint);
			canvas.drawText("4",width/2-width/20,width/2/5*4-width/10*3,Textpaint);	
			//负轴
			canvas.drawLine(width/2,width/5*4,width/2+width/50,width/5*4,spaint);
			canvas.drawText("-1",width/2-width/20,width/5*4-width/5,Textpaint);
			canvas.drawLine(width/2,width/5*4-width/10,width/2+width/50,width/5*4-width/10,spaint);
			canvas.drawText("-2",width/2-width/20,width/5*4-width/10,Textpaint);	
			canvas.drawLine(width/2,width/5*4-width/5,width/2+width/50,width/5*4-width/5,spaint);
			canvas.drawText("-3",width/2-width/20,width/5*4,Textpaint);
			canvas.drawLine(width/2,width/2/5*4+width/2,width/2+width/50,width/2/5*4+width/2,spaint);
			canvas.drawText("-4",width/2-width/20,width/2/5*4+width/2,Textpaint);
				
		}
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu)
		{
			menu.add(1,1,1,"使用说明");
			menu.add(2,2,2,"关于");
			return true;
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item)
		{
			if(item.getItemId()==1)
			{
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				
				builder.setTitle("使用说明");
				builder.setMessage("软件的使用：\n在分别在a=\tb=\tc=\t的后面加上函数：\ny=ax^2+bx+c中的a，b，c。\n然后点击绘图，就可以画出二次函数的图像了（＾_＾）\n\n\n\nQ：这个软件能不能在同一个坐标轴上画多个二次函数图像呢？我想比较这些函数的关系（＾_＾）\nA：这个当然是可以的。\n\n\nQ：我画的图像太多了，退出重进又太麻烦了，怎么办？\nA：软件中间有个还原，点击一下，画过的图像都会消失。所以，放心画吧！\n\n\nQ：画的线条太多，分不清怎么办(╯︵╰,)\nA：点击颜色，可以自定义颜色！（＾_＾），拖动拖动条，还可以自定义线条的大小！");
				builder.setIcon(R.drawable.app);
				builder.setPositiveButton("知道了", new DialogInterface.OnClickListener(){
				
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							// TODO: Implement this method
						}
					});
				
				builder.show();
			}
			if(item.getItemId()==2)
			{
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

				builder.setTitle("关于");
				builder.setMessage("\t由于本人是小白，所以很多地方还没有完善，要是各位有什么好的建议，不妨浪费几分钟把建议留下来。\n\n\t\t\t\t\t\t\t\t\t\t————by：蓝天\n\t\t\t\t\t\t\t\t\t\t\tQQ:1980718886");
				builder.setIcon(R.drawable.app);
				builder.setPositiveButton("知道了", new DialogInterface.OnClickListener(){

						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							// TODO: Implement this method
						}
					});

				builder.show();
			}
			
			return false;
		}
		

		
	
		
	
}


