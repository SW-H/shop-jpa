package com.seungwon.shop.domain.repository;

import com.seungwon.shop.domain.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {

	private String memberName;
	private OrderStatus orderStatus;
}
