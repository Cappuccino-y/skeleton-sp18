public class Planet {
    public double xxPos, yyPos, xxVel,yyVel,mass;
    String imgFileName;
    public static double G=6.67e-11;
    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Planet(Planet p){
        xxPos=p.xxPos;
        yyPos=p.yyPos;
        xxVel=p.xxVel;
        yyVel=p.yyVel;
        mass=p.mass;
        imgFileName=p.imgFileName;
    }
    public double calcDistance(Planet p){
        double distance= Math.sqrt(Math.pow(p.xxPos-xxPos,2)+Math.pow(p.yyPos-yyPos,2));
        return distance;
    }
    public double calcForceExertedBy(Planet p){
        double force=G*mass*p.mass/Math.pow(calcDistance(p),2);
        return force;
    }
    public double calcForceExertedByX(Planet p){
        double force=calcForceExertedBy(p);
        double x_force=force*(p.xxPos-xxPos)/calcDistance(p);
        return x_force;
    }
    public double calcForceExertedByY(Planet p){
        double force=calcForceExertedBy(p);
        double y_force=force*(p.yyPos-yyPos)/calcDistance(p);
        return y_force;
    }
    public double calcNetForceExertedByX(Planet[] p){
        double netforce_x=0;
        for (int i = 0; i< p.length; i++){
            if (equals(p[i])){
                continue;
            }
            netforce_x=netforce_x+calcForceExertedByX(p[i]);
        }
        return netforce_x;
    }
    public double calcNetForceExertedByY(Planet[] p){
        double netforce_y=0;
        for (int i = 0; i< p.length; i++){
            if (equals(p[i])){
                continue;
            }
            netforce_y=netforce_y+calcForceExertedByY(p[i]);
        }
        return netforce_y;
    }

    public void update(double dt,double x_force,double y_force){
        double a_x=x_force/mass, a_y=y_force/mass;
        xxVel=xxVel+a_x*dt;
        yyVel=yyVel+a_y*dt;
        xxPos=xxVel*dt+xxPos;
        yyPos=yyVel*dt+yyPos;
    }
    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
}
