package dev.dhlee.advanced.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceV0 {

    private final OrderRepositoryV0 orderRepository;

    public void orderItem(final String itemId) {
        orderRepository.save(itemId);
    }
}
