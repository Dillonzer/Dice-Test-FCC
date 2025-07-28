package models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Die {
	@Setter(AccessLevel.NONE)
	private int rollValue;

	public void Roll() {
		rollValue = (int) (Math.random() * 6 + 1);
	}
}
