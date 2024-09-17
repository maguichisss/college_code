/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GRAFICACION;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.GLUT;  
import java.awt.Frame;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  
import javax.media.opengl.GL;  
import javax.media.opengl.GLAutoDrawable;  
import javax.media.opengl.GLCanvas;  
import javax.media.opengl.GLEventListener; 
import javax.media.opengl.glu.GLU;

/**   
*   
* @author Giovanna Eloisa Vazquez Moreno   
*         Pablo Sergio Cabrera Uribe   
*   
* @materia: Graficación por Computadora   
*   
* @grupo: 2803   
*   
* @fecha 14/02/2014  
*   
*/ 
public class Practica2 implements GLEventListener{

    public static void main(String[] args) {         
    Frame frame = new Frame("Practica2.java");         
    GLCanvas canvas = new GLCanvas();         
    canvas.addGLEventListener(new Practica2());         
    frame.add(canvas);         
    frame.setSize(820, 640);         
    final Animator animator = new Animator(canvas); 
    
    frame.addWindowListener(new WindowAdapter() {             
    @Override             
        public void windowClosing(WindowEvent e) {                
         new Thread(new Runnable() {                    
         public void run() {                         
            animator.stop();                         
            System.exit(0);                     
            }                    
        }).start();             
        }         
    }); 
     frame.setLocationRelativeTo(null);         
     frame.setVisible(true);        
     animator.start();      
    } //Fin del main 

    public void dibuja(GLAutoDrawable gLDrawable,float x1, float y1, float lado){         
    final GL gl = gLDrawable.getGL();         
    gl.glPointSize(5f);         
    gl.glBegin(GL.GL_POINTS);                 
    gl.glColor3f(1, 0, 0);                 
    gl.glVertex2f(x1-lado,y1-lado);                 
    gl.glColor3f(0, 0, 1);                 
    gl.glVertex2f(x1-lado,y1+lado);                 
    gl.glColor3f(0, 1, 0);   
    gl.glVertex2f(x1+lado,y1+lado);
    gl.glColor3f(0, 0, 0);                 
    gl.glVertex2f(x1+lado,y1-lado);
    gl.glEnd();         
} 

public void ejes(GLAutoDrawable gLDrawable){         
    final GL gl = gLDrawable.getGL();         
    gl.glLineWidth(1f);         
    gl.glBegin(GL.GL_LINES);                 
    gl.glColor3f(0, 0, 0);                 
    gl.glVertex2f(-9,0);                 
    gl.glColor3f(0, 0, 0);                 
    gl.glVertex2f(9,0);
    gl.glColor3f(0, 0, 0);                 
    gl.glVertex2f(0,-9);                 
    gl.glColor3f(0, 0, 0);                 
    gl.glVertex2f(0,9); 
    gl.glEnd();         
} 
public void cuadricula(GLAutoDrawable gLDrawable){  
    System.out.println("hola");
    final GL gl = gLDrawable.getGL();         
    gl.glLineWidth(1f);         
    gl.glBegin(GL.GL_LINES);                 
    gl.glColor3f(0, 0, 0);                 
    gl.glVertex2f(-1,0);                 
    gl.glColor3f(0, 0, 0);                 
    gl.glVertex2f(1,0);
    gl.glColor3f(0, 0, 0);                 
    gl.glVertex2f(0,-1);                 
    gl.glColor3f(0, 0, 0);                 
    gl.glVertex2f(0,1); 
    gl.glEnd();          
} 
public void init(GLAutoDrawable drawable) {  
         final GL gl = drawable.getGL();         
         final GLU glu = new GLU();                 
         gl.glMatrixMode (GL.GL_PROJECTION);          
         gl.glClearColor (1.0f, 1.0f, 1.0f, 0.0f);          
         glu.gluOrtho2D (-10.0, 10.0, -10.0, 10.0); 
}  
     public void display(GLAutoDrawable drawable) {   
     final GL gl = drawable.getGL();                    
     gl.glClear(GL.GL_COLOR_BUFFER_BIT);          
     gl.glLoadIdentity();  
     cuadricula(drawable);        
     dibuja(drawable,0,0,0.25f);
     ejes(drawable);
     
     gl.glFlush(); 
     }  
     public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {  
     
     }  
     public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {      } 
}
