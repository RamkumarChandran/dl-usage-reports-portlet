package org.gnenc.dlusagereports.portlet.util;

public class DLUsageReportsUtil {
	public static String convertToHumanReadableSize(long size) {
		String displaySize;
		
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
	
	/**
	* The number of bytes in a kilobyte.
	*/
	private static final long ONE_KB = 1024;
	
	/**
	* The number of bytes in a megabyte.
	*/
	private static final long ONE_MB = ONE_KB * ONE_KB;
	
	/**
	* The number of bytes in a gigabyte.
	*/
	private static final long ONE_GB = ONE_KB * ONE_MB;
	
	/**
	* The number of bytes in a terabyte.
	*/
	private static final long ONE_TB = ONE_KB * ONE_GB;
}
