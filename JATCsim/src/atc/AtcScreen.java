/*
 * AtcScreen.java
 *
 * Created on May 17, 2006, 12:02 PM
 *
 * Copyright 2006 David Ammerlaan
 *
 *    This file is part of jATC.
 *
 *  jATC is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  jATC is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with jATC; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package atc;


import java.awt.*;
import javax.swing.*;
import java.util.*;


/**
 * The AtcScreen Object holds the planes and is a window inside the Simulator
 * @author  David the jATC open source author
 */
public class AtcScreen extends JPanel {
    
    // Create the list
    java.util.List<AirPlane> planelist; 

    public AirPlane ap = null;
    /** Creates new form AtcScreen */
    public AtcScreen() 
    {    

        planelist = new ArrayList();          // List implemented as growable array
        
        setLayout( null );
    }

    /**
     * Adds a plane object to the screen and displays it.
     * @param airplane
     */
    public void addplane(AirPlane airplane)
    {
        // add plane to a list for paint
        
        planelist.add(airplane);
          
        add(airplane.apLabel);
	airplane.apLabel.setLocation(airplane.getPosX(), airplane.getPosY());
        airplane.apLabel.setSize(75,40);
        for(int i=0; i<4; i++)
        {
            add(airplane.trailarray[i]);
            airplane.trailarray[i].setLocation(airplane.trailarray[i].getPosX(),airplane.trailarray[i].getPosY());
            airplane.trailarray[i].setSize(7,7);
        }
        
        
    
    }

    /**
     * Resets the location for the plane label
     * @param airplane
     */
    public void updateLabelLocation(AirPlane airplane)
    {
        airplane.apLabel.setLocation(airplane.getPosX(), airplane.getPosY());
        for(int i=0; i<4; i++)
        {
            airplane.trailarray[i].setLocation(airplane.trailarray[i].getPosX(),airplane.trailarray[i].getPosY());
        }
        
    }
    
    /**
     * Updates the airplane's location on the AirPlane
     */
    public void update()
    {
        Iterator<AirPlane> it = planelist.iterator(); 
        while (it.hasNext())
        {
            AirPlane ap = it.next();
            ap.PlaneProcess();
            updateLabelLocation(ap);
        }
    }
}