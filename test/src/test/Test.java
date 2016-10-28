/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jogamp.opengl.util.Animator;
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
public class Test implements GLEventListener {

    /**
     * @param args the command line arguments
     */
    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    static Animator animator;

    public static void main(String[] args) {
        // TODO code application logic here

        Test l = new Test();

        glcanvas.setSize(600, 400);

        final JFrame frame = new JFrame("straight Line");
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        glcanvas.addGLEventListener(l);
        
        animator = new Animator(glcanvas);
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
        float x = 50f;
        float y = 50f;
        float radious = 100f;
        final GL2 gl = glad.getGL().getGL2();
//        drawCircle(gl, x, y, radious);
//        drawCircle(gl, x, y - 50, radious);
//        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
//        drawCircle(gl, x, y - 100, radious);
//        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
//        drawCircle(gl, x, y - 150, radious);
//        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
//        drawCircle(gl, x, y - 200, radious);
//        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
gl.glBegin(GL2.GL_POINTS);
        gl.glVertex2d(x, y);
        for (double i = 0; i <= 360; i += 1) {

            double a = x + radious * Math.cos(i);
            double b = y + radious * Math.sin(i);

            gl.glVertex2d(a, b);

        }// The Loop

        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        GL gl = glad.getGL();
        GLU glu = new GLU();
        ((GL2ES1) gl).glOrtho(-600, 600, -400, 400, -1.0, 1.0);

    }
    
    public void render(){
        
    }
    public void update(float i){
        i=i+2;
    }
    public void drawCircle(GL2 gl, float x, float y, float radious) {

        
    }// End of method draw Circle
    
    

}
