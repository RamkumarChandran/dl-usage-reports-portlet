package org.gnenc.liferay.model;

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
	
	public String getHumanReadableUsage() {
		String displaySize;
		long size = usage;
		
		if (size / ONE_TB > 0) {
			displaySize = String.valueOf(size / ONE_TB) + " TB";
		} else if (size / ONE_GB > 0) {
			displaySize = String.valueOf(size / ONE_GB) + " GB";
		} else if (size / ONE_MB > 0) {
			displaySize = String.valueOf(size / ONE_MB) + " MB";
		} else if (size / ONE_KB > 0) {
			displaySize = String.valueOf(size / ONE_KB) + " KB";
		} else {
			displaySize = String.valueOf(size) + " bytes";
		}
		
		return displaySize;
	}

	public int compareTo(DLUser user) {
		return usage < user.usage ? -1 : usage > user.usage ? 1 : 0;
	}
	
	private long usage;
	private String name;
	
	/**
	* The number of bytes in a kilobyte.
	*/
	public static final long ONE_KB = 1024;
	
	/**
	* The number of bytes in a megabyte.
	*/
	public static final long ONE_MB = ONE_KB * ONE_KB;
	
	/**
	* The number of bytes in a gigabyte.
	*/
	public static final long ONE_GB = ONE_KB * ONE_MB;
	
	/**
	* The number of bytes in a terabyte.
	*/
	public static final long ONE_TB = ONE_KB * ONE_GB;

}
