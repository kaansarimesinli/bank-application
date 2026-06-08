package com.project.service.interfaces;

import java.time.LocalDateTime;

public interface Syncable {
    void sync();
    LocalDateTime getLastSyncTime();
}
