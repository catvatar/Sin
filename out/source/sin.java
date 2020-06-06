import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sin extends PApplet {

public void setup(){
    

}

int d = 5;
float divh = 4.5f;

public void graphsin(float of,int n,int _c){
    float x = 0;
    pushMatrix();
    noFill();
    stroke(_c);
    strokeWeight(5);
    beginShape();
    for(int i = -1;i <= width;i++){
        vertex(i,sin(x+of) * height/divh);
        x += (TWO_PI * n)/width;
    }
    endShape();
    popMatrix();
}
public void graph2sin(float of,int n,int _c){
    float x = 0;
    pushMatrix();
    noFill();
    stroke(_c);
    strokeWeight(5);
    beginShape();
    for(int i = -1;i <= width;i++){
        vertex(i,sin(x)* height/divh +sin(x+of) * height/divh);
        x += (TWO_PI * n)/width;
    }
    endShape();
    popMatrix();
}

float a;
int scount = 0;

public void draw(){
    background(16);
    int c1 = color(28,28,180);
    int c2 = color(180,28,28);
    int c3 = color(140,0,140);
    translate(0,height/2);
    graphsin(0,d,c1);
    graphsin(a,d,c2);
    graph2sin(a,d,c3);
    a += 0.1f;
    scount++;
    //saveFrame("output/gif-"+scount+".png");
    //if(scount>63){
    //    exit();
    //}
}
  public void settings() {  size(1600,900); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#F50202", "sin" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
