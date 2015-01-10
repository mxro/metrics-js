package de.mxro.metrics.js;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

@ExportPackage("")
@Export("Nextweb")
public class MetricsJs implements Exportable {

    
    @Export
    public static JsMetricsNode create() {
        
    }
    
    public MetricsJs() {
        super();
    }

}
