package shamim.graphicslab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Line implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      Line l = new Line();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
	   
      final GL2 gl = drawable.getGL().getGL2();
       	  gl.glBegin (GL2.GL_POINTS);//static field
       	try {
    		BufferedReader br = new BufferedReader(new FileReader("line.txt"));
    		String line;
    		String [] z= new String[2];
    		float x= (float) 0.0;
    		float y= (float) 0.0;
    		float x1= (float) 0.0;
    		float y1= (float) 0.0;
    		int count=0;
    		while((line = br.readLine()) != null){
    			z=line.split(" ",2);
    			if(count==0){
    			x=Float.valueOf(z[0]);
    			y=Float.valueOf(z[1]);
    			gl.glVertex2d(x,y);
    			count++;
    			}
    			else{
    				x1=Float.valueOf(z[0]);
        			y1=Float.valueOf(z[1]);
    				gl.glVertex2d(x1,y1);
    				count++;
    			}
    			
    		}
    		float dy = y1-y;
    		float dx = x1-x;
    		float m = dy/dx;
    		float p=x;
    		float q=y;

    		if(dx==0){	
    			if(q<y1){
	    			while(q<=y1){
	    				gl.glVertex2d(p,q);
	        			q=q+0.001f;
	    			}
    			}else if(q>y1){
    				while(q>=y1){
	    				gl.glVertex2d(p,q);
	        			q=q-0.001f;
	    			}
    			}
    		}else if(m>0){
    			if(p<x1 && q<y1){
        			while(p<=x1 && q<=y1){
        				gl.glVertex2d(p,q);
            			p=p+0.001f;
            			q=q+0.001f;
        			}
        			}else if(p>x1 && q>y1){
        			while(p>=x1 && q>=y1){
        				gl.glVertex2d(p,q);
            			p=p-0.001f;
            			q=q-0.001f;
        			}
        			}
    		}else if(m<0){
    			if(p<x1 && q>y1){
    			while(p<=x1 && q>=y1){
    				gl.glVertex2d(p,q);
        			p=p+0.001f;
        			q=q-0.001f;
    			}
    			}else if(p>x1 && q<y1){
    			while(p>=x1 && q<=y1){
    				gl.glVertex2d(p,q);
        			p=p-0.001f;
        			q=q+0.001f;
    			}
    			}
    		}else if(m==0){
    			if(p<x1){
	    			while(p<=x1){
	    				gl.glVertex2d(p,q);
	        			p=p+0.001f;
	    			}
    			}else if(p>x1){
    				while(p>=x1){
	    				gl.glVertex2d(p,q);
	        			p=p-0.001f;
	    			}
    			}
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


