/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labrotation;

/**
 *
 * @author Arshad
 */


import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.Scanner;
//import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javax.media.opengl.GL2;
import static javax.media.opengl.GL2.GL_POLYGON;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

/**
 *
 * @author arshad
 */
public class LabRotation implements GLEventListener{

    /**
     * @param args the command line arguments
     */
    
    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
          double [] z= new double[10000];
          double [] w= new double[10000];
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
          int j=0;
          
    public static void main(String[] args) {
        // TODO code application logic here
        LabRotation l = new LabRotation();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 600);
              
	      final JFrame frame = new JFrame ("Rotation");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              FPSAnimator animator = new FPSAnimator(glcanvas, 60);
        animator.add(glcanvas);
        animator.start();
    }

    @Override
    public void init(GLAutoDrawable glad) {
//    glad.getGL().setSwapInterval(Integer.BYTES);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display(GLAutoDrawable glad) {
           final GL2 gl = glad.getGL().getGL2();
         render(glad);
         
         gl.glBegin(GL2.GL_POINTS);
         for (int i = 0; i < z.length; i++) {
            gl.glVertex2d(z[i], w[i]);
        }
         gl.glEnd();
         exit();
        
            
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void render(GLAutoDrawable glad){
        final GL2 gl = glad.getGL().getGL2();
       	 // gl.glBegin (GL2.GL_POINTS);//static field
         
             glad.swapBuffers();
            gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
            
        double t=Math.toRadians(i);
            double x_1=x1*Math.cos(t)-y1*Math.sin(t);
           double y_1=x1*Math.sin(t)+y1*Math.cos(t);
           
           z[j]=x_1;
           w[j]=y_1;
           
           double x_2=x2*Math.cos(t)-y2*Math.sin(t);
           double y_2=x2*Math.sin(t)+y2*Math.cos(t);
           
           double x_3=x3*Math.cos(t)-y3*Math.sin(t);
           double y_3=x3*Math.sin(t)+y3*Math.cos(t);
           
           double x_4=x4*Math.cos(t)-y4*Math.sin(t);
           double y_4=x4*Math.sin(t)+y4*Math.cos(t);
           
           double x_5=x5*Math.cos(t)-y5*Math.sin(t);
           double y_5=x5*Math.sin(t)+y5*Math.cos(t);
           
           double x_6=x6*Math.cos(t)-y6*Math.sin(t);
           double y_6=x6*Math.sin(t)+y6*Math.cos(t);
           
           double x_7=x7*Math.cos(t)-y7*Math.sin(t);
           double y_7=x7*Math.sin(t)+y7*Math.cos(t);
           
           double x_8=x8*Math.cos(t)-y8*Math.sin(t);
           double y_8=x8*Math.sin(t)+y8*Math.cos(t);

           
          
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex2d(x_1, y_1);
            gl.glVertex2d(x_2, y_2);
            
            gl.glVertex2d(x_1, y_1);
            gl.glVertex2d(x_3, y_3);
            
            gl.glVertex2d(x_3, y_3);
            gl.glVertex2d(x_4, y_4);
            
            gl.glVertex2d(x_2, y_2);
            gl.glVertex2d(x_4, y_4);
            
            gl.glVertex2d(x_5, y_5);
            gl.glVertex2d(x_6, y_6);
            
            gl.glVertex2d(x_5, y_5);
            gl.glVertex2d(x_7, y_7);
            
            gl.glVertex2d(x_7, y_7);
            gl.glVertex2d(x_8, y_8);
            
            gl.glVertex2d(x_6, y_6);
            gl.glVertex2d(x_8, y_8);
            
            gl.glVertex2d(x_1, y_1);
            gl.glVertex2d(x_5, y_5);
            
            gl.glVertex2d(x_2, y_2);
            gl.glVertex2d(x_6, y_6);
            
            gl.glVertex2d(x_3, y_3);
            gl.glVertex2d(x_7, y_7);
            
            gl.glVertex2d(x_4, y_4);
            gl.glVertex2d(x_8, y_8);
            gl.glEnd();
            j++;
        
    }
}

    
