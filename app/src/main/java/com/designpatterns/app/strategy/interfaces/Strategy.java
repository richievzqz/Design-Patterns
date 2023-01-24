package com.designpatterns.app.strategy.interfaces;

import com.designpatterns.app.strategy.model.Order;

import java.io.IOException;
import java.util.Map;

public interface Strategy <S, T> {
    T executeOrder(S stock, T order) throws IOException;

}
