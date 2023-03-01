package de.rudi.dropbox;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DbxUserFilesRequests;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadBuilder;
import com.dropbox.core.v2.files.UploadErrorException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestDropbox {

	public static void main(String[] args) {
		DbxRequestConfig config = DbxRequestConfig.newBuilder("RudisBox").build();
		DbxClientV2 client = new DbxClientV2(config, "sl.BZxparg2c9qB_3WskYwidhGgcTViTXg2dkQJq_QlESzgtSIta4DhJmSvf5Pr9qiVJBAM5eETHrUCUBhWFPnbJzee7U0rN76fSQPsp37gHZsXCIAoiEVG8zC_cdLRCDlOhEjcoAmb");
		
		try (InputStream in = new FileInputStream("local-file.txt")) {
			DbxUserFilesRequests requests 	= client.files();
			UploadBuilder builder			= requests.uploadBuilder("/remote-file.txt");
			builder.uploadAndFinish			(in);
//		    FileMetadata metadata = client
//		    		.files()
//		    		.uploadBuilder("/remote-file.txt")
//		    		.uploadAndFinish(in);
		}
		catch (IOException | DbxException  e) {
			System.out.println(e.getMessage());
		}


	}

}
