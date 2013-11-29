/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.impaq.arena.visualisation.impl.swing;

import java.beans.*;

/**
 *
 * @author jaro
 */
public class SwingVisualisationBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class , null ); // NOI18N//GEN-HEADEREND:BeanDescriptor
    // Here you can add code for customizing the BeanDescriptor.

        return beanDescriptor;     }//GEN-LAST:BeanDescriptor


    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_accessibleContext = 0;
    private static final int PROPERTY_active = 1;
    private static final int PROPERTY_alignmentX = 2;
    private static final int PROPERTY_alignmentY = 3;
    private static final int PROPERTY_alwaysOnTop = 4;
    private static final int PROPERTY_alwaysOnTopSupported = 5;
    private static final int PROPERTY_autoRequestFocus = 6;
    private static final int PROPERTY_background = 7;
    private static final int PROPERTY_backgroundSet = 8;
    private static final int PROPERTY_baselineResizeBehavior = 9;
    private static final int PROPERTY_bounds = 10;
    private static final int PROPERTY_bufferStrategy = 11;
    private static final int PROPERTY_colorModel = 12;
    private static final int PROPERTY_component = 13;
    private static final int PROPERTY_componentCount = 14;
    private static final int PROPERTY_componentListeners = 15;
    private static final int PROPERTY_componentOrientation = 16;
    private static final int PROPERTY_components = 17;
    private static final int PROPERTY_containerListeners = 18;
    private static final int PROPERTY_contentPane = 19;
    private static final int PROPERTY_cursor = 20;
    private static final int PROPERTY_cursorSet = 21;
    private static final int PROPERTY_cursorType = 22;
    private static final int PROPERTY_defaultCloseOperation = 23;
    private static final int PROPERTY_displayable = 24;
    private static final int PROPERTY_doubleBuffered = 25;
    private static final int PROPERTY_dropTarget = 26;
    private static final int PROPERTY_enabled = 27;
    private static final int PROPERTY_extendedState = 28;
    private static final int PROPERTY_firstPlayer = 29;
    private static final int PROPERTY_focusable = 30;
    private static final int PROPERTY_focusableWindow = 31;
    private static final int PROPERTY_focusableWindowState = 32;
    private static final int PROPERTY_focusCycleRoot = 33;
    private static final int PROPERTY_focusCycleRootAncestor = 34;
    private static final int PROPERTY_focused = 35;
    private static final int PROPERTY_focusListeners = 36;
    private static final int PROPERTY_focusOwner = 37;
    private static final int PROPERTY_focusTraversable = 38;
    private static final int PROPERTY_focusTraversalKeys = 39;
    private static final int PROPERTY_focusTraversalKeysEnabled = 40;
    private static final int PROPERTY_focusTraversalPolicy = 41;
    private static final int PROPERTY_focusTraversalPolicyProvider = 42;
    private static final int PROPERTY_focusTraversalPolicySet = 43;
    private static final int PROPERTY_font = 44;
    private static final int PROPERTY_fontSet = 45;
    private static final int PROPERTY_foreground = 46;
    private static final int PROPERTY_foregroundSet = 47;
    private static final int PROPERTY_glassPane = 48;
    private static final int PROPERTY_graphics = 49;
    private static final int PROPERTY_graphicsConfiguration = 50;
    private static final int PROPERTY_height = 51;
    private static final int PROPERTY_hierarchyBoundsListeners = 52;
    private static final int PROPERTY_hierarchyListeners = 53;
    private static final int PROPERTY_iconImage = 54;
    private static final int PROPERTY_iconImages = 55;
    private static final int PROPERTY_ignoreRepaint = 56;
    private static final int PROPERTY_inputContext = 57;
    private static final int PROPERTY_inputMethodListeners = 58;
    private static final int PROPERTY_inputMethodRequests = 59;
    private static final int PROPERTY_insets = 60;
    private static final int PROPERTY_JMenuBar = 61;
    private static final int PROPERTY_keyListeners = 62;
    private static final int PROPERTY_layeredPane = 63;
    private static final int PROPERTY_layout = 64;
    private static final int PROPERTY_lightweight = 65;
    private static final int PROPERTY_locale = 66;
    private static final int PROPERTY_location = 67;
    private static final int PROPERTY_locationByPlatform = 68;
    private static final int PROPERTY_locationOnScreen = 69;
    private static final int PROPERTY_locationRelativeTo = 70;
    private static final int PROPERTY_maximizedBounds = 71;
    private static final int PROPERTY_maximumSize = 72;
    private static final int PROPERTY_maximumSizeSet = 73;
    private static final int PROPERTY_menuBar = 74;
    private static final int PROPERTY_minimumSize = 75;
    private static final int PROPERTY_minimumSizeSet = 76;
    private static final int PROPERTY_modalExclusionType = 77;
    private static final int PROPERTY_mostRecentFocusOwner = 78;
    private static final int PROPERTY_mouseListeners = 79;
    private static final int PROPERTY_mouseMotionListeners = 80;
    private static final int PROPERTY_mousePosition = 81;
    private static final int PROPERTY_mouseWheelListeners = 82;
    private static final int PROPERTY_name = 83;
    private static final int PROPERTY_opacity = 84;
    private static final int PROPERTY_opaque = 85;
    private static final int PROPERTY_ownedWindows = 86;
    private static final int PROPERTY_owner = 87;
    private static final int PROPERTY_parent = 88;
    private static final int PROPERTY_peer = 89;
    private static final int PROPERTY_preferredSize = 90;
    private static final int PROPERTY_preferredSizeSet = 91;
    private static final int PROPERTY_propertyChangeListeners = 92;
    private static final int PROPERTY_resizable = 93;
    private static final int PROPERTY_rootPane = 94;
    private static final int PROPERTY_secondPlayer = 95;
    private static final int PROPERTY_shape = 96;
    private static final int PROPERTY_showing = 97;
    private static final int PROPERTY_size = 98;
    private static final int PROPERTY_state = 99;
    private static final int PROPERTY_title = 100;
    private static final int PROPERTY_toolkit = 101;
    private static final int PROPERTY_transferHandler = 102;
    private static final int PROPERTY_treeLock = 103;
    private static final int PROPERTY_type = 104;
    private static final int PROPERTY_undecorated = 105;
    private static final int PROPERTY_valid = 106;
    private static final int PROPERTY_validateRoot = 107;
    private static final int PROPERTY_visible = 108;
    private static final int PROPERTY_warningString = 109;
    private static final int PROPERTY_width = 110;
    private static final int PROPERTY_windowFocusListeners = 111;
    private static final int PROPERTY_windowListeners = 112;
    private static final int PROPERTY_windowStateListeners = 113;
    private static final int PROPERTY_x = 114;
    private static final int PROPERTY_y = 115;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[116];
    
        try {
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getAccessibleContext", null ); // NOI18N
            properties[PROPERTY_active] = new PropertyDescriptor ( "active", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isActive", null ); // NOI18N
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getAlignmentX", null ); // NOI18N
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getAlignmentY", null ); // NOI18N
            properties[PROPERTY_alwaysOnTop] = new PropertyDescriptor ( "alwaysOnTop", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isAlwaysOnTop", "setAlwaysOnTop" ); // NOI18N
            properties[PROPERTY_alwaysOnTopSupported] = new PropertyDescriptor ( "alwaysOnTopSupported", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isAlwaysOnTopSupported", null ); // NOI18N
            properties[PROPERTY_autoRequestFocus] = new PropertyDescriptor ( "autoRequestFocus", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isAutoRequestFocus", "setAutoRequestFocus" ); // NOI18N
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getBackground", "setBackground" ); // NOI18N
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isBackgroundSet", null ); // NOI18N
            properties[PROPERTY_baselineResizeBehavior] = new PropertyDescriptor ( "baselineResizeBehavior", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getBaselineResizeBehavior", null ); // NOI18N
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getBounds", "setBounds" ); // NOI18N
            properties[PROPERTY_bufferStrategy] = new PropertyDescriptor ( "bufferStrategy", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getBufferStrategy", null ); // NOI18N
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getColorModel", null ); // NOI18N
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, null, null, "getComponent", null ); // NOI18N
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getComponentCount", null ); // NOI18N
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getComponentListeners", null ); // NOI18N
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getComponentOrientation", "setComponentOrientation" ); // NOI18N
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getComponents", null ); // NOI18N
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getContainerListeners", null ); // NOI18N
            properties[PROPERTY_contentPane] = new PropertyDescriptor ( "contentPane", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getContentPane", "setContentPane" ); // NOI18N
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, null, "setCursor" ); // NOI18N
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isCursorSet", null ); // NOI18N
            properties[PROPERTY_cursorType] = new PropertyDescriptor ( "cursorType", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getCursorType", null ); // NOI18N
            properties[PROPERTY_defaultCloseOperation] = new PropertyDescriptor ( "defaultCloseOperation", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getDefaultCloseOperation", "setDefaultCloseOperation" ); // NOI18N
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isDisplayable", null ); // NOI18N
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isDoubleBuffered", null ); // NOI18N
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getDropTarget", "setDropTarget" ); // NOI18N
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isEnabled", "setEnabled" ); // NOI18N
            properties[PROPERTY_extendedState] = new PropertyDescriptor ( "extendedState", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getExtendedState", "setExtendedState" ); // NOI18N
            properties[PROPERTY_firstPlayer] = new PropertyDescriptor ( "firstPlayer", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getFirstPlayer", "setFirstPlayer" ); // NOI18N
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isFocusable", "setFocusable" ); // NOI18N
            properties[PROPERTY_focusableWindow] = new PropertyDescriptor ( "focusableWindow", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isFocusableWindow", null ); // NOI18N
            properties[PROPERTY_focusableWindowState] = new PropertyDescriptor ( "focusableWindowState", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getFocusableWindowState", "setFocusableWindowState" ); // NOI18N
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isFocusCycleRoot", "setFocusCycleRoot" ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getFocusCycleRootAncestor", null ); // NOI18N
            properties[PROPERTY_focused] = new PropertyDescriptor ( "focused", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isFocused", null ); // NOI18N
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getFocusListeners", null ); // NOI18N
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getFocusOwner", null ); // NOI18N
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isFocusTraversable", null ); // NOI18N
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, null, null, "getFocusTraversalKeys", null ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isFocusTraversalPolicySet", null ); // NOI18N
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getFont", "setFont" ); // NOI18N
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isFontSet", null ); // NOI18N
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getForeground", "setForeground" ); // NOI18N
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isForegroundSet", null ); // NOI18N
            properties[PROPERTY_glassPane] = new PropertyDescriptor ( "glassPane", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getGlassPane", "setGlassPane" ); // NOI18N
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getGraphics", null ); // NOI18N
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getGraphicsConfiguration", null ); // NOI18N
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getHeight", null ); // NOI18N
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getHierarchyBoundsListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getHierarchyListeners", null ); // NOI18N
            properties[PROPERTY_iconImage] = new PropertyDescriptor ( "iconImage", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getIconImage", "setIconImage" ); // NOI18N
            properties[PROPERTY_iconImages] = new PropertyDescriptor ( "iconImages", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, null, "setIconImages" ); // NOI18N
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getIgnoreRepaint", "setIgnoreRepaint" ); // NOI18N
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getInputContext", null ); // NOI18N
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getInputMethodListeners", null ); // NOI18N
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getInputMethodRequests", null ); // NOI18N
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getInsets", null ); // NOI18N
            properties[PROPERTY_JMenuBar] = new PropertyDescriptor ( "JMenuBar", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getJMenuBar", "setJMenuBar" ); // NOI18N
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getKeyListeners", null ); // NOI18N
            properties[PROPERTY_layeredPane] = new PropertyDescriptor ( "layeredPane", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getLayeredPane", "setLayeredPane" ); // NOI18N
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getLayout", "setLayout" ); // NOI18N
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isLightweight", null ); // NOI18N
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getLocale", "setLocale" ); // NOI18N
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getLocation", "setLocation" ); // NOI18N
            properties[PROPERTY_locationByPlatform] = new PropertyDescriptor ( "locationByPlatform", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isLocationByPlatform", "setLocationByPlatform" ); // NOI18N
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getLocationOnScreen", null ); // NOI18N
            properties[PROPERTY_locationRelativeTo] = new PropertyDescriptor ( "locationRelativeTo", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, null, "setLocationRelativeTo" ); // NOI18N
            properties[PROPERTY_maximizedBounds] = new PropertyDescriptor ( "maximizedBounds", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getMaximizedBounds", "setMaximizedBounds" ); // NOI18N
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getMaximumSize", "setMaximumSize" ); // NOI18N
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isMaximumSizeSet", null ); // NOI18N
            properties[PROPERTY_menuBar] = new PropertyDescriptor ( "menuBar", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getMenuBar", "setMenuBar" ); // NOI18N
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getMinimumSize", "setMinimumSize" ); // NOI18N
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isMinimumSizeSet", null ); // NOI18N
            properties[PROPERTY_modalExclusionType] = new PropertyDescriptor ( "modalExclusionType", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getModalExclusionType", "setModalExclusionType" ); // NOI18N
            properties[PROPERTY_mostRecentFocusOwner] = new PropertyDescriptor ( "mostRecentFocusOwner", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getMostRecentFocusOwner", null ); // NOI18N
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getMouseListeners", null ); // NOI18N
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getMouseMotionListeners", null ); // NOI18N
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getMousePosition", null ); // NOI18N
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getMouseWheelListeners", null ); // NOI18N
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getName", "setName" ); // NOI18N
            properties[PROPERTY_opacity] = new PropertyDescriptor ( "opacity", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getOpacity", "setOpacity" ); // NOI18N
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isOpaque", null ); // NOI18N
            properties[PROPERTY_ownedWindows] = new PropertyDescriptor ( "ownedWindows", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getOwnedWindows", null ); // NOI18N
            properties[PROPERTY_owner] = new PropertyDescriptor ( "owner", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getOwner", null ); // NOI18N
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getParent", null ); // NOI18N
            properties[PROPERTY_peer] = new PropertyDescriptor ( "peer", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getPeer", null ); // NOI18N
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getPreferredSize", "setPreferredSize" ); // NOI18N
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isPreferredSizeSet", null ); // NOI18N
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getPropertyChangeListeners", null ); // NOI18N
            properties[PROPERTY_resizable] = new PropertyDescriptor ( "resizable", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isResizable", "setResizable" ); // NOI18N
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getRootPane", null ); // NOI18N
            properties[PROPERTY_secondPlayer] = new PropertyDescriptor ( "secondPlayer", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getSecondPlayer", "setSecondPlayer" ); // NOI18N
            properties[PROPERTY_shape] = new PropertyDescriptor ( "shape", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getShape", "setShape" ); // NOI18N
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isShowing", null ); // NOI18N
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getSize", "setSize" ); // NOI18N
            properties[PROPERTY_state] = new PropertyDescriptor ( "state", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getState", "setState" ); // NOI18N
            properties[PROPERTY_title] = new PropertyDescriptor ( "title", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getTitle", "setTitle" ); // NOI18N
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getToolkit", null ); // NOI18N
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getTransferHandler", "setTransferHandler" ); // NOI18N
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getTreeLock", null ); // NOI18N
            properties[PROPERTY_type] = new PropertyDescriptor ( "type", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getType", "setType" ); // NOI18N
            properties[PROPERTY_undecorated] = new PropertyDescriptor ( "undecorated", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isUndecorated", "setUndecorated" ); // NOI18N
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isValid", null ); // NOI18N
            properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isValidateRoot", null ); // NOI18N
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "isVisible", "setVisible" ); // NOI18N
            properties[PROPERTY_warningString] = new PropertyDescriptor ( "warningString", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getWarningString", null ); // NOI18N
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getWidth", null ); // NOI18N
            properties[PROPERTY_windowFocusListeners] = new PropertyDescriptor ( "windowFocusListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getWindowFocusListeners", null ); // NOI18N
            properties[PROPERTY_windowListeners] = new PropertyDescriptor ( "windowListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getWindowListeners", null ); // NOI18N
            properties[PROPERTY_windowStateListeners] = new PropertyDescriptor ( "windowStateListeners", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getWindowStateListeners", null ); // NOI18N
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getX", null ); // NOI18N
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "getY", null ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Properties
    // Here you can add code for customizing the properties array.

        return properties;     }//GEN-LAST:Properties

    // EventSet identifiers//GEN-FIRST:Events
    private static final int EVENT_componentListener = 0;
    private static final int EVENT_containerListener = 1;
    private static final int EVENT_focusListener = 2;
    private static final int EVENT_hierarchyBoundsListener = 3;
    private static final int EVENT_hierarchyListener = 4;
    private static final int EVENT_inputMethodListener = 5;
    private static final int EVENT_keyListener = 6;
    private static final int EVENT_mouseListener = 7;
    private static final int EVENT_mouseMotionListener = 8;
    private static final int EVENT_mouseWheelListener = 9;
    private static final int EVENT_propertyChangeListener = 10;
    private static final int EVENT_windowFocusListener = 11;
    private static final int EVENT_windowListener = 12;
    private static final int EVENT_windowStateListener = 13;

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[14];
    
        try {
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentResized", "componentMoved", "componentShown", "componentHidden"}, "addComponentListener", "removeComponentListener" ); // NOI18N
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" ); // NOI18N
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" ); // NOI18N
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" ); // NOI18N
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" ); // NOI18N
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" ); // NOI18N
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyTyped", "keyPressed", "keyReleased"}, "addKeyListener", "removeKeyListener" ); // NOI18N
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mousePressed", "mouseReleased", "mouseEntered", "mouseExited"}, "addMouseListener", "removeMouseListener" ); // NOI18N
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" ); // NOI18N
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" ); // NOI18N
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
            eventSets[EVENT_windowFocusListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "windowFocusListener", java.awt.event.WindowFocusListener.class, new String[] {"windowGainedFocus", "windowLostFocus"}, "addWindowFocusListener", "removeWindowFocusListener" ); // NOI18N
            eventSets[EVENT_windowListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "windowListener", java.awt.event.WindowListener.class, new String[] {"windowOpened", "windowClosing", "windowClosed", "windowIconified", "windowDeiconified", "windowActivated", "windowDeactivated"}, "addWindowListener", "removeWindowListener" ); // NOI18N
            eventSets[EVENT_windowStateListener] = new EventSetDescriptor ( com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class, "windowStateListener", java.awt.event.WindowStateListener.class, new String[] {"windowStateChanged"}, "addWindowStateListener", "removeWindowStateListener" ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Events
    // Here you can add code for customizing the event sets array.

        return eventSets;     }//GEN-LAST:Events

    // Method identifiers//GEN-FIRST:Methods
    private static final int METHOD_action0 = 0;
    private static final int METHOD_add1 = 1;
    private static final int METHOD_add2 = 2;
    private static final int METHOD_add3 = 3;
    private static final int METHOD_add4 = 4;
    private static final int METHOD_add5 = 5;
    private static final int METHOD_add6 = 6;
    private static final int METHOD_AddBuilders7 = 7;
    private static final int METHOD_addNotify8 = 8;
    private static final int METHOD_addPropertyChangeListener9 = 9;
    private static final int METHOD_AddWarriors10 = 10;
    private static final int METHOD_AddWizards11 = 11;
    private static final int METHOD_applyComponentOrientation12 = 12;
    private static final int METHOD_applyResourceBundle13 = 13;
    private static final int METHOD_applyResourceBundle14 = 14;
    private static final int METHOD_areFocusTraversalKeysSet15 = 15;
    private static final int METHOD_bounds16 = 16;
    private static final int METHOD_BuildCastle17 = 17;
    private static final int METHOD_CheckBuildersCount18 = 18;
    private static final int METHOD_CheckCastleHeight19 = 19;
    private static final int METHOD_checkImage20 = 20;
    private static final int METHOD_checkImage21 = 21;
    private static final int METHOD_CheckWarriorCount22 = 22;
    private static final int METHOD_CheckWizardCount23 = 23;
    private static final int METHOD_contains24 = 24;
    private static final int METHOD_contains25 = 25;
    private static final int METHOD_countComponents26 = 26;
    private static final int METHOD_createBufferStrategy27 = 27;
    private static final int METHOD_createBufferStrategy28 = 28;
    private static final int METHOD_createImage29 = 29;
    private static final int METHOD_createImage30 = 30;
    private static final int METHOD_createVolatileImage31 = 31;
    private static final int METHOD_createVolatileImage32 = 32;
    private static final int METHOD_deliverEvent33 = 33;
    private static final int METHOD_DestroyCastle34 = 34;
    private static final int METHOD_disable35 = 35;
    private static final int METHOD_dispatchEvent36 = 36;
    private static final int METHOD_dispose37 = 37;
    private static final int METHOD_doLayout38 = 38;
    private static final int METHOD_enable39 = 39;
    private static final int METHOD_enable40 = 40;
    private static final int METHOD_enableInputMethods41 = 41;
    private static final int METHOD_findComponentAt42 = 42;
    private static final int METHOD_findComponentAt43 = 43;
    private static final int METHOD_firePropertyChange44 = 44;
    private static final int METHOD_firePropertyChange45 = 45;
    private static final int METHOD_firePropertyChange46 = 46;
    private static final int METHOD_firePropertyChange47 = 47;
    private static final int METHOD_firePropertyChange48 = 48;
    private static final int METHOD_firePropertyChange49 = 49;
    private static final int METHOD_FirstPlayerWin50 = 50;
    private static final int METHOD_getBaseline51 = 51;
    private static final int METHOD_getBounds52 = 52;
    private static final int METHOD_getComponentAt53 = 53;
    private static final int METHOD_getComponentAt54 = 54;
    private static final int METHOD_getComponentZOrder55 = 55;
    private static final int METHOD_getCursor56 = 56;
    private static final int METHOD_getFontMetrics57 = 57;
    private static final int METHOD_getFrames58 = 58;
    private static final int METHOD_getIconImages59 = 59;
    private static final int METHOD_getListeners60 = 60;
    private static final int METHOD_getLocation61 = 61;
    private static final int METHOD_getMousePosition62 = 62;
    private static final int METHOD_getOwnerlessWindows63 = 63;
    private static final int METHOD_getPropertyChangeListeners64 = 64;
    private static final int METHOD_getSize65 = 65;
    private static final int METHOD_getWindows66 = 66;
    private static final int METHOD_gotFocus67 = 67;
    private static final int METHOD_handleEvent68 = 68;
    private static final int METHOD_hasFocus69 = 69;
    private static final int METHOD_hide70 = 70;
    private static final int METHOD_imageUpdate71 = 71;
    private static final int METHOD_insets72 = 72;
    private static final int METHOD_inside73 = 73;
    private static final int METHOD_invalidate74 = 74;
    private static final int METHOD_isAncestorOf75 = 75;
    private static final int METHOD_isDefaultLookAndFeelDecorated76 = 76;
    private static final int METHOD_isFocusCycleRoot77 = 77;
    private static final int METHOD_isFocusOwner78 = 78;
    private static final int METHOD_keyDown79 = 79;
    private static final int METHOD_keyUp80 = 80;
    private static final int METHOD_KillBuilders81 = 81;
    private static final int METHOD_KillWarriors82 = 82;
    private static final int METHOD_KillWizards83 = 83;
    private static final int METHOD_layout84 = 84;
    private static final int METHOD_list85 = 85;
    private static final int METHOD_list86 = 86;
    private static final int METHOD_list87 = 87;
    private static final int METHOD_list88 = 88;
    private static final int METHOD_list89 = 89;
    private static final int METHOD_locate90 = 90;
    private static final int METHOD_location91 = 91;
    private static final int METHOD_lostFocus92 = 92;
    private static final int METHOD_minimumSize93 = 93;
    private static final int METHOD_mouseDown94 = 94;
    private static final int METHOD_mouseDrag95 = 95;
    private static final int METHOD_mouseEnter96 = 96;
    private static final int METHOD_mouseExit97 = 97;
    private static final int METHOD_mouseMove98 = 98;
    private static final int METHOD_mouseUp99 = 99;
    private static final int METHOD_move100 = 100;
    private static final int METHOD_nextFocus101 = 101;
    private static final int METHOD_pack102 = 102;
    private static final int METHOD_paint103 = 103;
    private static final int METHOD_paintAll104 = 104;
    private static final int METHOD_paintComponents105 = 105;
    private static final int METHOD_postEvent106 = 106;
    private static final int METHOD_preferredSize107 = 107;
    private static final int METHOD_prepareImage108 = 108;
    private static final int METHOD_prepareImage109 = 109;
    private static final int METHOD_print110 = 110;
    private static final int METHOD_printAll111 = 111;
    private static final int METHOD_printComponents112 = 112;
    private static final int METHOD_Refresh113 = 113;
    private static final int METHOD_remove114 = 114;
    private static final int METHOD_remove115 = 115;
    private static final int METHOD_remove116 = 116;
    private static final int METHOD_removeAll117 = 117;
    private static final int METHOD_removeNotify118 = 118;
    private static final int METHOD_removePropertyChangeListener119 = 119;
    private static final int METHOD_repaint120 = 120;
    private static final int METHOD_repaint121 = 121;
    private static final int METHOD_repaint122 = 122;
    private static final int METHOD_repaint123 = 123;
    private static final int METHOD_requestFocus124 = 124;
    private static final int METHOD_requestFocusInWindow125 = 125;
    private static final int METHOD_reshape126 = 126;
    private static final int METHOD_resize127 = 127;
    private static final int METHOD_resize128 = 128;
    private static final int METHOD_revalidate129 = 129;
    private static final int METHOD_RoundInfo130 = 130;
    private static final int METHOD_SecondPlayerWin131 = 131;
    private static final int METHOD_setBounds132 = 132;
    private static final int METHOD_setComponentZOrder133 = 133;
    private static final int METHOD_setCursor134 = 134;
    private static final int METHOD_setDefaultLookAndFeelDecorated135 = 135;
    private static final int METHOD_setFocusTraversalKeys136 = 136;
    private static final int METHOD_show137 = 137;
    private static final int METHOD_show138 = 138;
    private static final int METHOD_size139 = 139;
    private static final int METHOD_StartGame140 = 140;
    private static final int METHOD_toBack141 = 141;
    private static final int METHOD_toFront142 = 142;
    private static final int METHOD_toString143 = 143;
    private static final int METHOD_transferFocus144 = 144;
    private static final int METHOD_transferFocusBackward145 = 145;
    private static final int METHOD_transferFocusDownCycle146 = 146;
    private static final int METHOD_transferFocusUpCycle147 = 147;
    private static final int METHOD_update148 = 148;
    private static final int METHOD_validate149 = 149;

    // Method array 
    /*lazy MethodDescriptor*/
    private static MethodDescriptor[] getMdescriptor(){
        MethodDescriptor[] methods = new MethodDescriptor[150];
    
        try {
            methods[METHOD_action0] = new MethodDescriptor(java.awt.Component.class.getMethod("action", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_action0].setDisplayName ( "" );
            methods[METHOD_add1] = new MethodDescriptor(java.awt.Component.class.getMethod("add", new Class[] {java.awt.PopupMenu.class})); // NOI18N
            methods[METHOD_add1].setDisplayName ( "" );
            methods[METHOD_add2] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_add2].setDisplayName ( "" );
            methods[METHOD_add3] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.lang.String.class, java.awt.Component.class})); // NOI18N
            methods[METHOD_add3].setDisplayName ( "" );
            methods[METHOD_add4] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, int.class})); // NOI18N
            methods[METHOD_add4].setDisplayName ( "" );
            methods[METHOD_add5] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_add5].setDisplayName ( "" );
            methods[METHOD_add6] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class, int.class})); // NOI18N
            methods[METHOD_add6].setDisplayName ( "" );
            methods[METHOD_AddBuilders7] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("AddBuilders", new Class[] {int.class, boolean.class})); // NOI18N
            methods[METHOD_AddBuilders7].setDisplayName ( "" );
            methods[METHOD_addNotify8] = new MethodDescriptor(java.awt.Frame.class.getMethod("addNotify", new Class[] {})); // NOI18N
            methods[METHOD_addNotify8].setDisplayName ( "" );
            methods[METHOD_addPropertyChangeListener9] = new MethodDescriptor(java.awt.Window.class.getMethod("addPropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class})); // NOI18N
            methods[METHOD_addPropertyChangeListener9].setDisplayName ( "" );
            methods[METHOD_AddWarriors10] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("AddWarriors", new Class[] {int.class, boolean.class})); // NOI18N
            methods[METHOD_AddWarriors10].setDisplayName ( "" );
            methods[METHOD_AddWizards11] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("AddWizards", new Class[] {int.class, boolean.class})); // NOI18N
            methods[METHOD_AddWizards11].setDisplayName ( "" );
            methods[METHOD_applyComponentOrientation12] = new MethodDescriptor(java.awt.Container.class.getMethod("applyComponentOrientation", new Class[] {java.awt.ComponentOrientation.class})); // NOI18N
            methods[METHOD_applyComponentOrientation12].setDisplayName ( "" );
            methods[METHOD_applyResourceBundle13] = new MethodDescriptor(java.awt.Window.class.getMethod("applyResourceBundle", new Class[] {java.util.ResourceBundle.class})); // NOI18N
            methods[METHOD_applyResourceBundle13].setDisplayName ( "" );
            methods[METHOD_applyResourceBundle14] = new MethodDescriptor(java.awt.Window.class.getMethod("applyResourceBundle", new Class[] {java.lang.String.class})); // NOI18N
            methods[METHOD_applyResourceBundle14].setDisplayName ( "" );
            methods[METHOD_areFocusTraversalKeysSet15] = new MethodDescriptor(java.awt.Container.class.getMethod("areFocusTraversalKeysSet", new Class[] {int.class})); // NOI18N
            methods[METHOD_areFocusTraversalKeysSet15].setDisplayName ( "" );
            methods[METHOD_bounds16] = new MethodDescriptor(java.awt.Component.class.getMethod("bounds", new Class[] {})); // NOI18N
            methods[METHOD_bounds16].setDisplayName ( "" );
            methods[METHOD_BuildCastle17] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("BuildCastle", new Class[] {int.class, boolean.class})); // NOI18N
            methods[METHOD_BuildCastle17].setDisplayName ( "" );
            methods[METHOD_CheckBuildersCount18] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("CheckBuildersCount", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_CheckBuildersCount18].setDisplayName ( "" );
            methods[METHOD_CheckCastleHeight19] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("CheckCastleHeight", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_CheckCastleHeight19].setDisplayName ( "" );
            methods[METHOD_checkImage20] = new MethodDescriptor(java.awt.Component.class.getMethod("checkImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_checkImage20].setDisplayName ( "" );
            methods[METHOD_checkImage21] = new MethodDescriptor(java.awt.Component.class.getMethod("checkImage", new Class[] {java.awt.Image.class, int.class, int.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_checkImage21].setDisplayName ( "" );
            methods[METHOD_CheckWarriorCount22] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("CheckWarriorCount", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_CheckWarriorCount22].setDisplayName ( "" );
            methods[METHOD_CheckWizardCount23] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("CheckWizardCount", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_CheckWizardCount23].setDisplayName ( "" );
            methods[METHOD_contains24] = new MethodDescriptor(java.awt.Component.class.getMethod("contains", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_contains24].setDisplayName ( "" );
            methods[METHOD_contains25] = new MethodDescriptor(java.awt.Component.class.getMethod("contains", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_contains25].setDisplayName ( "" );
            methods[METHOD_countComponents26] = new MethodDescriptor(java.awt.Container.class.getMethod("countComponents", new Class[] {})); // NOI18N
            methods[METHOD_countComponents26].setDisplayName ( "" );
            methods[METHOD_createBufferStrategy27] = new MethodDescriptor(java.awt.Window.class.getMethod("createBufferStrategy", new Class[] {int.class})); // NOI18N
            methods[METHOD_createBufferStrategy27].setDisplayName ( "" );
            methods[METHOD_createBufferStrategy28] = new MethodDescriptor(java.awt.Window.class.getMethod("createBufferStrategy", new Class[] {int.class, java.awt.BufferCapabilities.class})); // NOI18N
            methods[METHOD_createBufferStrategy28].setDisplayName ( "" );
            methods[METHOD_createImage29] = new MethodDescriptor(java.awt.Component.class.getMethod("createImage", new Class[] {java.awt.image.ImageProducer.class})); // NOI18N
            methods[METHOD_createImage29].setDisplayName ( "" );
            methods[METHOD_createImage30] = new MethodDescriptor(java.awt.Component.class.getMethod("createImage", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_createImage30].setDisplayName ( "" );
            methods[METHOD_createVolatileImage31] = new MethodDescriptor(java.awt.Component.class.getMethod("createVolatileImage", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_createVolatileImage31].setDisplayName ( "" );
            methods[METHOD_createVolatileImage32] = new MethodDescriptor(java.awt.Component.class.getMethod("createVolatileImage", new Class[] {int.class, int.class, java.awt.ImageCapabilities.class})); // NOI18N
            methods[METHOD_createVolatileImage32].setDisplayName ( "" );
            methods[METHOD_deliverEvent33] = new MethodDescriptor(java.awt.Container.class.getMethod("deliverEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_deliverEvent33].setDisplayName ( "" );
            methods[METHOD_DestroyCastle34] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("DestroyCastle", new Class[] {int.class, boolean.class})); // NOI18N
            methods[METHOD_DestroyCastle34].setDisplayName ( "" );
            methods[METHOD_disable35] = new MethodDescriptor(java.awt.Component.class.getMethod("disable", new Class[] {})); // NOI18N
            methods[METHOD_disable35].setDisplayName ( "" );
            methods[METHOD_dispatchEvent36] = new MethodDescriptor(java.awt.Component.class.getMethod("dispatchEvent", new Class[] {java.awt.AWTEvent.class})); // NOI18N
            methods[METHOD_dispatchEvent36].setDisplayName ( "" );
            methods[METHOD_dispose37] = new MethodDescriptor(java.awt.Window.class.getMethod("dispose", new Class[] {})); // NOI18N
            methods[METHOD_dispose37].setDisplayName ( "" );
            methods[METHOD_doLayout38] = new MethodDescriptor(java.awt.Container.class.getMethod("doLayout", new Class[] {})); // NOI18N
            methods[METHOD_doLayout38].setDisplayName ( "" );
            methods[METHOD_enable39] = new MethodDescriptor(java.awt.Component.class.getMethod("enable", new Class[] {})); // NOI18N
            methods[METHOD_enable39].setDisplayName ( "" );
            methods[METHOD_enable40] = new MethodDescriptor(java.awt.Component.class.getMethod("enable", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_enable40].setDisplayName ( "" );
            methods[METHOD_enableInputMethods41] = new MethodDescriptor(java.awt.Component.class.getMethod("enableInputMethods", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_enableInputMethods41].setDisplayName ( "" );
            methods[METHOD_findComponentAt42] = new MethodDescriptor(java.awt.Container.class.getMethod("findComponentAt", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_findComponentAt42].setDisplayName ( "" );
            methods[METHOD_findComponentAt43] = new MethodDescriptor(java.awt.Container.class.getMethod("findComponentAt", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_findComponentAt43].setDisplayName ( "" );
            methods[METHOD_firePropertyChange44] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, byte.class, byte.class})); // NOI18N
            methods[METHOD_firePropertyChange44].setDisplayName ( "" );
            methods[METHOD_firePropertyChange45] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, char.class, char.class})); // NOI18N
            methods[METHOD_firePropertyChange45].setDisplayName ( "" );
            methods[METHOD_firePropertyChange46] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, short.class, short.class})); // NOI18N
            methods[METHOD_firePropertyChange46].setDisplayName ( "" );
            methods[METHOD_firePropertyChange47] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, long.class, long.class})); // NOI18N
            methods[METHOD_firePropertyChange47].setDisplayName ( "" );
            methods[METHOD_firePropertyChange48] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, float.class, float.class})); // NOI18N
            methods[METHOD_firePropertyChange48].setDisplayName ( "" );
            methods[METHOD_firePropertyChange49] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, double.class, double.class})); // NOI18N
            methods[METHOD_firePropertyChange49].setDisplayName ( "" );
            methods[METHOD_FirstPlayerWin50] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("FirstPlayerWin", new Class[] {})); // NOI18N
            methods[METHOD_FirstPlayerWin50].setDisplayName ( "" );
            methods[METHOD_getBaseline51] = new MethodDescriptor(java.awt.Component.class.getMethod("getBaseline", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getBaseline51].setDisplayName ( "" );
            methods[METHOD_getBounds52] = new MethodDescriptor(java.awt.Component.class.getMethod("getBounds", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_getBounds52].setDisplayName ( "" );
            methods[METHOD_getComponentAt53] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentAt", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getComponentAt53].setDisplayName ( "" );
            methods[METHOD_getComponentAt54] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentAt", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_getComponentAt54].setDisplayName ( "" );
            methods[METHOD_getComponentZOrder55] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentZOrder", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_getComponentZOrder55].setDisplayName ( "" );
            methods[METHOD_getCursor56] = new MethodDescriptor(java.awt.Component.class.getMethod("getCursor", new Class[] {})); // NOI18N
            methods[METHOD_getCursor56].setDisplayName ( "" );
            methods[METHOD_getFontMetrics57] = new MethodDescriptor(java.awt.Component.class.getMethod("getFontMetrics", new Class[] {java.awt.Font.class})); // NOI18N
            methods[METHOD_getFontMetrics57].setDisplayName ( "" );
            methods[METHOD_getFrames58] = new MethodDescriptor(java.awt.Frame.class.getMethod("getFrames", new Class[] {})); // NOI18N
            methods[METHOD_getFrames58].setDisplayName ( "" );
            methods[METHOD_getIconImages59] = new MethodDescriptor(java.awt.Window.class.getMethod("getIconImages", new Class[] {})); // NOI18N
            methods[METHOD_getIconImages59].setDisplayName ( "" );
            methods[METHOD_getListeners60] = new MethodDescriptor(java.awt.Window.class.getMethod("getListeners", new Class[] {java.lang.Class.class})); // NOI18N
            methods[METHOD_getListeners60].setDisplayName ( "" );
            methods[METHOD_getLocation61] = new MethodDescriptor(java.awt.Component.class.getMethod("getLocation", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_getLocation61].setDisplayName ( "" );
            methods[METHOD_getMousePosition62] = new MethodDescriptor(java.awt.Container.class.getMethod("getMousePosition", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_getMousePosition62].setDisplayName ( "" );
            methods[METHOD_getOwnerlessWindows63] = new MethodDescriptor(java.awt.Window.class.getMethod("getOwnerlessWindows", new Class[] {})); // NOI18N
            methods[METHOD_getOwnerlessWindows63].setDisplayName ( "" );
            methods[METHOD_getPropertyChangeListeners64] = new MethodDescriptor(java.awt.Component.class.getMethod("getPropertyChangeListeners", new Class[] {java.lang.String.class})); // NOI18N
            methods[METHOD_getPropertyChangeListeners64].setDisplayName ( "" );
            methods[METHOD_getSize65] = new MethodDescriptor(java.awt.Component.class.getMethod("getSize", new Class[] {java.awt.Dimension.class})); // NOI18N
            methods[METHOD_getSize65].setDisplayName ( "" );
            methods[METHOD_getWindows66] = new MethodDescriptor(java.awt.Window.class.getMethod("getWindows", new Class[] {})); // NOI18N
            methods[METHOD_getWindows66].setDisplayName ( "" );
            methods[METHOD_gotFocus67] = new MethodDescriptor(java.awt.Component.class.getMethod("gotFocus", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_gotFocus67].setDisplayName ( "" );
            methods[METHOD_handleEvent68] = new MethodDescriptor(java.awt.Component.class.getMethod("handleEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_handleEvent68].setDisplayName ( "" );
            methods[METHOD_hasFocus69] = new MethodDescriptor(java.awt.Component.class.getMethod("hasFocus", new Class[] {})); // NOI18N
            methods[METHOD_hasFocus69].setDisplayName ( "" );
            methods[METHOD_hide70] = new MethodDescriptor(java.awt.Window.class.getMethod("hide", new Class[] {})); // NOI18N
            methods[METHOD_hide70].setDisplayName ( "" );
            methods[METHOD_imageUpdate71] = new MethodDescriptor(java.awt.Component.class.getMethod("imageUpdate", new Class[] {java.awt.Image.class, int.class, int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_imageUpdate71].setDisplayName ( "" );
            methods[METHOD_insets72] = new MethodDescriptor(java.awt.Container.class.getMethod("insets", new Class[] {})); // NOI18N
            methods[METHOD_insets72].setDisplayName ( "" );
            methods[METHOD_inside73] = new MethodDescriptor(java.awt.Component.class.getMethod("inside", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_inside73].setDisplayName ( "" );
            methods[METHOD_invalidate74] = new MethodDescriptor(java.awt.Container.class.getMethod("invalidate", new Class[] {})); // NOI18N
            methods[METHOD_invalidate74].setDisplayName ( "" );
            methods[METHOD_isAncestorOf75] = new MethodDescriptor(java.awt.Container.class.getMethod("isAncestorOf", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_isAncestorOf75].setDisplayName ( "" );
            methods[METHOD_isDefaultLookAndFeelDecorated76] = new MethodDescriptor(javax.swing.JFrame.class.getMethod("isDefaultLookAndFeelDecorated", new Class[] {})); // NOI18N
            methods[METHOD_isDefaultLookAndFeelDecorated76].setDisplayName ( "" );
            methods[METHOD_isFocusCycleRoot77] = new MethodDescriptor(java.awt.Container.class.getMethod("isFocusCycleRoot", new Class[] {java.awt.Container.class})); // NOI18N
            methods[METHOD_isFocusCycleRoot77].setDisplayName ( "" );
            methods[METHOD_isFocusOwner78] = new MethodDescriptor(java.awt.Component.class.getMethod("isFocusOwner", new Class[] {})); // NOI18N
            methods[METHOD_isFocusOwner78].setDisplayName ( "" );
            methods[METHOD_keyDown79] = new MethodDescriptor(java.awt.Component.class.getMethod("keyDown", new Class[] {java.awt.Event.class, int.class})); // NOI18N
            methods[METHOD_keyDown79].setDisplayName ( "" );
            methods[METHOD_keyUp80] = new MethodDescriptor(java.awt.Component.class.getMethod("keyUp", new Class[] {java.awt.Event.class, int.class})); // NOI18N
            methods[METHOD_keyUp80].setDisplayName ( "" );
            methods[METHOD_KillBuilders81] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("KillBuilders", new Class[] {int.class, boolean.class})); // NOI18N
            methods[METHOD_KillBuilders81].setDisplayName ( "" );
            methods[METHOD_KillWarriors82] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("KillWarriors", new Class[] {int.class, boolean.class})); // NOI18N
            methods[METHOD_KillWarriors82].setDisplayName ( "" );
            methods[METHOD_KillWizards83] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("KillWizards", new Class[] {int.class, boolean.class})); // NOI18N
            methods[METHOD_KillWizards83].setDisplayName ( "" );
            methods[METHOD_layout84] = new MethodDescriptor(java.awt.Container.class.getMethod("layout", new Class[] {})); // NOI18N
            methods[METHOD_layout84].setDisplayName ( "" );
            methods[METHOD_list85] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {})); // NOI18N
            methods[METHOD_list85].setDisplayName ( "" );
            methods[METHOD_list86] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {java.io.PrintStream.class})); // NOI18N
            methods[METHOD_list86].setDisplayName ( "" );
            methods[METHOD_list87] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {java.io.PrintWriter.class})); // NOI18N
            methods[METHOD_list87].setDisplayName ( "" );
            methods[METHOD_list88] = new MethodDescriptor(java.awt.Container.class.getMethod("list", new Class[] {java.io.PrintStream.class, int.class})); // NOI18N
            methods[METHOD_list88].setDisplayName ( "" );
            methods[METHOD_list89] = new MethodDescriptor(java.awt.Container.class.getMethod("list", new Class[] {java.io.PrintWriter.class, int.class})); // NOI18N
            methods[METHOD_list89].setDisplayName ( "" );
            methods[METHOD_locate90] = new MethodDescriptor(java.awt.Container.class.getMethod("locate", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_locate90].setDisplayName ( "" );
            methods[METHOD_location91] = new MethodDescriptor(java.awt.Component.class.getMethod("location", new Class[] {})); // NOI18N
            methods[METHOD_location91].setDisplayName ( "" );
            methods[METHOD_lostFocus92] = new MethodDescriptor(java.awt.Component.class.getMethod("lostFocus", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_lostFocus92].setDisplayName ( "" );
            methods[METHOD_minimumSize93] = new MethodDescriptor(java.awt.Container.class.getMethod("minimumSize", new Class[] {})); // NOI18N
            methods[METHOD_minimumSize93].setDisplayName ( "" );
            methods[METHOD_mouseDown94] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseDown", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseDown94].setDisplayName ( "" );
            methods[METHOD_mouseDrag95] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseDrag", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseDrag95].setDisplayName ( "" );
            methods[METHOD_mouseEnter96] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseEnter", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseEnter96].setDisplayName ( "" );
            methods[METHOD_mouseExit97] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseExit", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseExit97].setDisplayName ( "" );
            methods[METHOD_mouseMove98] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseMove", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseMove98].setDisplayName ( "" );
            methods[METHOD_mouseUp99] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseUp", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseUp99].setDisplayName ( "" );
            methods[METHOD_move100] = new MethodDescriptor(java.awt.Component.class.getMethod("move", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_move100].setDisplayName ( "" );
            methods[METHOD_nextFocus101] = new MethodDescriptor(java.awt.Component.class.getMethod("nextFocus", new Class[] {})); // NOI18N
            methods[METHOD_nextFocus101].setDisplayName ( "" );
            methods[METHOD_pack102] = new MethodDescriptor(java.awt.Window.class.getMethod("pack", new Class[] {})); // NOI18N
            methods[METHOD_pack102].setDisplayName ( "" );
            methods[METHOD_paint103] = new MethodDescriptor(java.awt.Window.class.getMethod("paint", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paint103].setDisplayName ( "" );
            methods[METHOD_paintAll104] = new MethodDescriptor(java.awt.Component.class.getMethod("paintAll", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paintAll104].setDisplayName ( "" );
            methods[METHOD_paintComponents105] = new MethodDescriptor(java.awt.Container.class.getMethod("paintComponents", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paintComponents105].setDisplayName ( "" );
            methods[METHOD_postEvent106] = new MethodDescriptor(java.awt.Window.class.getMethod("postEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_postEvent106].setDisplayName ( "" );
            methods[METHOD_preferredSize107] = new MethodDescriptor(java.awt.Container.class.getMethod("preferredSize", new Class[] {})); // NOI18N
            methods[METHOD_preferredSize107].setDisplayName ( "" );
            methods[METHOD_prepareImage108] = new MethodDescriptor(java.awt.Component.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_prepareImage108].setDisplayName ( "" );
            methods[METHOD_prepareImage109] = new MethodDescriptor(java.awt.Component.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, int.class, int.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_prepareImage109].setDisplayName ( "" );
            methods[METHOD_print110] = new MethodDescriptor(java.awt.Container.class.getMethod("print", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_print110].setDisplayName ( "" );
            methods[METHOD_printAll111] = new MethodDescriptor(java.awt.Component.class.getMethod("printAll", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_printAll111].setDisplayName ( "" );
            methods[METHOD_printComponents112] = new MethodDescriptor(java.awt.Container.class.getMethod("printComponents", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_printComponents112].setDisplayName ( "" );
            methods[METHOD_Refresh113] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("Refresh", new Class[] {com.impaq.arena.player.Player.class, com.impaq.arena.player.Player.class})); // NOI18N
            methods[METHOD_Refresh113].setDisplayName ( "" );
            methods[METHOD_remove114] = new MethodDescriptor(java.awt.Container.class.getMethod("remove", new Class[] {int.class})); // NOI18N
            methods[METHOD_remove114].setDisplayName ( "" );
            methods[METHOD_remove115] = new MethodDescriptor(java.awt.Frame.class.getMethod("remove", new Class[] {java.awt.MenuComponent.class})); // NOI18N
            methods[METHOD_remove115].setDisplayName ( "" );
            methods[METHOD_remove116] = new MethodDescriptor(javax.swing.JFrame.class.getMethod("remove", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_remove116].setDisplayName ( "" );
            methods[METHOD_removeAll117] = new MethodDescriptor(java.awt.Container.class.getMethod("removeAll", new Class[] {})); // NOI18N
            methods[METHOD_removeAll117].setDisplayName ( "" );
            methods[METHOD_removeNotify118] = new MethodDescriptor(java.awt.Frame.class.getMethod("removeNotify", new Class[] {})); // NOI18N
            methods[METHOD_removeNotify118].setDisplayName ( "" );
            methods[METHOD_removePropertyChangeListener119] = new MethodDescriptor(java.awt.Component.class.getMethod("removePropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class})); // NOI18N
            methods[METHOD_removePropertyChangeListener119].setDisplayName ( "" );
            methods[METHOD_repaint120] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {})); // NOI18N
            methods[METHOD_repaint120].setDisplayName ( "" );
            methods[METHOD_repaint121] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {long.class})); // NOI18N
            methods[METHOD_repaint121].setDisplayName ( "" );
            methods[METHOD_repaint122] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_repaint122].setDisplayName ( "" );
            methods[METHOD_repaint123] = new MethodDescriptor(javax.swing.JFrame.class.getMethod("repaint", new Class[] {long.class, int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_repaint123].setDisplayName ( "" );
            methods[METHOD_requestFocus124] = new MethodDescriptor(java.awt.Component.class.getMethod("requestFocus", new Class[] {})); // NOI18N
            methods[METHOD_requestFocus124].setDisplayName ( "" );
            methods[METHOD_requestFocusInWindow125] = new MethodDescriptor(java.awt.Component.class.getMethod("requestFocusInWindow", new Class[] {})); // NOI18N
            methods[METHOD_requestFocusInWindow125].setDisplayName ( "" );
            methods[METHOD_reshape126] = new MethodDescriptor(java.awt.Window.class.getMethod("reshape", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_reshape126].setDisplayName ( "" );
            methods[METHOD_resize127] = new MethodDescriptor(java.awt.Component.class.getMethod("resize", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_resize127].setDisplayName ( "" );
            methods[METHOD_resize128] = new MethodDescriptor(java.awt.Component.class.getMethod("resize", new Class[] {java.awt.Dimension.class})); // NOI18N
            methods[METHOD_resize128].setDisplayName ( "" );
            methods[METHOD_revalidate129] = new MethodDescriptor(java.awt.Component.class.getMethod("revalidate", new Class[] {})); // NOI18N
            methods[METHOD_revalidate129].setDisplayName ( "" );
            methods[METHOD_RoundInfo130] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("RoundInfo", new Class[] {int.class, boolean.class})); // NOI18N
            methods[METHOD_RoundInfo130].setDisplayName ( "" );
            methods[METHOD_SecondPlayerWin131] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("SecondPlayerWin", new Class[] {})); // NOI18N
            methods[METHOD_SecondPlayerWin131].setDisplayName ( "" );
            methods[METHOD_setBounds132] = new MethodDescriptor(java.awt.Window.class.getMethod("setBounds", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_setBounds132].setDisplayName ( "" );
            methods[METHOD_setComponentZOrder133] = new MethodDescriptor(java.awt.Container.class.getMethod("setComponentZOrder", new Class[] {java.awt.Component.class, int.class})); // NOI18N
            methods[METHOD_setComponentZOrder133].setDisplayName ( "" );
            methods[METHOD_setCursor134] = new MethodDescriptor(java.awt.Window.class.getMethod("setCursor", new Class[] {java.awt.Cursor.class})); // NOI18N
            methods[METHOD_setCursor134].setDisplayName ( "" );
            methods[METHOD_setDefaultLookAndFeelDecorated135] = new MethodDescriptor(javax.swing.JFrame.class.getMethod("setDefaultLookAndFeelDecorated", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_setDefaultLookAndFeelDecorated135].setDisplayName ( "" );
            methods[METHOD_setFocusTraversalKeys136] = new MethodDescriptor(java.awt.Container.class.getMethod("setFocusTraversalKeys", new Class[] {int.class, java.util.Set.class})); // NOI18N
            methods[METHOD_setFocusTraversalKeys136].setDisplayName ( "" );
            methods[METHOD_show137] = new MethodDescriptor(java.awt.Component.class.getMethod("show", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_show137].setDisplayName ( "" );
            methods[METHOD_show138] = new MethodDescriptor(java.awt.Window.class.getMethod("show", new Class[] {})); // NOI18N
            methods[METHOD_show138].setDisplayName ( "" );
            methods[METHOD_size139] = new MethodDescriptor(java.awt.Component.class.getMethod("size", new Class[] {})); // NOI18N
            methods[METHOD_size139].setDisplayName ( "" );
            methods[METHOD_StartGame140] = new MethodDescriptor(com.impaq.arena.visualisation.impl.swing.SwingVisualisation.class.getMethod("StartGame", new Class[] {})); // NOI18N
            methods[METHOD_StartGame140].setDisplayName ( "" );
            methods[METHOD_toBack141] = new MethodDescriptor(java.awt.Window.class.getMethod("toBack", new Class[] {})); // NOI18N
            methods[METHOD_toBack141].setDisplayName ( "" );
            methods[METHOD_toFront142] = new MethodDescriptor(java.awt.Window.class.getMethod("toFront", new Class[] {})); // NOI18N
            methods[METHOD_toFront142].setDisplayName ( "" );
            methods[METHOD_toString143] = new MethodDescriptor(java.awt.Component.class.getMethod("toString", new Class[] {})); // NOI18N
            methods[METHOD_toString143].setDisplayName ( "" );
            methods[METHOD_transferFocus144] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocus", new Class[] {})); // NOI18N
            methods[METHOD_transferFocus144].setDisplayName ( "" );
            methods[METHOD_transferFocusBackward145] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocusBackward", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusBackward145].setDisplayName ( "" );
            methods[METHOD_transferFocusDownCycle146] = new MethodDescriptor(java.awt.Container.class.getMethod("transferFocusDownCycle", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusDownCycle146].setDisplayName ( "" );
            methods[METHOD_transferFocusUpCycle147] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocusUpCycle", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusUpCycle147].setDisplayName ( "" );
            methods[METHOD_update148] = new MethodDescriptor(javax.swing.JFrame.class.getMethod("update", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_update148].setDisplayName ( "" );
            methods[METHOD_validate149] = new MethodDescriptor(java.awt.Container.class.getMethod("validate", new Class[] {})); // NOI18N
            methods[METHOD_validate149].setDisplayName ( "" );
        }
        catch( Exception e) {}//GEN-HEADEREND:Methods
    // Here you can add code for customizing the methods array.

        return methods;     }//GEN-LAST:Methods

    private static java.awt.Image iconColor16 = null;//GEN-BEGIN:IconsDef
    private static java.awt.Image iconColor32 = null;
    private static java.awt.Image iconMono16 = null;
    private static java.awt.Image iconMono32 = null;//GEN-END:IconsDef
    private static String iconNameC16 = null;//GEN-BEGIN:Icons
    private static String iconNameC32 = null;
    private static String iconNameM16 = null;
    private static String iconNameM32 = null;//GEN-END:Icons

    private static final int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
    private static final int defaultEventIndex = -1;//GEN-END:Idx


//GEN-FIRST:Superclass
    // Here you can add code for customizing the Superclass BeanInfo.

//GEN-LAST:Superclass
  /**
   * Gets the bean's <code>BeanDescriptor</code>s.
   *
   * @return BeanDescriptor describing the editable properties of this bean. May
   * return null if the information should be obtained by automatic analysis.
   */
  @Override
  public BeanDescriptor getBeanDescriptor() {
    return getBdescriptor();
  }

  /**
   * Gets the bean's <code>PropertyDescriptor</code>s.
   *
   * @return An array of PropertyDescriptors describing the editable properties
   * supported by this bean. May return null if the information should be
   * obtained by automatic analysis.
   * <p>
   * If a property is indexed, then its entry in the result array will belong to
   * the IndexedPropertyDescriptor subclass of PropertyDescriptor. A client of
   * getPropertyDescriptors can use "instanceof" to check if a given
   * PropertyDescriptor is an IndexedPropertyDescriptor.
   */
  @Override
  public PropertyDescriptor[] getPropertyDescriptors() {
    return getPdescriptor();
  }

  /**
   * Gets the bean's <code>EventSetDescriptor</code>s.
   *
   * @return An array of EventSetDescriptors describing the kinds of events
   * fired by this bean. May return null if the information should be obtained
   * by automatic analysis.
   */
  @Override
  public EventSetDescriptor[] getEventSetDescriptors() {
    return getEdescriptor();
  }

  /**
   * Gets the bean's <code>MethodDescriptor</code>s.
   *
   * @return An array of MethodDescriptors describing the methods implemented by
   * this bean. May return null if the information should be obtained by
   * automatic analysis.
   */
  @Override
  public MethodDescriptor[] getMethodDescriptors() {
    return getMdescriptor();
  }

  /**
   * A bean may have a "default" property that is the property that will mostly
   * commonly be initially chosen for update by human's who are customizing the
   * bean.
   *
   * @return Index of default property in the PropertyDescriptor array returned
   * by getPropertyDescriptors.
   * <P>
   * Returns -1 if there is no default property.
   */
  @Override
  public int getDefaultPropertyIndex() {
    return defaultPropertyIndex;
  }

  /**
   * A bean may have a "default" event that is the event that will mostly
   * commonly be used by human's when using the bean.
   *
   * @return Index of default event in the EventSetDescriptor array returned by
   * getEventSetDescriptors.
   * <P>
   * Returns -1 if there is no default event.
   */
  @Override
  public int getDefaultEventIndex() {
    return defaultEventIndex;
  }

  /**
   * This method returns an image object that can be used to represent the bean
   * in toolboxes, toolbars, etc. Icon images will typically be GIFs, but may in
   * future include other formats.
   * <p>
   * Beans aren't required to provide icons and may return null from this
   * method.
   * <p>
   * There are four possible flavors of icons (16x16 color, 32x32 color, 16x16
   * mono, 32x32 mono). If a bean choses to only support a single icon we
   * recommend supporting 16x16 color.
   * <p>
   * We recommend that icons have a "transparent" background so they can be
   * rendered onto an existing background.
   *
   * @param iconKind The kind of icon requested. This should be one of the
   * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
   * ICON_MONO_32x32.
   * @return An image object representing the requested icon. May return null if
   * no suitable icon is available.
   */
  @Override
  public java.awt.Image getIcon(int iconKind) {
    switch (iconKind) {
      case ICON_COLOR_16x16:
        if (iconNameC16 == null) {
          return null;
        } else {
          if (iconColor16 == null) {
            iconColor16 = loadImage(iconNameC16);
          }
          return iconColor16;
        }
      case ICON_COLOR_32x32:
        if (iconNameC32 == null) {
          return null;
        } else {
          if (iconColor32 == null) {
            iconColor32 = loadImage(iconNameC32);
          }
          return iconColor32;
        }
      case ICON_MONO_16x16:
        if (iconNameM16 == null) {
          return null;
        } else {
          if (iconMono16 == null) {
            iconMono16 = loadImage(iconNameM16);
          }
          return iconMono16;
        }
      case ICON_MONO_32x32:
        if (iconNameM32 == null) {
          return null;
        } else {
          if (iconMono32 == null) {
            iconMono32 = loadImage(iconNameM32);
          }
          return iconMono32;
        }
      default:
        return null;
    }
  }
  
}
