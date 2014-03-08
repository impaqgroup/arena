package com.impaq.arena.client.view.swing.common;

import static com.google.common.base.Throwables.propagate;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import static com.google.common.io.Resources.getResource;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.imageio.ImageIO.read;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public abstract class Images {

    private static LoadingCache<String, BufferedImage> imageCache = CacheBuilder.newBuilder().weakValues().build(new CacheLoader<String, BufferedImage>() {

        @Override
        public BufferedImage load(String key) throws Exception {
            try {
                return read(getResource(key));
            } catch (IOException ex) {
                throw propagate(ex);
            }
        }

    });

    public static BufferedImage valueOf(String classpathUrl) {
        try {
            return imageCache.get(classpathUrl);
        } catch (ExecutionException ex) {
            throw propagate(ex);
        }
    }
}
