package com.qsp.trello.genericutility;

import java.time.LocalDateTime;
/**
 * These are Java the Library given facilities
 * @author Rakesh
 *
 */

public class Javautility {
	/**
	 * It will capture the current machine date and time in String Format
	 * @return
	 */
	public String timeStamp() {
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		return timeStamp;
	}
}
