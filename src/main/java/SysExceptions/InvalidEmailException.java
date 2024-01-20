/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SysExceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author prath
 */

public class InvalidEmailException extends Exception
{
   public InvalidEmailException()
    {
        JOptionPane.showMessageDialog(null, "Email is not Valid ! Please enter valid Email");
    }
}
