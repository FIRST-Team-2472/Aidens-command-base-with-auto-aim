package frc.robot.subsystems;

public class accelerationLimiter {
     public double maxSpeed = 1;
     private double speed = 0;
     private double newSpeed = 0;
     private double accel = 0;
     private double timer = 0;
     private double 

     public void accelerationLimiter {
        accel = (newSpeed - speed)/timer;
        
        if(timer == 0.5){
            newSpeed = counts/timer
            if(accel >= 0.5)
                maxSpeed -= 0.1;

            timer = 0;
        }

    timer += 0.02;
    }
}
