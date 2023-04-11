package com.example.otel;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import io.opentelemetry.context.ImplicitContextKeyed;

public interface MineHeader extends ImplicitContextKeyed {
    ContextKey<MineHeader> contextKey = ContextKey.named("propagation.mine.header");

    @Override
    default Context storeInContext(Context context) {
        return context.with(contextKey, this);
    }

    static MineHeader fromContext(Context context) {
        return context.get(contextKey);
    }
}
