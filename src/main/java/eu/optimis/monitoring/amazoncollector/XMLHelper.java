/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.optimis.monitoring.amazoncollector;

import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author A545568
 */
public class XMLHelper {
    
    public static final String ROOT = "MonitoringResources";
    public static final String MON_RESOURCE = "monitoring_resource";
    
    public static final String PHYSICAL_RESOURCE= "physical_resource_id";
    public static final String METRIC_NAME="metric_name";
    public static final String METRIC_VALUE="metric_value";
    public static final String METRIC_UNIT="metric_unit";
    public static final String METRIC_TIMESTAMP="metric_timestamp";
    public static final String SERVICE_RESOURCE_ID="service_resource_id";
    public static final String VIRTUAL_RESOURCE_ID="virtual_resource_id";
    public static final String RESOURCE_TYPE="resource_type";
    public static final String COLLECTOR_ID="monitoring_information_collector_id";
    
    public static Document createDocument(List<Measurement> measurements) {
        
        Element root = new Element(ROOT);
        Document doc = new Document(root);

        for (Measurement m : measurements) {
            root.addContent(createMonitoringResource(m));
        }
        
        /*XMLOutputter outputter = new XMLOutputter();
        outputter.setFormat(Format.getPrettyFormat());
        try {
            outputter.output(doc, new FileOutputStream("./aws.xml"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        return doc;
    }
    
    public static Element createMonitoringResource(Measurement measurement) {
        
        Element mon_res = new Element(MON_RESOURCE);
        
        mon_res.addContent(new Element(PHYSICAL_RESOURCE).setText(measurement.getPhysical_resource_id()));
        mon_res.addContent(new Element(METRIC_NAME).setText(measurement.getMetric_name()));
        mon_res.addContent(new Element(METRIC_VALUE).setText(measurement.getMetric_value()));
        mon_res.addContent(new Element(METRIC_UNIT).setText(measurement.getMetric_unit()));
        mon_res.addContent(new Element(METRIC_TIMESTAMP).setText(measurement.getTimestamp().toString()));
        mon_res.addContent(new Element(SERVICE_RESOURCE_ID).setText(measurement.getService_id()));
        mon_res.addContent(new Element(VIRTUAL_RESOURCE_ID).setText(measurement.getVirtual_resource_id()));
        mon_res.addContent(new Element(RESOURCE_TYPE).setText(measurement.getResoruce_type()));
        mon_res.addContent(new Element(COLLECTOR_ID).setText(measurement.getCollector_id()));
        
        return mon_res;
    }
}
