/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.round;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
/**
 *
 * @author astha
 */
public class Circle2 implements GLEventListener{

    /**
     * @param args the command line arguments
     */
   static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    static String arr[] = new String[100];
    static BufferedReader rd;
    static BufferedReader rd1;
    static int length = 0;
    static int length2 = 0;
    static String arr2[] = new String[100];
    static int r = 0;
    static int x[] = new int[2];
    static int y[] = new int[2];
    static float lx[] = new float[2];
    static float ly[] = new float[2];
    
   public static void main(String[] args) throws FileNotFoundException, IOException {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      Circle2 l = new Circle2();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 600);
	  
              File f = new File("test\\test5.txt");
              rd = new BufferedReader(new FileReader(f));
              
              while((arr[length]=rd.readLine())!=null){
                length++;
              }
              
              File f2 = new File("test\\test6.txt");
              rd1 = new BufferedReader(new FileReader(f2));
              
              while((arr2[length2]=rd1.readLine())!=null){
                length2++;
              }
	      
	      final JFrame frame = new JFrame ("Circle");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      GLAutoDrawable drawable;
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	   }
   @Override
 public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
       
       GL gl = drawable.getGL();
       GLU glu = new GLU();
       ((GL2ES1) gl).glOrtho (-600, width, -600, height, -1.0, 1.0);
    
   }
   public void display(GLAutoDrawable drawable) {
       //final GL gl=drawable.getGL();
       final GL2 gl = drawable.getGL().getGL2();
		  gl.glBegin (GL2.GL_POINTS);
      for(int i=0; i<length; i++){
                String arr3[] = arr[i].split(" ");
                x[0]= Integer.valueOf(arr3[0]);
               // x[1]= Float.valueOf(arr3[2]);
                y[0]= Integer.valueOf(arr3[1]);
               // y[1]= Float.valueOf(arr3[3]);
                r =Integer.valueOf(arr3[2]);
                
       int x0=x[0];
       int y0=y[0];
       int x=0;
       int y=r;
       int d=5-4*r;
       
       
       draw8way(x, y,x0,y0,drawable);
       
       while(x<y)
       {
           if(d<0)
           {
               d+=4*(2*x+3);
               x+=1;
               
           }
           else
           {
               d+=(-2*y+2*x+5)*4;
               x+=1;
               y-=1;
           }
           draw8way(x, y,x0,y0, drawable);
       }
       
   }
      for(int j=0; j<length2; j++){
                String arr4[] = arr2[j].split(" ");
                lx[j]= Float.valueOf(arr4[0]);
                ly[j]= Float.valueOf(arr4[1]);
                //gl.glVertex2d(Float.valueOf(x[i]),Float.valueOf(y[i]));
            }
            float Delx= lx[1]-lx[0];
            float Dely= ly[1]-ly[0];
           float initialy;
           initialy = ly[0];
           float initialx;
           initialx = lx[0];
           float k = 0.01f;
           gl.glVertex2d(lx[0],ly[0]);
            gl.glVertex2d(lx[1],ly[1]);
           if(Delx>Dely){
           while(initialx<=lx[1] )
            { 
                gl.glVertex2d(initialx,initialy);
                initialx= initialx+ k;
                initialy= initialy+ k;
                
            }}
           else{
               while(initialy<=ly[1] )
            {  
                gl.glVertex2d(initialx,initialy);
                initialx= initialx+ k;
                initialy= initialy+ k;
                
            }
           }
           gl.glEnd();
   }
   
   void draw8way(int x,int y,int x0,int y0,GLAutoDrawable drawable)
   {

	   
		final GL2 gl = drawable.getGL().getGL2();
		  gl.glBegin (GL2.GL_POINTS);
                 
                  Random rand = new Random(); 
                  int ran1= rand.nextInt(3);
                  int ran2= rand.nextInt(2);
                  int ran3= rand.nextInt(2);

                gl.glColor3d(ran1, ran2, ran3);
	        gl.glVertex2d(x0+x, y0+y);
	        gl.glVertex2d(x0+y, y0+x);
	        gl.glVertex2d(x0-y, y0+x);
	        gl.glVertex2d(x0-x, y0+y);
	        gl.glVertex2d(x0-x, y0-y);
	        gl.glVertex2d(x0-y, y0-x);
	        gl.glVertex2d(x0+y, y0-x);
	        gl.glVertex2d(x0+x, y0-y);
	         
	    }
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
  
    
}
