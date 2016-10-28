package animrotate;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import com.jogamp.opengl.util.Animator;


public class Animrotate implements GLEventListener {
    
          double x1=.3;
          double x2=.6;
          double x3=.3;
          double x4=.6;
          double y1=.2;
          double y2=.2;
          double y3=.5;
          double y4=.5;
          
          double x5=.5;
          double x6=.8;
          double x7=.5;
          double x8=.8;
          double y5=.4;
          double y6=.4;
          double y7=.7;
          double y8=.7;

    private double theta = 0;
    private double s = 0;
    private double c = 0;
    public static Animator animator;
    public static void main(String[] args) {
    	Animrotate s= new Animrotate();
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        caps.setDoubleBuffered(true);
        GLCanvas canvas = new GLCanvas(caps);
        canvas.addGLEventListener(s);
        JFrame frame = new JFrame("Animating triangle");
        frame.setSize(600, 600);
        frame.add(canvas);
        frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.addGLEventListener(new Animrotate());
        animator = new Animator(canvas);
        animator.start();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
    	theta += 0.01;
        s = Math.sin(theta);
        c = Math.cos(theta);
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
      
        // draw a triangle filling the window
        gl.glBegin(GL2.GL_LINES);
            gl.glVertex2d(x1, y1);
            gl.glVertex2d(x2, y2);
            
            gl.glVertex2d(x1, y1);
            gl.glVertex2d(x3, y3);
            
            gl.glVertex2d(x3, y3);
            gl.glVertex2d(x4, y4);
            
            gl.glVertex2d(x2, y2);
            gl.glVertex2d(x4, y4);
            
            gl.glVertex2d(x5, y5);
            gl.glVertex2d(x6, y6);
            
            gl.glVertex2d(x5, y5);
            gl.glVertex2d(x7, y7);
            
            gl.glVertex2d(x7, y7);
            gl.glVertex2d(x8, y8);
            
            gl.glVertex2d(x6, y6);
            gl.glVertex2d(x8, y8);
            
            gl.glVertex2d(x1, y1);
            gl.glVertex2d(x5, y5);
            
            gl.glVertex2d(x2, y2);
            gl.glVertex2d(x6, y6);
            
            gl.glVertex2d(x3, y3);
            gl.glVertex2d(x7, y7);
            
            gl.glVertex2d(x4, y4);
            gl.glVertex2d(x8, y8);
        gl.glEnd();
    }

  
    public void dispose(GLAutoDrawable drawable) {
    	
    }

   
    public void init(GLAutoDrawable drawable) {
    	drawable.getGL().setSwapInterval(1);
    }

    
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    }

   
}
