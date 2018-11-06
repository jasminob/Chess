package com.company.model;

import io.vertx.core.json.JsonObject;

public interface Saveable {
    JsonObject getSaveData();
}
