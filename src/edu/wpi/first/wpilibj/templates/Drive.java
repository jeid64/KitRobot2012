/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author RSMHTPC
 */
public class Drive extends RobotTemplate {
    //Initilization of victors. leftVic is left side, rightVic is right side. mountedVic is random vic for motor on board.
    Victor leftVic = new Victor(2);
    Victor rightVic = new Victor(3);
    Victor mountedVic = new Victor(1);
    Joystick left = new Joystick(1);
    Joystick right = new Joystick(2);
    //Initilizes a new compressor. first param is pressureswitchchannel, second is relaychannel for compressor relay
    Compressor compressor = new Compressor(1,2);
    //Channel on module to controll is first param, must check
    Solenoid pistonLeft = new Solenoid (1);
    Solenoid pistonRight = new Solenoid (2);
    //Joystick deadzones for X neg and pos and Y neg and pos
    double MIN_NEG_X = -.15;
    double MAX_NEG_X = -1.00;
    double MIN_POS_X = .15;
    double MAX_POS_X = 1.00;
    double MIN_NEG_Y = -.15;
    double MAX_NEG_Y = -1.00;
    double MIN_POS_Y = .15;
    double MAX_POS_Y = 1.00;
    public void drive() {
        if ((drive.left.getY())>drive.MIN_NEG_Y) {
            drive.leftVic.set(drive.left.getY());   
        }
        
        else if ((drive.left.getY())>drive.MIN_POS_Y) {
            drive.leftVic.set(drive.left.getY());   
        }
        
        else if ((drive.right.getY())>drive.MIN_NEG_Y) {
            drive.rightVic.set(drive.right.getY());   
        }
        
        else if ((drive.right.getY())>drive.MIN_POS_Y) {
            drive.rightVic.set(drive.right.getY());   
        }
    }
    
    public void kick() {
        if (left.getRawButton(1) == true) {
            pistonLeft.set(true);
            pistonRight.set(true);
        }
        else if (left.getRawButton(2) == true) {
            pistonLeft.set(false);
            pistonRight.set(false);
        }
        else if (left.getRawButton(3) == true) {
            pistonLeft.set(true);
            pistonRight.set(false);
        }
        else if (left.getRawButton(4) == true) {
            pistonLeft.set(false);
            pistonRight.set(false);
        }
        
    }
}
    

