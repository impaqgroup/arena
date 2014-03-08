package com.impaq.arena.server.login.util

class Copy {

    static GroovyObject copyTo(GroovyObject from, GroovyObject to, List<String> props = []) {
        from.properties.keySet().findAll { String propName ->
            !(propName =~ ~/(meta)?[cC]lass/)
        }.each { String propName ->
            try {
                boolean shouldCopy = props.isEmpty() || props.contains(propName)
                if (shouldCopy && to.hasProperty(propName)) {
                    def fromVal = from[propName]
                    if (fromVal != null) {
                        to.setProperty(propName, fromVal)
                    }
                }
            } catch (MissingPropertyException ex) {}
        }
        return to
    }

    static <T> T copyTo(GroovyObject from, Class<T> to, List<String> props = []) {
        return copyTo(from, to.newInstance())
    }

}
