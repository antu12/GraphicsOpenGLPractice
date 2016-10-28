/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics_project;

//import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;
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

/**
 *
 * @author Koushik
 */
public class Line2 implements GLEventListener {

    /**
     * @param args the command line arguments
     */
    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    static GLCanvas glcanvas = new GLCanvas(capabilities);
//    static Animator animator;
    
    float x = 205;
    float y = 180;
    float radious = 36f;

    public static void main(String[] args) {
        // TODO code application logic here

        Line2 l = new Line2();

        glcanvas.setSize(600, 700);

        final JFrame frame = new JFrame("project Water Tap");
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        glcanvas.addGLEventListener(l);
        
        FPSAnimator animator = new FPSAnimator(glcanvas, 60);
        animator.add(glcanvas);
        animator.start();
    }

    @Override
    public void init(GLAutoDrawable glad) {
        glad.getGL().setSwapInterval(Integer.MAX_VALUE);
        
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display(GLAutoDrawable glad) {

        final GL2 gl = glad.getGL().getGL2();
        render(glad);
        drawCircle(glad, x, y, radious);
        if (radious>0) {
            update();
        }else{
            y=180;
            radious=36;
        }
        
        
        
//        drawCircle(gl, x, y, radious);
//        drawCircle(gl, x, y - 50, radious);
//        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
//        drawCircle(gl, x, y - 100, radious);
//        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
//        drawCircle(gl, x, y - 150, radious);
//        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
//        drawCircle(gl, x, y - 200, radious);
//        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        GL gl = glad.getGL();
        GLU glu = new GLU();
        ((GL2ES1) gl).glOrtho(-600, 600, -700, 700, -1.0, 1.0);

    }
    
    public void render(GLAutoDrawable glad){
//        final GL2 gl = glad.getGL().getGL2();
//        gl.glBegin (GL2.GL_POLYGON);
        tap(glad);
//        gl.glEnd();
        
    }
    public void update(){
//        x-=1;
        y-=5;
        radious-=.2;
    }
    public void drawCircle(GLAutoDrawable glad, float x, float y, float radious) {
        final GL2 gl = glad.getGL().getGL2();
        
        gl.glBegin(GL2.GL_POINTS);
//        gl.glVertex2d(x, y);
        for (double i = 0; i <= 360; i += 1) {

            double a = x + radious * Math.cos(i);
            double b = y + radious * Math.sin(i);

            gl.glVertex2d(a, b);

        }// The Loop

        gl.glEnd();
    }// End of method draw Circle
    
    public void tap(GLAutoDrawable glad){
        final GL2 gl = glad.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
       	gl.glBegin (GL2.GL_POINTS);//static field
                float r = 80;
                float x0 = 400;
                float y0 = 250;
                
                float x=0;
                float y=r;
                float d=5-4*r;

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
        gl.glEnd();
        
        double x1=470;
          double x2=580;
          double x3=470;
          double x4=580;
          double y1=225;
          double y2=225;
          double y3=290;
          double y4=290;
        
        gl.glBegin(GL2.GL_POLYGON);
             
            gl.glVertex2d(x1, y1);
            gl.glVertex2d(x2, y2);
            
            gl.glVertex2d(x1, y1);
            gl.glVertex2d(x3, y3);
            
            gl.glVertex2d(x2, y2);
            gl.glVertex2d(x4, y4);
            
            gl.glVertex2d(x3, y3);
            gl.glVertex2d(x4, y4);
            gl.glEnd();
          
          double x5=170;
          double x6=330;
          double x7=170;
          double x8=330;
          double y5=225;  
          double y6=225;
          double y7=290;
          double y8=290;
        
        gl.glBegin(GL2.GL_POLYGON);
            
            gl.glVertex2d(x5, y5);
            gl.glVertex2d(x6, y6);
            
            gl.glVertex2d(x6, y6);
            gl.glVertex2d(x8, y8);
            
            gl.glVertex2d(x5, y5);
            gl.glVertex2d(x7, y7);
            
            gl.glVertex2d(x7, y7);
            gl.glVertex2d(x8, y8);
            gl.glEnd();
            
            double x9=170;
          double x10=240;
          double x11=170;
          double x12=240;
          double y9=225;  
          double y10=225;
          double y11=180;
          double y12=180;
        
        gl.glBegin(GL2.GL_POLYGON);

            gl.glVertex2d(x9, y9);
            gl.glVertex2d(x11, y11);
            
            gl.glVertex2d(x11, y11);
            gl.glVertex2d(x12, y12);
            
            gl.glVertex2d(x9, y9);
            gl.glVertex2d(x10, y10);
            
            gl.glVertex2d(x10, y10);
            gl.glVertex2d(x12, y12);
            gl.glEnd();
            
          double x13=360;
          double x14=360;
          double x15=430;
          double x16=430;
          double y13=320;
          double y14=380;
          double y15=320;
          double y16=380;
          
          gl.glBegin(GL2.GL_POLYGON);
             gl.glVertex2d(x13, y13);
            gl.glVertex2d(x14, y14);
            
            gl.glVertex2d(x14, y14);
            gl.glVertex2d(x16, y16);
            
            gl.glVertex2d(x15, y15);
            gl.glVertex2d(x16, y16);
            
            gl.glVertex2d(x13, y13);
            gl.glVertex2d(x16, y16);
            gl.glEnd();
            
          double x17=320;
          double x18=320;
          double x19=470;
          double x20=470;
          double y17=381;
          double y18=440;
          double y19=381;
          double y20=440;
          
          gl.glBegin(GL2.GL_POLYGON);
             gl.glVertex2d(x17, y17);
            gl.glVertex2d(x18, y18);
            
            gl.glVertex2d(x18, y18);
            gl.glVertex2d(x20, y20);
            
            gl.glVertex2d(x19, y19);
            gl.glVertex2d(x20, y20);
            
            gl.glVertex2d(x19, y19);
            gl.glVertex2d(x17, y17);
            gl.glEnd();
    }

}
