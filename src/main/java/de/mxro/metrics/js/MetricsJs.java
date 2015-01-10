package de.mxro.metrics.js;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

import de.mxro.metrics.MetricsCommon;

/**
 * Facade class to initialize new metrics instances.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
@ExportPackage("")
@Export("Nextweb")
public class MetricsJs implements Exportable {

    @Export
    public static JsMetricsNode create() {
        return JsMetricsNode.wrap(MetricsCommon.createUnsafe());
    }

    public MetricsJs() {
        super();
    }

}
