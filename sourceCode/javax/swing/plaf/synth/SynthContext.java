/*
 * Copyright (c) 2002, 2008, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package javax.swing.plaf.synth;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * An immutable transient object containing contextual information about
 * a <code>Region</code>. A <code>SynthContext</code> should only be
 * considered valid for the duration
 * of the method it is passed to. In other words you should not cache
 * a <code>SynthContext</code> that is passed to you and expect it to
 * remain valid.
 *
 * @since 1.5
 * @author Scott Violet
 */
public class SynthContext {
    private static final Queue<SynthContext> queue = new ConcurrentLinkedQueue<>();

    private JComponent component;
    private Region region;
    private SynthStyle style;
    private int state;

    static SynthContext getContext(JComponent c, SynthStyle style, int state) {
        return getContext(c, SynthLookAndFeel.getRegion(c), style, state);
    }

    static SynthContext getContext(JComponent component,
                                   Region region, SynthStyle style,
                                   int state) {
        SynthContext context = queue.poll();
        if (context == null) {
            context = new SynthContext();
        }
        context.reset(component, region, style, state);
        return context;
    }

    static void releaseContext(SynthContext context) {
        queue.offer(context);
    }

    SynthContext() {
    }

    /**
     * Creates a SynthContext with the specified values. This is meant
     * for subclasses and custom UI implementors. You very rarely need to
     * construct a SynthContext, though some methods will take one.
     *
     * @param component JComponent
     * @param region Identifies the portion of the JComponent
     * @param style Style associated with the component
     * @param state State of the component as defined in SynthConstants.
     * @throws NullPointerException if component, region of style is null.
     */
    public SynthContext(JComponent component, Region region, SynthStyle style,
                        int state) {
        if (component == null || region == null || style == null) {
            throw new NullPointerException(
                "You must supply a non-null component, region and style");
        }
        reset(component, region, style, state);
    }


    /**
     * Returns the hosting component containing the region.
     *
     * @return Hosting Component
     */
    public JComponent getComponent() {
        return component;
    }

    /**
     * Returns the Region identifying this state.
     *
     * @return Region of the hosting component
     */
    public Region getRegion() {
        return region;
    }

    /**
     * A convenience method for <code>getRegion().isSubregion()</code>.
     */
    boolean isSubregion() {
        return getRegion().isSubregion();
    }

    void setStyle(SynthStyle style) {
        this.style = style;
    }

    /**
     * Returns the style associated with this Region.
     *
     * @return SynthStyle associated with the region.
     */
    public SynthStyle getStyle() {
        return style;
    }

    void setComponentState(int state) {
        this.state = state;
    }

    /**
     * Returns the state of the widget, which is a bitmask of the
     * values defined in <code>SynthConstants</code>. A region will at least
     * be in one of
     * <code>ENABLED</code>, <code>MOUSE_OVER</code>, <code>PRESSED</code>
     * or <code>DISABLED</code>.
     *
     * @see SynthConstants
     * @return State of Component
     */
    public int getComponentState() {
        return state;
    }

    /**
     * Resets the state of the Context.
     */
    void reset(JComponent component, Region region, SynthStyle style,
               int state) {
        this.component = component;
        this.region = region;
        this.style = style;
        this.state = state;
    }

    void dispose() {
        this.component = null;
        this.style = null;
        releaseContext(this);
    }

    /**
     * Convenience method to get the Painter from the current SynthStyle.
     * This will NEVER return null.
     */
    SynthPainter getPainter() {
        SynthPainter painter = getStyle().getPainter(this);

        if (painter != null) {
            return painter;
        }
        return SynthPainter.NULL_PAINTER;
    }
}
