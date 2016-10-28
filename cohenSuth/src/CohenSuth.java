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
//import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class CohenSuth implements GLEventListener{
    
static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    static float Xmin=-.5f;
    static float Xmax=.5f;
    static float Ymin=-.5f;
    static float Ymax=.5f;
    static int Top=8;
    static int Bottom=4;
    static int Right=2;
    static int Left=1;
    
    
    
    
    public static void main(String[] args) throws IOException {
       CohenSuth l = new CohenSuth();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
              
	      final JFrame frame = new JFrame ("Cohen SutherLand Line Clipping");
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
                    float[] np=new float[4];
                    
                    np=cohen_SutherlandLC(x0, y0, x1, y1);
                    x0=np[0];
                    y0=np[1];
                    x1=np[2];
                    y1=np[3];
                    
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
            Logger.getLogger(CohenSuth.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
        Logger.getLogger(CohenSuth.class.getName()).log(Level.SEVERE, null, ex);
    }
          
          gl.glEnd();
  
            
                    }

    int makeCode(float x,float y){
        int outCode=0;
        if(x<Xmin){
            outCode+=1;
        }
        else if(x>Xmax){
            outCode+=2;
        }
        if(y<Ymin){
            outCode+=4;
        }
        else if(y>Ymax){
            outCode+=8;
        }
        return outCode;
    }
    
    float[] cohen_SutherlandLC(float x0,float y0, float x1,float y1){
        float x=0;
        float y=0;
        int code=0;
        int code0=0;
        int code1=0;
        float[] z=new float[4];
        while(true){
            code0=makeCode(x0,y0);
            code1=makeCode(x1,y1);
            System.out.println(code0+","+code1);
            System.out.println((code0 | code1));
            System.out.println((code0 & code1));
            if((code0 | code1)==0){
                z[0]=x0;
                z[1]=y0;
                z[2]=x1;
                z[3]=y1;
                System.out.println("Accepted");
                return z;
                //exit(1);
            }
            else if((code0 & code1)>0){
                z[0]=0;
                z[1]=0;
                z[2]=0;
                z[3]=0;
                System.out.println("Rejected");
                return z;
            }
            else{
                if(code0 >=1){
                    code=code0;
                }else{
                    code = code1;
                }
            }
            if ((code & Top)!=0) {
                x=x0+((Ymax-y0)/(y1-y0))*(x1-x0);
                y=Ymax;
            }
            else if ((code & Bottom)!=0) {
                x=x0+((Ymin-y0)/(y1-y0))*(x1-x0);
                y=Ymin;
            }
            else if ((code & Right)!=0) {
                x=Xmax;
                y=y0+((Xmax-x0)/(x1-x0))*(y1-y0);
            }
            else if ((code & Left)!=0) {
                x=Xmin;
                y=y0+((Xmin-x0)/(x1-x0))*(y1-y0);
            }
            if(code==code0){
                x0=x;
                y0=y;
                System.out.println(x0+"+"+y0);
            }else{
                x1=x;
                y1=y;
                System.out.println(x1+"+"+y1);
            }
        }
    }
    
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
}
