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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Lab03 implements GLEventListener{
    
static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
    public static void main(String[] args) throws IOException {
       Lab03 l = new Lab03();
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
    public void init(GLAutoDrawable glad) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void dispose(GLAutoDrawable glad) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void display(GLAutoDrawable drawable) {
       
      final GL2 gl = drawable.getGL().getGL2();
       	  gl.glBegin (GL2.GL_POINTS);//static field
          String line;
            String z[]=new String[4];
            float x0=0;
            float x1=0;
            float y0=0;
            float y1=0;
            float dx=0;
            float dy=0;
            try {
                BufferedReader br=new BufferedReader(new FileReader("a.txt"));
                while((line=br.readLine())!=null){
                    z=line.split(" ");
                    x0=Float.valueOf(z[0]);
                    y0=Float.valueOf(z[1]);
                    x1=Float.valueOf(z[2]);
                    y1=Float.valueOf(z[3]);
//                    gl.glVertex2d(x0, y0);
//                    gl.glVertex2d(x1, y1);
                    
                    dx=x1-x0;
                    dy=y1-y0;
                    if(Math.abs(dx)>=Math.abs(dy)){
                        if(dx>=0 && dy>=0){  //Zone 0
                            System.out.println("Zone 0: ("+x0+","+y0+") ("+x1+ ","+y1+")");
                            float d=2*dy-dx;
                            float dE=2*dy;
                            float dNE=2*dy-2*dx;
                            float x=x0;
                            float y=y0;
                            
//                            gl.glVertex2d(x, y);
                            while(x<x1){
                                if (d<0) { 
                                    x+=.01f;
                                    d+=dE;
                                }else{
                                    x+=.01f;
                                    y+=.01f;
                                    d+=dNE;
                                }
                                gl.glColor3d(0, 0, 1);
                                gl.glVertex2d(x, y);
                            }
                        }
                        else if(dx>=0 && dy<0){ // zone 7
                            System.out.println("Zone 7: ("+x0+","+y0+") ("+x1+ ","+y1+")");
                            float d=2*dy+dx;
                            float dE=2*dy;
                            float dSE=2*dx+2*dy;
                            float x=x0;
                            float y=y0;
                            
//                            gl.glVertex2d(x, y);
                            while(x<x1){
                                if (d>0) { 
                                    x+=.01f;
                                    d+=dE;
                                }else{
                                    x+=.01f;
                                    y-=.01f;
                                    d+=dSE;
                                }
                                gl.glColor3d(0, 2, 0);
                                gl.glVertex2d(x, y);
                            }
                        }
                        else if(dx<0 && dy>=0){ //zone 3
                            System.out.println("Zone 3: ("+x0+","+y0+") ("+x1+ ","+y1+")");
                            float d=-2*dy-dx;
                            float dW=-2*dy;
                            float dNW=-2*dy-2*dx;
                            float x=x0;
                            float y=y0;
                            
//                            gl.glVertex2d(x, y);
                            while(x>x1){
                                if (d>0) {
                                    x-=.01f;
                                    d+=dW;
                                }else{
                                    x-=.01f;
                                    y+=.01f;
                                    d+=dNW;
                                }
                                gl.glColor3d(2, 0, 1);
                                gl.glVertex2d(x, y);
                            }
                        }
                        else if(dx<0 && dy<0){  //zone 4
                            System.out.println("Zone 4: ("+x0+","+y0+") ("+x1+ ","+y1+")");
                            float d=-2*dy+dx;
                            float dW=-2*dy;
                            float dSW=2*dx-2*dy;
                            float x=x0;
                            float y=y0;
                            
//                            gl.glVertex2d(x, y);
                            while(x>x1){
                                if (d<0) {
                                    x-=.01f;
                                    d+=dW;
                                }else{
                                    x-=.01f;
                                    y-=.01f;
                                    d+=dSW;
                                }
                                gl.glColor3d(0, 2, 2);
                                gl.glVertex2d(x, y);
                            }
                        }
                    }else{
                        if(dx>=0 && dy>=0){ // zone 1
                            System.out.println("Zone 1: ("+x0+","+y0+") ("+x1+ ","+y1+")");
                            float d=dy-2*dx;
                            float dN=-2*dx;
                            float dNE=-2*dy-2*dx;
                            float x=x0;
                            float y=y0;
                            
//                            gl.glVertex2d(x, y);
                            while(y<y1){
                                if (d>=0) {
                                    y+=.01f;
                                    d+=dN;
                                }else{
                                    x+=.01f;
                                    y+=.01f;
                                    d+=dNE;
                                }
                                gl.glColor3d(1, 0, 0);
                                gl.glVertex2d(x, y);
                            }
                        }
                        else if(dx>=0 && dy<0){  // zone 6
                            System.out.println("Zone 6: ("+x0+","+y0+") ("+x1+ ","+y1+")");
                            float d=dy+2*dx;
                            float dS=2*dx;
                            float dSE=2*(dy+dx);
                            float x=x0;
                            float y=y0;
                            
//                            gl.glVertex2d(x, y);
                            while(y>y1){
                                if (d<0) { 
                                    y-=.01f;
                                    d+=dS;
                                }else{
                                    x+=.01f;
                                    y-=.01f;
                                    d+=dSE;
                                }
                                gl.glColor3d(1, 2, 0);
                                gl.glVertex2d(x, y);
                            }
                        }
                        else if(dx<0 && dy>=0) { //zone 2
                            System.out.println("Zone 2: ("+x0+","+y0+") ("+x1+ ","+y1+")");
                            float d=-dy-2*dx;
                            float dN=-2*(dy+dx);
                            float dNW=-2*dy+2*dx;
                            float x=x0;
                            float y=y0;
                            
//                            gl.glVertex2d(x, y);
                            while(y<y1){
                                if (d>=0) {
                                    y+=.01f;
                                    d+=dN;
                                }else{
                                    x-=.01f;
                                    y+=.01f;
                                    d+=dNW;
                                }
                                gl.glColor3d(.5, -.5, 1.5);
                                gl.glVertex2d(x, y);
                            }
                        }
                        else if(dx<0 && dy<0){  //zone 5
                            System.out.println("Zone 5: ("+x0+","+y0+") ("+x1+ ","+y1+")");
                            float d=-dy+2*dx;
                            float dS=2*dx;
                            float dSW=2*dx-2*dy;
                            float x=x0;
                            float y=y0;
                            
//                            gl.glVertex2d(x, y);
                            while(y>=y1){
                                if (d>0) {
                                    x-=.01f;
                                    d+=dS;
                                }else{
                                    x-=.01f;
                                    y-=.01f;
                                    d+=dSW;
                                }
                                gl.glColor3d(1, .5, -.5);
                                gl.glVertex2d(x, y);
                            }
                        }
                    }
                    
            }
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lab03.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
        Logger.getLogger(Lab03.class.getName()).log(Level.SEVERE, null, ex);
    }
          
          gl.glEnd();
  
            
                    }

    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
}
