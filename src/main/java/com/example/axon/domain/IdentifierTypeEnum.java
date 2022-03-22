package com.example.axon.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IdentifierTypeEnum {

	RNA, NIR;

	private static Map<String, IdentifierTypeEnum> namesMap = new HashMap<>(2);

	static {
		namesMap.put("RNA", RNA);
		namesMap.put("NIR ", NIR);
	}

	@JsonCreator
	public static IdentifierTypeEnum forValue(String value) {
		return namesMap.get(value);
	}

	@JsonValue
	public String toValue() {
		for (Entry<String, IdentifierTypeEnum> entry : namesMap.entrySet()) {
			if (entry.getValue() == this)
				return entry.getKey();
		}
		return null;
	}
}
