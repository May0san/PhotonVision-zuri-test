package frc.robot.utility_classes;

import edu.wpi.first.math.geometry.Translation2d;

public class RobotTracking {
    public Translation2d robotPosition;
    public double rotation;
    public RobotTracking (double x, double y, double th) {
        UpdatePosition(x, y, th);
    }

    public void UpdatePosition(double x, double y, double th){
        robotPosition = new Translation2d(x, y);
        rotation = th;
    }
}