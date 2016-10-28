/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06rotation;

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
public class Lab06Transform implements GLEventListener{

    /**
     * @param args the command line arguments
     */
    
    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Lab06Transform l = new Lab06Transform();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 600);
              
	      final JFrame frame = new JFrame ("Line Clipping");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void init(GLAutoDrawable glad) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display(GLAutoDrawable glad) {
         final GL2 gl = glad.getGL().getGL2();
       	 // gl.glBegin (GL2.GL_POINTS);//static field
          
          double x1=.1;
          double x2=.7;
          double x3=.1;
          double x4=.7;
          double y1=.1;
          double y2=.1;
          double y3=.4;
          double y4=.4;
          
          
          
            gl.glBegin(GL2.GL_LINES);
             gl.glVertex2d(x1, y1);
            gl.glVertex2d(x2, y2);
            
            gl.glVertex2d(x1, y1);
            gl.glVertex2d(x3, y3);
            
            gl.glVertex2d(x2, y2);
            gl.glVertex2d(x4, y4);
            
            gl.glVertex2d(x3, y3);
            gl.glVertex2d(x4, y4);
            gl.glEnd();
            
            
            
//          double dx=(x1+x2)/2;
//          double dy=(y1+y2)/2;
          
          Scanner rex=new Scanner(System.in);
          
          double t=Math.toRadians(90*rex.nextDouble());
          
//           x1=x1-dx;
//           x2=x2-dx;
//           y1=y1-dy;
//           y2=y2-dy;

           double x_1=x1*Math.cos(t)-y1*Math.sin(t);
           double y_1=x1*Math.sin(t)+y1*Math.cos(t);
           
           double x_2=x2*Math.cos(t)-y2*Math.sin(t);
           double y_2=x2*Math.sin(t)+y2*Math.cos(t);
           
           double x_3=x3*Math.cos(t)-y3*Math.sin(t);
           double y_3=x3*Math.sin(t)+y3*Math.cos(t);
           
           double x_4=x4*Math.cos(t)-y4*Math.sin(t);
           double y_4=x4*Math.sin(t)+y4*Math.cos(t);
           
//           x1=x_1+dx;
//           x2=x_2+dx;
//           y1=y_1+dy;
//           y2=y_2+dy;
          
          
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex2d(x_1, y_1);
            gl.glVertex2d(x_2, y_2);
            
            gl.glVertex2d(x_1, y_1);
            gl.glVertex2d(x_3, y_3);
            
            gl.glVertex2d(x_3, y_3);
            gl.glVertex2d(x_4, y_4);
            
            gl.glVertex2d(x_2, y_2);
            gl.glVertex2d(x_4, y_4);
            
            
            gl.glEnd();
                      
          }
           
    

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void glBegin(int GL_POLYGON) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
