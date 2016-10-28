/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse423_rotation;

import com.jogamp.opengl.util.Animator;
import java.util.Scanner;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

/**
 *
 * @author Koushik
 */
public class Line implements GLEventListener{

    /**
     * @param args the command line arguments
     */
    
    static GLProfile profile=GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    static GLCanvas glcanvas = new GLCanvas(capabilities);
  
    static int zone;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lab=new Scanner(System.in);
         zone=lab.nextInt();
        
        Line l=new Line();
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(600, 400);
        
         final JFrame frame = new JFrame ("straight Line");
       frame.getContentPane().add(glcanvas);
       frame.setSize(frame.getContentPane().getPreferredSize());
       frame.setVisible(true);
       
       
       //frame.getContentPane().setBackground(Color.white);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
      
    }

    @Override
    public void init(GLAutoDrawable glad) {
       //glad.getGL().setSwapInterval(1);
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display(GLAutoDrawable glad) {
        final GL2 gl = glad.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glBegin (GL2.GL_LINES);//static field
        gl.glVertex2d(-1,0);
        gl.glVertex2d(-1,1);
        gl.glEnd();
        float x0=.1f,x1=.5f,x2=.1f,x3=.5f;
    	float y0=.1f,y1=.1f,y2=.5f,y3=.5f;
          gl.glBegin (GL2.GL_LINES);//static field
          gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
          
    	
        gl.glVertex2d(x0,y0);
        gl.glVertex2d(x1,y1);
        
        gl.glVertex2d(x0,y0);
        gl.glVertex2d(x2,y2);
        
        gl.glVertex2d(x2,y2);
        gl.glVertex2d(x3,y3);
        
        gl.glVertex2d(x1,y1);
        gl.glVertex2d(x3,y3);
        
        
          gl.glEnd();
          double i=zone*90;
          //for (double i = 0; i < 360; i+=90) {
            rotate(gl, x0, y0, x1, y1, i);
          rotate(gl, x0, y0, x2, y2, i);
          rotate(gl, x2, y2, x3, y3, i);
          rotate(gl, x1, y1, x3, y3, i);
        //}
          
          
    }
    
    public void rotate(GL2 gl,float p,float q,float  p1,float  q1, double t){
        double theta=Math.toRadians(t);
       
        double nx0=p*Math.cos(theta)-q*Math.sin(theta);
    	double ny0=q*Math.cos(theta)+p*Math.sin(theta);
    	double nx1=p1*Math.cos(theta)-q1*Math.sin(theta);
    	double ny1=q1*Math.cos(theta)+p1*Math.sin(theta);
        
        gl.glBegin(GL2.GL_LINES);
    	gl.glVertex2d(nx0,ny0);
        gl.glVertex2d(nx1,ny1);
        
        
        gl.glEnd();
        
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
