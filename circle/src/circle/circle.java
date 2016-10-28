package circle;

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


public class circle implements GLEventListener{

	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
  
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      circle l = new circle();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	  
	      
	      final JFrame frame = new JFrame ("");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      GLAutoDrawable drawable;
	      
	   }
   @Override
 public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
       
       GL gl = drawable.getGL();
       GLU glu = new GLU();
       ((GL2ES1) gl).glOrtho (-600, width, -400, height, -1.0, 1.0);
    
   }
   public void display(GLAutoDrawable drawable) {
       final GL gl=drawable.getGL();
      
       int r=200;
       
       int x=0;
       int y=r;
       int d=5-4*r;
       
       
       draw8way(x, y,drawable);
       
        while(x<y){
                    if (d<0) {
                        d+=4*(2*x+3);
                        x+=1;
                    }else{
                        d+=4*(2*x-2*y+5);
                        x+=1;
                        y-=1;
                    }
           draw8way(x, y, drawable);
       }
       
   }

   
   void draw8way(int x,int y,GLAutoDrawable drawable)
   {

	   
		final GL2 gl = drawable.getGL().getGL2();
		  gl.glBegin (GL2.GL_POINTS);

	        gl.glVertex2d(x, y);
	        gl.glVertex2d(y, x);
	        gl.glVertex2d(-y, x);
	        gl.glVertex2d(-x, y);
	        gl.glVertex2d(-x, -y);
	        gl.glVertex2d(-y, -x);
	        gl.glVertex2d(y, -x);
	        gl.glVertex2d(x, -y);
	         gl.glEnd();
	    }
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
  
  

   //end of main
}//end of cl