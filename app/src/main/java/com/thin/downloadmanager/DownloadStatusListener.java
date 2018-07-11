package com.thin.downloadmanager;

public interface DownloadStatusListener {

	// Callback when download is successfully completed
	void onDownloadComplete(int mId);

	// Callback if download is failed. Corresponding error code and error
	// messages are provided
	void onDownloadFailed(int mId, int errorCode, String errorMessage);

	// Callback provides download progress
	void onProgress(int mId, long totalBytes, long downloadedBytes, int progress);

	void onConnectHeader(String timeConnectHeader);
}
