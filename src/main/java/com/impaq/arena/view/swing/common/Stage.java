package com.impaq.arena.view.swing.common;

import com.google.common.base.Optional;
import com.google.common.base.Ticker;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jaro
 */
public class Stage {

    private Logger log = LoggerFactory.getLogger(Stage.class);

    static class Lazy {

        static Stage instance = new Stage();

    }

    public static Stage get() {
        return Lazy.instance;
    }

    private final ScreenManager manager = new ScreenManager();
    private long currTime;
    private Ticker ticker;
    private Timer timer;
    private final Component background = new Component(new CopyOnWriteArrayList());
    private final Collection<TimeListener> timeListeners = new CopyOnWriteArrayList<>();
    private final int width = 1000;
    private final int height = 700;

    private Stage() {
        initialize();
    }

    private void initialize() {
        manager.initalizeFullScreen();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                timer = new Timer(20, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            animationate();
                        } catch (Exception ex) {
                            log.warn("animate loop failed", ex);
                        }
                    }
                });
                timer.start();
                ticker = Ticker.systemTicker();
            }
        });

    }

    private void animationate() {

        long elapsedTime = TimeUnit.NANOSECONDS.toMillis(ticker.read()) - currTime;
        currTime += elapsedTime;

        update(elapsedTime);

        Optional<Graphics2D> optinalGraphic = manager.getGraphics();
        if (optinalGraphic.isPresent()) {
            final Graphics2D graphic = optinalGraphic.get();
            BufferedImage screen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            final Graphics2D screenGraphics = screen.createGraphics();
            draw(screenGraphics);
            screenGraphics.dispose();
            final BufferedImage scaled = Scalr.resize(screen, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_HEIGHT, manager.getScreenDimension().width, manager.getScreenDimension().height);
            graphic.setColor(Color.WHITE);
            graphic.fillRect(0, 0, manager.getScreenDimension().width, manager.getScreenDimension().height);
            graphic.drawImage(scaled, (manager.getScreenDimension().width - scaled.getWidth()) / 2, (manager.getScreenDimension().height - scaled.getHeight()) / 2, null);
            graphic.dispose();
            manager.update();
        }

    }

    private void draw(Graphics2D graphics) {
        background.draw(graphics);
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

    public Component getBackground() {
        return background;
    }

    void addTimeListener(TimeListener listener) {
        timeListeners.add(listener);
    }

    void removeTimeListener(TimeListener listener) {
        timeListeners.remove(listener);
    }

}
