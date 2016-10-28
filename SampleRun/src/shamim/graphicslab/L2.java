package shamim.graphicslab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class L2 implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      L2 l = new L2();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }
   public void display(GLAutoDrawable drawable) {
	   
      final GL2 gl = drawable.getGL().getGL2();
       	  gl.glBegin (GL2.GL_POINTS);//static field
       	try {
    		BufferedReader br = new BufferedReader(new FileReader("Line2.txt"));
    		String line,line2;
    		String [] z= new String[2];
    		float x= (float) 0.0;
    		float y= (float) 0.0;
    		float x1= (float) 0.0;
    		float y1= (float) 0.0;
    		Scanner rex= new Scanner(System.in);
    		int a=rex.nextInt();
    		int i=0;
    		while(i<a){
    			float upper= 1;
    			float lower= -1;
    			
    			//System.out.println("s");
//    			z=line.split(" ",2);
    			x=(float) (Math.random()*(upper-lower)+lower);
    			y=(float) (Math.random()*(upper-lower)+lower);
//    			line2=br.readLine();
//    			z=line2.split(" ",2);
    			x1=(float) (Math.random()*(upper-lower)+lower);
        		y1=(float) (Math.random()*(upper-lower)+lower);
    
    		    
    			
    		
    		float dy = y1-y;
    		float dx = x1-x;
    		float m = dy/dx;
    		float p=x;
    		float q=y;

    		if(dx==0){
    			if(q<y1){
	    			while(q<y1){
	    				q=q+0.001f;
	    				gl.glColor3d(0, 1, 1);
	    				gl.glVertex2d(p,q);
	        			
	    			}
    			}
    			if(q>y1){
    				while(q>y1){
    					q=q-0.001f;
    					gl.glColor3d(1, 1, 0);
	    				gl.glVertex2d(p,q);
    				}
	    		}
    		}else if(m>0){
    			if(p<x1 && q<y1){
        			while(p<x1 && q<y1){
        				p=p+0.001f;
            			q=q+0.001f;
        				gl.glColor3d(1, 0, 2);
        				gl.glVertex2d(p,q);
            			
        			}
    			}
    			if(p>x1 && q>y1){
        			while(p>x1 && q>y1){
        				p=p-0.001f;
            			q=q-0.001f;
        				gl.glColor3d(2, 1, 1);
        				gl.glVertex2d(p,q);
            			
        			}
    			}
    		}else if(m<0){
    			if(p<x1 && q>y1){
    			while(p<x1 && q>y1){
    				p=p+0.001f;
        			q=q-0.001f;
    				gl.glColor3d(0, 1, 0);
    				gl.glVertex2d(p,q);
        			
    			}
    			}
    			if(p>x1 && q<y1){
    			while(p>x1 && q<y1){
    				p=p-0.001f;
        			q=q+0.001f;
    				gl.glColor3d(1, 0, 0);
    				gl.glVertex2d(p,q);
        			
    			}
    			}
    		}else if(m==0){
    			if(p<x1){
	    			while(p<x1){
	    				p=p+0.001f;
	    				gl.glColor3d(1, 2, 0);
	    				gl.glVertex2d(p,q);
	        			
	    			}
    			}
    			if(p>x1){
    				while(p>x1){
    					p=p-0.001f;
    					gl.glColor3d(0, 2, 2);
	    				gl.glVertex2d(p,q);
	        			
	    			}
    			}
    		}
    		
    		
    		i++;
    		}
    		br.close();
    	} catch (FileNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
       // gl.glVertex2d(0.5f,0.5f);
       // gl.glVertex2d(0.5f,-0.5f);
       // gl.glVertex2d(-0.5f,0.5f);
       // gl.glVertex2d(-0.5f,-0.5f);
       	  
          gl.glEnd();
          
          
      
   }
   
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
   
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   //end of main
}//end of class


