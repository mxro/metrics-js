package de.mxro.metrics.js;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

import de.mxro.metrics.MetricsCommon;
import de.mxro.metrics.MetricsNode;

/**
 * JavaScript wrapper for {@link MetricsNode}.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
@Export
public class JsMetricsNode implements Exportable {

    @NoExport
    public static JsMetricsNode wrap(final MetricsNode metrics) {
        final JsMetricsNode jsMetricsNode = new JsMetricsNode();

        jsMetricsNode.setDecorated(metrics);

        return jsMetricsNode;
    }

    @NoExport
    private MetricsNode metrics;

    @NoExport
    private void setDecorated(final MetricsNode metrics) {
        this.metrics = metrics;
    }

    @Export
    public void value(final String id, final int value) {
        this.metrics.record(MetricsCommon.value(id, value));
    }

    @Export
    public void happened(final String id) {
        this.metrics.record(MetricsCommon.happened(id));
    }

    @Export
    public void increment(final String id) {
        this.metrics.record(MetricsCommon.increment(id));
    }

    @Export
    public void decrement(final String id) {
        this.metrics.record(MetricsCommon.decrement(id));
    }

    @Export
    public String render() {
        return this.metrics.render().get();
    }

    @Export
    public void print() {

    }

    public JsMetricsNode() {
        super();
    }

}
