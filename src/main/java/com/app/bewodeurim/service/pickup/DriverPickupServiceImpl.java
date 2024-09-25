package com.app.bewodeurim.service.pickup;

import com.app.bewodeurim.domain.pickup.DriverPickUpDTO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.repository.pickup.DriverPickupDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class DriverPickupServiceImpl implements DriverPickupService {
    private final DriverPickupDAO driverPickupDAO;

    @Override
    public List<DriverPickUpDTO> getPickupList(Pagination pagination, Long driverId) {
        return driverPickupDAO.findAllByDriverId(pagination, driverId);
    }

    @Override
    public int getTotal() {
        return driverPickupDAO.findCount();
    }
}
