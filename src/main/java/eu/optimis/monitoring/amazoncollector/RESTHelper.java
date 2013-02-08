/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.optimis.monitoring.amazoncollector;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author A545568
 */
public class RESTHelper {
    
    private String url;
    private Client client = null;
    
    public RESTHelper(String url) {
        this.url = url;
        client = Client.create();
        client.addFilter(new LoggingFilter(System.out));
    }
    
    public void sendDocument(Measurements ms) {
        WebResource r = client.resource(url);
        /*ClientResponse res = r.type(MediaType.APPLICATION_XML_TYPE).post(ClientResponse.class, doc);
        if (res.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new RuntimeException("There was a problem while sending the metrics to the aggregator: " +
                    res.getStatus(), new Exception());
        }*/
        /*Measurements res = r.type(MediaType.APPLICATION_XML_TYPE).accept(MediaType.APPLICATION_XML_TYPE).post(Measurements.class, ms);
        System.out.println("Measurement received back!!");
        for (Measurement m : res.getMeasurements()) {
            System.out.println(m.toString());
        }*/
        r.type(MediaType.APPLICATION_XML_TYPE).post(ms);
    }
}
