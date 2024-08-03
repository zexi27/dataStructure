package com.zlq;

import java.lang.annotation.Repeatable;

public @interface RepeatingAnnotations {

    @Repeatable(Notifications.class)
    public @interface Notify {
        String email();
    }

    public @interface Notifications {
        Notify[] value();
    }
}
