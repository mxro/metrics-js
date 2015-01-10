package de.mxro.metrics.js.internal;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

import de.mxro.metrics.MetricsNode;

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
    public void value(final String id, final long value) {

    }

    @Export
    public String render() {
        return this.metrics.render().get();
    }

    public JsMetricsNode() {
        super();
    }

}
