package com.ocr.observer;

public interface Observateur {
	public void update(String word, short diff, boolean wql);
}
