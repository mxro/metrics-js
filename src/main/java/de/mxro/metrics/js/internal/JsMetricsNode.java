package de.mxro.metrics.js.internal;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

import de.mxro.metrics.MetricsCommon;
import de.mxro.metrics.MetricsNode;
import de.mxro.metrics.helpers.RecordOperation;
import de.mxro.metrics.internal.operations.CounterEvent;

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

    public static RecordOperation increment(final String id) {
        return new CounterEvent(1).setId(id);
    }

    public static RecordOperation decrement(final String id) {
        return new CounterEvent(-1).setId(id);
    }

    @Export
    public String render() {
        return this.metrics.render().get();
    }

    public JsMetricsNode() {
        super();
    }

}
