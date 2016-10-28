
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import javax.media.opengl.glu.GLU;
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
public class Lab04 implements GLEventListener {

    /**
     * @param args the command line arguments
     */
    
    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Lab04 l = new Lab04();
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
            BufferedReader br=new BufferedReader(new FileReader("r.txt"));
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
                        x+=.001f;
                    }else{
                        d+=4*(2*x-2*y+5);
                        x+=.001f;
                        y-=.001f;
                    }
                    gl.glVertex2d(x0+x, y0+y);
                    gl.glVertex2d(x0+x, y0-y);
                    gl.glVertex2d(x0-x, y0+y);
                    gl.glVertex2d(x0-x,y0-y);
                    gl.glVertex2d(x0+y, y0+x);
                    gl.glVertex2d(x0+y, y0-x);
                    gl.glVertex2d(x0-y, y0+x);
                    gl.glVertex2d(x0-y, y0-x);
                }
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lab04.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lab04.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        
       GL gl = glad.getGL();
       GLU glu = new GLU();
       ((GL2ES1) gl).glOrtho (-600, i2, -600, i3, -1.0, 1.0);
    
    }
    
}
