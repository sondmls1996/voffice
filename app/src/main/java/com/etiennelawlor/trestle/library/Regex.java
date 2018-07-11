package com.etiennelawlor.trestle.library;

import java.util.ArrayList;

/**
 * Created by etiennelawlor on 10/30/15.
 */
public class Regex {

	// region Constants
	public static final int CASE_SENSITIVE = 0;
	public static final int CASE_INSENSITIVE = 1;
	// endregion

	// region Fields
	private String text;
	private int caseSensitivity;
	private ArrayList<String> arrayListText;

	// endregion

	// region Constructors
	public Regex(String text, int caseSensitivity) {
		this.text = text;
		this.caseSensitivity = caseSensitivity;
	}

	public Regex(ArrayList<String> arrayListText, int caseSensitivity) {
		this.arrayListText = arrayListText;
		this.caseSensitivity = caseSensitivity;
	}

	// endregion

	// region Getters
	public String getText() {
		return text;
	}

	public int getCaseSensitivity() {
		return caseSensitivity;
	}

	// endregion

	// region Setters
	public void setText(String text) {
		this.text = text;
	}

	public void setCaseSensitivity(int caseSensitivity) {
		this.caseSensitivity = caseSensitivity;
	}

	// endregion
	public ArrayList<String> getArrayListText() {
		return arrayListText;
	}

	public void setArrayListText(ArrayList<String> arrayListText) {
		this.arrayListText = arrayListText;
	}

}
