/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.optimis.monitoring.amazoncollector;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author A545568
 */
@XmlRootElement(name="MonitoringResources")
public class Measurements {
    
    
    private List<Measurement> measurements;
    
    public Measurements() {
        
    }
    
    public Measurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }
    
    @XmlElement(name="monitoring_resource")
    public List<Measurement> getMeasurements() {
        return measurements;
    }
}
