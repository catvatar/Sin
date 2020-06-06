void setup(){
    size(1600,900);
}

int d = 5;
float divh = 4.5;

void graphsin(float of,int n,color _c){
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
void graph2sin(float of,int n,color _c){
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

void draw(){
    background(16);
    color c1 = color(28,28,180);
    color c2 = color(180,28,28);
    color c3 = color(140,0,140);
    translate(0,height/2);
    graphsin(0,d,c1);
    graphsin(a,d,c2);
    graph2sin(a,d,c3);
    a += 0.1;
    scount++;
    //saveFrame("output/gif-"+scount+".png");
    //if(scount>63){
    //    exit();
    //}
}
