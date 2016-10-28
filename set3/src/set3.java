
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
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
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arsha
 */
public class set3 implements GLEventListener {

    /**
     * @param args the command line arguments
     */
    
    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    static Scanner rex = new Scanner(System.in);
    static int n=rex.nextInt();
    static float[] xpoints = new float[n] ;
    static float[] ypoints = new float[n] ;
    static int count=0;
    static int c=0;
    public static void main(String[] args) {
        // TODO code application logic here
        set3 l = new set3();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 600);
              
	      final JFrame frame = new JFrame ("Circle Mid Point");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
              GLAutoDrawable glad;
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
        
    }

    @Override
    public void init(GLAutoDrawable glad) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display(GLAutoDrawable glad) {
        final GL2 gl = glad.getGL().getGL2();
       	gl.glBegin (GL2.GL_POINTS);//static field
        
        try {
            BufferedReader br=new BufferedReader(new FileReader("a.txt"));
            String line;
            while((line=br.readLine())!=null){
                String [] z = line.split(" ");
                float r = Float.parseFloat(z[0]);
                float x0 = Float.parseFloat(z[1]);
                float y0 = Float.parseFloat(z[2]);
                
                float x=0;
                float y=r;
                float d=5-4*r;
//                float dE=4*(2*x+3);
//                float dSE=4*(2*x-2*y+5);
                
                gl.glVertex2d(x0+x, y0+y);
                gl.glVertex2d(x0+x, y0-y);
                gl.glVertex2d(x0-x, y0+y);
                gl.glVertex2d(x0-x, y0-y);
                gl.glVertex2d(x0+y, y0+x);
                gl.glVertex2d(x0+y, y0-x);
                gl.glVertex2d(x0-y, y0+x);
                gl.glVertex2d(x0-y, y0-x);
                
                while(x<y){
                    if (d<0) {
                        d+=4*(2*x+3);
                        x+=.1f;
                    }else{
                        d+=4*(2*x-2*y+5);
                        x+=.1f;
                        y-=.1f;
                    }
                    
                    gl.glVertex2d(x0+x, y0+y);
                    gl.glVertex2d(x0+x, y0-y);
                    gl.glVertex2d(x0-x, y0+y);
                    gl.glVertex2d(x0-x, y0-y);
                    gl.glVertex2d(x0+y, y0+x);
                    gl.glVertex2d(x0+y, y0-x);
                    gl.glVertex2d(x0-y, y0+x);
                    gl.glVertex2d(x0-y, y0-x);
                    
                   if(c%100==0){
                    for (int i = 0; i < 8; i++) {
                        System.out.println("count: "+count);
                        if(count<n){
                            if (i==0) {
                                xpoints[count]=x0+x;
                                ypoints[count]=y0+y;
                                count++;
                            }
//                            else if (i==1) {
//                                xpoints[count]=x0+x;
//                                ypoints[count]=y0-y;
//                                count++;
//                            }
//                            else if (i==2) {
//                                xpoints[count]=x0-x;
//                                ypoints[count]=y0+y;
//                                count++;
//                            }
                            else if (i==3) {
                                xpoints[count]=x0-x;
                                ypoints[count]=y0-y;
                                count++;
                            }
                            else if (i==4) {
                                xpoints[count]=x0+y;
                                ypoints[count]=y0+x;
                                count++;
                            }
//                            else if (i==5) {
//                                xpoints[count]=x0+y;
//                                ypoints[count]=y0-x;
//                                count++;
//                            }
//                            else if (i==6) {
//                                xpoints[count]=x0-y;
//                                ypoints[count]=y0+x;
//                                count++;
//                            }
                            else if (i==7) {
                                xpoints[count]=x0-y;
                                ypoints[count]=y0-x;
                                count++;
                            }
                        }else{
                            break;
                        }
                    }
                   }
                }
                c++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(set3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(set3.class.getName()).log(Level.SEVERE, null, ex);
        }
        int p=0;
        while(p<xpoints.length){
            System.out.println("x:"+xpoints[p]+"y:"+ypoints[p]);
            float r = 150;
            
            float x0 = Float.valueOf(xpoints[p]);
            float y0 = Float.valueOf(ypoints[p]);
                
            float x=0;
            float y=r;
            float d=5-4*r;
            
            gl.glVertex2d(x0+x, y0+y);
            gl.glVertex2d(x0+x, y0-y);
            gl.glVertex2d(x0-x, y0+y);
            gl.glVertex2d(x0-x, y0-y);
            gl.glVertex2d(x0+y, y0+x);
            gl.glVertex2d(x0+y, y0-x);
            gl.glVertex2d(x0-y, y0+x);
            gl.glVertex2d(x0-y, y0-x);
                
                while(x<y){
                    if (d<0) {
                        d+=4*(2*x+3);
                        x+=1f;
                    }else{
                        d+=4*(2*x-2*y+5);
                        x+=1f;
                        y-=1f;
                    }
                    
                    gl.glVertex2d(x0+x, y0+y);
                    gl.glVertex2d(x0+x, y0-y);
                    gl.glVertex2d(x0-x, y0+y);
                    gl.glVertex2d(x0-x, y0-y);
                    gl.glVertex2d(x0+y, y0+x);
                    gl.glVertex2d(x0+y, y0-x);
                    gl.glVertex2d(x0-y, y0+x);
                    gl.glVertex2d(x0-y, y0-x);
        }
          p++;
    }
        gl.glEnd();
    }
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        
       GL gl = glad.getGL();
//       GLU glu = new GLU();
       ((GL2ES1) gl).glOrtho (-600, i2, -600, i3, -1.0, 1.0);
    
    }
    
}
