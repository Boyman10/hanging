package com.ocr.observer;

import com.ocr.visuel.AllPane;

public interface Observable {
	public void addObservateur(Observateur obs);
	public void updateObservateur(AllPane pan);
	public void delObservateur();
}