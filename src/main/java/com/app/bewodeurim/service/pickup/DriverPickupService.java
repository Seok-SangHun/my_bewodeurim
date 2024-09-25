package com.app.bewodeurim.service.pickup;

import com.app.bewodeurim.domain.pickup.DriverPickUpDTO;
import com.app.bewodeurim.domain.pickup.Pagination;

import java.util.List;

public interface DriverPickupService {
    public List<DriverPickUpDTO> getPickupList(Pagination pagination, Long driverId);

    public int getTotal();
}
