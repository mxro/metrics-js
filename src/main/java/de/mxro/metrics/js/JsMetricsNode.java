package de.mxro.metrics.js;

import delight.async.properties.PropertyNode;

import de.mxro.metrics.MetricsCommon;

/**
 * JavaScript wrapper for {@link PropertyNode}.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
@jsinterop.annotations.JsType public class JsMetricsNode {

    @jsinterop.annotations.JsIgnore
    public static JsMetricsNode wrap(final PropertyNode metrics) {
        final JsMetricsNode jsMetricsNode = new JsMetricsNode();

        jsMetricsNode.setDecorated(metrics);

        return jsMetricsNode;
    }

    @jsinterop.annotations.JsIgnore
    private PropertyNode metrics;

    @jsinterop.annotations.JsIgnore
    private void setDecorated(final PropertyNode metrics) {
        this.metrics = metrics;
    }

    @delight.functional.annotations.ExportedElement public void value(final String id, final int value) {
        this.metrics.record(MetricsCommon.value(id, value));
    }

    @delight.functional.annotations.ExportedElement public void happened(final String id) {
        this.metrics.record(MetricsCommon.happened(id));
    }

    @delight.functional.annotations.ExportedElement public void increment(final String id) {
        this.metrics.record(MetricsCommon.increment(id));
    }

    @delight.functional.annotations.ExportedElement public void decrement(final String id) {
        this.metrics.record(MetricsCommon.decrement(id));
    }

    @delight.functional.annotations.ExportedElement public String render() {
        return this.metrics.render().get();
    }

    @delight.functional.annotations.ExportedElement public void print() {

    }

    public JsMetricsNode() {
        super();
    }

}
