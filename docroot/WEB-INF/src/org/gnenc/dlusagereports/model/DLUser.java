package org.gnenc.dlusagereports.model;

public class DLUser implements Comparable<DLUser> {
	public DLUser(long usage, String name) {
		this.usage = usage;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public long getUsage() {
		return usage;
	}

	public int compareTo(DLUser user) {
		return usage < user.usage ? -1 : usage > user.usage ? 1 : 0;
	}
	
	private long usage;
	private String name;

}
