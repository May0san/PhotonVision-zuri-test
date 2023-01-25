// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.lang.annotation.Target;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.utility_classes.SimulatedFieldPositions;
import frc.robot.utility_classes.RobotTracking;
import frc.robot.utility_classes.VisionTargetArea;

public class PhotonVisionSubsystem extends SubsystemBase {
  /** Creates a new PhotonVisionSubsystem. */
  PhotonCamera camera;

  public final SimulatedFieldPositions m_field = new SimulatedFieldPositions();
  public final RobotTracking m_tracking = new RobotTracking(0, 0, 0);

  public PhotonVisionSubsystem() {
    camera = new PhotonCamera("Arducam_OV9281_MMN2");
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */


  public PhotonTrackedTarget returnBestTarget(){
    var results = camera.getLatestResult();
    PhotonTrackedTarget target = results.getBestTarget();
    return target;
  }

  public void checkRobotPosition(){
    PhotonTrackedTarget bestTarget = returnBestTarget();
    if (bestTarget != null){
      int targetID = bestTarget.getFiducialId();
      VisionTargetArea simTarget = m_field.getTarget(targetID);
      double targetRotation = simTarget.rotation;
      Translation2d targetDist = simTarget.position;
      Translation2d absoluteTargetRotation;
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
