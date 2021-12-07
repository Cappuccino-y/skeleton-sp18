public class TestPlanet {
    public static void main(String[] args){
        Planet[] total=new Planet[3];
        total[0]=new Planet(23,51,0,0,100,"sda");
        total[1]=new Planet(37,2312,0,0,100,"sda");
        total[2]=new Planet(231,541,0,0,100,"sda");
        double dt=1;
        double X_force;
        double Y_force;
        for (int i=0; i<100000;i++){
            for (int j=0; j<total.length;j++) {
                X_force = total[j].calcNetForceExertedByX(total);
                Y_force = total[j].calcNetForceExertedByY(total);
                total[j].update(dt, X_force, Y_force);
                System.out.print("our");
                System.out.print(j);
                System.out.print("th planet's x coordinate is ");
                System.out.println(total[0].xxPos);
            }

        }
    }
}
