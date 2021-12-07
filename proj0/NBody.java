public class NBody {
    public static double readRadius(String file_name){
        In in = new In(file_name);
        int N= in.readInt();
        double radius= in.readDouble();
        return radius;
    }
    public static Planet[] readPlanets(String file_name){
        Planet[] planets= new Planet[]{};
        In in = new In(file_name);
        int N = in.readInt();
        double radius = in.readDouble();
        for (int i = 0; i<planets.length; i++) {
            double x_p = in.readDouble();
            double y_p = in.readDouble();
            double x_v = in.readDouble();
            double y_v = in.readDouble();
            double mass = in.readDouble();
            String fig_name = in.readString();
            planets[i]= new Planet(x_p,y_p,x_v,y_v,mass,fig_name);
        }
        return planets;
    }
    public static void drawbackground(double radius) {

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);

        /* Clears the drawing window. */
        StdDraw.clear();
        StdDraw.picture(0,0,"images/starfield.jpg");

//        StdDraw.show();
//        StdDraw.pause(2000);
    }
    public static void main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=readRadius(filename);
        double X_force;
        double Y_force;
        Planet[] planets= readPlanets(filename);
        for (int i=0;i<planets.length;i++)
            planets[i].draw();
        for (double t=0;t<=T;t=t+dt){
            drawbackground(radius);
            for (int j=0; j<planets.length;j++) {
                X_force = planets[j].calcNetForceExertedByX(planets);
                Y_force = planets[j].calcNetForceExertedByY(planets);
                planets[j].update(dt, X_force, Y_force);
                planets[j].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }
}
