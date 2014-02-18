package com.impaq.arena.view.swing.common;

import static com.google.common.base.Throwables.propagate;
import com.google.common.base.Ticker;
import com.google.common.collect.ImmutableList;
import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

/**
 *
 * @author jaro
 */
public class Stage {

    private final ScreenManager manager = new ScreenManager();
    private long currTime;
    private Ticker ticker;
    private Timer timer;
    private final Layer<Node> background = new Layer<>(new CopyOnWriteArrayList<Node>());
    private final Layer<Layer<Node>> layers = new Layer<>(ImmutableList.of(background));
    private final Collection<TimeListener> timeListeners = new CopyOnWriteArrayList<>();

    public void initialize() {
        try {
            manager.setFullScreen(manager.findFirstCompatibleMode(new DisplayMode[]{new DisplayMode(1026, 567, DisplayMode.BIT_DEPTH_MULTI, DisplayMode.REFRESH_RATE_UNKNOWN)}));

            EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    timer = new Timer(20, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            animationate();
                        }
                    });
                    timer.start();
                    ticker = Ticker.systemTicker();
                }
            });

        } catch (InterruptedException | InvocationTargetException ex) {
            throw propagate(ex);
        }
    }

    private void animationate() {

        long elapsedTime = TimeUnit.NANOSECONDS.toMillis(ticker.read()) - currTime;
        currTime += elapsedTime;

        update(elapsedTime);

        Graphics2D g = manager.getGraphics();
        try{
        draw(g);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        g.dispose();
        manager.update();

    }

    private void draw(Graphics2D graphics) {
        layers.draw(graphics);
    }

    private void update(long elapsedTime) {
        for (TimeListener listner : timeListeners) {
            listner.update(elapsedTime);
        }
    }

    public void dispose() {
        timer.stop();
        manager.restoreScreen();
    }

    public Layer<Node> getBackground() {
        return background;
    }
    
    void addTimeListener(TimeListener listener){
        timeListeners.add(listener);
    }
    void removeTimeListener(TimeListener listener){
        timeListeners.remove(listener);
    }
    
    
}
